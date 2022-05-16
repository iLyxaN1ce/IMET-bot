var mongoose = require('mongoose');

const models = require('./models');
var KeyboardMarkupModel = models.keyboardMarkupModel;
var KeyboardButtonModel = models.keyboardButtonModel;
var StaffModel = models.staffModel;
var DataModel = models.dataModel;

const keyboardMarkups = require('./keyboardMarkups');
var keyboardMarkupsArray = keyboardMarkups.keyboardMarkupsArray;

const keyboardButtons = require('./keyboardButtons');
var buttonsArray = keyboardButtons.buttonsArray

const buttonDatas = require('./buttonDatas');
var buttonDatasArray = buttonDatas.buttonDatasArray;

const DB_IP = process.env.DB_IP;
const URL = `mongodb://${DB_IP}:27017/imet-db`;

var options = {
   user: process.env.MONGO_USER,
   pass: process.env.MONGO_PWD,
   connectTimeoutMS: 60000
}

async function update(db, model, collectionName, documentsArray) {
   console.log("Updating " + collectionName);
   return db.listCollections({ name: collectionName }).toArray().then(arr => {
      if (arr.length != 0) {
         console.log("Dropping " + collectionName);
         return db.dropCollection(collectionName);
      } else {
         console.log("No collection " + collectionName);
      }
   }).then(() => {
      console.log("Inserting " + collectionName);
      return model.insertMany(documentsArray);
   }).catch((e) => {
      console.error(e);
   });
}

async function main() {
   try {
      console.log("Connecting to database");
      await mongoose.connect(URL, options);
      const db = mongoose.connection.db;

      Promise.all([
          update(db, KeyboardMarkupModel, "markups", keyboardMarkupsArray),
          update(db, KeyboardButtonModel, "buttons", buttonsArray),
          update(db, DataModel, "datas", buttonDatasArray),
          ]
      ).then(() => {
         console.log("All promises resolved, exit")
         process.exit(0);
      });
   } catch (error) {
      console.error(error);
      process.exit(1);
   }
}

main();
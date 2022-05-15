var mongoose = require('mongoose');

const models = require('./models');
var KeyboardMarkupModel = models.keyboardMarkupModel;
var KeyboardButtonModel = models.keyboardButtonModel;
var StaffModel = models.staffModel;

const keyboardMarkups = require('./keyboardMarkups');
var startKeyboard = keyboardMarkups.startKeyboard;
var staffKeyboard = keyboardMarkups.staffKeyboard;
var documentsKeyboard = keyboardMarkups.documentsKeyboard;

const keyboardButtons = require('./keyboardButtons');
var staffButton = keyboardButtons.staffButton;
var documentsButton = keyboardButtons.documentsButton;
var helpButton = keyboardButtons.helpButton;
var bachelorButton = keyboardButtons.bachelorButton;
var masterButton = keyboardButtons.masterButton;
var internationalButton = keyboardButtons.internationalButton;
var lkButton = keyboardButtons.lkButton;

const staffs = require('./staffs');
var bachelorStaff = staffs.bachelorStaff;
var masterStaff = staffs.masterStaff;

const DB_IP = process.env.DB_IP;
const URL = `mongodb://${DB_IP}:27017/imet-db`;

var options = {
   user: process.env.MONGO_USER,
   pass: process.env.MONGO_PWD,
   connectTimeoutMS: 60000
}

async function updateKeyboards(db) {
   console.log("Updating keyboards");
   return db.listCollections({ name: 'keyboards' }).toArray().then(arr => {
      if (arr.length != 0) {
         console.log("Dropping keyboards");
         return db.dropCollection("keyboards")
      } else {
         console.log("No collection keyboards");
      }
   }).then(() => {
      console.log("Inserting keyboards");
      return KeyboardMarkupModel.insertMany([
          startKeyboard,
          staffKeyboard,
          documentsKeyboard
      ])
   });
}

async function updateButtons(db) {
   console.log("Updating keyboard buttons")
   return db.listCollections({ name: 'buttons' }).toArray().then(arr => {
      if (arr.length != 0) {
         console.log("Dropping buttons");
         return db.dropCollection("buttons")
      } else {
         console.log("No collection buttons");
      }
   }).then(() => {
      console.log("Inserting buttons");
      return KeyboardButtonModel.insertMany([
         staffButton,
         documentsButton,
         helpButton,
         bachelorButton,
         masterButton,
         internationalButton,
         lkButton
      ]);
   });
}

async function updateStaffs(db) {
   console.log("Updating staffs");
   return db.listCollections({ name: 'staffs' }).toArray().then(arr => {
      if (arr.length != 0) {
         console.log("Dropping staffs");
         return db.dropCollection("staffs")
      } else {
         console.log("No collection staffs");
      }
   }).then(() => {
      console.log("Inserting staffs");
      return StaffModel.insertMany([
          bachelorStaff,
          masterStaff
      ])
   });
}


async function main() {
   try {
      console.log("Connecting to database");
      await mongoose.connect(URL, options);
      const db = mongoose.connection.db;
      Promise.all([updateKeyboards(db), updateButtons(db), updateStaffs(db)]).then(() => {
         console.log("All promises resolved, exit")
         process.exit(0);
      });
   } catch (error) {
      console.error(error);
      process.exit(1);
   }
}

main();
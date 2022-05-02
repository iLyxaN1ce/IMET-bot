var mongoose = require('mongoose');

var getCommandsArray = require('./commands');

const models = require('./models');
var CommandModel = models.commandModel;
var EmployeesModel = models.employeeModel;

const contingent = require('./contingent');
var bachelorContingent = contingent.bachelorContingent;
var masterContingent = contingent.masterContingent;

const URL = "mongodb://172.21.0.2:27017/imet-db";

var options = {
   user: process.env.MONGO_USER,
   pass: process.env.MONGO_PWD,
   connectTimeoutMS: 60000
}

async function updateCommands(db) {
   console.log("Updating commands")
   return db.listCollections({ name: 'commands' }).toArray().then(arr => {
      if (arr.length != 0) {
         console.log("Dropping commands");
         return db.dropCollection("commands")
      } else {
         console.log("No collection commands");
      }
   }).catch(err => {
      console.log(err);
   }).then(() => {
      console.log("Inserting commands");
      commandsArray = getCommandsArray(bachelorContingent, masterContingent);
      return CommandModel.insertMany(commandsArray);
   });
}

async function updateEmployees(db) {
   console.log("Updating employees");
   return db.listCollections({ name: 'employees' }).toArray().then(arr => {
      if (arr.length != 0) {
         console.log("Dropping employees");
         return db.dropCollection("employees")
      } else {
         console.log("No collection employees");
      }
   }).catch(err => {
      console.log(err);
   }).then(() => {
      console.log("Inserting employees");
      const employeesArray = [bachelorContingent, masterContingent];
      return EmployeesModel.insertMany(employeesArray)
   });
}

async function main() {
   try {
      console.log("Connecting to database");
      await mongoose.connect(URL, options);
   } catch (error) {
      handleError(error);
   }

   const db = mongoose.connection.db;

   Promise.all([updateCommands(db), updateEmployees(db)]).then(() => {
      console.log("All promises resolved, exit")
      process.exit(0);
   });
}

main();
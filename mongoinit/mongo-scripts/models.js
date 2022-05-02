var mongoose = require('mongoose');

const Schema = require('mongoose').Schema;
const Mixed = Schema.Types.Mixed;

const commandSchema = new Schema({
  text: String,
  responseType: String,
  responseBody: Mixed,
  nextCommands: Array
});

const employeesSchema = new Schema({
  name: String,
  employees: {
    address: String,
    contacts: String,
    email: String,
    fullName: String,
    position: String
  }
})

const CommandModel = mongoose.model("command", commandSchema);
const EmployeeModel = mongoose.model("employees", employeesSchema);

module.exports = {
  commandModel: CommandModel,
  employeeModel: EmployeeModel
}

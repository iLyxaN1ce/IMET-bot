var mongoose = require('mongoose');

const Schema = require('mongoose').Schema;
const Mixed = Schema.Types.Mixed;

const keyboardMarkupSchema = new Schema({
  name: String,
  text: String,
  buttons: Array
});

const keyboardButtonSchema = new Schema({
  name: String,
  label: String,
  data: String
})

const dataSchema = new Schema({
  name: String,
  responseType: String,
  responseBody: Mixed
})

const staffSchema = new Schema({
  name: String,
  employees: {
    address: String,
    contacts: String,
    email: String,
    fullName: String,
    position: String
  }
})

const KeyboardMarkupModel = mongoose.model("markup", keyboardMarkupSchema);
const KeyboardButtonModel = mongoose.model("button", keyboardButtonSchema);
const DataModel = mongoose.model("data", dataSchema)
const StaffModel = mongoose.model("staff", staffSchema);

module.exports = {
  "keyboardMarkupModel": KeyboardMarkupModel,
  "keyboardButtonModel": KeyboardButtonModel,
  "staffModel": StaffModel,
  "dataModel": DataModel
}

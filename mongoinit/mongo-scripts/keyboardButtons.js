var documentsKeyboard = require('./keyboardMarkups');
var staffKeyboard = require('./keyboardMarkups');
var bachelorStaff = require('./staffs');
var masterStaff = require('./staffs');

const staffButton = {
    "name": "/staff",
    "label": "Персонал",
    "data": "staffData"
}

const documentsButton = {
    "name": "/documents",
    "label": "Документы",
    "data": "documentsData"
}

const helpButton = {
    "name": "/help",
    "label": "Помощь",
    "data": "helpData"
}

const bachelorButton = {
    "name": "/b",
    "label": "Бакалавриат",
    "data": "bachelorData"
}

const masterButton = {
    "name": "/m",
    "label": "Магистратура",
    "data": "masterData"
}

const internationalButton = {
    "name": "/international",
    "label": "Международная деятельность",
    "data": "internationalData"
}

const lkButton = {
    "name": "/lk",
    "label": "Личный кабинет",
    "data": "lkData"
}

module.exports = {
    "staffButton": staffButton,
    "documentsButton": documentsButton,
    "helpButton": helpButton,
    "bachelorButton": bachelorButton,
    "masterButton": masterButton,
    "internationalButton": internationalButton,
    "lkButton": lkButton
}
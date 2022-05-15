var documentsKeyboard = require('./keyboardMarkups');
var staffKeyboard = require('./keyboardMarkups');
var bachelorStaff = require('./staffs');
var masterStaff = require('./staffs');

const staffButton = {
    "name": "/staff",
    "label": "Персонал",
    "responseType": "Keyboard",
    "responseBody": staffKeyboard
}

const documentsButton = {
    "name": "/documents",
    "label": "Документы",
    "responseType": "Keyboard",
    "responseBody": documentsKeyboard
}

const helpButton = {
    "name": "/help",
    "label": "Помощь",
    "responseType": "String",
    "responseBody": "Привет! Я бот ИПМЭиТ и я готов ответить на твои вопросы! Напиши /help, чтобы узнать, что я умею"
}

const bachelorButton = {
    "name": "/b",
    "label": "Бакалавриат",
    "responseType": "Staff",
    "responseBody": bachelorStaff
}

const masterButton = {
    "name": "/m",
    "label": "Магистратура",
    "responseType": "Staff",
    "responseBody": masterStaff
}

const internationalButton = {
    "name": "/international",
    "label": "Международная деятельность",
    "responseType": "String",
    "responseBody": "https://imet.spbstu.ru/mezhdunarodnaya_deyatelnost/"
}

const lkButton = {
    "name": "/lk",
    "label": "Личный кабинет",
    "responseType": "String",
    "responseBody": "https://dep.spbstu.ru/userfiles/files/prev/docs/general/reglament_lko_2018.pdf"
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
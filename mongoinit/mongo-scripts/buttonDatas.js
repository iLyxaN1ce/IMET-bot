const {bachelorStaff, masterStaff} = require("./staffs");

const staffData = {
    "name": "staffData",
    "responseType": "Keyboard",
    "responseBody": "staffKeyboard"
}

const documentsData = {
    "name": "documentsData",
    "responseType": "Keyboard",
    "responseBody": "documentsKeyboard"
}

const helpData = {
    "name": "helpData",
    "responseType": "String",
    "responseBody": "Привет! Я бот ИПМЭиТ и я готов ответить на твои вопросы! Напиши /help, чтобы узнать, что я умею"
}

const bachelorData = {
    "name": "bachelorData",
    "responseType": "Staff",
    "responseBody": bachelorStaff
}

const masterData = {
    "name": "masterData",
    "responseType": "Staff",
    "responseBody": masterStaff
}

const internationalData = {
    "name": "internationalData",
    "responseType": "String",
    "responseBody": "https://imet.spbstu.ru/mezhdunarodnaya_deyatelnost/"
}

const lkData = {
    "name": "lkData",
    "responseType": "String",
    "responseBody": "https://dep.spbstu.ru/userfiles/files/prev/docs/general/reglament_lko_2018.pdf"
}

module.exports = {
    "buttonDatasArray": [
        staffData,
        documentsData,
        helpData,
        bachelorData,
        masterData,
        internationalData,
        lkData
    ]
}

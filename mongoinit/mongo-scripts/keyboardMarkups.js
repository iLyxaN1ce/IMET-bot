const startKeyboard = {
    "text": "Привет! Я бот ВШПМ ИПМЭиТ",
    "name": "startKeyboard",
    "buttons": [
        "/staff",
        "/documents",
        "/help"
    ]
}

const staffKeyboard = {
    "text": "Выбери интересующий тебя список сотрудников",
    "name": "staffKeyboard",
    "buttons": [
        "/b",
        "/m",
        "/backStaff"
    ]
}

const documentsKeyboard = {
    "text": "Выбери необходимый тебе документ",
    "name": "documentsKeyboard",
    "buttons": [
        "/international",
        "/lk",
        "/backDocuments"
    ]
}

module.exports = {
    "keyboardMarkupsArray": [
        startKeyboard,
        staffKeyboard,
        documentsKeyboard
    ]
}
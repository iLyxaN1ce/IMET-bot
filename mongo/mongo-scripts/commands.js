function getCommandsArray(bachelor, master) {
  const commandsArray = [
    {
      "text": "/b",
      "responseType": "com.imet_bot.entities.Employees",
      "responseBody": bachelor,
      "nextCommand": []
    },
    {
      "text": "/m",
      "responseType": "com.imet_bot.entities.Employees",
      "responseBody": master,
      "nextCommand": []
    },
    {
      "text": "/start",
      "responseType": "com.imet_bot.entities.StringObject",
      "responseBody": {"value": "Привет! Я бот ИПМЭиТ и я готов ответить на твои вопросы! Напиши /help, чтобы узнать, что я умею"},
      "nextCommand": []
    },
    {
      "text": "/documents",
      "responseType": "com.imet_bot.entities.StringObject",
      "responseBody": {"value": "https://imet.spbstu.ru/podacha_i_vizirovanie_zayavleniy_studentov/"},
      "nextCommand": []
    },
    {
      "text": "/international",
      "responseType": "com.imet_bot.entities.StringObject",
      "responseBody": {"value": "https://imet.spbstu.ru/mezhdunarodnaya_deyatelnost/"},
      "nextCommand": []
    },
    {
      "text": "/help",
      "responseType": "com.imet_bot.entities.StringObject",
      "responseBody": {"value": "Список доступных команд: \n/b - контакты дирекции бакалавриата/специалитета \n/m - контакты дирекции магистратуры/аспирантуры \n/documents - информация о порядке подачи и визирования заявлений студентов \n/international - информация об академической мобильности \n/contingent - положение о движении контингента обучающихся \n/reglament - регламент функционирования личного кабинета обучающегося"},
      "nextCommand": []
    },
    {
      "text": "/reglament",
      "responseType": "com.imet_bot.entities.StringObject",
      "responseBody": {"value": "https://dep.spbstu.ru/userfiles/files/prev/docs/general/reglament_lko_2018.pdf"},
      "nextCommand": []
    },
    {
      "text": "/contingent",
      "responseType": "com.imet_bot.entities.StringObject",
      "responseBody": {"value": "https://dep.spbstu.ru/userfiles/files/prev/docs/for_students/pol_o_suos_16_06_2017.pdf"},
      "nextCommand": []
    }
  ]
  
  return commandsArray;
}

module.exports = getCommandsArray

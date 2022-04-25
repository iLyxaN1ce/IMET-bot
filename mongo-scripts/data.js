conn = new Mongo();
db = conn.getDB("imet-db");

db.employees.insertOne({
  "name": "Бакалавриат",
  "employees": [
    {
      "address": "УК-50, 1420 ауд.",
      "contacts": "-",
      "email": "ivanov_mv@spbstu.ru",
      "fullName": "Иванов Максим Владимирович",
      "position": "Заместитель директора по работе со студентами"
    }, 
    {
      "address": "УК-50, 1236 ауд.",
      "contacts": "-",
      "email": "krasnov_as@spbstu.ru",
      "fullName": "Краснов Алекс Сергеевич",
      "position": "Заместитель по работе со студентами (1 и 2 курс)"
    }, 
    {
      "address": "УК-50, 1238 ауд.",
      "contacts": "-",
      "email": "lyamin_bm@spbstu.ru",
      "fullName": "Лямин Борис Михайлович",
      "position": "1 и 2 курс куратор"
    }, 
    {
      "address": "УК-50, 1237 ауд.",
      "contacts": "89315411220",
      "email": "skachkova_mg@spbstu.ru",
      "fullName": "Процюк Маргарита Григорьевна",
      "position": "1 курс"
    }, 
    {
      "address": "УК-50, 1237 ауд.",
      "contacts": "89217599225",
      "email": "kim_na@spbstu.ru",
      "fullName": "Ким Наталья Арсеньевна",
      "position": "2 курс"
    }, 
    {
      "address": "УК-50, 1329а ауд.",
      "contacts": "-",
      "email": "ilyashenko_oyu@spbstu.ru",
      "fullName": "Ильяшенко Оксана Юрьевна",
      "position": "Заместитель по работе с 3-5 курсом"
    }, 
    {
      "address": "УК-50, 1330 ауд.",
      "contacts": "-",
      "email": "asfond_iv@spbstu.ru",
      "fullName": "Асфондьярова Ирина Владимировна",
      "position": "3-5 курс куратор"
    }, 
    {
      "address": "УК-50, 1329 ауд.",
      "contacts": "89315411231",
      "email": "nikitina_oa@spbstu.ru",
      "fullName": "Никитина Ольга Анатольевна",
      "position": "3 курс"
    }, 
    {
      "address": "УК-50, 1229 ауд.",
      "contacts": "89315411294",
      "email": "novikova_ap@spbstu.ru",
      "fullName": "Новикова Анастасия Петровна",
      "position": "4,5 курс"
    }, 
    {
      "address": "УК-50, 1340 ауд.",
      "contacts": "89315411195",
      "email": "lorentsson_ta@spbstu.ru",
      "fullName": "Лоренцсон Татьяна Александровна",
      "position": "Вечернее 1-5, заочное 1-2 курс"
    },
    {
      "address": "УК-50, 1332 ауд.",
      "contacts": "89291039325",
      "email": "gorbacheva_nm@spbstu.ru",
      "fullName": "Горбачева Надежда Митрофановна",
      "position": "Заочное 3-5 курс"
    }
]});

db.employees.insertOne({
  "name": "Магистратура",
  "employees": [
    {
      "address": "УК-50,1430 ауд.",
      "contacts": "-",
      "email": "selentieva_tn@spbstu.ru",
      "fullName": "Селентьева Тамара Николаевна",
      "position": "Заместитель по работе со студентами"
    },
    {
      "address": "УК-50,1330 ауд.",
      "contacts": "89217587856",
      "email": "besednova_lp@spbstu.ru",
      "fullName": "Беседнова Любовь Петровна",
      "position": "2 курс"
    },
    {
      "address": "УК-50,1330 ауд.",
      "contacts": "89217587856",
      "email": "ragel_ti@spbstu.ru",
      "fullName": "Рагель Татьяна Ивановна",
      "position": "1, 3 курс"
    },
    {
      "address": "УК-50,1320 ауд.",
      "contacts": "89218099509",
      "email": "lapina_ml@spbstu.ru",
      "fullName": "Лапина Мария Леонидовна",
      "position": "ЦДО"
    },
    {
      "address": "УК-50, 1227 ауд.",
      "contacts": "89218093449",
      "email": "gutshina_lb@spbstu.ru",
      "fullName": "Гущина Лариса Борисовна",
      "position": "Восстановление и перевод"
    },
    {
      "address": "УК-50, 1333 ауд.",
      "contacts": "89218454789",
      "email": "filpolitehspb@mail.ru, lidakropoliteh@mail.ru",
      "fullName": "Филонова Татьяна Николаевна, Кропотова Лидия Ивановна",
      "position": "Дипломная"
    },
    {
      "address": "УК-16, 502 ауд.",
      "contacts": "89312151570",
      "email": "lukashevich@spbstu.ru",
      "fullName": "Лукашевич Никита Сергеевич",
      "position": "Заместитель директора по международной деятельности"
    },
    {
      "address": "УК-50, 1241 ауд.",
      "contacts": "89298093716",
      "email": "eremochkina_is@spbstu.ru",
      "fullName": "Еремочкина Ирина Сергеевна",
      "position": "Ответственный за оплату и ДОП соглашения"
    }, 
  ]
}
)

bachelor = db.employees.findOne({"name": "Бакалавриат"})

db.command.insertOne({
  "text": "/b",
  "responseType": "com.imet_bot.entities.Employees",
  "responseBody": bachelor,
  "nextCommand": []
});

master = db.employees.findOne({"name": "Магистратура"})
db.command.insertOne({
  "text": "/m",
  "responseType": "com.imet_bot.entities.Employees",
  "responseBody": master,
  "nextCommand": []
});



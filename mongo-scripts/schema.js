conn = new Mongo();
db = conn.getDB("imet-db");

db.createCollection("command", {
  "validator": {
     "$jsonSchema": {
        "bsonType": "object",
        "required": ["text", "responseType", "responseBody", "nextCommand" ],
        "properties": {
           "text": {
             "bsonType": "string" 
           },
           "responseType": {
              "bsonType": "string"
           },
           "responseBody": {
              "bsonType": "object"
           },
           "nextCommands": {
              "bsonType": "array",
              "items": {
                "bsonType": "string"
              }
           }
        }
     }
  }
})

db.createCollection("employees", {
   "validator": {
      "$jsonSchema": {
         "bsonType": "object",
         "required": [ "name", "employees" ],
         "properties": {
            "name": {
               "bsonType": "string"
            },
            "employees": {
               "bsonType": "array",
               "items": {
                  "bsonType": "object",
                  "required": [ "address", "contacts", "contingent", "email", "fullName", "position" ],
                  "properties": {
                     "address": {
                        "bsonType": "string" 
                     },
                     "contacts": {
                        "bsonType": "string" 
                     },
                     "contingent": {
                        "bsonType": "string"
                     }, 
                     "email": {
                        "bsonType": "string"
                     },
                     "fullMame": {
                        "bsonType": "string"
                     },
                     "position": {
                        "bsonType": "string"
                     }
                  }
               }    
            }
         }
      }
   }
})
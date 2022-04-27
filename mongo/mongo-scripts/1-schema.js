conn = new Mongo();
db = conn.getDB("imet-db");

const pwd = _getEnv("MONGO_PWD");

var collectionNames = ["command", "employees"]
for(var i = 0, len = collectionNames.length; i < len ; i++) {
   var collectionName = collectionNames[i]
   db[collectionName].drop();
}

db.createUser({
  user: "aapozd",
  pwd: pwd,
  roles: [ "dbOwner" ]
})

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
                  "required": [ "address", "contacts", "email", "fullName", "position" ],
                  "properties": {
                     "address": {
                        "bsonType": "string" 
                     },
                     "contacts": {
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
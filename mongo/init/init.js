conn = new Mongo();
db = conn.getDB("imet-db");

const pwd = _getEnv("MONGO_PWD");

const users = db.getUsers({ filter: { user: "aapozd" } });
      if (users.length == 0) {
         db.createUser({
            user: "aapozd",
            pwd: pwd,
            roles: [ "dbOwner" ]
          })
      }
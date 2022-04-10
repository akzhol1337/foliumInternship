// the Factory Patterns allows to create objects without specifying the exact class of object that will be created

import java.util.Scanner;

class Connection {
    private String name;
    Connection(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

interface Database {
    Connection getConnection();
}

class PostgreDB implements Database {
    public Connection getConnection() {
        return new Connection("Postgres");
    }
}

class MySqlDB implements Database {
    public Connection getConnection() {
        return new Connection("MySql");
    }
}

class MongoDB implements Database {
    public Connection getConnection() {
        return new Connection("MongoDB");
    }
}

class DatabaseFactory {
    public Database createDatabase(int dbType){
        if(dbType == 1){
            return new PostgreDB();
        } else if(dbType == 2){
            return new MySqlDB();
        } else if(dbType == 3){
            return new MongoDB();
        }
        return null;
    }
}

class Factory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dbType = in.nextInt();

        DatabaseFactory databaseFactory = new DatabaseFactory();

        Database db = databaseFactory.createDatabase(dbType);

        Connection conn = db.getConnection();
        
        System.out.println(conn.getName());

    }
}
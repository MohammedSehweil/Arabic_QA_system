package com.AQAS.Database;

public class Driver {

    public static void main(String[] args) {
        Boolean dataBaseCreated = false;

        if(dataBaseCreated){
            Database.connect();
            //work can be done here
        }
        else {
            Database.createDataBase();
            Database.createTables();
        }

    }


}
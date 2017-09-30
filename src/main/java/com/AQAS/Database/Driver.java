package com.AQAS.Database;

import static com.AQAS.Database.HelpersDB.storeTestingData;

public class Driver {

    public static void main(String[] args) {

        storeTestingData();
        System.exit(1);
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
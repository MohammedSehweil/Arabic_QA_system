package com.AQAS.Database;

import static com.AQAS.Database.HelpersDB.storeTestingData;
import static com.AQAS.Database.HelpersDB.intializeProb;

public class Driver {

    public static void main(String[] args) {
        intializeProb();
//        storeTestingData();
        Form f = new Form(31);
        f.getDocuments();
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
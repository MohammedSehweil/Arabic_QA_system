package com.exmaple.aqs;


import javax.print.Doc;
import java.io.IOException;


public class Driver {

    public static void main(String[] args) throws IOException {
            new DocumentRetrieval().getLinks( "السكري", 3,"http://www.doctoori.net/search/?word=", "pg",".content-main a.btn-primary","href=\"([^\"]*)\"" );
    }
}

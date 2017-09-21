package com.AQAS.document_retrieval;

import java.util.ArrayList;
import java.util.Arrays;

public final  class Config {

    public static final boolean VERBOS = true;
    public static final ArrayList<Website> webSites = new ArrayList<Website>(Arrays.asList(
            new Website("http://www.doctoori.net/search/?word=",
                    "pg",
                    "a.btn-primary",
                    0,
                    "div#condition-content"
                    )
            ,new Website("https://www.webteb.com/search?q=",
                    "page",//no page
                    "div.gsc-table-cell-thumbnail a.gs-title",
                    1,
                    "div.main-content")

    ));



}

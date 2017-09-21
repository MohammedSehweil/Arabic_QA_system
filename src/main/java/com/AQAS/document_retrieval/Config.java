package com.AQAS.document_retrieval;

import java.util.ArrayList;
import java.util.Arrays;

public final  class Config {

    public static final ArrayList<Website> webSites = new ArrayList<Website>(Arrays.asList(
            new Website("http://www.doctoori.net/search/?word=",
                    "pg",
                    ".content-main a.btn-primary",
                    "href=\"([^\"]*)\"",
                    true),
            new Website("http://www.doctoori.net/search/?word=",
                    "pg",
                    ".content-main a.btn-primary",
                    "href=\"([^\"]*)\"",
                    true)
    ));



}

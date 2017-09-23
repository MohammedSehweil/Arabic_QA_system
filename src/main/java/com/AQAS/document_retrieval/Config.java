package com.AQAS.document_retrieval;

import java.util.ArrayList;
import java.util.Arrays;

public final class Config {

    public static final boolean VERBOS = true;
    public static final ArrayList<Website> webSites = new ArrayList<Website>(Arrays.asList(
            new Website("doctoori",
                    "http://www.doctoori.net/search/?word=%s&pg=%s",
                    "pg",
                    "a.btn-primary",
                    0,
                    "div#condition-content"
            )
            , new Website("webteb",
                    "https://www.webteb.com/search?q=%s&page=%s",
                    "page",//no page
                    "div.gsc-table-cell-thumbnail a.gs-title",
                    1,
                    "div.main-content")
            , new DailyMedicalInfoWebsite("dailymedicalinfo",
                    "http://www.dailymedicalinfo.com/page/%s/?s=%s",
                    "page",//no page
                    ".post-listing h2.post-box-title a",
                    1,
                    "div.main-content")

            , new Google("google",
                    "https://www.google.com/search?q=%s&start=%s",
                    "start",
                    "div.rc h3.r a",
                    0,
                    "body"
            )
    ));


}

package com.AQAS.Database;

import java.util.ArrayList;
import java.util.Arrays;

public class ConfigDB {

    public static final ArrayList<Question> testingQuestions = new ArrayList<Question>(Arrays.asList(
            new Question("أعراض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("ما هي أعراض السكري"),
                            new Form("اذكر أعراض السكري")

                            ))),
            new Question("مدة علاج السعال",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("كم هي مدة علاج السعال"),
                            new Form("ما هي المدة اللازمة للشفاء من مرض السعال")

                    )))


    ));

}

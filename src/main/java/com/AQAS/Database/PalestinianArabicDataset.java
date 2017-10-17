package com.AQAS.Database;

import com.AQAS.question_type.ConfigQT;

import java.util.ArrayList;
import java.util.Arrays;

public final class PalestinianArabicDataset {

    //TODO fix the question type for this dataset
    public static final ArrayList<Question> trainingQuestions = new ArrayList<Question>(Arrays.asList(
            new Question("مرض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("شو هو مرض السكري"),
                            new Form("شو هو تعريف مرض السكري"),
                            new Form("ايش يعني مرض السكري"),
                            new Form("ايش تعريف مرض السكري"),
                            new Form("شو السكري"),
                            new Form("ايش هو السكري")

                    ))
                    , ConfigQT.QT_LIST
            ),
            new Question("مدة علاج السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("قديش بدي حتى اطيب من السكري"),
                            new Form("كم لازم اضل اتعالج من مرض السكري؟"),
                            new Form("قديش مدة علاج مرض السكري"),
                            new Form("قديش فترة علاج مرض السكري؟"),
                            new Form("قديش بوخد علاج السكري وقت"),
                            new Form("كديش بدي وقت حتى أطيب من مرض السكري"),
                            new Form("أكم فترة العلاج من مرض السكري"),
                            new Form("شو هي الفترة يلي بتلزم لحتى أتعالج من مرض السكري"),
                            new Form("قديش يستمر علاج مرض السكري")
                    ))
                    , ConfigQT.QT_LIST
            ),
            new Question("أعراض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("شو الأعراض  الجانبية لمرض السكري"),
                            new Form("شو بصير مع الواحد لما بصير معه سكري"),
                            new Form("شو الآثار الجانبية للسكري")

                    ))
                    , ConfigQT.QT_LIST
            ),

            new Question("سبب مرض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("شو السبب لمرض السكري"),
                            new Form("شو سبب  مرض السكري"),
                            new Form("ليش بصير مرض السكري؟"),
                            new Form("من شو بصير مرض السكري"),
                            new Form("كيف بتنصاب بمرض السكري"),
                            new Form("شو اللي بسبب مرض السكري؟"),
                            new Form("شو الاشي اللي بخلي الواحد ينصاب بالسكري؟"),
                            new Form("كيف يصاب الانسان بمرض السكري؟")
                    ))
                    , ConfigQT.QT_LIST
            ),
            new Question("علاج السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("شو علاج مرض السكري"),
                            new Form("شو الدوا للسكري"),
                            new Form("انو دوا لعلاج مرض السكري"),
                            new Form("كيف الواحد بتعلاج من  مرض السكري"),
                            new Form("كيف بقدر اتعالج من مرض السكري"),
                            new Form("شو الأدوية اللي بتلزم للعلاج من مرض السكري"),
                            new Form("كيف اتشافى من مرض السكري"),
                            new Form("ايش العلاج لمرض السكري")
                    ))
                    , ConfigQT.QT_LIST
            ),
            new Question("الوقاية من مرض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("ميف بقدر أحمي حالي من مرض السكري"),
                            new Form("كيف  أتجنب الإصابة بالسكري؟"),
                            new Form("شو أعمل حتى ما يصيبني مرض السكري"),
                            new Form("كيف ما أنصاب بمرض السكري؟"),
                            new Form("شو أعمل عشان ما يصير معي مرض السكري"),
                            new Form("كيف أقي حالي من مرض السكري")
                    ))
                    , ConfigQT.QT_LIST
            ),
            new Question("تشخيص مرض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("كيف بعرف اني مصاب بمرض السكري"),
                            new Form("شو الفحص اللي لازم أعملو عشان أكشف مرض السكري"),
                            new Form("شو هي الطريقة اللي بكتشف أو بشخص فيها مرض السكري"),
                            new Form("كيف ممكن أكشف عن الإصابة  بمرض السكري"),
                            new Form("كيف بنشخص مرض السكري")
                    ))
                    , ConfigQT.QT_LIST
            ),
            new Question("الفحوصات الطبية لمرض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("شو الفحوصات اللي لازم أعلمها بشكل دوري لمرض السكري"),
                            new Form("شو بتعمل فحوصات اذا كنت مريض سكري"),
                            new Form("ما هي الفحوصات  الدورية اللازمة لمرض السكري"),
                            new Form("شو هي فحوصات المصابين بالسكري الروتينية")
                    ))
                    , ConfigQT.QT_LIST
            ),
            new Question("امكانية علاج مرض السكري",
                    new ArrayList<Form>(Arrays.asList(
                            new Form("في لمرض السكري علاج؟ "),
                            new Form("السكري بتعالح ولا لا؟"),
                            new Form("هل في علاح لمرض السكري؟")
                    ))
                    , ConfigQT.QT_LIST
            )

    ));
}

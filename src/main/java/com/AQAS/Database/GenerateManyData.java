package com.AQAS.Database;

import com.AQAS.question_processessing.ConfigP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;

public class GenerateManyData {

    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String fileName = "Results";
        String   [] DiseaseNames = {"السكري", "ضغط الدم", "الجدري","الانفلونزا", "الملاريا"};
        //you have to go to file then and remove the last comma (,)
        PrintWriter writer = new PrintWriter(ConfigDB.packagePath + fileName + ".java", "UTF-8");

        writer.println("package com.AQAS.Database;\n" +
                "\n" +
                "import com.AQAS.question_type.ConfigQT;\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.Arrays;\n" +
                "public class " + fileName  + "{\n" +
                " public static final ArrayList<Question> trainingQuestions = new ArrayList<Question>(Arrays.asList(\n");


        //for loop
        for (String s:
             DiseaseNames) {
            writer.println(oneForm.replace("السكري", s));
        }

        writer.println("    ));\n" +
                "\n" +
                "}\n");
        writer.close();
    }
    public static String oneForm =
           " /*******\n" +
                   "             *\n" +
                   "             *\n" +
                   "             *marad el sokaree\n" +
                   "             *\n" +
                   "             */\n" +
                   "            new Question(\"مرض السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"ما هو مرض السكري\"),\n" +
                   "                            new Form(\"ماذا يعني مرض السكري\"),\n" +
                   "                            new Form(\"مرض السكري\"),\n" +
                   "                            new Form(\"تعريف السكري\")\n" +
                   "\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_PARAGRAPH\n" +
                   "            ),\n" +
                   "            new Question(\"مدة علاج السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"كم  مدة علاج السكري\"),\n" +
                   "                            new Form(\"كم  فترة علاج السكري\"),\n" +
                   "                            new Form(\"كم هي فترة علاج السكري\"),\n" +
                   "                            new Form(\"ما هي فترة العلاج اللازمة لمرض السكري؟\"),\n" +
                   "                            new Form(\"ما هي المدة اللازمة للشفاء من مرض السكري\"),\n" +
                   "                            new Form(\"كم تبلغ فنرة علاج مرض السكري\"),\n" +
                   "                            new Form(\"ما هي الفترة التي يحتاجها مريض السكري للعلاج\"),\n" +
                   "                            new Form(\"كم تمتد فترة العلاج لمرض السكري؟\"),\n" +
                   "                            new Form(\"كم يلزم من الوقت للعلاج من مرض السكري؟\"),\n" +
                   "                            new Form(\"كم تستمر فترة علاج مرض السكري؟\"),\n" +
                   "                            new Form(\"كم يحتاج مرض السكري للعلاح؟\"),\n" +
                   "                            new Form(\"كم يستغرق مرض السكري للعلاح؟\")\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_NUMERIC\n" +
                   "            ),\n" +
                   "            new Question(\"أعراض السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"ما هي أعراض السكري\"),\n" +
                   "                            new Form(\"اذكر أعراض السكري\"),\n" +
                   "                            new Form(\"ما هي الأعراض الجانبية للسكري\"),\n" +
                   "                            new Form(\"ما هي الأعراض الجانبية لمرض  السكري\"),\n" +
                   "                            new Form(\"على ماذا يؤثر السكري\"),\n" +
                   "                            new Form(\"آثار مرض السكري\"),\n" +
                   "                            new Form(\"ما هي  الآثار الجانبية لمرض السكري؟\")\n" +
                   "\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_LIST\n" +
                   "            ),\n" +
                   "\n" +
                   "            new Question(\"سبب مرض السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"ما هي مسببات مرض السكري\"),\n" +
                   "                            new Form(\"ما هو سبب  مرض السكري\"),\n" +
                   "                            new Form(\"سبب  مرض السكري\"),\n" +
                   "                            new Form(\"ما هو سبب الإصابة بمرض السكري\"),\n" +
                   "                            new Form(\"ما هي أسباب الإصابة بمرض السكري\"),\n" +
                   "                            new Form(\"ما هي الأسباب المؤدية إلى مرض السكري\"),\n" +
                   "                            new Form(\"ماالمسبب الرئيسي لمرض السكري؟\"),\n" +
                   "                            new Form(\"كيف يصاب الانسان بمرض السكري؟\")\n" +
                   "\n" +
                   "\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_PARAGRAPH\n" +
                   "            ),\n" +
                   "            new Question(\"علاج السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"ما هو علاج مرض السكري\"),\n" +
                   "                            new Form(\"ما هو دواء السكري\"),\n" +
                   "                            new Form(\"كيفية علاج مرض السكري\"),\n" +
                   "                            new Form(\"كيف يمكن الشفاء من مرض السكري\"),\n" +
                   "                            new Form(\"أدوية لعلاج مرض السكري\")\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_PARAGRAPH\n" +
                   "            ),\n" +
                   "            new Question(\"الوقاية من مرض السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"ما هي طريقة الوقاية من مرض السكري\"),\n" +
                   "                            new Form(\"كيف نستطيع تجنب الإصابة بالسكري؟\"),\n" +
                   "                            new Form(\"كيفية  تجنب الإصابة بمرض السكري\"),\n" +
                   "                            new Form(\"ما هي طرق الوقاية من مرض السكري؟\"),\n" +
                   "                            new Form(\"كيف تحمي نفسك من مرض السكري\"),\n" +
                   "                            new Form(\"الوقاية من مرض السكري\"),\n" +
                   "                            new Form(\"ما هي طرق الحماية من مرض السكري\"),\n" +
                   "                            new Form(\"وسائل الوقاية من مرض السكري\")\n" +
                   "\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_LIST\n" +
                   "            ),\n" +
                   "            new Question(\"تشخيص مرض السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"كيف نكشف عن مرض السكري\"),\n" +
                   "                            new Form(\"كيف نشخص مرض السكري\"),\n" +
                   "                            new Form(\"كيف يتم الكشف عن الإصابة  بمرض السكري\"),\n" +
                   "                            new Form(\"ما هي الطرق المتبعة للكشف عن الإصابة  بمرض السكري\"),\n" +
                   "                            new Form(\"كيف يمكن تشخيص مرض السكري\"),\n" +
                   "                            new Form(\"كيف يتم تشخيص مرض السكري\"),\n" +
                   "                            new Form(\"كيف أعرف اني مصاب بمرض السكري\"),\n" +
                   "                            new Form(\"ما هي الآلية المتبعة في الكشف عن مرض السكري\")\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_PARAGRAPH\n" +
                   "            ),\n" +
                   "            new Question(\"الفحوصات الطبية لمرض السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"ما هي الفحوصات اللازمة لمرض السكري\"),\n" +
                   "                            new Form(\"ما هي الفحوصات اللازمة لمريض السكري\"),\n" +
                   "                            new Form(\"ما هي الفحوصات  الدورية اللازمة لمرض السكري\"),\n" +
                   "                            new Form(\"ما هي الفحوصات  الروتينية لمرض السكري\"),\n" +
                   "                            new Form(\"ما هي الفحوصات التي يخضع لها الشخص المصاب بمرض السكري\"),\n" +
                   "                            new Form(\"الفحوصات التي يجريها مريض السكري\"),\n" +
                   "                            new Form(\" ما هي الفحوصات الطبية للأشحاص المصابين بمرض السكري\")\n" +
                   "\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_PARAGRAPH\n" +
                   "            ),\n" +
                   "            new Question(\"امكانية علاج مرض السكري\",\n" +
                   "                    new ArrayList<Form>(Arrays.asList(\n" +
                   "                            new Form(\"ها هناك علاج لمرض السكري\"),\n" +
                   "                            new Form(\"هل يوجد علاج لمرض السكري؟\"),\n" +
                   "                            new Form(\"احتمالية الشفاء من مرض السكري\"),\n" +
                   "                            new Form(\" ما هي احتمالية وجود علاج لمرض السكري\"),\n" +
                   "                            new Form(\" ما هي امكانية وجود علاج لمرض السكري\"),\n" +
                   "                            new Form(\"هل يمكن الشفاء من مرض السكري\"),\n" +
                   "                            new Form(\"هل من علاج لمرض السكري\")\n" +
                   "                    ))\n" +
                   "                    , ConfigQT.QT_PARAGRAPH\n" +
                   "            ),\n"
            ;
}



package language;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class LanguageDetectorDemo {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("C:\\Apache\\apache-opennlp-2.0.0\\bin\\langdetect-183.bin");
        LanguageDetectorModel detectorModel = new LanguageDetectorModel(inputStream);
        inputStream.close();

        String inputTextGerman = "Ich selbst sehe das nicht so eng, aber ich weiß, " +
                "dass in der Community Debatten dazu geführt werden, " +
                "welche der beiden Formulierungen besser ist. Politisch korrekt heißt es behinderter Mensch, " +
                "weil es offen lässt, " +
                "ob jemand behindert ist oder durch seine Umwelt behindert wird.";
        LanguageDetector myCategorizer = new LanguageDetectorME(detectorModel);

// Get the most probable language
        Language predictLanguage = myCategorizer.predictLanguage(inputTextGerman);
        System.out.println();
        System.out.println(inputTextGerman);
        System.out.println("Detected language: " + predictLanguage.getLang());
        System.out.println("Confidence: " + predictLanguage.getConfidence());


        String inputTextVietnamese = "Chuối rất giàu vitamin và khoáng chất tốt cho sức khỏe, " +
                "nhưng không nên ăn quá 2 quả mỗi ngày." +
                " Ăn vừa phải, chuối hỗ trợ tiêu hóa và giảm cân, ngăn chặn đường huyết tăng đột biến.";
        predictLanguage = myCategorizer.predictLanguage(inputTextVietnamese);
        System.out.println();
        System.out.println(inputTextVietnamese);
        System.out.println("Detected language: " + predictLanguage.getLang());
        System.out.println("Confidence: " + predictLanguage.getConfidence());

        String inputTextFrench = "Quel temps fait-il? " +
                "Est-ce que vous avez des frères et sœurs?";
        predictLanguage = myCategorizer.predictLanguage(inputTextFrench);
        System.out.println();
        System.out.println(inputTextFrench);
        System.out.println("Detected language: " + predictLanguage.getLang());
        System.out.println("Confidence: " + predictLanguage.getConfidence());

// Get an array with the most probable languages
//        Language[] languages = myCategorizer.predictLanguages(inputTextFrench);
//        System.out.println(Arrays.toString(languages));

    }

}

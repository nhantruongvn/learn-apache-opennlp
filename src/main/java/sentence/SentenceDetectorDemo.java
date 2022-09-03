package sentence;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SentenceDetectorDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(SentenceDetectorDemo.class.getName());
        logger.setLevel(Level.INFO);

        try (InputStream modelIn = new FileInputStream("src/main/resources/models/opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin")) {
            SentenceModel model = new SentenceModel(modelIn);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
            String sentences[] = sentenceDetector.sentDetect("  What can art teach you about the person who made it? Maybe you’ll learn about their favorite colors. Maybe you’ll learn what shapes they find interesting. Maybe you’ll learn about an emotion they felt, or wanted other people to feel. Or maybe you’ll learn about part of the artist’s culture that they wanted to share with you. ");
            for(String sentence : sentences)
                System.out.println(sentence);

            Span positions[] = sentenceDetector.sentPosDetect("  What can art teach you about the person who made it? Maybe you’ll learn about their favorite colors. Maybe you’ll learn what shapes they find interesting. Maybe you’ll learn about an emotion they felt, or wanted other people to feel. Or maybe you’ll learn about part of the artist’s culture that they wanted to share with you. ");
            for(Span position : positions)
                System.out.println(position);

        } catch (IOException e) {
            logger.info("Error while loading the model:");
            e.printStackTrace();
        }
    }
}

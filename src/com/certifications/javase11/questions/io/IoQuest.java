package src.com.certifications.javase11.questions.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IoQuest {

    public static void main(String[] args) {
        try (Reader reader1 = new FileReader("some.text");
            Reader reader2 = new FileReader("some.text");
            Reader reader3 = new FileReader("some.text")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

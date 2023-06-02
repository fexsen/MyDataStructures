package JavaLabs.FistSem.Lab6;
import java.io.*;
import java.util.*;

public class TranslateWriter {
    private FileWriter writer;
    private Dictionary dictionary;

    public TranslateWriter(FileWriter writer, Dictionary dictionary) {
        this.writer = writer;
        this.dictionary = dictionary;
    }

    public void write(String text) throws IOException {
        StringTokenizer st = new StringTokenizer(text, " ");
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (dictionary.contains(word)) {
                writer.write(dictionary.get(word) + " ");
            } else {
                writer.write(word + " ");
            }
        }
        writer.write("\n");
        writer.flush();
    }
}

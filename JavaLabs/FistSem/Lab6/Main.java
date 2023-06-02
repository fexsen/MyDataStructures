package JavaLabs.FistSem.Lab6;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter formatted data: %d %s %c");
        Object[] values = FormattedInput.scanf("%d %s %c");
        System.out.println("Integer: " + values[0]);
        System.out.println("String: " + values[1]);
        System.out.println("Char: " + values[2]);

         /*

        Dictionary dic = new Dictionary();
        dic.add(" ", "1");
        TranslateWriter wr = new TranslateWriter(new FileWriter("out.txt"), dic);
        wr.write("my sweet home");

          */
    }

}

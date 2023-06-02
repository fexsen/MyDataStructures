package JavaLabs.FistSem.Lab6;
import java.io.*;

public class EncodingConverter {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java EncodingConverter input_file output_file encoding");
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];
        String coding = args[2];
        String encoding = args[3];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), coding));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), encoding));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding: " + encoding);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error reading/writing file");
        }
    }
}

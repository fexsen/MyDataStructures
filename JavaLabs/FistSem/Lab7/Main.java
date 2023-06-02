package JavaLabs.FistSem.Lab7;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Settings sett = new Settings();
        Settings sett_new = new Settings();
        Settings sett_very_new = new Settings();

        sett.put("Audio", -11);
        System.out.println("default: " + sett.get("Audio"));

        sett.saveToBinaryFile("save_bin");
        sett_new.loadFromBinaryFile("save_bin");
        System.out.println("from text: " + sett_new.get("Audio"));

        sett.saveToTextFile("save_txt");
        sett_very_new.loadFromTextFile("save_txt");
        System.out.println("from bin: " + sett_very_new.get("Audio"));
    }
}

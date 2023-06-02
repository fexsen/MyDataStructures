package JavaLabs.FistSem.Lab7;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Settings {
    private Map<String, Integer> settingsMap;

    public Settings() {
        settingsMap = new HashMap<>();
    }

    public void put(String name, int value) {
        settingsMap.put(name, value);
    }

    public int get(String name) {
        return settingsMap.get(name);
    }

    public void delete(String name) {
        settingsMap.remove(name);
    }

    public void loadFromBinaryFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            settingsMap = (HashMap<String, Integer>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from binary file: " + e.getMessage());
        }
    }

    public void saveToBinaryFile(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(settingsMap);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving to binary file: " + e.getMessage());
        }
    }

    public void loadFromTextFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    try {
                        int value = Integer.parseInt(parts[1]);
                        settingsMap.put(parts[0], value);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing value in text file: " + e.getMessage());
                    }
                } else {
                    System.out.println("Error parsing line in text file: " + line);
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveToTextFile(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (Map.Entry<String, Integer> entry : settingsMap.entrySet()) {
                String line = entry.getKey() + "=" + entry.getValue();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error saving to text file: " + e.getMessage());
        }
    }
}

package JavaLabs.FistSem.Lab6;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;

    public Dictionary() {
        words = new HashMap<String, String>();
    }

    public void add(String word, String definition) {
        words.put(word, definition);
    }

    public String get(String word) {
        return words.get(word);
    }

    public void removeWord(String word) {
        words.remove(word);
    }

    public boolean contains(String word) {
        if(words.containsKey(word)){
            return true;
        }
        return false;
    }
}

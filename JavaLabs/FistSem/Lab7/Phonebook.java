package JavaLabs.FistSem.Lab7;

import java.io.*;

public class Phonebook implements Serializable {
    private final String fileName = "phonebook.bin";
    private Contact[] entries;

    public Phonebook(Contact[] entries) {
        this.entries = entries;
    }

    public void writeBinary() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        try {
            out.writeObject(entries);
        } finally {
            out.close();
        }
    }

    public void readBinary() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        try {
            entries = (Contact[]) in.readObject();
        } finally {
            in.close();
        }
    }

    public void writeText() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("phonebook.txt"));
        try {
            for (Contact contact : entries) {
                out.println(contact.getName() + ";" + contact.getPhone());
            }
        } finally {
            out.close();
        }
    }

    public void readText() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("phonebook.txt"));
        int numEntries = countLines("phonebook.txt");
        entries = new Contact[numEntries];
        for (int i = 0; i < numEntries; i++) {
            String line = in.readLine();
            String[] parts = line.split(";");
            entries[i] = new Contact(parts[0], parts[1]);
        }
        in.close();
    }

    private int countLines(String filename) throws IOException {
        LineNumberReader reader = new LineNumberReader(new FileReader(filename));
        int count = 0;
        try {
            while (reader.readLine() != null) count++;
        } finally {
            reader.close();
        }
        return count;
    }

    public static class Contact implements Serializable {
        private String name;
        private String phone;

        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

}
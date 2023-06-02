package JavaLabs.FistSem.Lab6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattedInput {
    public static Object[] scanf(String format) {
        String inputStr = readStringFromStdin();
        return sscanf(format, inputStr);
    }

    public static Object[] sscanf(String format, String in) {
        String[] formatSpecifiers = format.split("\\s+");
        String[] values = in.trim().split("\\s+");
        Object[] result = new Object[formatSpecifiers.length];
        if (formatSpecifiers.length != values.length) {
            System.out.println("Input does not match format");
            return sscanf(format, readStringFromStdin());
        }
        for (int i = 0; i < formatSpecifiers.length; i++) {
            String specifier = formatSpecifiers[i];
            String value = values[i];
            switch (specifier) {
                case "%d" -> {
                    try {
                        result[i] = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        System.out.println("Input does not match format");
                        return sscanf(format, readStringFromStdin());
                    }
                }
                case "%f" -> {
                    try {
                        result[i] = Double.parseDouble(value);
                    } catch (NumberFormatException e) {
                        System.out.println("Input does not match format");
                        return sscanf(format, readStringFromStdin());
                    }
                }
                case "%s" -> result[i] = value;
                case "%c" -> {
                    if (value.length() != 1) {
                        System.out.println("Input does not match format");
                        return sscanf(format, readStringFromStdin());
                    }
                    result[i] = value.charAt(0);
                }
                default -> {
                    System.out.println("Invalid format specifier");
                    return sscanf(format, readStringFromStdin());
                }
            }
        }
        return result;
    }

    private static String readStringFromStdin() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading from stdin");
            return "";
        }
    }
}

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static long byteCount(String filePath) {
        return new File(filePath).length();
    }

    private static long lineCount(BufferedReader bufferedReader) throws IOException {
        long lineCount = 0;
        while(bufferedReader.readLine() != null)
            lineCount++;

        return lineCount;
    }

    private static long wordCount(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        long wordCount = 0;

        String line;

        while((line = bufferedReader.readLine()) != null) {
            if(!line.isEmpty()) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }

    private static long charCount(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        long charCount = 0;

        String line;

        while((line = bufferedReader.readLine()) != null) {
            charCount += line.length();
        }

        return charCount;
    }

    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        if(args.length == 0 || args.length > 2) {
            System.out.println("Incorrect number of arguments");
            return;
        }
        else if(args.length == 1 || args[1].isEmpty()) {
            if(args[0].length() == 2 && args[0].charAt(0) == '-') {
                System.out.println("Unknown command file combination");
                return;
            }

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
                long lines = lineCount(bufferedReader);
                long words = wordCount(args[0]);
                System.out.println(lines + " " + words + " " + byteCount(args[0]) + " " + args[0]);
            }
            catch (FileNotFoundException notFound) {
                System.out.println("File not found");
            }
            return;
        }

        String command = args[0];
        String filePath = args[1].trim();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            long lines = lineCount(bufferedReader);
            long words = wordCount(filePath);
            long chars = charCount(filePath);

            switch (command) {
                case "-c":
                    System.out.println(byteCount(filePath) + " " + filePath);
                    break;
                case "-l":
                    System.out.println(lines + " " + filePath);
                    break;
                case "-w":
                    System.out.println(words + " " + filePath);
                    break;
                case "-m":
                    System.out.println(chars + " " + filePath);
                    break;
                default:
                    System.out.println("Could not resolve this " + command + " command");
                    break;
            }
        }
        catch (FileNotFoundException notFound) {
            System.out.println("File not found");
        }

    }
}
package junit.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class FileProcessor {

    public static void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes());
    }
    public static String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
package src.test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import src.main.java.org.example.*;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    @TempDir
    Path tempDir; // JUnit creates & deletes this automatically

    @Test
    void testWriteAndReadFile() throws IOException {
        Path file = tempDir.resolve("test.txt");

        FileProcessor.writeToFile(file.toString(), "Hello JUnit");
        String content = FileProcessor.readFromFile(file.toString());

        assertEquals("Hello JUnit", content);
    }
    @Test
    void testFileExistsAfterWrite() throws IOException {
        Path file = tempDir.resolve("exists.txt");

        FileProcessor.writeToFile(file.toString(), "Check file");

        assertTrue(file.toFile().exists());
    }
    @Test
    void testReadFromNonExistingFile() {
        Path file = tempDir.resolve("missing.txt");

        assertThrows(IOException.class, () -> {
            FileProcessor.readFromFile(file.toString());
        });
    }
}
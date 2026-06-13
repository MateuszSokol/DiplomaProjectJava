package save_read_data;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class MyFileTest {

    @Test
    void testSaveDataToFile() throws IOException {
        // Tworzymy tymczasowy plik
        File tempFile = File.createTempFile("testfile", ".txt");

        // Wywołujemy metodę
        MyFile.saveDataToFile(tempFile.getAbsolutePath());

        // Odczytujemy zawartość
        String content = Files.readString(tempFile.toPath());

        assertEquals("Hello", content);
    }

    @Test
    void testReadDataFromFile() throws IOException {
        // Tworzymy tymczasowy plik
        File tempFile = File.createTempFile("testfile", ".txt");

        // Zapisujemy coś do pliku
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Line1\nLine2");
        }

        // Wywołujemy metodę — nie zwraca nic, ale nie powinna rzucać wyjątków
        assertDoesNotThrow(() -> MyFile.readDataFromFile(tempFile.getAbsolutePath()));
    }

    @Test
    void testReadDataFromFile_FileNotFound() {
        // Podajemy ścieżkę do nieistniejącego pliku
        String fakePath = "C:/this/file/does/not/exist.txt";

        // Metoda nie powinna rzucać wyjątku
        assertDoesNotThrow(() -> MyFile.readDataFromFile(fakePath));
    }
}

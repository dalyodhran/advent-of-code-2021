package common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @TempDir
    File tempDir;

    @Test
    public void testReadFile() throws IOException {
        ReadFile readFile = new ReadFile();
        File sampleDataFile = new File(tempDir, "sampleFile.txt");

        String expectedStringValue = "forward 5\n down 5\n forward 8\n up 3\n down 8\n forward 2";
        byte[] strToByte = expectedStringValue.getBytes(StandardCharsets.UTF_8);
        Files.write(sampleDataFile.toPath(), strToByte);

        String actualStringValue = readFile.getFileData(sampleDataFile.toPath());
        assertTrue(sampleDataFile.exists());
        assertEquals(expectedStringValue, actualStringValue);
    }

    @Test
    public void readFilesFromResources() throws IOException {
        ReadFile readFile = new ReadFile();
        Path filePath = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/positions.txt");
        String data = readFile.getFileData(filePath);
        assertNotNull(data);
    }
}
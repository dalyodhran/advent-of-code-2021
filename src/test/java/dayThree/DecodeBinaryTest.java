package dayThree;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DecodeBinaryTest {

    @Test
    public void sampleData() throws IOException {
        DecodeBinary decodeBinary = new DecodeBinary();
        String data = "00100\n 11110\n 10110\n 10111\n 10101\n 01111\n 00111\n 11100\n 10000\n 11001\n 00010\n 01010";
        int actualPowerConsumption = decodeBinary.getPowerConsumption(data);
        assertEquals(198, actualPowerConsumption);
    }

    @Test
    public void testData() throws IOException {
        DecodeBinary decodeBinary = new DecodeBinary();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/diagnosticReport.txt");
        String data = readFile.getFileData(pathToFile);
        int actualPowerConsumption = decodeBinary.getPowerConsumption(data);
        assertEquals(198, actualPowerConsumption);
    }
}
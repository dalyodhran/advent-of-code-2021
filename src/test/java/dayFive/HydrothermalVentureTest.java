package dayFive;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HydrothermalVentureTest {

    @Test
    public void sampleData() {
        HydrothermalVenture hydrothermalVenture = new HydrothermalVenture();
        String data = "0,9 -> 5,9\n" +
                "8,0 -> 0,8\n" +
                "9,4 -> 3,4\n" +
                "2,2 -> 2,1\n" +
                "7,0 -> 7,4\n" +
                "6,4 -> 2,0\n" +
                "0,9 -> 2,9\n" +
                "3,4 -> 1,4\n" +
                "0,0 -> 8,8\n" +
                "5,5 -> 8,2";
        int numberOfDangerHydrothermalVenture = hydrothermalVenture.getNumberOfDangerVents(data);
        assertEquals(12, numberOfDangerHydrothermalVenture);
    }

    @Test
    public void testData() throws IOException {
        HydrothermalVenture hydrothermalVenture = new HydrothermalVenture();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/vents.txt");
        String data = readFile.getFileData(pathToFile);
        int actualPowerConsumption = hydrothermalVenture.getNumberOfDangerVents(data);
        assertEquals(230, actualPowerConsumption);
    }

}
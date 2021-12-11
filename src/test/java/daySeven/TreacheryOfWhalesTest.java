package daySeven;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TreacheryOfWhalesTest {

    @Test
    public void sampleData() {
        TreacheryOfWhales whales = new TreacheryOfWhales();
        String data = "16,1,2,0,4,2,7,1,2,14";
        Double fuel = whales.getFuelAmount(data);
        assertEquals(168, fuel);
    }

    @Test
    public void testData() throws IOException {
        TreacheryOfWhales whales = new TreacheryOfWhales();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/whale.txt");
        String data = readFile.getFileData(pathToFile);
        Double fuel = whales.getFuelAmount(data);
        assertEquals(37, fuel);
    }

}
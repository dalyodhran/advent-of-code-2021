package dayFourteen;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedPolymerizationTest {

    @Test
    public void sampleData() {
        ExtendedPolymerization polymerization = new ExtendedPolymerization();
        String data = "NNCB\n" +
                "\n" +
                "CH -> B\n" +
                "HH -> N\n" +
                "CB -> H\n" +
                "NH -> C\n" +
                "HB -> C\n" +
                "HC -> B\n" +
                "HN -> C\n" +
                "NN -> C\n" +
                "BH -> H\n" +
                "NC -> B\n" +
                "NB -> B\n" +
                "BN -> B\n" +
                "BB -> N\n" +
                "BC -> B\n" +
                "CC -> N\n" +
                "CN -> C";
        int polymer = polymerization.getPolymer(data);
        assertEquals(1588, polymer);
    }

    @Test
    public void testData() throws IOException {
        ExtendedPolymerization polymerization = new ExtendedPolymerization();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/polymer.txt");
        String data = readFile.getFileData(pathToFile);
        int polymer = polymerization.getPolymer(data);
        assertEquals(1588, polymer);
    }

}
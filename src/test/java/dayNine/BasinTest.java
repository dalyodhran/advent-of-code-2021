package dayNine;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasinTest {

    @Test
    public void sampleData() {
        Basin basin = new Basin();
        String data = "2199943210\n" +
                "3987894921\n" +
                "9856789892\n" +
                "8767896789\n" +
                "9899965678";
        int largestBasins = basin.getLargestBasin(data);
        assertEquals(1134, largestBasins);
    }

    @Test
    public void tesData() throws IOException {
        Basin basin = new Basin();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/heights.txt");
        String data = readFile.getFileData(pathToFile);
        int largestBasins = basin.getLargestBasin(data);
        assertEquals(1134, largestBasins);
    }

}
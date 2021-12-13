package dayNine;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmokeBasinTest {

    @Test
    public void sampleData() {
        SmokeBasin smokeBasin = new SmokeBasin();
        String data = "2199943210\n" +
                "3987894921\n" +
                "9856789892\n" +
                "8767896789\n" +
                "9899965678";
        List<Pair> riskLevel = smokeBasin.getRiskLeve(data);
        assertEquals(15, riskLevel.size());
    }

    @Test
    public void tesData() throws IOException {
        SmokeBasin smokeBasin = new SmokeBasin();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/heights.txt");
        String data = readFile.getFileData(pathToFile);
        List<Pair> riskLevel = smokeBasin.getRiskLeve(data);
        assertEquals(15, riskLevel.size());
    }

}
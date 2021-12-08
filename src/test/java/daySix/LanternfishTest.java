package daySix;

import common.ReadFile;
import dayFive.HydrothermalVenture;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LanternfishTest {

    @Test
    public void sampleData() {
        Lanternfish lanternfish = new Lanternfish();
        String data = "3,4,3,1,2";
        long fish = lanternfish.getNumberOfLanterfish(data);
        assertEquals(26984457539L, fish);
    }

    @Test
    public void testData() throws IOException {
        Lanternfish lanternfish = new Lanternfish();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/fish.txt");
        String data = readFile.getFileData(pathToFile);
        Long fish = lanternfish.getNumberOfLanterfish(data);
        assertEquals(5934L, fish);
    }

}
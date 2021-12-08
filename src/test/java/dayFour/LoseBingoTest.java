package dayFour;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LoseBingoTest {

    @Test
    public void sampleData() {
        LoseBingo bingo = new LoseBingo();
        String data = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\n" +
                "22 13 17 11  0\n" +
                " 8  2 23  4 24\n" +
                "21  9 14 16  7\n" +
                " 6 10  3 18  5\n" +
                " 1 12 20 15 19\n" +
                "\n" +
                " 3 15  0  2 22\n" +
                " 9 18 13 17  5\n" +
                "19  8  7 25 23\n" +
                "20 11 10 24  4\n" +
                "14 21 16 12  6\n" +
                "\n" +
                "14 21 17 24  4\n" +
                "10 16 15  9 19\n" +
                "18  8 23 26 20\n" +
                "22 11 13  6  5\n" +
                " 2  0 12  3  7";
        int score = bingo.getLosingScore(data);
        assertEquals(1924, score);
    }

    @Test
    public void testData() throws IOException {
        LoseBingo bingo = new LoseBingo();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/bingoData.txt");
        String data = readFile.getFileData(pathToFile);
        int actualPowerConsumption = bingo.getLosingScore(data);
        assertEquals(230, actualPowerConsumption);
    }

}
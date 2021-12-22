package dayThirty;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransparentOrigamiTest {

    @Test
    public void sampleData() throws IOException {
        TransparentOrigami origami = new TransparentOrigami();
        String data = "6,10\n" +
                "0,14\n" +
                "9,10\n" +
                "0,3\n" +
                "10,4\n" +
                "4,11\n" +
                "6,0\n" +
                "6,12\n" +
                "4,1\n" +
                "0,13\n" +
                "10,12\n" +
                "3,4\n" +
                "3,0\n" +
                "8,4\n" +
                "1,10\n" +
                "2,14\n" +
                "8,10\n" +
                "9,0\n" +
                "9,14\n" +
                "\n" +
                "fold along y=7\n" +
                "fold along x=5";
        int numberOfDots = origami.getDots(data);
        assertEquals(17, numberOfDots);
    }

    @Test
    public void testData() throws IOException {
        TransparentOrigami origami = new TransparentOrigami();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/folds.txt");
        String data = readFile.getFileData(pathToFile);
        int numberOfDots = origami.getDots(data);
        assertEquals(17, numberOfDots);
    }

}
package dayTwo;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void samplePositions() throws IOException {
        Position position = new Position();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/samplePositions.txt");
        String data = readFile.getFileData(pathToFile);
        int distance = position.getPosition(data);
        assertEquals(900, distance);
    }

    @Test
    public void testPositions() throws IOException {
        Position position = new Position();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/positions.txt");
        String data = readFile.getFileData(pathToFile);
        int distance = position.getPosition(data);
        assertEquals(150, distance);
    }

}
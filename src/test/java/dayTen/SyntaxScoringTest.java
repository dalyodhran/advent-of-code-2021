package dayTen;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SyntaxScoringTest {

    @Test
    public void sampleData() {
        SyntaxScoring scoring = new SyntaxScoring();
        String data = "[({(<(())[]>[[{[]{<()<>>\n" +
                "[(()[<>])]({[<{<<[]>>(\n" +
                "{([(<{}[<>[]}>{[]{[(<()>\n" +
                "(((({<>}<{<{<>}{[]{[]{}\n" +
                "[[<[([]))<([[{}[[()]]]\n" +
                "[{[{({}]{}}([{[{{{}}([]\n" +
                "{<[[]]>}<{[{[{[]{()[[[]\n" +
                "[<(<(<(<{}))><([]([]()\n" +
                "<{([([[(<>()){}]>(<<{{\n" +
                "<{([{{}}[<[[[<>{}]]]>[]]";
        int illegalScore = scoring.getIllegalScore(data);
        assertEquals(26397, illegalScore);
    }

    @Test
    public void testData() throws IOException {
        SyntaxScoring scoring = new SyntaxScoring();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/syntax.txt");
        String data = readFile.getFileData(pathToFile);
        int illegalScore = scoring.getIllegalScore(data);
        assertEquals(26397, illegalScore);
    }

}
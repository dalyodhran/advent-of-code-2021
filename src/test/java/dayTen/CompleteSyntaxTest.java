package dayTen;

import common.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CompleteSyntaxTest {

    @Test
    public void sampleTest() {
        CompleteSyntax syntax = new CompleteSyntax();
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
        Long completeScore = syntax.getCompleteScore(data);
        assertEquals(288957L, completeScore);
    }

    @Test
    public void testData() throws IOException {
        CompleteSyntax syntax = new CompleteSyntax();
        ReadFile readFile = new ReadFile();
        Path pathToFile = Path.of("/Users/odhrandaly/Dev/AdventOfCode/src/test/java/files/syntax.txt");
        String data = readFile.getFileData(pathToFile);
        Long completeScore = syntax.getCompleteScore(data);
        assertEquals(288957L, completeScore);
    }

}
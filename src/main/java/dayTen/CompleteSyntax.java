package dayTen;

import java.util.*;
import java.util.stream.Collectors;

public class CompleteSyntax {
    public Long getCompleteScore(String data) {
        String[] syntaxLines = data.split("\\r?\\n");
        List<Long> completeScores = new ArrayList<>();

        for (String line : syntaxLines) {
            Long score = getScores(line);
            if (score != 0) {
                completeScores.add(score);
            }
        }

        completeScores = completeScores.stream().sorted().collect(Collectors.toList());

        return completeScores.get(completeScores.size() / 2);
    }

    private Long getScores(String line) {
        Map<Character, Integer> syntaxPoints = new HashMap<>(){
            {
                put('(', 1);
                put('[', 2);
                put('{', 3);
                put('<', 4);
            }
        };
        Long score = 0L;

        Stack<Character> syntaxStack = new Stack<>();
        boolean isCorrupt = false;

        for (int i = 0; i < line.length(); i++) {
            char syntax = line.charAt(i);

            if (syntax == '(' || syntax == '[' || syntax == '{' || syntax == '<') {
                syntaxStack.push(syntax);
            } else {
                if ((syntaxStack.peek() == '(' && syntax == ')') ||
                        (syntaxStack.peek() == '[' && syntax == ']') ||
                        (syntaxStack.peek() == '{' && syntax == '}') ||
                        (syntaxStack.peek() == '<' && syntax == '>')) {
                    syntaxStack.pop();
                } else {
                    isCorrupt = true;
                    break;
                }
            }
        }

        if(!isCorrupt) {
            while (!syntaxStack.isEmpty()) {
                score *= 5;
                score += syntaxPoints.get(syntaxStack.pop());
            }
        }
        return score;
    }
}

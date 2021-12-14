package dayTen;

import java.util.*;

public class SyntaxScoring {
    public int getIllegalScore(String data) {
        String[] syntaxLines = data.split("\\r?\\n");
        List<Integer> corruptScores = new ArrayList<>();

        for (String line : syntaxLines) {
            corruptScores.add(getCorruptScore(line));
        }

        return corruptScores.stream().reduce(0, Integer::sum);
    }

    private Integer getCorruptScore(String line) {
        Map<Character, Integer> syntaxErrorPoints = new HashMap<>(){
            {
                put(')', 3);
                put(']', 57);
                put('}', 1197);
                put('>', 25137);
            }
        };
        int score = 0;

        Stack<Character> syntaxStack = new Stack<>();

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
                    score = syntaxErrorPoints.get(syntax);
                    break;
                }
            }
        }
        return score;
    }
}

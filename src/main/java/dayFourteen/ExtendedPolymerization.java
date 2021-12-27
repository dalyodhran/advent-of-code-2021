package dayFourteen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExtendedPolymerization {
    public int getPolymer(String data) {
        String[] input = data.split("\\r?\\n");
        String polymer = input[0];
        Map<String, String> polymerCodes = getPolymerCodes(input);

        for (int i = 0; i < 10; i++) {
            polymer = cyclePolymerCodes(polymer, polymerCodes);
        }

        int quantity = Integer.MIN_VALUE;
        int quality = Integer.MAX_VALUE;
        Map<Character, Integer> codeCount = new HashMap<>();

        for (int i = 0; i < polymer.length(); i++) {
            if(codeCount.containsKey(polymer.charAt(i))) {
                codeCount.put(polymer.charAt(i), codeCount.get(polymer.charAt(i)) + 1);
            } else {
                codeCount.put(polymer.charAt(i), 1);
            }
        }

        for (Character c: codeCount.keySet()) {
            if (quantity < codeCount.get(c)) {
                quantity = codeCount.get(c);
            }

            if (quality > codeCount.get(c)) {
                quality = codeCount.get(c);
            }
        }

        return (quantity / 2 )  - (quality / 2);
    }

    private String cyclePolymerCodes(String polymer, Map<String, String> polymerCodes) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < polymer.length(); i++) {
            if (i == polymer.length() - 1) {
                sb.append(polymer.charAt(i));
                break;
            }
            String code = polymer.substring(i, i+2);
            String insert = "";
            if (polymerCodes.containsKey(code)) {
                insert = polymerCodes.get(code);
            }
            sb.append(polymer.charAt(i) + insert);
        }

        return sb.toString();
    }

    private List<String> getPolymerText(String[] input) {
        List<String> tmpPolymerText = new LinkedList<>();

        String text = input[0];

        for (int i = 0; i < text.length(); i++) {
            tmpPolymerText.add(String.valueOf(text.charAt(i)));
        }

        return tmpPolymerText;
    }

    private Map<String, String> getPolymerCodes(String[] input) {
        Map<String, String> tmpPolyCodes = new HashMap<>();
        for (int i = 2; i < input.length; i++) {
            String [] codes = input[i].split("->");
            tmpPolyCodes.put(codes[0].trim(), codes[1].trim());
        }
        return tmpPolyCodes;
    }
}

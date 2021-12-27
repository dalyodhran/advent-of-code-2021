package dayFourteen;

import java.util.HashMap;
import java.util.Map;

public class ExtendedPolymerizationPartTwo {
    public Long getPolymer(String data) {
        String[] input = data.split("\\r?\\n");
        Map<String, String> polymerCodes = getPolymerCodes(input);
        Map<String, Long> polymer = getPolymerCont(input[0]);
        for (int i = 0; i < 40; i++) {
            polymer = getPairCount(polymer, polymerCodes);
        }

        return getCommonElements(polymer);
    }

    private Long getCommonElements(Map<String, Long> polymer) {
        Map<String, Long> tmpPolymerCount = new HashMap<>();

        for (String code : polymer.keySet()) {
            Long quantity = polymer.get(code);
            for (int i = 0; i < code.length(); i++) {
                if (tmpPolymerCount.containsKey(String.valueOf(code.charAt(i)))) {
                    tmpPolymerCount.put(String.valueOf(code.charAt(i)), tmpPolymerCount.get(String.valueOf(code.charAt(i))) + quantity);
                } else {
                    tmpPolymerCount.put(String.valueOf(code.charAt(i)), quantity);
                }
            }
        }

        Long quantity = Long.MIN_VALUE;
        Long quality = Long.MAX_VALUE;


        for (String code: tmpPolymerCount.keySet()) {
            if (quantity < tmpPolymerCount.get(code)) {
                quantity = tmpPolymerCount.get(code);
            }

            if (quality > tmpPolymerCount.get(code)) {
                quality = tmpPolymerCount.get(code);
            }
        }

        return Double.valueOf(Math.ceil((double) quantity / 2)).longValue() -
                Double.valueOf(Math.ceil((double) quality / 2)).longValue();
    }

    private Map<String, Long> getPairCount(Map<String, Long> polymer, Map<String, String> polymerCodes) {
        Map<String, Long> tmpPolymer = new HashMap<>();
        for (String code : polymer.keySet()) {
            Long quantity = polymer.get(code);
            String insert = polymerCodes.get(code);
            String strOne = code.charAt(0) + insert;
            String strTwo = insert + code.charAt(1);

            if (tmpPolymer.containsKey(strOne)) {
                tmpPolymer.put(strOne, quantity + tmpPolymer.get(strOne));
            } else {
                tmpPolymer.put(strOne, quantity);
            }

            if (tmpPolymer.containsKey(strTwo)) {
                tmpPolymer.put(strTwo, quantity + tmpPolymer.get(strTwo));
            } else {
                tmpPolymer.put(strTwo, quantity);
            }
        }
        return tmpPolymer;
    }

    private Map<String, Long> getPolymerCont(String data) {
        Map<String, Long> tmpPolymer = new HashMap<>();

        for (int i = 0; i < data.length() - 1; i++) {
            String code = data.substring(i, i + 2);
            if (tmpPolymer.containsKey(code)) {
                tmpPolymer.put(code, tmpPolymer.get(code) + 1);
            } else {
                tmpPolymer.put(code, 1L);
            }
        }
        return tmpPolymer;
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

package dayEight;

import java.util.*;
import java.util.stream.Collectors;

public class SegmentDecoder {
    public int getDecodedNumber(String data) {
        int count = 0;

        String[] lines = data.split("\\r?\\n");

        for (String line : lines) {
            String[] codes = line.split("\\|");
            Map<Integer, String> decodedDigits = getDecodedDigits(codes[0]);
            decodedDigits = sortCodes(decodedDigits);

            StringBuilder sb = new StringBuilder();
            String[] decode = codes[1].split("\\s");
            decode = sortDecode(decode);
            for (String digit : decode) {
                sb.append(getDigit(digit, decodedDigits));
            }

            count += Integer.parseInt(sb.toString());
        }
        return count;
    }

    private String[] sortDecode(String[] decode) {
        String[] sortedDecode = decode;

        for (int i = 0; i < sortedDecode.length; i++) {
            sortedDecode[i] = sortCode(sortedDecode[i]);
        }
        return sortedDecode;
    }

    private Map<Integer, String> sortCodes(Map<Integer, String> decodedDigits) {
        Map<Integer, String> sortedCodes = decodedDigits;

        for (int i = 0; i < 10; i++) {
            sortedCodes.put(i, sortCode(sortedCodes.get(i)));
        }
        return sortedCodes;
    }

    private String sortCode(String s) {
        char[] strToChar = s.toCharArray();
        Arrays.sort(strToChar);
        return String.valueOf(strToChar);
    }

    private int getDigit(String digit, Map<Integer, String> decodedDigits) {
        int intDigit = 0;

        for (int i = 0; i < 10; i++) {
            if (digit.equals(decodedDigits.get(i))) {
                intDigit = i;
            }
        }
        return intDigit;
    }

    private Map<Integer, String> getDecodedDigits(String codes) {
        Map<Integer, String> decodedDigits = new HashMap<>();
        String[] digit = codes.split("\\s");
        List<String> digitAsList = Arrays.stream(digit)
                .sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        for (int i = 0; i < digitAsList.size(); i++) {
            switch (digitAsList.get(i).length()) {
                case 2:
                    decodedDigits.put(1, digitAsList.get(i));
                    break;

                case 3:
                    decodedDigits.put(7, digitAsList.get(i));
                    break;

                case 4:
                    decodedDigits.put(4, digitAsList.get(i));
                    break;
                    
                case 5:
                    decodedDigits = getDigitForLengthFive(decodedDigits, digitAsList, i);
                    break;

                case 6:
                    decodedDigits = getDigitForLengthSix(decodedDigits, digitAsList, i);
                    break;
                    
                case 7:
                    decodedDigits.put(8, digitAsList.get(i));
                    break;

                default:
                    System.out.println("Not a supported digit");
            }
        }

        return decodedDigits;
    }

    private Map<Integer, String> getDigitForLengthSix(Map<Integer, String> decodedDigits, List<String> digitAsList, int i) {
        Map<Integer, String> tmoDecodedDigits = decodedDigits;

        if (containsDigit(digitAsList.get(i), tmoDecodedDigits.get(1))
                && containsDigit(digitAsList.get(i), tmoDecodedDigits.get(4))
                && containsDigit(digitAsList.get(i), tmoDecodedDigits.get(7))) {
            tmoDecodedDigits.put(9, digitAsList.get(i));
        } else if (containsDigit(digitAsList.get(i), tmoDecodedDigits.get(1))
                && containsDigit(digitAsList.get(i), tmoDecodedDigits.get(7))) {
            tmoDecodedDigits.put(0, digitAsList.get(i));
        } else {
            tmoDecodedDigits.put(6, digitAsList.get(i));
        }

        return tmoDecodedDigits;
    }

    private Map<Integer, String> getDigitForLengthFive(Map<Integer, String> decodedDigits, List<String> digitAsList, int i) {
        Map<Integer, String> tmoDecodedDigits = decodedDigits;

        if (containsDigit(digitAsList.get(i), tmoDecodedDigits.get(1))
                && containsDigit(digitAsList.get(i), tmoDecodedDigits.get(7))) {
            tmoDecodedDigits.put(3, digitAsList.get(i));
        }else if (matchesTwoDigits(digitAsList.get(i), tmoDecodedDigits.get(4))) {
            tmoDecodedDigits.put(2, digitAsList.get(i));
        }else if (matchesThreeDigits(digitAsList.get(i), tmoDecodedDigits.get(4))) {
            tmoDecodedDigits.put(5, digitAsList.get(i));
        }

        return tmoDecodedDigits;
    }

    private boolean matchesThreeDigits(String s, String s1) {
        int count = getDigitCount(s, s1);
        return count == 3;
    }

    private boolean matchesTwoDigits(String s, String s1) {
        int count = getDigitCount(s, s1);
        return count == 2;
    }

    private int getDigitCount(String s, String s1) {
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (containsChar(s, s1.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean containsDigit(String s, String s1) {
        boolean contains = true;

        for (int i = 0; i < s1.length(); i++) {
            if (!containsChar(s, s1.charAt(i))) {
                contains = false;
            }
        }
        return contains;
    }

    private boolean containsChar(String s, char charAt) {
        boolean contains = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == charAt) {
                contains = true;
            }
        }
        return contains;
    }
}

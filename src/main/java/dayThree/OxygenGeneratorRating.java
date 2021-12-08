package dayThree;

import java.util.ArrayList;
import java.util.List;

public class OxygenGeneratorRating {

    int getOxygenRating(String data) {

        String[] reportData = data.split("\\r?\\n");

        String oxygen = getRating(reportData, 0, "Max");
        String co2 = getRating(reportData, 0, "Min");

        return Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2);
    }

    private String getRating(String[] binaryArray, int index, String findMinMax) {
        if (binaryArray.length - 1 < 1) {
            return binaryArray[binaryArray.length - 1];
        }

        char c = getMostOccurringBit(binaryArray, index, findMinMax);

        List<String> binaries = splitBinary(binaryArray, index, c);
        return getRating(binaries.stream().toArray(String[]::new), ++index, findMinMax);
    }

    private List<String> splitBinary(String[] binaryArray, int index, char c) {
        List<String> binaries = new ArrayList<>();

        for (String binary : binaryArray) {
            binary = binary.trim();
            if (binary.charAt(index) == c) {
                binaries.add(binary);
            }
        }

        return binaries;
    }

    private char getMostOccurringBit(String[] binaries, int index, String findMinMax) {
        int zeroCount = 0;
        int oneCount = 0;

        for (String binary : binaries) {
            binary = binary.trim();
            if (binary.charAt(index) == 48) {
                zeroCount += 1;
            } else {
                oneCount += 1;
            }
        }

        if (findMinMax.equals("Min")) {
            return zeroCount <= oneCount ? '0' : '1';
        } else {
            return zeroCount > oneCount ? '0' : '1';
        }
    }
}
package dayEight;

import java.util.Arrays;

public class SevenSegmentSearch {
    public int findOccurrence(String data) {
        int count = 0;

        String[] lines = data.split("\\r?\\n");

        for (String line : lines) {
            String[] digits = line.split("\\|");
            String[] afterPipe = digits[1].split("\\s");
            for (String digit : afterPipe) {
                switch (digit.length()) {
                    case 2:
                        count++;
                        break;

                    case 3:
                        count++;
                        break;

                    case 4:
                        count++;
                        break;

                    case 7:
                        count++;
                        break;

                    default:
                        System.out.println("Not a unique segment");
                }
            }
        }
        return count;
    }
}

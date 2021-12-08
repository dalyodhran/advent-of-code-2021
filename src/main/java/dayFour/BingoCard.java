package dayFour;

import java.util.HashMap;
import java.util.Map;

public class BingoCard {

    int [][] markArray = new int[5][5];
    Map<Integer, int[]> numberAndPosition = new HashMap<>();
    private int winningSum = 0;

    void mapBingoCard(String card) {
        String [] rows = card.split("\\r?\\n");

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].trim();
            String[] columns = splitIntoColumn(row);
            for (int j = 0; j < columns.length; j++) {
                String column = columns[j].trim();
                numberAndPosition.put(Integer.parseInt(column), new int[]{i, j});
            }
        }
    }

    private String[] splitIntoColumn(String row) {
        String [] splitRow = new String[5];
        String [] tempArray = row.split("\\s");
        int index = 0;
        for (int i = 0; i < tempArray.length; i++) {
            if(!tempArray[i].equals("")) {
                splitRow[index] = tempArray[i];
                index++;
            }
        }
        return splitRow;
    }

    Map<Integer, int[]> getNumberAndPosition() {
        return numberAndPosition;
    }

    void checkNumber(int number) {
        if(numberAndPosition.containsKey(number)){
            int [] position = numberAndPosition.get(number);
            markArray[position[0]][position[1]] = 1;
        }
    }

    boolean checkForBingo() {
        boolean bingo = false;

        for (int i = 0; i < markArray.length; i++) {
            int horizontal = 0;
            int vertical = 0;
            for (int j = 0; j < markArray.length; j++) {
                if(markArray[i][j] == 1) {
                   horizontal++;
                }
            }

            if (horizontal == 5) {
                bingo = true;

            }

            for (int j = 0; j < markArray.length; j++) {
                if (markArray[j][i] == 1){
                    vertical++;
                }
            }

            if (vertical == 5) {
                bingo = true;
            }
        }
        return bingo;
    }

    private boolean doArrayMatch(int[] value, int[] ints) {
        for (int i = 0; i < value.length; i++) {
            if(value[i] != ints[i]) {
                return false;
            }
        }
        return true;
    }

    public int getWinningSum() {
        int sum = 0;
        for (int i = 0; i < markArray.length; i++) {
            for (int j = 0; j < markArray.length; j++) {
                if(markArray[i][j] == 0) {
                    sum += getKey(i, j);
                }
            }
        }
        return sum;
    }

    private int getKey(int i, int j) {
        int key = 0;
        for (Map.Entry<Integer, int[]> entry : numberAndPosition.entrySet()) {
            if (doArrayMatch(entry.getValue(), new int []{i, j})) {
                key = entry.getKey();
                break;
            }
        }
        return key;
    }
}

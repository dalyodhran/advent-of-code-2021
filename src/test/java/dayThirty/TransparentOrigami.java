package dayThirty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransparentOrigami {

    public int getDots(String data) throws IOException {
        String[] inputData = data.split("\\r?\\n");

        int[][] dotMap = getDotMap(inputData);
        List<String> folds = getFolds(inputData);
        for (int i = 0; i < folds.size(); i++) {
            String[] fold = folds.get(i).split("=");
            if (fold[0].equals("x")) {
                dotMap = getFoldXAxisNumber(Integer.parseInt(fold[1]), dotMap);
            } else {
                dotMap = getFoldYAxisNumber(Integer.parseInt(fold[1]), dotMap);
            }
        }
        printSheet(dotMap);
        return getDotCount(dotMap);
    }

    private void printSheet(int[][] dotMap) throws IOException {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < dotMap.length; i++)//for each row
        {
            for(int j = 0; j < dotMap[0].length; j++)//for each column
            {
                builder.append(dotMap[i][j]+"");//append to the output string
                if(j < dotMap[0].length - 1)//if this is not the last row element
                    builder.append(",");//then add comma (if you don't like commas you can use spaces)
            }
            builder.append("\n");//append new line at the end of the row
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("./board.txt"));
        writer.write(builder.toString());//save the string representation of the board
        writer.close();
    }

    private int getDotCount(int[][] dotMap) {
        int count = 0;
        for (int i = 0; i < dotMap.length; i++) {
            for (int j = 0; j < dotMap[0].length; j++) {
                if (dotMap[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[][] getFoldXAxisNumber(int x, int[][] dotMap) {
        for (int i = 0; i < dotMap.length; i++) {
            for (int j = 0; j < dotMap[0].length; j++) {
                if (dotMap[i][j] == 1 && x != j) {
                    if (j > x) {
                        int xTransform = x - j + x;

                        if (dotMap[i][xTransform] != 1) {
                            dotMap[i][xTransform] = 1;
                        }
                        dotMap[i][j] = 0;
                    }
                }
            }
        }
        return dotMap;
    }

    private int[][] getFoldYAxisNumber(int y, int[][] dotMap) {
        for (int i = 0; i < dotMap.length; i++) {
            if (i != y) {
                for (int j = 0; j < dotMap[0].length; j++) {
                    if (dotMap[i][j] == 1) {
                        if (i > y) {
                            int yTransform = y - i + y;

                            if (dotMap[yTransform][j] != 1) {
                                dotMap[yTransform][j] = 1;
                            }
                            dotMap[i][j] = 0;
                        }
                    }
                }
            }
        }
        return dotMap;
    }

    private List<String> getFolds(String[] inputData) {
        List<String> tmpFoldList = new ArrayList<>();
        boolean canParseFolds = false;
        for (int i = 0; i < inputData.length; i++) {
            if (!canParseFolds) {
                if (inputData[i].equals("")) {
                    canParseFolds = true;
                }
            } else {
                String[] fold = inputData[i].split("\\s");
                tmpFoldList.add(fold[2].trim());
            }
        }
        return tmpFoldList;
    }

    private int[][] getDotMap(String[] inputData) {
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        for (String point : inputData) {
            if (point.equals("")) {
                break;
            }

            String[] pair = point.split(",");
            if (xMax < Integer.parseInt(pair[0])) {
                xMax = Integer.parseInt(pair[0]);
            }

            if (yMax < Integer.parseInt(pair[1])) {
                yMax = Integer.parseInt(pair[1]);
            }
        }

        int[][] tmpDotMap = new int[yMax + 1][xMax + 1];
        for (String point : inputData) {
            if (point.equals("")) {
                break;
            }
            String[] pair = point.split(",");
            tmpDotMap[Integer.parseInt(pair[1])][Integer.parseInt(pair[0])] = 1;

        }
        return tmpDotMap;
    }
}

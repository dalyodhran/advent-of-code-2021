package dayNine;

import java.util.ArrayList;
import java.util.List;

public class SmokeBasin {
    public List<Pair> getRiskLeve(String data) {
        String [] heights = data.split("\n");
        int [][] heightMaps = createHeightMap(heights);
        List<Pair> basinLowPoint = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < heightMaps.length; i++) {
            for (int j = 0; j < heightMaps[0].length; j++) {
                if(isLowRisk(i, j, heightMaps)) {
                    basinLowPoint.add(new Pair(j, i));
                }
            }
        }

        return basinLowPoint;
    }

    private boolean isLowRisk(int i, int j, int[][] heightMaps) {
        // up
        boolean isLowRiskUp = isLessThanAbove(i, j, heightMaps);

        // down
        boolean isLowRiskDown = isLessThanBelow(i, j, heightMaps);

        // right
        boolean isLowRiskRight = isLessThanRight(i, j, heightMaps);

        // left
        boolean isLowRiskLeft = isLessThanLeft(i, j, heightMaps);

        return isLowRiskUp && isLowRiskDown && isLowRiskRight && isLowRiskLeft;
    }

    private boolean isLessThanLeft(int i, int j, int[][] heightMaps) {
        boolean isLower = false;
        try {
            int i1 = i;
            int j1 = j - 1;

            if (heightMaps[i][j] < heightMaps[i1][j1]) {
                isLower = true;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not inside the height map");
            isLower = true;
        }
        return isLower;
    }

    private boolean isLessThanRight(int i, int j, int[][] heightMaps) {
        boolean isLower = false;
        try {
            int i1 = i;
            int j1 = j + 1;

            if (heightMaps[i][j] < heightMaps[i1][j1]) {
                isLower = true;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not inside the height map");
            isLower = true;
        }
        return isLower;
    }

    private boolean isLessThanBelow(int i, int j, int[][] heightMaps) {
        boolean isLower = false;
        try {
            int i1 = i + 1;
            int j1 = j;

            if (heightMaps[i][j] < heightMaps[i1][j1]) {
                isLower = true;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not inside the height map");
            isLower = true;
        }
        return isLower;
    }

    private boolean isLessThanAbove(int i, int j, int[][] heightMaps) {
        boolean isLower = false;
        try {
            int i1 = i - 1;
            int j1 = j;

            if (heightMaps[i][j] < heightMaps[i1][j1]) {
                isLower = true;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not inside the height map");
            isLower = true;
        }
        return isLower;
    }

    private int[][] createHeightMap(String[] heights) {
        int [][] tmpHeightMap = new int[heights.length][heights[0].length()];

        for (int i = 0; i < heights.length; i++) {
            String height = heights[i];
            for (int j = 0; j < height.length(); j++) {
                tmpHeightMap[i][j] = Integer.parseInt(String.valueOf(height.charAt(j)));
            }
        }
        return tmpHeightMap;
    }
}

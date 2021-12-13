package dayNine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Basin {
    public int getLargestBasin(String data) {
        String[] basinHeight = data.split("\\r?\\n");
        int[][] basinMap = createBasinMap(basinHeight);
        SmokeBasin smokeBasin = new SmokeBasin();
        List<Pair> lowestBasin = smokeBasin.getRiskLeve(data);
        List<Integer> basinSize = new ArrayList<>();

        for (Pair pair : lowestBasin) {
            basinSize.add(getBasinSize(pair, basinMap));
        }

        basinSize = basinSize.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int threeLargestBasin = 1;

        for (int i = 0; i < 3; i++) {
            threeLargestBasin *= basinSize.get(i);
        }


        return threeLargestBasin;
    }

    private Integer getBasinSize(Pair pair, int[][] basinMap) {

        if (!isPartOfBasin(pair, basinMap)) {
            return 0;
        } else {
            basinMap[pair.getY1()][pair.getX1()] = 9;
            return 1 + getBasinSize(new Pair(pair.getX1(), pair.getY1() + 1), basinMap) + // down
                    getBasinSize(new Pair(pair.getX1(), pair.getY1() - 1), basinMap) + // up
                    getBasinSize(new Pair(pair.getX1() + 1, pair.getY1()), basinMap) + // right
                    getBasinSize(new Pair(pair.getX1() - 1, pair.getY1()), basinMap); // left
        }
    }

    private boolean isPartOfBasin(Pair pair, int[][] basinMap) {
        boolean isPartOfBasin = false;
        try {
            if (basinMap[pair.getY1()][pair.getX1()] == 0) {
                isPartOfBasin = true;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }
        return isPartOfBasin;
    }

    private int[][] createBasinMap(String[] basinHeight) {
        int[][] tmpBasinMap = new int[basinHeight.length][basinHeight[0].length()];
        for (int i = 0; i < basinHeight.length; i++) {
            String heights = basinHeight[i];
            for (int j = 0; j < basinHeight[0].length(); j++) {
                if (Integer.parseInt(String.valueOf(heights.charAt(j))) == 9) {
                    tmpBasinMap[i][j] = 9;
                } else {
                    tmpBasinMap[i][j] = 0;
                }
            }
        }
        return tmpBasinMap;
    }
}

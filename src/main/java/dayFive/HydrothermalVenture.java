package dayFive;

public class HydrothermalVenture {
    public int getNumberOfDangerVents(String data) {
        String[] coordinates = data.split("\\r?\\n");

        int[] scalars = getLargestValues(coordinates);
        int[][] board = new int[scalars[0] + 1][scalars[1] + 1];

        for (String coordinate : coordinates) {
            String[] points = coordinate.split("->");

            board = addLine(board, points);

        }

        return getNumberOfDangousVents(board);
    }

    private int getNumberOfDangousVents(int[][] board) {
        int count = 0;

        for (int[] cell : board) {
            for (int value : cell) {
                if (value >= 2) {
                    count++;
                }
            }

        }
        return count;
    }

    private int[][] addLine(int[][] board, String[] points) {
        String direction = getDirection(points);

        switch (direction) {
            case "leftToRight":
                board = setLeftToRight(board, points);
                break;

            case "down":
                board = setDown(board, points);
                break;

            case "diagonalPositive":
                board = setDiagonalPositive(board, points);
                break;

            case "diagonalNegative":
                board = setDiagonalNegative(board, points);
                break;

            default:
                System.out.println("Not a valid coordinate");
        }

        return board;
    }

    private int[][] setDiagonalNegative(int[][] board, String[] points) {
        String[] correctDirection = setCorrectDiagonalDirection(points);
        String[] xyOneValue = correctDirection[0].split(",");
        String[] xyTwoValue = correctDirection[1].split(",");
        int yValue = Integer.parseInt(xyOneValue[1].trim());

        for (int i = Integer.parseInt(xyOneValue[0].trim()); i <= Integer.parseInt(xyTwoValue[0].trim()) ; i++) {
            board[yValue--][i] += 1;
        }
        return board;
    }

    private int[][] setDiagonalPositive(int[][] board, String[] points) {
        String[] correctDirection = setCorrectDiagonalDirection(points);
        String[] xyOneValue = correctDirection[0].split(",");
        String[] xyTwoValue = correctDirection[1].split(",");
        int j = Integer.parseInt(xyOneValue[1].trim());

        for (int i = Integer.parseInt(xyOneValue[0].trim()); i <= Integer.parseInt(xyTwoValue[0].trim()); i++) {
            board[j++][i] += 1;
        }
        return board;
    }

    private int[][] setDown(int[][] board, String[] points) {
        String[] correctDirection = setCorrectDirection(points);
        String[] xyOneValue = correctDirection[0].split(",");
        String[] xyTwoValue = correctDirection[1].split(",");

        for (int i = Integer.parseInt(xyOneValue[1].trim()); i <= Integer.parseInt(xyTwoValue[1].trim()); i++) {
            board[i][Integer.parseInt(xyOneValue[0].trim())] += 1;
        }
        return board;
    }

    private int[][] setLeftToRight(int[][] board, String[] points) {
        String[] correctDirection = setCorrectDirection(points);
        String[] xyOneValue = correctDirection[0].split(",");
        String[] xyTwoValue = correctDirection[1].split(",");

        for (int i = Integer.parseInt(xyOneValue[0].trim()); i <= Integer.parseInt(xyTwoValue[0].trim()); i++) {
            board[Integer.parseInt(xyOneValue[1].trim())][i] += 1;
        }
        return board;
    }

    private String[] setCorrectDirection(String[] points) {
        String[] temp = points;
        String[] xyOneValue = points[0].split(",");
        String[] xyTwoValue = points[1].split(",");

        if (Integer.parseInt(xyOneValue[0].trim()) > Integer.parseInt(xyTwoValue[0].trim())) {
            return swap(points);
        }

        if (Integer.parseInt(xyOneValue[1].trim()) > Integer.parseInt(xyTwoValue[1].trim())) {
            return swap(points);
        }

        return temp;
    }

    private String[] setCorrectDiagonalDirection(String[] points) {
        String[] temp = points;
        String[] xyOneValue = points[0].split(",");
        String[] xyTwoValue = points[1].split(",");

        if (Integer.parseInt(xyOneValue[0].trim()) > Integer.parseInt(xyTwoValue[0].trim())) {
            return swap(points);
        }

        return temp;
    }

    private String[] swap(String[] points) {
        String[] temp = new String[points.length];
        temp[0] = points[1];
        temp[1] = points[0];
        return temp;
    }

    private String getDirection(String[] points) {
        String direction = "nether";

        String[] xyOneValue = points[0].split(",");
        String[] xyTwoValue = points[1].split(",");

        if (Integer.parseInt(xyOneValue[0].trim()) == Integer.parseInt(xyTwoValue[0].trim())) {
            return "down";
        }

        if (Integer.parseInt(xyOneValue[1].trim()) == Integer.parseInt(xyTwoValue[1].trim())) {
            return "leftToRight";
        }

        int slope = (Integer.parseInt(xyTwoValue[1].trim()) - Integer.parseInt(xyOneValue[1].trim())) / (Integer.parseInt(xyTwoValue[0].trim()) - Integer.parseInt(xyOneValue[0].trim()));

        if (slope == 1) {
            return "diagonalPositive";
        }

        if (slope == -1) {
            return "diagonalNegative";
        }

        return direction;
    }

    private int[] getLargestValues(String[] coordinates) {
        int maxXCoordinate = Integer.MIN_VALUE;
        int maxYCoordinate = Integer.MIN_VALUE;

        for (String coordinate : coordinates) {
            String[] points = coordinate.split("->");
            for (String point : points) {
                String[] values = point.split(",");
                if (Integer.parseInt(values[0].trim()) > maxXCoordinate) {
                    maxXCoordinate = Integer.parseInt(values[0].trim());
                }
                if (Integer.parseInt(values[1].trim()) > maxYCoordinate) {
                    maxYCoordinate = Integer.parseInt(values[1].trim());
                }
            }
        }


        return new int[]{maxXCoordinate, maxYCoordinate};
    }
}

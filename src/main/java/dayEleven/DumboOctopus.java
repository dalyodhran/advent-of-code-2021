package dayEleven;

public class DumboOctopus {
    public int getOctopusFlashes(String data) {

        String [] octopusLines = data.split("\\r?\\n");
        int[][] octopuses = getOctopus(octopusLines);
        int flashes = 0;

        for (int i = 0; i < 100; i++) {
            incrementFlash(octopuses);
            flashes += getFlashes(octopuses);
        }

        return flashes;
    }

    private int getFlashes(int[][] octopuses) {
        int flashes = 0;
        for (int i = 0; i < octopuses.length; i++) {
            for (int j = 0; j < octopuses[0].length; j++) {
                if (octopuses[i][j] == 0) {
                    flashes++;
                    octopuses[i][j] = -1;
                }
            }
        }
        return flashes;
    }

    private void incrementFlash(int[][] octopuses) {
        for (int i = 0; i < octopuses.length; i++) {
            for (int j = 0; j < octopuses[i].length; j++) {
                octopuses = increaseFlash(i, j, octopuses);
            }

        }
    }

    private int[][] increaseFlash(int i, int j, int[][] octopuses) {
        if (0 > i || i > octopuses.length - 1) {
            return octopuses;
        }

        if (0 > j || j > octopuses.length - 1) {
            return octopuses;
        }

        if (octopuses[i][j] == 0) {
            return octopuses;
        }

        int flash = octopuses[i][j];

        if (flash == -1) {
            octopuses[i][j] = 1;
            return octopuses;
        }

        if (flash++ < 9) {
            octopuses[i][j] = flash;
            return octopuses;
        } else {
            octopuses[i][j] = 0;
            int iPlusOne = i + 1;
            int iMinusOne = i - 1;
            int jPlusOne = j + 1;
            int jMinusOne = j - 1;
            // up
            octopuses = increaseFlash(iMinusOne, j, octopuses);
            // down
            octopuses = increaseFlash(iPlusOne, j, octopuses);
            // right
            octopuses = increaseFlash(i, jPlusOne, octopuses);
            // left
            octopuses = increaseFlash(i, jMinusOne, octopuses);
            // top left
            octopuses = increaseFlash(iMinusOne, jMinusOne, octopuses);
            // top right
            octopuses = increaseFlash(iMinusOne, jPlusOne, octopuses);
            // bottom left
            octopuses = increaseFlash(iPlusOne, jMinusOne, octopuses);
            // bottom right
            return increaseFlash(iPlusOne, jPlusOne, octopuses);
        }
    }

    private int[][] getOctopus(String[] octopusLines) {
        int [][] tmpOctopuses = new int[octopusLines.length][octopusLines[0].length()];
        for (int i = 0; i < octopusLines.length; i++) {
            String line = octopusLines[i].trim();
            for (int j = 0; j < octopusLines[0].length(); j++) {
                tmpOctopuses[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        return tmpOctopuses;
    }

    public int getSynchroniseFlash(String data) {
        String [] octopusLines = data.split("\\r?\\n");
        int[][] octopuses = getOctopus(octopusLines);
        int count = 0;
        int maxFlash = octopuses.length * octopuses[0].length;
        boolean fullFlash = false;

        while(!fullFlash) {
            incrementFlash(octopuses);
            int flashes = getFlashes(octopuses);
            if (flashes == maxFlash) {
                fullFlash = true;
            }
            count++;
        }
        return count;
    }
}

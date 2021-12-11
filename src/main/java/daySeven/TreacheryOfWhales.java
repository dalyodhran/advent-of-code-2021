package daySeven;

import java.util.Arrays;

public class TreacheryOfWhales {
    public Double getFuelAmount(String data) {
        int[] directions = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
        directions = Arrays.stream(directions).sorted().toArray();

        Double minFuelAmount = Double.MAX_VALUE;


        for (int i = 0; i < directions[directions.length - 1]; i++) {
            Double fuel = 0.0;
            for (int direction : directions) {
                int difference = Math.abs(direction - i);
                fuel += (difference / 2.0) * (1 + difference);

            }

            if (minFuelAmount < fuel) {
                break;
            }

            minFuelAmount = fuel;
        }

        System.out.println(minFuelAmount);
        return minFuelAmount;
    }
}
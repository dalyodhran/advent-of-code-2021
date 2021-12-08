package dayTwo;

public class Position {
    public int getPosition(String data) {
        String[] directions = data.split("\\r?\\n");
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (int i = 0; i < directions.length; i++) {
            String[] direction = directions[i].split("\\s");
            switch (direction[0]) {
                case "forward":
                    horizontal += Integer.parseInt(direction[1]);
                    depth += aim * Integer.parseInt(direction[1]);
                    break;
                case "down":
                    aim += Integer.parseInt(direction[1]);
                    break;
                case "up":
                    aim -= Integer.parseInt(direction[1]);
                    break;
                default:
                    System.out.println("Not a direction");
            }
        }
        return horizontal * depth;
    }
}

package dayEleven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DumboOctopusTest {

    @Test
    public void sampleData() {
        DumboOctopus octopus = new DumboOctopus();
        String data = "5483143223\n" +
                "2745854711\n" +
                "5264556173\n" +
                "6141336146\n" +
                "6357385478\n" +
                "4167524645\n" +
                "2176841721\n" +
                "6882881134\n" +
                "4846848554\n" +
                "5283751526";
        int flashes = octopus.getOctopusFlashes(data);
        assertEquals(1656, flashes);
    }

    @Test
    public void testData() {
        DumboOctopus octopus = new DumboOctopus();
        String data = "2524255331\n" +
                "1135625881\n" +
                "2838353863\n" +
                "1662312365\n" +
                "6847835825\n" +
                "2185684367\n" +
                "6874212831\n" +
                "5387247811\n" +
                "2255482875\n" +
                "8528557131";
        int flashes = octopus.getOctopusFlashes(data);
        assertEquals(1656, flashes);
    }

}
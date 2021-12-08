package daySix;

import java.util.HashMap;
import java.util.Map;

public class Lanternfish {
    public Long getNumberOfLanterfish(String data) {

        Map<Integer, Long> lanternfishMap = new HashMap<>();

        String[] lanternfishTimers = data.split(",");

        for (String timer : lanternfishTimers) {
            if (lanternfishMap.get(Integer.parseInt(timer)) == null) {
                lanternfishMap.put(Integer.parseInt(timer.trim()), 1L);
            } else {
                lanternfishMap.put(Integer.parseInt(timer.trim()),
                        lanternfishMap.get(Integer.parseInt(timer.trim())) + 1);
            }
        }

        for (int i = 0; i < 256; i++) {
            Long newLanternfish = lanternfishMap.get(0) == null ? 0 : lanternfishMap.get(0);
            for (int j = 1; j <= 8; j++) {
                lanternfishMap.put(j - 1, lanternfishMap.get(j));
            }
            Long oldLanterfish = lanternfishMap.get(6) == null ? 0 : lanternfishMap.get(6);
            lanternfishMap.put(6, oldLanterfish + newLanternfish);
            lanternfishMap.put(8, newLanternfish);
        }

        Long count = 0L;

        for (int i = 0; i <= 8; i++) {
            count += lanternfishMap.get(i);
        }

        return count;
    }
}
package dayTwelve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassagePathingTest {

    @Test
    public void sampleData() {
        PassagePathing path = new PassagePathing();
        String data = "dc-end\n" +
                "HN-start\n" +
                "start-kj\n" +
                "dc-start\n" +
                "dc-HN\n" +
                "LN-dc\n" +
                "HN-end\n" +
                "kj-sa\n" +
                "kj-HN\n" +
                "kj-dc";
        int paths = path.getPaths(data);
        assertEquals(19, paths);
    }

    @Test
    public void testData() {
        PassagePathing path = new PassagePathing();
        String data = "FK-gc\n" +
                "gc-start\n" +
                "gc-dw\n" +
                "sp-FN\n" +
                "dw-end\n" +
                "FK-start\n" +
                "dw-gn\n" +
                "AN-gn\n" +
                "yh-gn\n" +
                "yh-start\n" +
                "sp-AN\n" +
                "ik-dw\n" +
                "FK-dw\n" +
                "end-sp\n" +
                "yh-FK\n" +
                "gc-gn\n" +
                "AN-end\n" +
                "dw-AN\n" +
                "gn-sp\n" +
                "gn-FK\n" +
                "sp-FK\n" +
                "yh-gc";
        int paths = path.getPaths(data);
        assertEquals(19, paths);
    }

}
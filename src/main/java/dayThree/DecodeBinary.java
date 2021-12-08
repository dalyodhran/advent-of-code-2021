package dayThree;

public class DecodeBinary {

    public int getPowerConsumption(String data) {
        int [] zeroCount = new int[12];
        int [] oneCount = new int[12];
        StringBuilder large = new StringBuilder();
        StringBuilder small = new StringBuilder();

        String [] reportData = data.split("\\r?\\n");

        for (String binary : reportData) {
            binary = binary.trim();
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == 48) {
                    zeroCount[i]+= 1;
                } else {
                    oneCount[i]+= 1;
                }
            }
        }

        for (int i = 0; i < zeroCount.length; i++) {
            if (zeroCount[i] > oneCount[i]) {
                large.append("0");
                small.append('1');
            } else {
                large.append("1");
                small.append("0");
            }
        }

        int gamma = Integer.parseInt(large.toString(), 2);
        int epsilon = Integer.parseInt(small.toString(), 2);

        return gamma*epsilon;
    }
}

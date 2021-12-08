package dayOne;

public class SlidingThree {

    int getSlidingThree(int[] depthsArray) {
        int[] sumOfThree = new int[depthsArray.length - 1];
        NumberOfDepths numberOfDepths = new NumberOfDepths();

        for (int i = 0; i < depthsArray.length; i++) {
            if (i + 2 < depthsArray.length) {
                sumOfThree[i] = depthsArray[i] + depthsArray[i+1] + depthsArray[i+2];
            }
        }

        return numberOfDepths.getDepths(sumOfThree);
    }
}

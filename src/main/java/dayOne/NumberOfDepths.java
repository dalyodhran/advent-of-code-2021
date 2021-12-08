package dayOne;

public class NumberOfDepths {

    int getDepths(int[] depthsArray) {
        int count = 0;
        int depthPointer = Integer.MAX_VALUE;

        for (int depth : depthsArray) {
            if(depth > depthPointer) {
                count++;
            }
            depthPointer = depth;
        }
        return count;
    }

}

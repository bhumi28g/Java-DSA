import java.util.Arrays;

public class MaximumUnitsOnTruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int totalUnits = 0;
        for (int[] box : boxTypes) {
            int boxes = box[0];
            int units = box[1];
            int take = Math.min(boxes, truckSize);
            totalUnits += take * units;
            truckSize -= take;
            if (truckSize == 0) {
                break;
            }
        }
        return totalUnits;
    }
    public static void main(String[] args) {
        int[][] boxTypes = {
            {1, 3},
            {2, 2},
            {3, 1}
        };
        int truckSize = 4;
        int result = maximumUnits(boxTypes, truckSize);
        System.out.println("Maximum Units = " + result);
    }
}
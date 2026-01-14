import java.util.*;
public class TwoSumProblem {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        if (result[0] != -1)
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        else
            System.out.println("No pair found");
    }
    static int[] twoSum(int[] arr, int target) {
        // HashMap to store value and its index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            // check if required value already exists
            if (map.containsKey(need))
                return new int[]{map.get(need), i};
            // store current value with index
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
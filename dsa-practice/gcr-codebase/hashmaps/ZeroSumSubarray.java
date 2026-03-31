import java.util.*;
public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        findZeroSumSubarrays(arr);
    }
    static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        // sum 0 at index -1 to handle subarrays starting from index 0
        map.put(0, new ArrayList<>(List.of(-1)));
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // if sum already exists, zero-sum subarray found
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray found from index "
                            + (start + 1) + " to " + i);
                }
            }
            // store current index for this sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }
}
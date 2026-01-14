import java.util.*;
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }
    static int longestConsecutive(int[] arr) {
        // HashSet to store all elements
        Set<Integer> set = new HashSet<>();
        for (int num : arr)
            set.add(num);
        int longest = 0;
        for (int num : set) {
            // start counting only if previous number does not exist
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 1;
                // check consecutive numbers
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                // update longest length
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
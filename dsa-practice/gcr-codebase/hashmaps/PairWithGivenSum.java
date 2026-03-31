import java.util.*;
public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        if (hasPair(arr, target))
            System.out.println("Pair exists");
        else
            System.out.println("Pair does not exist");
    }
    static boolean hasPair(int[] arr, int target) {
        // HashSet to store visited elements
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            // check if required number already exists
            if (set.contains(target - num))
                return true;
            // store current number
            set.add(num);
        }
        return false;
    }
}
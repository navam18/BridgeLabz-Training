import java.util.*;

class SingleNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int x = 0; x < nums.length; x++) {
            xor = xor ^ nums[x];
        }

        return xor;
    }

    public static void main(String[] args) {

        SingleNumber obj = new SingleNumber();

        int[] nums = {4, 1, 2, 1, 2};

        int result = obj.singleNumber(nums);

        System.out.println("Single number is: " + result);
    }
}

import java.util.*;

class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;

        int nums3[] = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                i++;
                k++;
            } else {
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }

        while (i < m) {
            nums3[k] = nums1[i];
            k++;
            i++;
        }

        while (j < n) {
            nums3[k] = nums2[j];
            k++;
            j++;
        }

        for (int x = 0; x < nums3.length; x++) {
            nums1[x] = nums3[x];
        }
    }

    public static void main(String[] args) {

        MergeSortedArray obj = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        obj.merge(nums1, m, nums2, n);

        System.out.println("Merged array:");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}

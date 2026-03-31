class CountingSort {
    // Method to perform counting sort on an array of integers within a known range
    public static void countingSort(int[] a) {
        int min = 10;
        int max = 18;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            count[a[i] - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            output[count[a[i] - min] - 1] = a[i];
            count[a[i] - min]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }
    }
    // Main method to test counting sort

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 13, 16, 11, 17, 12};
        countingSort(ages);
        for (int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
    }
}

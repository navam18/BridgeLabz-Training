class InsertionSort {
    // Method to perform insertion sort
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
    // Main method

    public static void main(String[] args) {
        int[] ids = {45, 12, 89, 33, 67, 5, 90, 24};
        insertionSort(ids);
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] + " ");
        }
    }
}

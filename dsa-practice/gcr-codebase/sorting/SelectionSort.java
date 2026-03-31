class SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
    // Main method
    public static void main(String[] args) {
        int[] scores = {78, 45, 90, 33, 67, 88, 12, 56};
        selectionSort(scores);
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
    }
}

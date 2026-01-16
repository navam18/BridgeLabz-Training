class QuickSort {
    // QuickSort method
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }
    // Partition method
    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }
    // Main method
    public static void main(String[] args) {
        int[] prices = {450, 120, 890, 330, 670, 50, 900, 240};
        quickSort(prices, 0, prices.length - 1);
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
    }
}

class HeapSort {
    // Method to perform heap sort
    public static void heapSort(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }
    // Method to heapify a subtree rooted at index i
    public static void heapify(int[] a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] > a[largest]) {
            largest = left;
        }

        if (right < n && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, n, largest);
        }
    }
    // Main method

    public static void main(String[] args) {
        int[] salaries = {45000, 12000, 89000, 33000, 67000, 5000, 90000, 24000};
        heapSort(salaries);
        for (int i = 0; i < salaries.length; i++) {
            System.out.print(salaries[i] + " ");
        }
    }
}

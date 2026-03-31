public class FibonacciPerformance {

    static long recursiveFib(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

  
    static long iterativeFib(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {

        int n = 40; 

        
        long startRecursive = System.nanoTime();
        long recResult = recursiveFib(n);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + ") = " + recResult);
        System.out.println("Recursive Time: " + (endRecursive - startRecursive) + " ns");

      
        long startIterative = System.nanoTime();
        long itrResult = iterativeFib(n);
        long endIterative = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + ") = " + itrResult);
        System.out.println("Iterative Time: " + (endIterative - startIterative) + " ns");
    }
}

class PowerOfTwo {
    // Method to check if n is a power of two
    public boolean isPowerOfTwo(int n) {
        while (n != 0) {
            if (n == 1) {
                return true;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PowerOfTwo s = new PowerOfTwo();
        int n = 16;
        boolean result = s.isPowerOfTwo(n);
        System.out.println(result);
    }
}

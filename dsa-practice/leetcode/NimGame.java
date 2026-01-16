class NimGame {
    // Method to determine if the first player can win the Nim game
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    // Main method
    public static void main(String[] args) {
        NimGame s= new NimGame();
        int n = 4;
        boolean result = s.canWinNim(n);
        System.out.println(result);
    }
}

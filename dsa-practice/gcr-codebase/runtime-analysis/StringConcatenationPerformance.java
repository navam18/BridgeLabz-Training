public class StringConcatenationPerformance {

    public static void main(String[] args) {

        int N = 1_000_000;

        long startString = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < N; i++) {
            str = str + "a";
        }
        long endString = System.currentTimeMillis();
        System.out.println("String Time: " + (endString - startString) + " ms");

      
        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ms");

        
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbuf.append("a");
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) + " ms");
    }
}

class InvalidScoreException extends Exception {
    InvalidScoreException(String m) {
        super(m);
    }
}

class StudentScoreAnalyzer {

    static double calculateAverage(int[] a) throws InvalidScoreException {
        int sum = 0;
        for (int i : a) {
            if (i < 0 || i > 100)
                throw new InvalidScoreException("Invalid score");
            sum += i;
        }
        return (double) sum / a.length;
    }

    static int findMax(int[] a) {
        int max = a[0];
        for (int i : a)
            if (i > max)
                max = i;
        return max;
    }

    static int findMin(int[] a) {
        int min = a[0];
        for (int i : a)
            if (i < min)
                min = i;
        return min;
    }

    public static void main(String[] args) {
        int[] a = {85, 90, 78, 88, 92};
        try {
            System.out.println(calculateAverage(a));
            System.out.println(findMax(a));
            System.out.println(findMin(a));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

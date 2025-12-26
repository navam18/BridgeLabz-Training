public class EmployeeBonus {
    static double[][] generateData() {
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + Math.random() * 90000;
            data[i][1] = 1 + Math.random() * 10;
        }
        return data;
    }
    static double[][] calculateBonus(double[][] data) {
        double[][] result = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus = years > 5 ? salary * 0.05 : salary * 0.02;
            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] data = generateData();
        double[][] result = calculateBonus(data);
        System.out.println("OldSalary NewSalary Bonus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\n",
                    data[i][0], result[i][0], result[i][1]);
        }
    }
}


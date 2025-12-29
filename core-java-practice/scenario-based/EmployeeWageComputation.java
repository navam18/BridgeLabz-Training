import java.util.Random;
public class EmployeeWageComputation {
    public static void main(String[] args) {
        Random random = new Random();

        //UC 1: Check Employee Present or Absent
        int attendance = random.nextInt(2);// 0 → Absent, 1 → Present
        boolean isPresent = attendance == 1;

        System.out.println("UC1: Checking Employee Attendance...");
        if (isPresent) {
            System.out.println("Employee is Present\n");
        } else {
            System.out.println("Employee is Absent\n");
        }
        final int WAGE_PER_HOUR = 20;
        final int FULL_DAY_HOUR = 8;
        final int PART_TIME_HOUR = 4;

        //UC 2: Calculate Daily Wage
        System.out.println("UC2: Calculating Daily Employee Wage...");
        int dailyWage = isPresent ? WAGE_PER_HOUR * FULL_DAY_HOUR : 0;
        System.out.println("Daily Wage: " + dailyWage + "\n");

        //UC 3: Add Part-Time Employee and Wage
        System.out.println("UC3: Adding Part-Time Employee...");
        int empType = random.nextInt(3);
        // 0 → Absent, 1 → Full-time, 2 → Part-time

        int workingHours = 0;

        if (empType == 1) {
            workingHours = FULL_DAY_HOUR;
            System.out.println("Employee is Full-Time");
        } else if (empType == 2) {
            workingHours = PART_TIME_HOUR;
            System.out.println("Employee is Part-Time");
        } else {
            System.out.println("Employee is Absent");
        }

        int partTimeOrFullTimeWage = workingHours * WAGE_PER_HOUR;
        System.out.println("Wage: " + partTimeOrFullTimeWage + "\n");

        //UC 4: Solve using Switch Case
        System.out.println("UC4: Solving using Switch Case...");
        empType = random.nextInt(3);
        switch (empType) {
            case 1:
                workingHours = FULL_DAY_HOUR;
                System.out.println("Switch: Full-Time Employee");
                break;
            case 2:
                workingHours = PART_TIME_HOUR;
                System.out.println("Switch: Part-Time Employee");
                break;
            default:
                workingHours = 0;
                System.out.println("Switch: Employee Absent");
        }
        System.out.println("Wage (Switch): " + (workingHours * WAGE_PER_HOUR) + "\n");

        //UC 5: Calculating Monthly Wage (20 days)
        System.out.println("UC5: Calculating Wages for a Month (20 Working Days)...");
        int totalMonthlyWage = 0;
        for (int day = 1; day <= 20; day++) {
            empType = random.nextInt(3);
            switch (empType) {
                case 1: workingHours = FULL_DAY_HOUR; break;
                case 2: workingHours = PART_TIME_HOUR; break;
                default: workingHours = 0;
            }
            totalMonthlyWage += workingHours * WAGE_PER_HOUR;
        }
        System.out.println("Total Monthly Wage: " + totalMonthlyWage + "\n");

        //UC 6: Wage till 100 hours OR 20 days (whichever comes first)
        System.out.println("UC6: Wage until 100 hours or 20 days reached...");
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < 100 && totalDays < 20) {
            totalDays++;
            empType = random.nextInt(3);

            switch (empType) {
                case 1: workingHours = FULL_DAY_HOUR; break;
                case 2: workingHours = PART_TIME_HOUR; break;
                default: workingHours = 0;
            }

            totalHours += workingHours;
            totalWage += workingHours * WAGE_PER_HOUR;
        }

        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Wage Earned: " + totalWage);
    }
}


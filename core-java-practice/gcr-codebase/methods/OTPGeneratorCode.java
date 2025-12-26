import java.util.*;

public class OTPGeneratorCode {

    // Method to generate 6-digit OTP
        static int generateOTP() {
            return 100000 + (int)(Math.random() * 900000);
        }

        static boolean isUnique(int[] arr) {
            for (int i = 0; i < arr.length; i++)
                for (int j = i + 1; j < arr.length; j++)
                    if (arr[i] == arr[j])
                        return false;
            return true;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of OTPs: ");
            int n = sc.nextInt();

            int[] otps = new int[n];

            for (int i = 0; i < n; i++) {
                otps[i] = generateOTP();
                System.out.println("OTP " + (i + 1) + ": " + otps[i]);
            }

            System.out.println(isUnique(otps) ? "All OTPs are unique" : "Duplicate OTP found");
        }
    }

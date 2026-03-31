interface Security {

    static boolean isStrongPassword(String pwd) {

        if(pwd.length() < 8){
            return false;
        }

        boolean hasDigit = pwd.matches(".*\\d.*");
        boolean hasUpper = pwd.matches(".*[A-Z].*");

        return hasDigit && hasUpper;
    }
}

class SecurityUtils {
    public static void main(String[] args) {

        String password="Admin123";

        if(Security.isStrongPassword(password)){
            System.out.println("Strong Password");
        } else {
            System.out.println("Weak Password");
        }
    }
}

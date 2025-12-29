import java.util.Scanner;

class Temperature {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int choice=sc.nextInt();

        if(choice==1){
            double f=sc.nextDouble();
            System.out.println(fahrenheitToCelsius(f));
        }
        else if(choice==2){
            double c=sc.nextDouble();
            System.out.println(celsiusToFahrenheit(c));
        }
    }

    static double fahrenheitToCelsius(double f){
        return (f-32)*5/9;
    }

    static double celsiusToFahrenheit(double c){
        return (c*9/5)+32;
    }
}

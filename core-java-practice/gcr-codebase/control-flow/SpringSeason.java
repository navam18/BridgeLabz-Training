import java.util.Scanner;
class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        if(month==3){
            if(day>=20){
                System.out.println("Its a Spring Season");
            }
            else{
                System.out.println("Not a Spring Season");
            }
        } 
        else if(month==4){
            System.out.println("Its a Spring Season");
        } 
        else if(month==5){
            System.out.println("Its a Spring Season");
        } 
        else if(month==6){
            if(day<=20) {
                System.out.println("Its a Spring Season");
            }
            else{
                System.out.println("Not a Spring Season");
            }
        } 
        else {
            System.out.println("Not a Spring Season");
        }
    }
}

import java.util.Scanner;
class SpringSeason{
    static boolean isSpring(int month,int day){
        if(month==3&&day>=20)return true;
        if(month>3&&month<6)return true;
        if(month==6&&day<=20)return true;
        return false;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int month=scanner.nextInt();
        int day=scanner.nextInt();
        if(isSpring(month,day))System.out.println("Its a Spring Season");
        else System.out.println("Not a Spring Season");
    }
}

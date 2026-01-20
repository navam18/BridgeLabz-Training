import java.util.*;

class IPValidation {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter IP for Validation:");
        String s=sc.nextLine();
        String arr[]=s.split("\\.");
        boolean flag=true;
        if (arr.length!=4||s.contains(" ")) {
            flag=false;
        }else {
            for(int x=0;x<arr.length;x++) {
                    int a=Integer.parseInt(arr[x]);
                    if (a<0||a>255||(arr[x].startsWith("0"))&&(arr[x].length()>1)) {
                        flag = false;
                        break;
                }
            }
        }
        if(!flag){
            System.out.println("Not a valid IP");
        }else{
            System.out.println("Valid IP");
        }
    }
}

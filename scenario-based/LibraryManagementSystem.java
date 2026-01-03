import java.util.Scanner;

class LibraryManagementSystem{
    static String[] titles={"Java Programming","Data Structures","Operating Systems","Database Management","Computer Networks"};
    static String[] authors={"James","Mark","Andrew","Raghav","Tanenbaum"};
    static boolean[] available={true,true,true,true,true};

    static void displayBooks(){
        for(int i=0;i<titles.length;i++){
            System.out.println(i+" "+titles[i]+" "+authors[i]+" "+(available[i]?"Available":"CheckedOut"));
        }
    }

    static void searchBook(String key){
        boolean found=false;
        for(int i=0;i<titles.length;i++){
            if(titles[i].toLowerCase().contains(key.toLowerCase())){
                System.out.println(i+" "+titles[i]+" "+authors[i]+" "+(available[i]?"Available":"CheckedOut"));
                found=true;
            }
        }
        if(!found){
            System.out.println("NoBookFound");
        }
    }

    static void updateStatus(int index){
        if(index>=0&&index<available.length){
            available[index]=!available[index];
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n1-Display\n2-Search\n3-CheckoutReturn\n4-Exit\n");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                displayBooks();
            }else if(choice==2){
                String key=sc.nextLine();
                searchBook(key);
            }else if(choice==3){
                int index=sc.nextInt();
                updateStatus(index);
            }else if(choice==4){
                break;
            }
        }
    }
}

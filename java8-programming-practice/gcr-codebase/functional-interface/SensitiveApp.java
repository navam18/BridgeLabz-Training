interface SensitiveTag{
}

class BankAccount implements SensitiveTag{

    String accNo="12345";
}

public class SensitiveApp{
    public static void main(String[] args){

        BankAccount b=new BankAccount();

        if(b instanceof SensitiveTag){
            System.out.println("Encrypt this data");
        } else {
            System.out.println("Normal data");
        }
    }
}
    
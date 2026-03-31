package exceptions;
import java.util.Scanner;
class InSufficientBalanceException extends Exception{
    public InSufficientBalanceException(double amount){
        super("Amount is insufficient:"+amount);
    }
}
class BankTransactionSystem{
    double balance=1000.0;
    public void withdraw(double amount)throws InSufficientBalanceException{
        if(amount<0){
            throw new IllegalArgumentException("Amount cannot be negative:"+amount);
        }
        if(amount>balance){
            throw new InSufficientBalanceException(amount);
        }
        balance-=amount;
        System.out.println("Withdrawal Successful! Remaining balance:"+balance);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        BankTransactionSystem bts=new BankTransactionSystem();
        int amount=sc.nextInt();
        try{
            bts.withdraw(amount);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
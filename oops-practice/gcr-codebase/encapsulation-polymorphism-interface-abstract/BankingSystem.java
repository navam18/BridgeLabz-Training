import java.util.ArrayList;

abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber,String holderName,double balance){
        this.accountNumber=accountNumber;
        this.holderName=holderName;
        this.balance=balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }
    public String getHolderName(){
        return holderName;
    }
    public void setHolderName(String holderName){
        this.holderName=holderName;
    }
    public double getBalance(){
        return balance;
    }
    protected void setBalance(double balance){
        this.balance=balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
        }
    }
    public void withdraw(double amount){
        if(amount>0&&amount<=balance){
            balance-=amount;
        }
    }
    public abstract double calculateInterest();
}

interface Loanable{
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable{
    private double interestRate;
    public SavingsAccount(String accountNumber,String holderName,double balance,double interestRate){
        super(accountNumber,holderName,balance);
        this.interestRate=interestRate;
    }
    public double calculateInterest(){
        return getBalance()*interestRate;
    }
    public void applyForLoan(double amount){
        System.out.println("Savings Account Loan Applied:"+amount);
    }
    public double calculateLoanEligibility(){
        return getBalance()*5;
    }
}

class CurrentAccount extends BankAccount implements Loanable{
    private double interestRate;
    public CurrentAccount(String accountNumber,String holderName,double balance,double interestRate){
        super(accountNumber,holderName,balance);
        this.interestRate=interestRate;
    }
    public double calculateInterest(){
        return getBalance()*interestRate;
    }
    public void applyForLoan(double amount){
        System.out.println("Current Account Loan Applied:"+amount);
    }
    public double calculateLoanEligibility(){
        return getBalance()*3;
    }
}

public class BankingSystem{
    public static void main(String[] args){
        ArrayList<BankAccount> accounts=new ArrayList<>();
        accounts.add(new SavingsAccount("SA101","Amit",50000,0.04));
        accounts.add(new CurrentAccount("CA201","Riya",80000,0.02));
        for(BankAccount acc:accounts){
            double interest=acc.calculateInterest();
            System.out.println(acc.getHolderName()+" Interest:"+interest);
            if(acc instanceof Loanable){
                System.out.println("Loan Eligibility:"+((Loanable)acc).calculateLoanEligibility());
            }
        }
    }
}
class BankAccount{
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(int accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }
}

class SavingsAccount extends BankAccount{
    SavingsAccount(int accountNumber,String accountHolder,double balance){
        super(accountNumber,accountHolder,balance);
    }

    void displayDetails(){
        System.out.println(accountNumber+" "+accountHolder);
    }

    public static void main(String[] args){
        SavingsAccount a1=new SavingsAccount(12345,"Neha",5000);
        a1.displayDetails();
        a1.setBalance(7000);
        System.out.println(a1.getBalance());
    }
}

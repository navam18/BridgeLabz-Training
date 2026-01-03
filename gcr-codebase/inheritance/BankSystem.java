class BankAccount{
    int accountNumber;
    double balance;
    BankAccount(int accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
}
class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(int accountNumber,double balance,double interestRate){
        super(accountNumber,balance);
        this.interestRate=interestRate;
    }
    void displayAccountType(){
        System.out.println("Savings Account "+accountNumber+" "+balance+" "+interestRate);
    }
}
class CheckingAccount extends BankAccount{
    double withdrawalLimit;
    CheckingAccount(int accountNumber,double balance,double withdrawalLimit){
        super(accountNumber,balance);
        this.withdrawalLimit=withdrawalLimit;
    }
    void displayAccountType(){
        System.out.println("Checking Account "+accountNumber+" "+balance+" "+withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount{
    int tenure;
    FixedDepositAccount(int accountNumber,double balance,int tenure){
        super(accountNumber,balance);
        this.tenure=tenure;
    }
    void displayAccountType(){
        System.out.println("Fixed Deposit Account "+accountNumber+" "+balance+" "+tenure);
    }
}
class BankSystem{
    public static void main(String args[]){
        SavingsAccount sa=new SavingsAccount(101,50000,4.5);
        CheckingAccount ca=new CheckingAccount(102,30000,10000);
        FixedDepositAccount fa=new FixedDepositAccount(103,100000,24);
        sa.displayAccountType();
        ca.displayAccountType();
        fa.displayAccountType();
    }
}

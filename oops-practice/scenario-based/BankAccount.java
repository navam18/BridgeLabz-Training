class BankAccount{
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
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
    public double checkBalance(){
        return balance;
    }
    public static void main(String[] args){
        BankAccount account=new BankAccount("ACC101",5000);
        account.deposit(2000);
        account.withdraw(1000);
        account.withdraw(7000);
        System.out.println(account.checkBalance());
    }
}

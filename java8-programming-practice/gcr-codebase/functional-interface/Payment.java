interface AllPayment {
    void pay(double amount);
}

class UPI implements AllPayment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CreditCard implements AllPayment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class Wallet implements AllPayment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Wallet");
    }
}

class Payment {
    public static void main(String[] args) {
        AllPayment p1=new UPI();
        AllPayment p2=new CreditCard();
        AllPayment p3=new Wallet();

        p1.pay(500);
        p2.pay(1000);
        p3.pay(300);
    }
}

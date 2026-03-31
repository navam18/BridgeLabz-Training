interface Payment {

    void pay(double amount);

    default void refund(double amount){
        System.out.println("Refunded " + amount);
    }
}

class UPI implements Payment{
    public void pay(double amount){
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CreditCard implements Payment{
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PaymentGateway{
    public static void main(String[] args){

        Payment p=new UPI();
        p.pay(500);
        p.refund(200);
    }
}

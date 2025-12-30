public class MobilePhoneDetails {
    String brand;
    String model;
    double price;

    void displayPhone() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        MobilePhoneDetails m1 = new MobilePhoneDetails();
        m1.brand = "VIVO";
        m1.model = "VIVO V29";
        m1.price = 15999.0;

        MobilePhoneDetails m2 = new MobilePhoneDetails();
        m2.brand = "ONE PLUS";
        m2.model = "ONE PLUS nord4";
        m2.price = 39999.0;

        MobilePhoneDetails m3 = new MobilePhoneDetails();
        m3.brand = "APPLE";
        m3.model = "iphone pro16";
        m3.price = 79999.0;

        m1.displayPhone();
        m2.displayPhone();
        m3.displayPhone();
    }
}

import java.util.ArrayList;

abstract class FoodItem{
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName,double price,int quantity){
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
    }
    public String getItemName(){
        return itemName;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    protected void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public abstract double calculateTotalPrice();
    public void getItemDetails(){
        System.out.println("Item:"+itemName+" Qty:"+quantity+" Total:"+calculateTotalPrice());
    }
}

interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable{
    public VegItem(String itemName,double price,int quantity){
        super(itemName,price,quantity);
    }
    public double calculateTotalPrice(){
        return getPrice()*getQuantity()-applyDiscount();
    }
    public double applyDiscount(){
        return getPrice()*getQuantity()*0.10;
    }
    public String getDiscountDetails(){
        return "10% Veg Discount";
    }
}

class NonVegItem extends FoodItem implements Discountable{
    private double extraCharge=50;
    public NonVegItem(String itemName,double price,int quantity){
        super(itemName,price,quantity);
    }
    public double calculateTotalPrice(){
        return getPrice()*getQuantity()+extraCharge-applyDiscount();
    }
    public double applyDiscount(){
        return getPrice()*getQuantity()*0.05;
    }
    public String getDiscountDetails(){
        return "5% NonVeg Discount";
    }
}

public class OnlineFoodDeliverySystem{
    public static void main(String[] args){
        ArrayList<FoodItem> order=new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala",250,2));
        order.add(new NonVegItem("Chicken Biryani",300,1));
        processOrder(order);
    }
    public static void processOrder(ArrayList<FoodItem> order){
        double grandTotal=0;
        for(FoodItem item:order){
            item.getItemDetails();
            grandTotal+=item.calculateTotalPrice();
        }
        System.out.println("Grand Total:"+grandTotal);
    }
}

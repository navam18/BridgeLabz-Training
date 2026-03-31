class Order {
    int orderId;
    String orderDate;
}

class ShippedOrder extends Order {
    String trackingNumber;
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OrderTest {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder();
        order.orderId = 5001;
        order.orderDate = "01-01-2026";
        order.trackingNumber = "TRK123";
        order.deliveryDate = "05-01-2026";

        System.out.println(order.getOrderStatus());
    }
}

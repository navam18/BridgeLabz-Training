import java.util.*;


public class NoAgentAvailableException extends Exception {
    public NoAgentAvailableException(String message) {
        super(message);
    }
}


public class Order {
    private int orderId;
    private String customerName;
    private int location; // simplified distance/location value

    public Order(int orderId, String customerName, int location) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.location = location;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", customer='" + customerName + "'}";
    }
}

public class Agent {
    private int agentId;
    private String name;
    private int location;
    private boolean available;

    public Agent(int agentId, String name, int location) {
        this.agentId = agentId;
        this.name = name;
        this.location = location;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Agent{id=" + agentId + ", name='" + name + "'}";
    }
}


public class DeliveryService {

    private Queue<Order> orderQueue = new LinkedList<>();
    private List<Agent> agents = new ArrayList<>();
    private Map<Order, Agent> activeDeliveries = new HashMap<>();

    // Add order
    public void placeOrder(Order order) {
        orderQueue.offer(order);
        System.out.println("Order placed: " + order);
    }

    // Add agent
    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    // Assign order FIFO to nearest available agent
    public void assignOrder() throws NoAgentAvailableException {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to assign");
            return;
        }

        Order order = orderQueue.poll();
        Agent nearestAgent = null;
        int minDistance = Integer.MAX_VALUE;

        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                int distance = Math.abs(agent.getLocation() - order.getLocation());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestAgent = agent;
                }
            }
        }

        if (nearestAgent == null) {
            throw new NoAgentAvailableException("No delivery agent available for order " + order.getOrderId());
        }

        nearestAgent.setAvailable(false);
        activeDeliveries.put(order, nearestAgent);

        System.out.println("Assigned " + order + " to " + nearestAgent);
    }

    // Cancel delivery
    public void cancelOrder(Order order) {
        Agent agent = activeDeliveries.remove(order);
        if (agent != null) {
            agent.setAvailable(true);
            System.out.println("Order cancelled: " + order);
        }
    }

    // View active deliveries
    public void viewActiveDeliveries() {
        if (activeDeliveries.isEmpty()) {
            System.out.println("No active deliveries");
            return;
        }

        for (Map.Entry<Order, Agent> entry : activeDeliveries.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {

        DeliveryService service = new DeliveryService();

        service.addAgent(new Agent(1, "Rahul", 10));
        service.addAgent(new Agent(2, "Amit", 20));

        service.placeOrder(new Order(101, "Abhay", 12));
        service.placeOrder(new Order(102, "Rohit", 18));

        try {
            service.assignOrder();
            service.assignOrder();
            service.assignOrder(); // triggers exception
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.viewActiveDeliveries();
    }
}


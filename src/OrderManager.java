import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderManager {
    private List<Order> orders = new ArrayList();
    private HashMap<Integer, List<Order>> userOrderHistory = new HashMap();

    public OrderManager() {
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        ((List)this.userOrderHistory.computeIfAbsent(order.getUserID(), (k) -> new ArrayList())).add(order);
    }

    public List<Order> getUserOrderHistory(int userID) {
        return (List)this.userOrderHistory.getOrDefault(userID, new ArrayList());
    }
}
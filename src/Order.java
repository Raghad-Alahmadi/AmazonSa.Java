import java.util.List;

public class Order {
    private int orderID;
    private int userID;
    private List<OrderDetails> orderDetails;

    public Order(int orderID, int userID, List<OrderDetails> orderDetails) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetails = orderDetails;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getUserID() {
        return this.userID;
    }

    public List<OrderDetails> getOrderDetails() {
        return this.orderDetails;
    }

    public double getTotalAmount() {
        return this.orderDetails.stream().mapToDouble(OrderDetails::getSubTotal).sum();
    }
}

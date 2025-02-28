public class OrderDetails {
    private int orderDetailID;
    private int orderID;
    private int productID;
    private int quantity;
    private double subTotal;

    public OrderDetails(int orderDetailID, int orderID, int productID, int quantity, double subTotal) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public int getOrderDetailID() {
        return this.orderDetailID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getProductID() {
        return this.productID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getSubTotal() {
        return this.subTotal;
    }
}

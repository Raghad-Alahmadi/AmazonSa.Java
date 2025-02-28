import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Laptop", "Electronics", 1000.0, 10, "1 Year"));
        products.add(new Clothing(2, "T-Shirt", "Clothing", 20.0, 50, "M"));

        while (true) {
            System.out.println("\nAmazon.sa Order Management System");
            System.out.println("1. View Products");
            System.out.println("2. Place Order");
            System.out.println("3. View Order History");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product product : products) {
                        System.out.println(product.getProductID() + ": " + product.getName() + " - $" + product.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userID = scanner.nextInt();
                    System.out.print("Enter Product ID: ");
                    int productID = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    try {
                        Product selectedProduct = products.stream()
                                .filter(p -> p.getProductID() == productID)
                                .findFirst()
                                .orElseThrow(() -> new Exception("Product not found"));

                        if (selectedProduct.getStockQuantity() < quantity) {
                            throw new OutOfStockException("Insufficient stock");
                        }

                        double subTotal = selectedProduct.getPrice() * quantity;
                        List<OrderDetails> orderDetails = new ArrayList<>();
                        orderDetails.add(new OrderDetails(1, orderManager.getUserOrderHistory(userID).size() + 1, productID, quantity, subTotal));

                        Order order = new Order(orderManager.getUserOrderHistory(userID).size() + 1, userID, orderDetails);
                        orderManager.addOrder(order);
                        selectedProduct.setStockQuantity(selectedProduct.getStockQuantity() - quantity);

                        System.out.println("Order placed successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int historyUserID = scanner.nextInt();
                    List<Order> userOrders = orderManager.getUserOrderHistory(historyUserID);

                    System.out.println("\nOrder History for User " + historyUserID + ":");
                    for (Order order : userOrders) {
                        System.out.println("Order ID: " + order.getOrderID() + ", Total Amount: $" + order.getTotalAmount());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

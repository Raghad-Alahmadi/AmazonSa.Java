
public class Clothing extends Product {
    private String size;

    public Clothing(int productID, String name, String category, double price, int stockQuantity, String size) {
        super(productID, name, category, price, stockQuantity);
        this.size = size;
    }

    public double calculateDiscount() {
        return this.getPrice() * 0.05;
    }
}

public class Electronics extends Product {
    private String warrantyPeriod;

    public Electronics(int productID, String name, String category, double price, int stockQuantity, String warrantyPeriod) {
        super(productID, name, category, price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    public double calculateDiscount() {
        return this.getPrice() * 0.1;
    }
}
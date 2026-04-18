package models;

public class FoodItem extends Item {
    private String expirationDate;

    public FoodItem(int id, String name, String category, int quantity,
                    double price, String supplier, String expirationDate) {
        super(id, name, category, quantity, price, supplier);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Expiration Date: " + expirationDate);
    }
}
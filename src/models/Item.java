package models;

public class Item {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;
    private String supplier;

    public Item(int id, String name, String category, int quantity, double price, String supplier) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
        System.out.println("Supplier: " + supplier);
    }
}
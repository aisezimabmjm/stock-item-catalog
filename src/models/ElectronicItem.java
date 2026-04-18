package models;

public class ElectronicItem extends Item {
    private int warrantyMonths;

    public ElectronicItem(int id, String name, String category, int quantity,
                          double price, String supplier, int warrantyMonths) {
        super(id, name, category, quantity, price, supplier);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
}
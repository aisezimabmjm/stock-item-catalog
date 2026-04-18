//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import models.Item;
import service.InventoryManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        manager.loadFromFile();

        while (true) {
            System.out.println("\n=== STOCK ITEM CATALOG ===");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Item by ID");
            System.out.println("4. Delete Item");
            System.out.println("5. Update Item");
            System.out.println("6.Export to CSV ");
            System.out.println("7. Import from CSV");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (id <= 0) {
                        System.out.println("ID must be greater than 0.");
                        break;
                    }

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    if (quantity < 0) {
                        System.out.println("Quantity cannot be negative.");
                        break;
                    }

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                        break;
                    }

                    System.out.print("Enter supplier: ");
                    String supplier = scanner.nextLine();

                    manager.addItem(new Item(id, name, category, quantity, price, supplier));
                    break;

                case 2:
                    manager.viewAllItems();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();

                    Item found = manager.searchById(searchId);
                    if (found != null) {
                        found.displayInfo();
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteItem(deleteId);
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();

                    if (newQuantity < 0 || newPrice < 0) {
                        System.out.println("Invalid quantity or price.");
                        break;
                    }
                    if (newName.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }
                    if (updateId <= 0) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    manager.updateItem(updateId, newName, newQuantity, newPrice);
                    break;


                case 6:
                    manager.exportToCSV();
                    break;

                case 7:
                    manager.importFromCSV();
                    break;

                case 8:
                    manager.saveToFile();
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");


            }

        }
    }
}
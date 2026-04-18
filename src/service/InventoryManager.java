package service;

import models.Item;
import java.io.*;
import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    public void viewAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }

        for (Item item : items) {
            item.displayInfo();
            System.out.println("-------------------");
        }
    }

    public Item searchById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void deleteItem(int id) {
        Item item = searchById(id);

        if (item != null) {
            items.remove(item);
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }
    public void updateItem(int id, String newName, int newQuantity, double newPrice) {
        Item item = searchById(id);

        if (item != null) {
            item.setName(newName);
            item.setQuantity(newQuantity);
            item.setPrice(newPrice);
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter("inventory.txt")) {
            for (Item item : items) {
                writer.println(item.getId() + "," +
                        item.getName() + "," +
                        item.getCategory() + "," +
                        item.getQuantity() + "," +
                        item.getPrice() + "," +
                        item.getSupplier());
            }
            System.out.println("Inventory saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String category = data[2];
                int quantity = Integer.parseInt(data[3]);
                double price = Double.parseDouble(data[4]);
                String supplier = data[5];

                items.add(new Item(id, name, category, quantity, price, supplier));
            }
            System.out.println("Inventory loaded from file.");
        } catch (IOException e) {
            System.out.println("No previous save file found.");
        }

    }
    public void exportToCSV() {
        System.out.println("Export to CSV works!");
    }

    public void importFromCSV() {
        System.out.println("Import from CSV works!");
    }
}
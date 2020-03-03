package w03_klassikomplekt;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory
 */
public class Inventory {
    private List<Item> inventory = new ArrayList<>();
    private int size;

    public Inventory(int size) {
        this.size = size;
    }

    public void addItem(Item item) {

        if (size >= 0) {
            modifyAvailableSlots(-1);
            inventory.add(item);
        } else {
            System.out.println("Inventory täis, item-it ei lisatud");
        }
    }

    public void removeItem(Item item) {
        boolean status = inventory.remove(item);
        if (status) {
            modifyAvailableSlots(1);
        } else {
            System.out.println("Inventory-s antud item-it ei leitud");
        }
        
    }

    private void modifyAvailableSlots(int amount) {
        size += amount;
    }
}
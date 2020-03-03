package w03_klassikomplekt;

/**
 * Item
 */
public class Item {

    String name = "";

    private ItemType itemType;
    private double weight;
    private int level;
    private int durability;

    public Item(String name, ItemType itemType, double weight) {
        this.name = name;
        this.itemType = itemType;
        this.weight = weight;

        this.level = 0;
        this.durability = 100;
    }

    public String toString() {
        return itemType + " named " + name;
    }

    public String getItemType() {
        return itemType.toString();
    }

}
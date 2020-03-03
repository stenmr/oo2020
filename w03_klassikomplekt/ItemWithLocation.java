package w03_klassikomplekt;

/**
 * ItemWithLocation
 */
public class ItemWithLocation {

    public Item item;
    public int x, y;
    private String symbol = "";

    public ItemWithLocation(Item item, int x, int y) {
        this.item = item;
        this.x = x;
        this.y = y;

        switch (item.getItemType()) {
            case "WEAPON":
                symbol = "W";
                break;
            case "ARMOR":
                symbol = "A";
                break;
            case "MISC":
                symbol = "M";
                break;
            case "CONSUMABLE":
                symbol = "C";
                break;
            default:
                System.out.println("ItemType ei klapi, seda ei tohiks juhtuda");
                break;
        }

    }

    public String getSymbol() {
        return symbol;
    }
}
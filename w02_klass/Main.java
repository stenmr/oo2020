package w02_klass;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Character sten = new Character("Sten", CharacterType.WIZARD);
        String[] items = {
            "Sword",
            "Bow",
            "Staff",
            "Apple",
            "Helmet"
        };
        
        System.out.println(sten);

        Shop shop = new Shop();

        for (String item : items) {
            shop.addItem(item);
        }

        shop.getShopSupplies();

    }

}
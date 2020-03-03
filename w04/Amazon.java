package w04;

/**
 * Amazon
 */
public class Amazon {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(60);

        for (int i = 0; i < 10; i++) {
            warehouse.addCrate(new Crate(4));
        }

        System.out.println(warehouse.toString());
    }
}
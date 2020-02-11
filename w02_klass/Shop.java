package w02_klass;

/**
 * Shop
 */
public class Shop {

    private String[] supplies = new String[99];

    public Shop() {

        
    }

    void addItem(String item) {
        int length = supplies.length;

        for (int i = 0; i < length; i++) {
            if (supplies[i] == null) {
                supplies[i] = item;
                return;
            }
        }
    }

    void stealItem(String item) {
        int length = supplies.length;
        for (int i = 0; i < length; i++) {
            if (supplies[i] == item) {
                removeElement(supplies, i);  
            }
        }
    }

    void getShopSupplies() {

        for (String item : supplies) {
            System.out.println(item);
        }
    }

    private void removeElement(Object[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }
}
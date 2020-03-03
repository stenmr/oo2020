package w04;

import java.util.ArrayList;
import java.util.List;

/**
 * Warehouse
 */
public class Warehouse {

    private int space;
    private List<Crate> crateList = new ArrayList<>();

    public Warehouse(int space) {
        this.space = space;
    }

    void addCrate(Crate crate) {
        int crateVolume = crate.getVolume();

        if (space - crateVolume >= 0) {
            crateList.add(crate);
            volumeOperation(-crateVolume);
        } else {
            System.out.println("Ladu on täis, kasti ei lisatud lattu");
        }
    }

    void removeCrate(int index) {
        // State-of-the-art error-handling
        if (index <= crateList.size()) {
            Crate targetedCrate = crateList.get(index);
            int crateVolume = targetedCrate.getVolume();
            volumeOperation(crateVolume);
        }
    }

    private void volumeOperation(int volume) {
        space += volume;
    }

    @Override
    public String toString() {
        String crates = "Crate volumes: ";

        for (Crate crate : crateList) {
            crates += crate.getVolume() + " ";
        }

        return crates;
    }
}
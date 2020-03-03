package w03_klassikomplekt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * World
 */
public class World {

    private int width, height;
    List<Character> characters;
    List<ItemWithLocation> items;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void addCharacters(List<Character> c) {
        this.characters = c;
    }

    void addItem(Item item, int x, int y) {

        if (x > width || y > height || x < 0 || y < 0) {
            System.out.println("Item-i koordinaadid on world-ist väljas");
        } else {
            items.add(new ItemWithLocation(item, x, y));
        }
    }

    void render() {
        restrict();

        String symbol = "";

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height - 1) {
                    symbol = "-";
                } else if (x == 0 || x == width - 1) {
                    symbol = "|";
                } else {
                    symbol = " ";
                }

                for (Character c : characters) {
                    if (c.isVisible && c.x == x && c.y == y) {
                        symbol = c.getSymbol();
                    }
                }

                for (ItemWithLocation item : items) {
                    if (item.x == x && item.y == y) {
                        symbol = item.getSymbol();
                    }
                }

                System.out.print(symbol);
            }

            System.out.println("");
            symbol = "";
        }
    }

    void restrict() {
        Character c = characters.get(characters.size() - 1);

        if (c.x == 0) {
            c.x++;
        } else if (c.x == 0) {
            c.x--;
        } else if (c.x == width) {
            c.x--;
        } else if (c.y == height) {
            c.y--;
        }
    }
}
package w03_klassikomplekt;

import java.util.List;

/**
 * World
 */
public class World {

    private int width, height;
    List<Character> characters;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void addCharacters(List<Character> c) {
        this.characters = c;
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
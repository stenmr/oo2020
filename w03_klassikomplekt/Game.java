package w03_klassikomplekt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Game
 */
public class Game {

    public static void main(String[] args) {

        World world = new World(20, 10);

        Character player = new Character("Sten", CharacterType.PLAYER, "X");
        Character enemy = new Character(5, 5, "Sipsik", CharacterType.MONSTER, "E");
        Character friend = new Character(3, 8, "Semu", CharacterType.NPC, "F");

        world.addCharacters(Arrays.asList(enemy, friend, player));

        String[] items = { "Sword", "Bow", "Staff", "Apple", "Helmet" };

        System.out.println(player);

        world.render();

        // Shop shop = new Shop();

        /*
         * for (String item : items) { shop.addItem(item); }
         */

        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();

        String input = new String();

        while (!input.equals("end")) {
            input = scanner.nextLine();

            if (input.equals("w")) {
                player.changeDirection(Direction.UP);
            } else if (input.equals("s")) {
                player.changeDirection(Direction.DOWN);
            } else if (input.equals("a")) {
                player.changeDirection(Direction.LEFT);
            } else if (input.equals("d")) {
                player.changeDirection(Direction.RIGHT);
            }

            if (player.x == friend.x && player.y == friend.y) {
                enemy.isVisible = !enemy.isVisible;
            }

            world.render();
        }
    }

}
package w03_klassikomplekt;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Game
 */
public class Game {

    public static void main(String[] args) {

        World world = new World(20, 10);

        Random r = new Random();

        Character player = new Character("Sten", CharacterType.PLAYER, "X", new Inventory(8));
        Character enemy = new Character(5, 5, "Paha Sipsik", CharacterType.MONSTER, "E");
        Character friend = new Character(3, 8, "Semu", CharacterType.NPC, "F");

        Item[] itemList = new Item[5];
        itemList[0] = new Item("Saabas", ItemType.MISC, 1.5);
        itemList[1] = new Item("Apple", ItemType.CONSUMABLE, 0.8);
        itemList[2] = new Item("Sword", ItemType.WEAPON, 4.5);
        itemList[3] = new Item("Helmet", ItemType.ARMOR, 3.0);
        itemList[4] = new Item("Banana", ItemType.CONSUMABLE, 0.8);

        world.addCharacters(Arrays.asList(enemy, friend, player));
        System.out.println(itemList[0]);
        for (int i = 0; i < 5; i++) {

            int x = r.nextInt(20);
            int y = r.nextInt(10);

            world.addItem(itemList[0], x, y);
        }
        

        System.out.println(player);

        world.render();

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
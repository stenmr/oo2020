package w03_klassikomplekt;

import java.util.Scanner;

/**
 * Game
 */
public class Game {

    public static void main(String[] args) {
        Character sten = new Character("Sten", CharacterType.WIZARD);
        Character enemy = new Character("Sipsik", CharacterType.GOBLIN);

        String[] items = {
            "Sword",
            "Bow",
            "Staff",
            "Apple",
            "Helmet"
        };
        
        sten.move();
        sten.move();
        sten.move();
        sten.move();

        System.out.println(sten);

        Shop shop = new Shop();

        for (String item : items) {
            shop.addItem(item);
        }

        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();

        String input = new String();

        while (!input.equals("end")) {
            input = scanner.nextLine();

            if (input.equals("w")) {
                sten.changeDirection(Direction.UP);
                sten.move();
            } else if (input.equals("s")) {
                sten.changeDirection(Direction.DOWN);
                sten.move();
            } else if (input.equals("a")) {
                sten.changeDirection(Direction.LEFT);
                sten.move();
            } else if (input.equals("d")) {
                sten.changeDirection(Direction.RIGHT);
                sten.move();
            }

            if (sten.x == enemy.x && sten.y == enemy.y) {
                System.out.println("Vastane!");         
            }
        }
    }

}
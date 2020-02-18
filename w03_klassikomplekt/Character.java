package w03_klassikomplekt;

/**
 * Character
 */
public class Character {

    public int x;
    public int y;

    private String name;
    private CharacterType characterType;
    public Direction direction;
    private Inventory inventory;

    String slogan = "Not a cornball.";

    public Character(String name, CharacterType characterType) {
        this.name = name;
        this.characterType = characterType;
        this.direction = direction.UP;

        this.x = 30;
        this.y = 30;
    }


    @Override
    public String toString() {
        return "My name is " + name + " and I'm at (" + x + "; " + y + ")";
    }

    void move() {
        switch (this.direction) {
            case UP:
                this.y++;
                break;
            case DOWN:
                this.y--;
                break;
            case LEFT:
                this.x--;
                break;
            case RIGHT:
                this.x++;
                break;
            default:
                break;
        }
    }

    void changeDirection(Direction direction) {
        this.direction = direction;
        move();
        getXY();
    }

    void getXY() {
        System.out.println(this.name + "is at (" + this.x + "; " + this.y + ")");
    }
}
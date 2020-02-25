package w03_klassikomplekt;

/**
 * Character
 */
public class Character {

    public int x, y;
    public boolean isVisible = true;

    private String name;
    private CharacterType characterType;
    public Direction direction;
    private Inventory inventory;

    private String symbol = "?";

    public Character(String name, CharacterType characterType, String symbol) {
        this.name = name;
        this.characterType = characterType;
        this.direction = Direction.RIGHT;
        this.symbol = symbol;

        this.x = 1;
        this.y = 1;
    }

    public Character(int x, int y, String name, CharacterType characterType, String symbol) {
        this.name = name;
        this.characterType = characterType;
        this.direction = Direction.RIGHT;
        this.symbol = symbol;

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "My name is " + name + " and I'm at (" + x + "; " + y + ")";
    }

    void move() {
        switch (this.direction) {
            case UP:
                this.y--;
                break;
            case DOWN:
                this.y++;
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

        System.out.println(this);
    }

    String getSymbol() {
        return this.symbol;
    }

    void changeDirection(Direction direction) {
        this.direction = direction;
        move();
    }
}
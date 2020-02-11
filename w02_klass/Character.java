package w02_klass;

/**
 * Character
 */
public class Character {

    private int x;
    private int y;

    private String name;
    private CharacterType characterType;
    private Direction direction;

    String slogan = "Not a cornball";

    public Character(String name, CharacterType characterType) {
        this.name = name;
        this.characterType = characterType;

        this.x = 30;
        this.y = 30;
    }

    @Override
    public String toString() {
        return "My name is " + name + " and I'm at (" + x + "; " + y + ")";
    }
}
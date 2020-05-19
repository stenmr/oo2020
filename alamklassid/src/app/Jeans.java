package app;

public class Jeans extends Cloth {
    public Connector connector;

    public Jeans(int height, int width, Pattern pattern, Connector connector) {
        super(height, width, Cloth.Material.DENIM, pattern);
        this.connector = connector;
    }
}

enum Connector {
    ZIPPER, BUTTONS
}

abstract class Cloth {
    public Material material;
    public Pattern pattern;
    public int height, width;

    public Cloth(int height, int width, Material material, Pattern pattern) {
        this.height = height;
        this.width = width;
        this.material = material;
        this.pattern = pattern;
    }

    enum Material {
        SILK, COTTON, WOOL, DENIM
    }

    enum Pattern {
        PLAID, PLAIN, STRIPED, DIAMOND
    }

    public int area() {
        return height * width;
    }
}

abstract class Pajamas extends Cloth {
    public int thickness;
    public Connector connector;

    enum Connector {
        BELT, ZIPPER, BUTTONS, NONE
    }

    public Pajamas(int height, int width, Material material, Pattern pattern, int thickness, Connector connector) {
        super(height, width, material, pattern);
        this.thickness = thickness;
    }

    @Override
    public int area() {
        return super.area() * thickness;
    }
}
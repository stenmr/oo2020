package app;

public class Jook {
    public String name;
    public float cost, mass;

    public Jook(String name, float cost, float mass) {
        this.name = name;
        this.cost = cost;
        this.mass = mass;
    }

    /**
     * @return the mass
     */
    public float getMass() {
        return mass;
    }

    /**
     * @return the cost
     */
    public float getCost() {
        return cost;
    }
}
package app;

public class Joogipudel {
    public float volumeL, filledVolumeL = 0f, mass, cost;
    public BottleType type;
    public Jook jook;

    public Joogipudel(float volumeL, float mass, float cost, BottleType type, Jook jook) {
        this.volumeL = volumeL;
        this.mass = mass;
        this.cost = cost;
        this.type = type;
        this.jook = jook;
    }

    public Joogipudel(float volumeL, float mass, float cost, BottleType type) {
        this.volumeL = volumeL;
        this.mass = mass;
        this.cost = cost;
        this.type = type;
    }

    /**
     * @return the mass
     */
    public float getMass() {
        if (this.jook != null)
            return this.mass + jook.getMass();
        return this.mass;
    }

    /**
     * @return the cost
     */
    public float getCost() {
        if (this.jook != null)
            return this.cost + jook.getCost();
        return this.cost;
    }

    /**
     * @return the volumeL
     */
    public float getVolume() {
        return volumeL;
    }

    public float fill(float volume) {
        if (volume + this.filledVolumeL <= this.volumeL) {
            this.filledVolumeL = this.volumeL - volume;
            return 0f;
        } else {
            float newVolume = volume - this.filledVolumeL;
            this.filledVolumeL = this.volumeL;
            return newVolume;
        }
    }
}
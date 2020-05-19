package app;

import java.util.List;

public class Joogivaat {
    float areaDm3;
    float filledVolumeL;

    public Joogivaat(float areaDm3, float filledVolumeL) {
        this.areaDm3 = areaDm3;
        this.filledVolumeL = filledVolumeL;
    }

    public String fill(Joogipudel joogipudel) {
        float volume = joogipudel.getVolume();

        if (filledVolumeL < volume) {
            return "Liiga vähe jooki vaadis!";
        }

        this.filledVolumeL = joogipudel.fill(this.filledVolumeL);

        return "Joogipudel täidetud!";
    }

    public String batchFill(List<Joogipudel> joogipudelid) {

        for (Joogipudel joogipudel : joogipudelid) {
            this.filledVolumeL = joogipudel.fill(this.filledVolumeL);
            if (this.filledVolumeL <= 0f)
                return "Joogivaat tühjendatud!";
        }

        return "Joogivaati jäi " + String.valueOf(this.filledVolumeL) + " liitrit";
    }
}
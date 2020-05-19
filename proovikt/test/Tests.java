import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.Joogipudel;
import app.Joogivaat;
import app.Jook;
import app.BottleType;

public class Tests {

    @Test
    public void joogipudelMass() {
        Joogipudel joogipudel = new Joogipudel(0.5f, 0.1f, 0.40f, BottleType.PLASTIC);

        assertEquals(0.1f, joogipudel.getMass(), 0.0001f);
    }

    @Test
    public void joogipudelWithJookMass() {
        Jook jook = new Jook("Limonaad", 3.75f, 0.33f);

        Joogipudel joogipudel = new Joogipudel(0.5f, 0.1f, 0.40f, BottleType.PLASTIC, jook);

        assertEquals(0.43f, joogipudel.getMass(), 0.0001f);
    }

    @Test
    public void joogipudelCost() {
        Joogipudel joogipudel = new Joogipudel(0.5f, 0.1f, 0.4f, BottleType.PLASTIC);

        assertEquals(0.4f, joogipudel.getCost(), 0.0001f);
    }

    @Test
    public void joogipudelWithJookCost() {
        Jook jook = new Jook("Limonaad", 3.75f, 0.33f);

        Joogipudel joogipudel = new Joogipudel(0.5f, 0.1f, 0.40f, BottleType.PLASTIC, jook);

        assertEquals(4.15f, joogipudel.getCost(), 0.0001f);
    }

    @Test
    public void FillJoogivaat() {
        Jook jook = new Jook("Limonaad", 3.75f, 0.33f);

        Joogipudel joogipudel = new Joogipudel(0.5f, 0.1f, 0.40f, BottleType.PLASTIC, jook);
        Joogivaat joogivaat = new Joogivaat(1f, 2.5f);

        var output = joogivaat.fill(joogipudel);

        assertEquals(output, "Joogipudel täidetud!");
    }
}
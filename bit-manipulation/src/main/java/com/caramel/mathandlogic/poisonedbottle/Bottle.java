package com.caramel.mathandlogic.poisonedbottle;

/**
 * Created by patrycja.lisowska on 10.10.2017.
 */
public class Bottle {

    private final int id;
    private boolean poisoned;

    public Bottle(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Bottle createNormal(int i) {
        Bottle bottle = new Bottle(i);
        return bottle;
    }

    public static Bottle createPoisoned(int i) {
        Bottle bottle = new Bottle(i);
        bottle.setPoisoned();
        return bottle;
    }

    private void setPoisoned() {
        this.poisoned = true;
    }

    public boolean isPoisoned() {
        return poisoned;
    }
}

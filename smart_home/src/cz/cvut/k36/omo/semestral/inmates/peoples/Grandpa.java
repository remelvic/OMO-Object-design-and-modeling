package cz.cvut.k36.omo.semestral.inmates.peoples;

import cz.cvut.k36.omo.semestral.Subscriber;
import cz.cvut.k36.omo.semestral.report.actions.*;
import cz.cvut.k36.omo.semestral.stuff.StuffAPI;

/**
 * The class contains methods related to the grandma.
 * @author Victor Remel
 * @author Roman Bulavkin
 * @version 1.0, November 2021
 */
public class Grandpa extends Person{
    private Subscriber sub;
    public Grandpa(String name, int age) {
        super(name, age);
        this.type = PersonType.GRANDPA;
    }

    @Override
    public void decreaseSatiety() {
        setSatiety(getSatiety() - 20);
    }

    @Override
    public boolean checkSatiety() {
        return getSatiety() < 28;
    }

    @Override
    public Eat eat(int time, StuffAPI stuffAPI) {
        return new Eat(time, this.getCurrentRoom(), this, stuffAPI);
    }

    @Override
    public void subscribe(Subscriber sub) {
        this.sub = sub;
    }

    @Override
    public void unsubscribe(Subscriber sub) {
        this.sub = null;
    }

    @Override
    public void notifySubscribers(Action action) {
        this.sub.update(action);
    }
}

package cz.cvut.k36.omo.semestral.inmates.peoples;

import cz.cvut.k36.omo.semestral.inmates.Inhabitant;
import cz.cvut.k36.omo.semestral.inmates.InhabitantState;
import cz.cvut.k36.omo.semestral.inmates.animals.Pet;
import cz.cvut.k36.omo.semestral.report.actions.Eat;
import cz.cvut.k36.omo.semestral.report.actions.FeedAnimal;
import cz.cvut.k36.omo.semestral.stuff.StuffAPI;
import cz.cvut.k36.omo.semestral.stuff.usable.Usable;

/**
 * An abstract class contains basic methods for all rooms in the house.
 * @author Victor Remel
 * @author Roman Bulavkin
 * @version 1.0, November 2021
 */
public abstract class Person extends Inhabitant {
    private final String name;
    private final int age;
    PersonType type;
    private Usable usedStuff;
    private boolean using;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.setSatiety(100);
        this.setInhabitantState(InhabitantState.SLEEPING);
        this.using = false;
    }

    /**
     * Normal getter.
     * @return name of a people
     */
    public String getName() {
        return name;
    }

    /**
     * Normal getter.
     * @return age of a people
     */
    public int getAge() { return age; }

    /**
     * When methods are called, another method is called that feeds the animal.
     * @param pet our animal that we will feed
     */
    public FeedAnimal feedPet(Pet pet, int time){
        return new FeedAnimal(time,pet.getCurrentRoom(), this,pet);
    }

    /**
     * Normal setter.
     */
    public void setUsing(boolean using) {
        this.using = using;
    }

    /**
     * Normal setter.
     */
    public void setUsedStuff(Usable usedStuff){
        this.usedStuff = usedStuff;
    }

    /**
     * Normal getter.
     * @return used Stuff as Usable type
     */
    public Usable getUsedStuff(){
        return this.usedStuff;
    }

    /**
     * @return the true if the person is busy with something.
     */
    public boolean isUsing(){
        return this.using;
    }

    /**
     * When the method are called, the amount of satiety of the people increases.
     */
    public abstract Eat eat(int time, StuffAPI stuffAPI);

    /**
     * The method returns a string that will be sent to the report.
     */
    public String toString() {
        return "Person: " + name+"; Person type: "+type.toString()+"; ";
    }
}

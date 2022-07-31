package cz.cvut.k36.omo.semestral.inmates.animals;

import cz.cvut.k36.omo.semestral.inmates.Inhabitant;
import cz.cvut.k36.omo.semestral.inmates.InhabitantState;

/**
 * An abstract class contains basic methods for all rooms in the house.
 * @author Victor Remel
 * @author Roman Bulavkin
 * @version 1.0, November 2021
 */
public abstract class Pet extends Inhabitant {
    private final String name;
    private final int age;
    PetType type;

    Pet(String name , int age){
        this.name = name;
        this.age = age;
        this.setSatiety(100);
        this.setInhabitantState(InhabitantState.SLEEPING);
    }

    /**
     * Normal getter.
     * @return age of an animal
     */
    public int getAge() {
        return age;
    }

    /**
     * Normal getter.
     * @return name of an animal
     */
    public String getName() {
        return name;
    }

    /**
     * When the method are called, the amount of satiety of the animal increases.
     */
    public abstract void eat();

    /**
     * The method returns a string that will be sent to the report.
     */
    public String toString() {
        return "Pet: "+name+ "; Pet type: "+type.toString()+"; ";
    }
}

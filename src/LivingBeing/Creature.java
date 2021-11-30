package LivingBeing;

import Utility.*;


public abstract class Creature implements Moveable, InteractionWithCar {
    protected String name;
    protected Integer age;
    protected Location location;
    protected Double speed;
    protected int health = 5;

    public Creature() {
        name = "Nameless";
        age = 0;
        location = Location.UNDEFINED;
        speed = 0d;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSpeed() {
        return speed;
    }

    public Creature(String name, Integer age, Location location, Double speed) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.speed = speed;
    }


    protected abstract void changingLocationMassage(Double speed);



}

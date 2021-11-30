package Thing;

import Utility.*;

public abstract class Vehicle implements Moveable {
    protected Double speed;
    protected Integer freeSeats;
    protected Location location;

    public Double getSpeed() {
        return speed;
    }

    Vehicle() {
        speed = 0d;
        freeSeats = 0;
        location = Location.UNDEFINED;
    }

    Vehicle(Double speed, Integer freeSeats, Location location) {
        this.speed = speed;
        this.freeSeats = freeSeats;
        this.location = location;
    }
}
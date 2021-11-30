package Utility;

import LivingBeing.Shorty;
import Thing.Car;
import Thing.LemonadeCar;

public class CarCreation {
    public static LemonadeCar createCar(Double speed, Integer freeSeats, Location location, int maxVolume, int currentVolume, Shorty... shorties){
        System.out.println("Машину создали");
        for(int i = 0;i<shorties.length;i++){
            System.out.print(shorties[i].getName() + " ");
        }
        System.out.println();
        return new LemonadeCar(speed, freeSeats, location, maxVolume, currentVolume);
    }
}

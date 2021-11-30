package Thing;

import LivingBeing.Shorty;
import Utility.Location;

public class LemonadeCar extends Car {

    public static final int prevalence = 99;

    public LemonadeCar(){
        super();
    }

    public LemonadeCar(Double speed, Integer freeSeats, Location location, int maxVolume, int currentVolume){
        super(speed, freeSeats, location);
        new Tank(maxVolume, currentVolume);
    }


    class Tank{
        private final int maxVolume;
        private int currentVolume;

        private Tank(int maxVolume, int currentVolume){
            this.maxVolume = maxVolume;
            this.currentVolume = currentVolume;
        }

        public void fill(int volume, Shorty shorty){
            try {
                if (volume < 0) {
                    throw new TankException("Значение должно быть отрицательным");
                }
                currentVolume += volume;
                if (currentVolume > maxVolume){throw new TankException("В бак невозможно налить так много лемонада");}
            }
            catch (TankException e){
                System.out.println(e.getMessage());
                currentVolume = Math.min(currentVolume, maxVolume);
            }
        }

        class PlasticTube{
            private PlasticTube(){
            }

            public void provideLemonade(){

            }
        }
    }


}

class TankException extends Exception{
    public TankException(String massage){
        super(massage);
    }
}

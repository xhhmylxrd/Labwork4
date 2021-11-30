package LivingBeing;

import Utility.*;
import Thing.*;


public class Shorty extends Creature implements AbleToJoinStory {


    private Car inWhatCar;
    private boolean isAbleToDrinkAllLemonade;
    private boolean loveToRideCar;
    private boolean canDrive = false;

    public Shorty(String name, Integer age, Location location, Double speed, boolean isAbleToDrinkAllLemonade, boolean loveToRideCar) {
        this.speed = speed;
        this.isAbleToDrinkAllLemonade = isAbleToDrinkAllLemonade;
        this.location = location;
        this.name = name;
        this.age = age;
        this.loveToRideCar = loveToRideCar;
    }

    public Shorty(String name, Integer age, Location location, Double speed) {
        super(name, age, location, speed);
    }


    @Override
    public void joinStory() {
        System.out.println(joinMassage() + "\n");
    }


    private String joinMassage() {
        return "Коротышка " + name + " присоединился к истории";
    }


    public void moveTo(Location location) {
        if (inWhatCar == null) {
            if (speed == 0) {
                System.out.println("Коротышка " + name + " не имеет возможности перемещаться\n");
            } else if (this.location == location) {
                System.out.println("Коротышка " + name + " и так находится в " + location + "\n");
            } else {
                this.location = location;
                changingLocationMassage(speed);
                System.out.println("Коротышка " + name + " переместился в " + location + "\n");
            }
        } else {
            inWhatCar.moveTo(location);
        }
    }


    @Override
    protected void changingLocationMassage(Double speed) {
        Double distance = 200d;
        if (speed < 30) {
            System.out.println("Коротышка " + name + " идет...");
        } else {
            System.out.println("Коротышка " + name + " бежит...");
        }
        Time.pause(distance / speed);
    }

    @Override
    public void speedUp(Double speed) {
        this.speed += speed;
    }

    @Override
    public void slowDown(Double speed) {
        this.speed -= speed;
    }

    @Override
    public void driveCar(Car car) {
        if (car.getIsDriven()) {
            System.out.println("За рулем уже кто-то есть!");
        } else {
            inWhatCar = car;
            car.setIsDriven(true);
            car.setFreeSeats(car.getFreeSeats() + 1);
            car.setDriver(this);
            System.out.println(name + " теперь находится за рулем машины.");
        }
    }

    @Override
    public void rideCar(Car car) {
        if (car.getFreeSeats() > 0) {
            isAbleToDrinkAllLemonade = true;
            car.setFreeSeats(car.getFreeSeats() - 1);
            inWhatCar = car;
            System.out.println(name + " теперь находится на пассажирском сидении");
        } else {
            System.out.println("Машина уже битком!");
        }
        System.out.println();
    }

    @Override
    public void leaveCar(Car car) {
        if (car.getDriver().getName().equals(name)) {
            car.setDriver(null);
            car.setFreeSeats(car.getFreeSeats() + 1);
            System.out.println(name + " вышел с водительского места");
            inWhatCar = null;

        } else if (inWhatCar.equals(car)) {
            car.setFreeSeats(car.getFreeSeats() + 1);
            inWhatCar = null;
            System.out.println(name + " вышел с пассажирского места");
        } else {
            System.out.println(name + " и так не в машине.");
        }
        System.out.println();
    }

    public void communicateWith(Shorty shorty, String massage) {
        if (this.location == shorty.location) {
            System.out.println(this.name + " обращается к " + shorty.name + ":");
            System.out.println(massage + "\n");

        } else {
            System.out.println(name + " не может обратиться к " + shorty.name + ". Персонажи не рядом");
        }
    }

    public boolean getIsAbleToDrinkAllLemonade() {
        return isAbleToDrinkAllLemonade;
    }

    public boolean getLoveToRideCar() {
        return loveToRideCar;

    }

    public void loveToRideCarMassage() {
        if (loveToRideCar) {
            System.out.println(name + " Любит ездить на машине" + '\n');
        } else {
            System.out.println(name + " не любит ездить на машине\n");
        }

    }

    public void setLoveToRideCar(boolean value) {
        loveToRideCar = value;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode() && this.getClass() == obj.getClass();
    }

    @Override
    public String toString() {
        return "Коротышка " + name + ", находящийся в " + location + ", " + age + " лет от роду, со скоростью = " + speed;
    }

    public void drinkLemonade() {
        if (this.isAbleToDrinkAllLemonade) {
            if (this.inWhatCar != null) {
                System.out.println(this.getName() + " может пить сколько угодно газировки");
            } else System.out.println(this.getName() + " любит пить газировку.");
        }
    }
    public void learnHowToDrive(){
        this.canDrive = true;
        System.out.println(this.toString() + " теперь умеет водить машину");
    }
}
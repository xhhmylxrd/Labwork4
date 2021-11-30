package Utility;

import LivingBeing.*;
import Thing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



public class Story {

    private static class CurrentDateTime {
        public static String getCurrentDT(){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            return dtf.format(now);
        }
    }

    public static void main(String[] args) {

        System.out.println("История начинается в " + CurrentDateTime.getCurrentDT());

        Shorty shorty1 = new Shorty("Торопыжка", 6, Location.UNDEFINED, 12d, true, true);
        Shorty shorty2 = new Shorty("Винтик", 6, Location.BACKYARD, 11d, false, true);
        Shorty shorty3 = new Shorty("Шпунтик", 6, Location.BACKYARD, 10d, false, true);
        Shorty shorty4 = new Shorty("Сиропчик", 6, Location.HOUSE, 12d, true, true);
        Shorty shorty5 = new Shorty("Незнайка", 6, Location.HOUSE, 12d, true, true);

        shorty2.joinStory();
        shorty3.joinStory();

        System.out.println("распространенность Газированных машин = " + LemonadeCar.prevalence + "%");

        LemonadeCar lCar = CarCreation.createCar(60d,4,Location.BACKYARD, 100, 0, shorty2, shorty3);

        shorty2.speedUp(20d);
        shorty3.speedUp(20d);
        shorty2.moveTo(Location.HOUSE);
        shorty3.moveTo(Location.HOUSE);

        shorty1.joinStory();
        shorty1.learnHowToDrive();

        shorty4.joinStory();
        System.out.println("Любовь " + shorty4.getName() + "к поездкам на машине = " + shorty4.getLoveToRideCar());

        shorty5.joinStory();
        shorty5.communicateWith(shorty1, "Прокати меня машине");
        shorty5.moveTo(Location.BACKYARD);
        shorty5.driveCar(lCar);
        shorty4.communicateWith(shorty5, "Ты куда?!!");
        shorty4.moveTo(Location.BACKYARD);
        shorty4.communicateWith(shorty5, "Ты куда?!!");
        shorty2.moveTo(Location.BACKYARD);
        shorty3.moveTo(Location.BACKYARD);


        Shorty shorty6 = new Shorty("Булька", 7, Location.BOOTH, 12d, true, false);

        Booth booth1 = new Booth();
        booth1.addShorty(shorty6);
        shorty6.moveTo(Location.BACKYARD);
        booth1.removeShorty(shorty6);
        shorty5.moveTo(Location.BOOTH);
        booth1.destroy(lCar);

        Gazebo gazebo = new Gazebo();
        shorty5.moveTo(Location.GAZEBO);
        gazebo.destroy(lCar);

        System.out.println("История заканчивается в " + CurrentDateTime.getCurrentDT());

    }
}
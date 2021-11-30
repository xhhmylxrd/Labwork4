package Utility;

public class Time {
    public static void pause(Double time) {
        try {
            Thread.sleep(Math.round(time) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

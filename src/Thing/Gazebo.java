package Thing;

import LivingBeing.Shorty;

public class Gazebo {
    private boolean exists = true;
    public Gazebo(){}
    public void destroy(Car o){
        exists = false;
        System.out.println("Беседка"  +  " разлетелась на щепки из-за " + o.toString());
        hurtSomeone(o.getDriver());
    }
    public boolean getExists(){
        return exists;
    }

    private void hurtSomeone(Shorty shorty){
        try {
            System.out.println(shorty.getName() + " покалечился от щепок беседки");
        }
        catch (GazeboDriverNullException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
class GazeboDriverNullException extends RuntimeException{
    GazeboDriverNullException(){
        super("Колечить некого, в машине нет водителя");
    }
}

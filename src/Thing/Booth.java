package Thing;

import LivingBeing.Shorty;
import Utility.Location;

import java.util.HashSet;

public class Booth {
    private boolean exists = true;
    private HashSet<Shorty> whoIsIn = new HashSet<>();
    public Booth() {
    }

    public HashSet<Shorty> getWhoIsIn() {
        return whoIsIn;
    }
    public void addShorty(Shorty s){
        whoIsIn.add(s);
        s.moveTo(Location.BOOTH);
    }
    public void removeShorty(Shorty s){
        whoIsIn.remove(s);
    }

    public void destroy(Object o){
        exists = false;
        System.out.println("Будка " + " разлетается на щепки из-за  " + o.toString());
    }

}

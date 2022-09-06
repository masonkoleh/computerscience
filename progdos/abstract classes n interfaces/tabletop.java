import java.util.*;

public class tabletop implements photocenter
{
    private String[] types = {"aluminum", "medallion", "wood"};
    private double[] moneys = {11.50, 13.50, 9.75};
    
    public int prints;
    public double cost = 25.00;
    public String type = "";
    
    public tabletop(String t, int p) {
        this.prints = p;
        if (Arrays.asList(types).indexOf(t.toLowerCase()) > -1) {
            this.type = types[Arrays.asList(types).indexOf(t.toLowerCase())];
            this.cost = moneys[Arrays.asList(types).indexOf(t.toLowerCase())];
        } else
            this.type = t.toLowerCase();
    }
    
    public double cost() {
        return prints * cost;
    }
    
    public String type() {
        return type;
    }
    
    public String toString() {
        return "";
    }
}
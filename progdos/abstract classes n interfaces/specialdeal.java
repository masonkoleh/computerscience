import java.util.*;

public class specialdeal implements photocenter
{
    public String type = "Special Deal";
    photoprints a;
    poster b;
    tabletop c;
    
    public specialdeal(photoprints a, poster b, tabletop c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double cost() {
        return (a.cost() + b.cost() + c.cost()) - 5;
    }
    
    public String type() {
        return type;
    }
    
    public String toString() {
        return "";
    }
}

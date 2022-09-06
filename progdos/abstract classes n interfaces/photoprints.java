public class photoprints implements photocenter
{
    public int prints;
    public double cost = 0.22;
    public String type = "Photo Prints";
    
    public photoprints(int p) {
        this.prints = p;
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

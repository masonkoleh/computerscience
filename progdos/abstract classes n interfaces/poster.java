public class poster implements photocenter
{
    public int prints;
    public double cost = 4.50;
    public String type = "Poster";
    
    public poster(int p) {
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

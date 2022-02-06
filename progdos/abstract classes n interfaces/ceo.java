public class ceo extends employee
{
    public ceo(String name, int level, double paygrade, int years, String reports) {
        super(name, "CEO", level, paygrade, years, reports);
    }
    
    public String toString() {
        return super.toString();
    }
}

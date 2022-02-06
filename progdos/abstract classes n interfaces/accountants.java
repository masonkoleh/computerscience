public class accountants extends employee
{
    public accountants(String name, int level, double paygrade, int years, String reports) {
        super(name, "Accountants", level, paygrade, years, reports);
    }
    
    public String toString() {
        return super.toString();
    }
}

public class accountingmanager extends employee
{
    public accountingmanager(String name, int level, double paygrade, int years, String reports) {
        super(name, "Accounting Manager", level, paygrade, years, reports);
    }
    
    public String toString() {
        return super.toString();
    }
}

import java.text.DecimalFormat;

public class employee
{
    DecimalFormat padding = new DecimalFormat("0000");
    DecimalFormat money = new DecimalFormat("$#.00");
    public String name, title, reports;
    int level, years;
    double paygrade, totalpay;
    
    public employee(String name, String title, int level, double paygrade, int years, String reports) {
        this.name = name;
        this.title = title;
        this.level = level;
        this.paygrade = paygrade;
        this.years = years;
        this.reports = reports;
    }
    
    public double paycalc() {
        totalpay = (paygrade * (1 + (0.1 * years))) * 25000;
        return totalpay;
    }
    
    public String toString() {
        String[] slims = {this.name, this.title};
        for (int x = 0; x < slims.length; x += 1) {
            int spaces = 16 - slims[x].length();
            for (int y = 0; y < spaces; y += 1)
                slims[x] += " ";
        }
        return slims[0] + "\t" + slims[1] + "\t" + level + "\t" + money.format(paycalc()) + "\t" + money.format(paygrade) + "\t\t" + years + "\t" + reports;
    }
}
import java.text.DecimalFormat;

public class employees
{
    DecimalFormat padding = new DecimalFormat("0000");
    DecimalFormat money = new DecimalFormat("$#.00");
    public String lastname, firstname, title, id;
    public double basepay, totalpay;
    public employees(String first, String last, String title, double pay) {
        this.firstname = first;
        this.lastname = last;        
        this.id = this.makeid();
        this.title = title;
        this.basepay = pay;
    }
    
    private String makeid() {
        return padding.format((Math.random() * 9999) + 1);
    }
    
    public void yearlypay() {
        totalpay = basepay;
    }
    
    public String toString() {
        return lastname + ", " + firstname + "\nID:\t\t" + id + "\nJob Title:\t" + title + "\nBase Pay:\t" + money.format(basepay) + "\nTotal Pay:\t" + money.format(totalpay) + "\n";
    }
}
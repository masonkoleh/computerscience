public class lawyer extends employees
{
    private int courthours;
    private double courtrate;
    public lawyer(String first, String last, String title, double pay, double rate, int hours) {
        super(first, last, title, pay);
        this.courtrate = rate;
        this.courthours = hours;
    }
    
    public void addcourthours(int hours) {
        courthours += hours;
    }
    
    public void yearlypay() {
        totalpay = basepay + (courthours * courtrate);
    }
    
    public String toString() {
        return super.toString() + "Court Rate:\t" + money.format(courtrate) + "\nCourt Hours:\t" + courthours + " Hours\n";
    }
}
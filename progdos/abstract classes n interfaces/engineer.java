public class engineer extends employees
{
    private int traveltime;
    private double travelrate, hazardpay;
    public engineer(String first, String last, String title, double pay, int time, double rate, double hazard) {
        super(first, last, title, pay);
        this.traveltime = time;
        this.travelrate = rate;
        this.hazardpay = hazard;
    }
    
    public void addtraveltime(int hours) {
        traveltime += hours;
    }
    
    public void sethazardpay(double pay) {
        hazardpay = pay;
    }
    
    public void yearlypay() {
        totalpay = basepay + (travelrate * traveltime) + hazardpay;
    }
    
    public String toString() {
        return super.toString() + "Travel Rate:\t" + money.format(travelrate) + "\nTravel Time:\t" + traveltime + " Hours\nHazard Pay:\t" + money.format(hazardpay) + "\n";
    }
}

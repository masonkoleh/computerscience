public class guard extends employees
{
    private double gunstipend = 350.00;
    public guard(String first, String last, String title, double pay, double stipend) {
        super(first, last, title, pay);
        this.gunstipend = stipend;
    }
    
    public void yearlypay() {
        totalpay = basepay + gunstipend;
    }
    
    public String toString() {
        return super.toString() + "Gun Stipend:\t" + money.format(gunstipend) + "\n";
    }
}
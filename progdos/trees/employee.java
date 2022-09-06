import java.util.*;
import java.text.DecimalFormat;
public class employee {
    DecimalFormat money = new DecimalFormat("$,###.00");
    public String name = "", job = "";
    public int level = 0, years = 0;
    public double pay = 0.0;
    public employee superior = null;
    
    public employee(String name, String job, int lvl, double pay, int yrs) {
        this.name = name;
        this.job = job;
        this.level = lvl;
        this.pay = pay;
        this.years = yrs;
        this.superior = superior;
    }
    
    public employee(String name, String job, int lvl, double pay, int yrs, employee superior) {
        this.name = name;
        this.job = job;
        this.level = lvl;
        this.pay = pay;
        this.years = yrs;
        this.superior = superior;
    }
    
    public String name()
    { return this.name; }
    public double salary()
    { return 40000 * this.pay * (1.02 * this.years);    }
    public String toString()
    {
        String padded = this.name;
        int spaces = (4 * 4) - padded.length();
        for (int y = 0; y < spaces; y += 1) padded += " ";
        
        String pjob = this.job;
        int pspac = (4 * 4) - pjob.length();
        for (int y = 0; y < pspac; y += 1) pjob += " ";
            
        if (this.superior != null)
            return padded + "\t" + pjob + "\t" + this.level + "\t" + this.pay + "\t\t" + this.years + "\t\t" + money.format(this.salary()) + "\t" + this.superior.name;
        else
            return padded + "\t" + pjob + "\t" + this.level + "\t" + this.pay + "\t\t" + this.years + "\t\t" + money.format(this.salary());
    }
}

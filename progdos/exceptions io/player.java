import java.text.DecimalFormat;

public class player{
    DecimalFormat rounding = new DecimalFormat("0.000");
    private String name, team, POS;
    private int G, AB, R, H, DB, TR, HR, RBI, BB, K, SB;
    private double AVG, OBP, SLG, OPS;
    
    public player(String name, String team, String POS, int G, int AB, int R, int H, int DB, int TR, int HR, int RBI, int BB, int K, int SB)
    {
        this.name = name;
        this.team = team;
        this.POS = POS;
        this.G = G;
        this.AB = AB;
        this.R = R;
        this.H = H;
        this.DB = DB;
        this.TR = TR;
        this.HR = HR;
        this.RBI = RBI;
        this.BB = BB;
        this.K = K;
        this.SB = SB;
    }
    
    public String getName()
    {   return name;    }
    public String getTeam()
    {   return team;    }
    public String getPOS()
    {   return POS; }
    public int getG()
    {   return G;   }
    public int getAB()
    {   return AB;  }
    public int getR()
    {   return R;   }
    public int getH()
    {   return H;   }
    public int getDB()
    {   return DB;  }
    public int getTR()
    {   return TR;  }
    public int getHR()
    {   return HR;  }
    public int getRBI()
    {   return RBI; }
    public int getBB()
    {   return BB;  }
    public int getK()
    {   return K;   }
    public int getSB()
    {   return SB;  }

    public double getAVG()
    {   return (double)H/AB; }
    public double getOBP()
    {   return (double)(H+BB)/(AB+BB); }
    public double getSLG()
    {   return (double)(H+DB+(TR*2)+(HR*3))/(AB); }
    public double getOPS()
    {   return getOBP()+getSLG(); }
    
    public String toString()
    {
        int spaces = 8 - name.length();
        String padded = name;
        if (spaces >= 1)
            padded += "\t";
        return padded + "\t" + team + "\t" + POS + "\t" + G + "\t" + AB + "\t" + R + "\t" + H + "\t" + DB + "\t" + TR + "\t" + HR + "\t" + RBI + "\t" + BB + "\t" + K + "\t" + SB + "\t" + rounding.format(this.getAVG()) + "\t" + rounding.format(this.getOBP()) + "\t" + rounding.format(this.getSLG()) + "\t" + rounding.format(this.getOPS());
    }
}
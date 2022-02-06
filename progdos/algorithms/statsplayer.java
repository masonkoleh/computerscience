import java.text.DecimalFormat;

public class statsplayer{
    DecimalFormat rounding = new DecimalFormat("0.000");
    private String name, team, POS;
    private int G, AB, R, H, DB, TR, HR, RBI, BB, K, SB;
    private double AVG, OBP, SLG, OPS;
    
    public statsplayer(String name, String team, String POS, int G, int AB, int R, int H, int DB, int TR, int HR, int RBI, int BB, int K, int SB)
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
    
    public String getinfo(int x)
    {
        switch (x) {
            case 0:     return this.name;
            case 1:     return this.team;
            case 2:     return this.POS;
            case 3:     return String.valueOf(this.G);
            case 4:     return String.valueOf(this.AB);
            case 5:     return String.valueOf(this.R);
            case 6:     return String.valueOf(this.H);
            case 7:     return String.valueOf(this.DB);
            case 8:     return String.valueOf(this.TR);
            case 9:     return String.valueOf(this.HR);
            case 10:    return String.valueOf(this.RBI);
            case 11:    return String.valueOf(this.BB);
            case 12:    return String.valueOf(this.K);
            case 13:    return String.valueOf(this.SB);
            case 14:    return String.valueOf(rounding.format(this.getAVG()));
            case 15:    return String.valueOf(rounding.format(this.getOBP()));
            case 16:    return String.valueOf(rounding.format(this.getSLG()));
            case 17:    return String.valueOf(rounding.format(this.getOPS()));
        }
        return "";
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
    
    public String toString() {
        String padded = this.name;
        int spaces = 8 - this.name.length();
        int tabs = 0;
        if (spaces >= 1)
            tabs = ((int)(spaces / 8) >= 1) ? 2 : 1;
        for (int a = 0; a < tabs; a += 1)
            padded += "\t";
        
        return padded + "\t" + this.team + "\t" + this.POS + "\t" + this.G + "\t" + this.AB + "\t" + this.R + "\t" + this.H + "\t" + this.DB + "\t" + this.TR + "\t" + this.HR + "\t" + this.RBI + "\t" + this.BB + "\t" + this.K + "\t" + this.SB + "\t" + rounding.format(this.getAVG()) + "\t" + rounding.format(this.getOBP()) + "\t" + rounding.format(this.getSLG()) + "\t" + rounding.format(this.getOPS());
    }
}
        

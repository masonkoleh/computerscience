public class students
{
    private String name;
    private int grade, period;
    public students(String name, int grade, int period)
    {
        this.name = name;
        this.grade = grade;
        this.period = period;
    }
    
    public String getName()
    {   return name;    }
    public int getGrade()
    {   return grade;   }
    public int getPeriod()
    {   return period;  }
    
    public String letterGrade(int currentGrade)
    {
        if (currentGrade >= 90)
            return "A";
        else if (currentGrade >= 80)
            return "B";
        else if (currentGrade >= 70)
            return "C";
        else if (currentGrade >= 60)
            return "D";
        return "F";
    }
    public String letterGrade()
    {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        return "F";
    }
    
    public String toString()
    {
        int spaces = 8 - name.length();
        String padded = name;
        int tabs = 0;
        if (spaces >= 1)
            tabs = ((int)(spaces / 8) >= 1) ? 2 : 1;
        for (int a = 0; a < tabs; a += 1)
            padded += "\t";
            
        return padded + "\t" + grade + "%\t" + period + "\t" + this.letterGrade();
    }
}

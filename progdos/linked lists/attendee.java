public class attendee
{
    public String[] name = new String[2];
    public int invited;
    public String relation = "";
    public int priority = 1;
    
    public attendee(String[] a, int b, String c, int d)
    {
        this.name = new String[]{a[1], a[0]};
        this.invited = b;
        this.relation = c;
        this.priority = d;
    }
    
    public String toString()
    {
        String[] padded = new String[]{name[0] + ", " + name[1]};
        for (int x = 0; x < padded.length; x += 1) {
            int spaces = 16 - padded[x].length();
            for (int y = 0; y < spaces; y += 1)
                padded[x] += " ";
        }
        return padded[0] + "\t" + invited + "\t\t" + priority + "\t\t" + relation;
    }
}
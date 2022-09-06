public class wageworker
{
    public String name = "";
    public String joined = "";
    
    public wageworker(String a, String b)
    {
        this.name = a;
        this.joined = b;
    }
    
    public String toString()
    {
        /*
        String[] padded = new String[]{name[0] + ", " + name[1]};
        for (int x = 0; x < padded.length; x += 1) {
            int spaces = 16 - padded[x].length();
            for (int y = 0; y < spaces; y += 1)
                padded[x] += " ";
        }
        return padded[0] + "\t" + invited + "\t\t" + priority + "\t\t" + relation;
        */
        return this.name + "\t" + this.joined;
    }
}

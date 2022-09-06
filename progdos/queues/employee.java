public class employee
{
    public String name, job;
    public int hired;
    
    public employee(String name, int hired, String job) {
        this.name = name;
        this.hired = hired;
        this.job = job;
    }
	
	public String toString() {
        String padded = this.name;
		int spaces = (4 * 2) - padded.length();
		for (int y = 0; y < spaces; y += 1)
			padded += " ";
		return padded + "\t" + hired + "\t" + job;
	}
}
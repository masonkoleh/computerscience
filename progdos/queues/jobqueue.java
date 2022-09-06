import java.util.*;
import java.io.*;
import java.lang.Math;

class sortyear implements Comparator<employee> {
    public int compare(employee a, employee b) {
        return a.hired - b.hired;
    }
}

public class jobqueue
{   
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] jobs = {"Manager", "Lawyer", "Vice President", "CEO"};
        String[] files = {"Managers.txt", "Lawyers.txt", "VicePresident.txt", "CEO.txt"};
        Queue<employee> company = new LinkedList<>();
        
        for (int a = 0; a < files.length; a += 1) {
            try {
                FileReader filereader = new FileReader("files/" + files[a]);
                BufferedReader bufferedreader = new BufferedReader(filereader);
                String line = "";
                while ((line = bufferedreader.readLine()) != null) {
                    String[] data = line.split("\t");
                    company.add(new employee(data[0], Integer.parseInt(data[1]), jobs[a]));
                }
                bufferedreader.close();
            } catch (FileNotFoundException error) {
                System.out.println(error);
            } catch (IOException error) {
                System.out.println(error);
            }
        }
        
        employee[] test = company.toArray(new employee[0]);
        Arrays.sort(test, new sortyear());
        company.clear();
        for (employee b : test)
            company.add(b);
        while(company.size() > 0)
            System.out.println(company.remove());
    }
}

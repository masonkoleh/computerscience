import java.util.*;
import java.io.*;
import java.lang.Math;
public class company {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        chain<employee> head = null;
        
        try {
            FileReader filereader = new FileReader("files/Company.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufferedreader.readLine()) != null) {
                String[] d = line.split("\t");
                if (!d[0].equals("Name")) {
                    if (d[5].equals("No One")) head = new chain<employee>(new employee(d[0], d[1], Integer.parseInt(d[2]), Double.parseDouble(d[3]), Integer.parseInt(d[4])));
                    else for (chain<employee> node : head.tree())
                            if (node.info.name.equals(d[5]))
                                node.add(new chain<employee>(new employee(d[0], d[1], Integer.parseInt(d[2]), Double.parseDouble(d[3]), Integer.parseInt(d[4]), node.info)));
                }
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        System.out.print("Did you want to print a specific employee's tree (y/n): ");
        boolean person = scan.nextLine().equalsIgnoreCase("Y");
        if (person) {
            System.out.print("Whose tree would you like to see: ");
            String name = scan.nextLine();
            for (chain<employee> node : head.tree())
                if (node.info.name.equalsIgnoreCase(name))
                    head = node;
			if (!head.info.name.equalsIgnoreCase(name))
				System.out.println("No employee with the name \"" + name + "\" could be found.");
        }
        
        System.out.println("\nName\t\t\tJob Title\t\tLevel\tPay Grade\tYears Employed\tSalary\t\tReports To");
        head.breadth();
    }
}
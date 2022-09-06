import java.util.*;
import java.io.*;
import java.lang.Math;

public class Corporation
{
    public static String titleformat(String position) {
        String[] splitted = position.toLowerCase().split(" ");
        String compiled = "";
        for (String x : splitted)
            compiled += x;
        return compiled;
    }
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] indexes = {"Name", "Job Title", "Level", "Pay Grade", "Years", "Reports To"};
        String[] titles = {"chairmanoftheboard", "boardofdirectors", "ceo", "cfo", "coo", "cto", "accountingmanager", "directorsofit", "accountants", "itmanagers", "hrleads", "hrspecialists", "secretaries", "itspecialists", "hrinterns"};
        
        String line = "";
        ArrayList<employee> company = new ArrayList<employee>();
        try {
            FileReader filereader = new FileReader("files/company.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null) {
                String[] data = line.split("\t");
                if (!data[0].equals("Name")) {
                    switch (Arrays.asList(titles).indexOf(titleformat(data[1]))) {
                        case 0:     company.add(new chairmanoftheboard(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 1:     company.add(new boardofdirectors(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 2:     company.add(new ceo(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 3:     company.add(new cfo(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 4:     company.add(new coo(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 5:     company.add(new cto(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 6:     company.add(new accountingmanager(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 7:     company.add(new directorsofit(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 8:     company.add(new accountants(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 9:     company.add(new itmanagers(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 10:    company.add(new hrleads(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        case 11:    company.add(new hrspecialists(data[0], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                        default:    company.add(new employee(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5])); break;
                    }
                }
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        System.out.println("Would you like to:\n1. Print all employees.\n2. Print all employees from a job.\n3. Print all employees that make over/under an amount of money.");
        System.out.print("Choice: ");
        int decision = Integer.parseInt(scan.nextLine()) - 1;
        switch (decision) {
            case 1:     System.out.print("What position would you like to filter by: ");
                        String pos = titleformat(scan.nextLine());
                        System.out.println("\nName\t\t\tJob Title\t\tLevel\tSalary\t\tPay Grade\tYears\tReports To");
                        for (employee e: company)
                            if (titleformat(e.title).equals(pos))
                                System.out.println(e);
                        break;
            case 2:     System.out.print("What are your targeted wages (ex. \"over 500000\"): ");
                        String[] filterby = scan.nextLine().split(" ");
                        int amount = Integer.parseInt(filterby[1]);
                        boolean greater = filterby[0].equals("over");
                        System.out.println("\nName\t\t\tJob Title\t\tLevel\tSalary\t\tPay Grade\tYears\tReports To");
                        for (employee e: company)
                            if (amount < e.paycalc() == greater)
                                System.out.println(e);
                        break;
            default:    System.out.println("\nName\t\t\tJob Title\t\tLevel\tSalary\t\tPay Grade\tYears\tReports To");
                        for (employee e : company)
                            System.out.println(e);
                        break;
        }        
    }
}

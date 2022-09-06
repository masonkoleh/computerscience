import java.util.*;
import java.io.*;
import java.lang.Math;

public class Corporation
{   
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String line = "";
        Stack<wageworker> company = new Stack<wageworker>();
        try {
            FileReader filereader = new FileReader("files/NamesDateFires.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null) {
                String[] data = line.split("\t");
                String[] splitted = data[0].split(" ");
                
                if (splitted[0].equals("fire"))
                    if (splitted.length > 1)
                        for (int x = 0; x < Integer.parseInt(splitted[1]); x += 1)
                            System.out.println(company.pop().name + " was fired on " + data[1]);
                    else
                        System.out.println(company.pop().name + " was fired on " + data[1]);
                else
                    System.out.println(company.push(new wageworker(data[0], data[1])).name + " was hired on " + data[1]);
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        System.out.println("\nFinal Team:");
        for (int y = 0; y < company.size(); y += 1)
            System.out.println(company.pop());
    }
}

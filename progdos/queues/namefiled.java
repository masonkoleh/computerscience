import java.util.*;
import java.io.*;

public class namefiled
{   
    public static void main(String[] args)
    {
        Queue<String> males = new LinkedList<>();
        Queue<String> females = new LinkedList<>();
        String line = "";
        
        try {
            FileReader filereader = new FileReader("files/NamesGenders.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null){
                String[] person = line.split(" ");
                if (person[0].toUpperCase().equals("M")) males.add(person[1]);
                else females.add(person[1]);
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        System.out.println("Men:");
        while (males.size() > 0)
            System.out.println(males.remove());
        System.out.println("\nWomen:");
        while (females.size() > 0)
            System.out.println(females.remove());
    }
}

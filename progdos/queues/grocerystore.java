import java.util.*;
import java.io.*;
import java.lang.Math;

public class grocerystore
{   
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Queue<String> storeline = new LinkedList<>();
        String line = "";
        
        try {
            FileReader filereader = new FileReader("files/GroceryStore2.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null) {
                if (line.toLowerCase().equals("next"))
                    try {
                        System.out.println(storeline.remove() + " has checked out\n" + storeline.size() + " remainin");
                    } catch (NoSuchElementException error) {
                        System.out.println("Grocery list is empty");
                    }
                else
                    if (storeline.add(line))
                        System.out.println(line + " has gotten in line");
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
    }
}

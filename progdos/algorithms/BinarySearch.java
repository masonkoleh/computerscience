import java.io.*;
import java.util.*;

public class BinarySearch {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> namesList = new ArrayList<String>();
        String[] names;
        
        try {
            String line = "";
            FileReader fileReader = new FileReader("files/Names.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
                namesList.add(line);
                
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Cannot open file");                
        } catch(IOException ex) {
            System.out.println("Error reading file");
        }        
        
        names = new String[namesList.size()];
        for (int x = 0; x < names.length; x++)
            names[x] = namesList.get(x);
            
        System.out.print("What names are you looking for: ");
        String searchName = scan.next();
        System.out.println(searchName + " is found at location: " + foundName(names, searchName));
    }
    
    public static int foundName(String[] names, String searchName)
    {
        //returns the location of searchName within the array names, -1 if not found.
        for (int x = 0; x < names.length; x++)
            if (names[x].equals(searchName))
                return x;
        return -1;
    }
}


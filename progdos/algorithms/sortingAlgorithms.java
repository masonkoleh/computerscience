import java.io.*;
import java.util.*;

public class sortingAlgorithms {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> namesList = new ArrayList<String>();
        
        try {
            FileReader fileReader = new FileReader("files/NamesUnordered.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null)
                namesList.add(line);
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Cannot open file");                
        } catch(IOException ex) {
            System.out.println("Error reading file");
        }
        
        String[] names = new String[namesList.size()];
        for (int x = 0; x < names.length; x++)
            names[x] = namesList.get(x);
        String[] orderedInsertion = insertionSort(names);
        
        System.out.println("Unordered List\n" + returnAllNames(names));
        System.out.println("Ordered List\n" + returnAllNames(orderedInsertion));
    }
    
    public static String returnAllNames(String[] names)
    {
        String n = "";
        for (int x = 0; x < names.length; x++) {
            if ((x % 10 == 0) && (x > 0))
                n += "\n";
            n += (names[x] + " ");
        }
        
        return n;
    }
    
    public static String[] insertionSort(String[] names)
    {
        //Puts all names in ordering using the insertion sort algorithm
        String[] sorted = names.clone();
        System.out.println(sorted.length);
        int x = 0;
        do {
            for (x = 0; x < sorted.length - 1; x += 1)
                if (sorted[x].compareTo(sorted[x + 1]) > 0) {
                    String temp = sorted[x];
                    sorted[x] = sorted[x + 1];
                    sorted[x + 1] = temp;
                    break;
                }
        } while (x < sorted.length - 1);
        return sorted;
    }
}
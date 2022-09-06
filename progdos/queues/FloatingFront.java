import java.util.*;
public class FloatingFront
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] stringarray = new String[10];
        int front = 0, back = 0;
        
        int choice;
        do {
            System.out.println("\nWhat would you like to do\n1. Push\n2. Pop\n3. Size\n4. Quit");
            System.out.print("Choice: ");         
            choice = Integer.parseInt(scan.nextLine());
            
            switch (choice) {
                case 1: System.out.print("Push: ");
                        int open = 0;
                        while (stringarray[open] != null)
                            open += 1;
                        stringarray[open] = scan.nextLine();
                        break;
                case 2: int index;
                        for (index = 0; stringarray[index] == null; index += 1)
                            continue;
                        stringarray[index] = null;
                        break;
                case 3: int count = 0;
                        for (int y = 0; y < stringarray.length; y += 1)
                            if (stringarray[y] != null) count += 1;
                        System.out.println(count);
                        break;
            }
        } while (choice != 4);
        
        System.out.println("\nArray:");
        for (String z : stringarray)
            if (z != null)
                System.out.println(z);
    }
}
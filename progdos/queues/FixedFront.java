import java.util.*;
public class FixedFront
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
                        stringarray[(stringarray[back] != null) ? back + 1 : back] = scan.nextLine();
                        if (stringarray[1] != null) back += 1;
                        break;
                case 2: stringarray[back] = null;
                        if (back != 0) back -= 1;
                        break;
                case 3: System.out.println(back + ((stringarray[0] == null) ? 0 : 1));
                        break;
            }
        } while (choice != 4);
        
        System.out.println("\nArray:");
        for (String z : stringarray)
            if (z != null)
                System.out.println(z);
    }
}

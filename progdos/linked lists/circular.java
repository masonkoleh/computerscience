import java.util.*;

public class circular
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        chain<String> head = null;
        String name = "";
        boolean again = false;
        
        while (true) {
            name = scan.nextLine();
            if (name.toLowerCase().equals("done")) {
                chain<String> last = head;
                while (last.before() != null)
                    last = last.before();
                last.before(head);
                head.after(last);
                break;
            }
            
            if (head != null) {
                chain<String> iterator = head;
                while (iterator.before() != null)
                    iterator = iterator.before();
                iterator.before(new chain<String>(name));
                iterator.before().after(iterator);
            } else {
                head = new chain<String>(name);
                head.after(head);
            }
        }
        
        do {
            System.out.println("\nWould you like to:");
            System.out.println("1. Add people to the list?");
            System.out.println("2. Remove people from the list?");
            System.out.println("3. Print the people in the list?");
            int choice = Integer.parseInt(scan.nextLine());
            
            switch (choice) {
                case 1: System.out.print("\nWho would you like to add to the list: ");
                        String person = scan.nextLine();
                        chain<String> last = head.after();
                        last.before(new chain<String>(person));
                        last.before().before(head);
                        last.before().after(last);
                        head.after(last.before());
                        break;
                case 2: System.out.print("\nWho would you like to remove from the list: ");
                        String del = scan.nextLine().toLowerCase();
                        chain<String> search = head;
                        while (!search.before().info().toLowerCase().equals(del))
                            search = search.before();
                        search.before().before().after(search);
                        search.before(search.before().before());
                        break;
            }
            
            System.out.println("\nBirthday List:");
            chain<String> thelist = head;
            do {
                System.out.println(thelist.info());
                thelist = thelist.before();
            } while (thelist.before() != head);
            System.out.println(thelist.info());
            
            System.out.print("\nWould you like to continue (y/n): ");
            again = scan.nextLine().toLowerCase().equals("y");
        } while (again);
    }
}

import java.util.*;

public class birthday
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        chain<String> head = null;
        String name = "";
        boolean again = false;
        
        while (!name.toLowerCase().equals("done")) {
            name = scan.nextLine();
            if (head != null) {
                chain<String> iterator = head;
                while (iterator.before() != null)
                    iterator = iterator.before();
                iterator.before(new chain<String>(name));
            } else
                head = new chain<String>(name);
        }
        
        do {
            System.out.println("\nWould you like to:");
            System.out.println("1. Add people to the list?");
            System.out.println("2. Remove people from the list?");
            System.out.println("3. Print the people in the list?");
            int choice = Integer.parseInt(scan.nextLine());
            
            switch (choice) {
                case 1:     System.out.print("\nWho would you like to add to the list: ");
                            String person = scan.nextLine();
                            chain<String> iterate = head;
                            while (!iterate.before().info().toLowerCase().equals("done"))
                                iterate = iterate.before();
                            iterate.before(new chain<String>(person));
                            iterate.before().before(new chain<String>("done"));
                            break;
                case 2:     System.out.print("\nWho would you like to remove from the list: ");
                            String del = scan.nextLine().toLowerCase();
                            chain<String> search = head;
                            while (!search.before().info().toLowerCase().equals(del))
                                search = search.before();
                            search.before(search.before().before());
                            break;
            }
            
            System.out.println("\nBirthday List:");
            chain<String> thelist = head;
            while (thelist.before() != null) {
                System.out.println(thelist.info());
                thelist = thelist.before();
            }
            
            System.out.print("\nWould you like to continue (y/n): ");
            again = scan.nextLine().toLowerCase().equals("y");
        } while (again);
    }
}

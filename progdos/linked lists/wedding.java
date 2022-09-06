import java.util.*;
import java.io.*;

public class wedding
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        chain<attendee> head = null;
        ArrayList<String> subcategories = new ArrayList<String>();
        String line = "";
        boolean again = false;
        
        try {
            FileReader filereader = new FileReader("files/WeddingList.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null) {
                String[] data = line.split("\t");
                if (head != null) {
                    chain<attendee> iterator = head;
                    while (iterator.before() != null && iterator.before().info().priority >= Integer.parseInt(data[3]))
                        iterator = iterator.before();
                    chain<attendee> next = iterator.before();
                    iterator.before(new chain<attendee>(new attendee(data[0].split(" "), Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]))));
                    iterator.before().after(iterator);
                    iterator.before().before(next);
                    if (next != null)
                        iterator.before().before().after(iterator.before());
                    if (subcategories.indexOf(iterator.before().info().relation) == -1)
                        subcategories.add(iterator.before().info().relation);
                } else {
                    head = new chain<attendee>(new attendee(data[0].split(" "), Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3])));
                    subcategories.add(head.info().relation);
                    head.after(head);
                }
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        do {
            System.out.println("\nWould you like to:");
            System.out.println("1. List and count attendees");
            System.out.println("2. Purge attendees");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scan.nextLine());
            
            switch (choice) {
                case 2:     System.out.println("\nWould you like to remove by:");
                            System.out.println("1. Priority");
                            System.out.println("2. Relationship and Priority");
                            System.out.print("Choice: ");
                            int decision = Integer.parseInt(scan.nextLine());
                            System.out.println("");
                            
                            switch (decision) {
                                case 2:     System.out.println("Select a relationship:");
                                            for (var y = 0; y < subcategories.size(); y += 1)
                                                System.out.println((y + 1) + ": " + subcategories.get(y));
                                            System.out.print("Choice: ");
                                            int rel = Integer.parseInt(scan.nextLine());
                                            System.out.print("What should the minimum priority allowed be: ");
                                            int pri = Integer.parseInt(scan.nextLine());
                                            boolean purged = false;
                                            do {
                                                chain<attendee> find = head;
                                                while (find.before() != null && (pri - 1 < find.before().info().priority || !find.before().info().relation.equals(subcategories.get(rel - 1))))
                                                    find = find.before();
                                                if (find.before() == null) {
                                                    purged = true;
                                                    break;
                                                } else {
                                                    find.before(find.before().before());
                                                    find.before().after(find);
                                                }
                                            } while (!purged);
                                            break;
                                default:    System.out.print("What should the minimum priority allowed be: ");
                                            int min = Integer.parseInt(scan.nextLine());
                                            chain<attendee> search = head;
                                            while (min - 1 < search.before().info().priority)
                                                search = search.before();
                                            search.before(null);
                                            break;
                            }
                            break;
            }
            
            System.out.println("\n---------------------------------------------------------------------------");
            System.out.println("                               Wedding List");
            System.out.println("Last, First\t\tInvited\t\tPriority\tRelationship");
            System.out.println("---------------------------------------------------------------------------");
            chain<attendee> wlist = head;
            int[] values = new int[subcategories.size() + 1];
            do {
                System.out.println(wlist.info());
                values[subcategories.indexOf(wlist.info().relation)] += 1;
                values[subcategories.size()] += (wlist.info().invited + 1);
                wlist = wlist.before();
            } while (wlist != null);
            System.out.println("\nAttendees: " + values[subcategories.size()]);
            for (int x = 0; x < subcategories.size(); x += 1)
                if (values[x] > 0)
                    System.out.println(subcategories.get(x) + ": " + values[x]);
            
            System.out.print("\nWould you like to continue (y/n): ");
            again = scan.nextLine().toLowerCase().equals("y");
        } while (again);
    }
}

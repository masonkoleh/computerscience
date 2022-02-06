import java.util.*;

public class namegender
{   
    public static void main(String[] args)
    {
        String person = "";
        Scanner scan = new Scanner(System.in);
        Queue<String> males = new LinkedList<>();
        Queue<String> females = new LinkedList<>();
        
        System.out.println("Enter Names and Genders");
        System.out.println("ex. m Mason\tf Avery");
        
        do {
            System.out.print("Input:\t");
            person = scan.nextLine();
            if (!person.toLowerCase().equals("x done")) {
                String[] human = person.split(" ");
                if (human[0].toLowerCase().equals("m")) males.add(human[1]);
                else females.add(human[1]);
            }
        } while (!person.toLowerCase().equals("x done"));
        
        System.out.println("\nMen:");
        while (males.size() > 0)
            System.out.println(males.remove());
        System.out.println("\nWomen:");
        while (females.size() > 0)
            System.out.println(females.remove());
    }
}

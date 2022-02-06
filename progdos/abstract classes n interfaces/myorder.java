import java.util.*;
import java.io.*;
import java.lang.Math;

public class myorder
{
    public static void main(String[] args)
    {
        photoprints prints = new photoprints(40);
        poster posters = new poster(1);
        tabletop tabletops = new tabletop("wood", 1);
        specialdeal deal = new specialdeal(prints, posters, tabletops);
        
        System.out.println("Your prints cost: " + prints.cost());
        System.out.println("Your poster cost: " + posters.cost());
        System.out.println("Your tabletop cost: " + tabletops.cost());
        System.out.println("");
        System.out.println("Subtotal: " + (prints.cost() + posters.cost() + tabletops.cost()));
        System.out.println("Special Deal: -$5.00");
        System.out.println("");
        System.out.println("Your total cost is: " + deal.cost());
    }
}

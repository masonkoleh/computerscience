import java.util.*;
public class EvenOdd
{
    public static void main(String[] args)
    {
        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();
        Queue<Integer> nums = new LinkedList<>();
        
        for (int x = 0; x < 50; x += 1)
            nums.add((int)(Math.random() * 100 + 1));
        
        while (nums.size() > 0) {
            int num = nums.remove();
            if (num % 2 > 0) odds.add(num);
            else evens.add(num);
        }
        
        System.out.println("Evens:");
        while (evens.size() > 0)
            System.out.print(evens.remove() + " ");
        System.out.println("\n");
        System.out.println("Odds:");
        while (odds.size() > 0)
            System.out.print(odds.remove() + " ");
    }
}
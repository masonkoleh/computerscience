import java.util.*;
import java.lang.Math;

public class mergesort
{
    public static String prompt(String question) {
        Scanner scan = new Scanner(System.in);
        System.out.print(question + ": ");
        String answer = scan.nextLine();
        return answer;
    }
    
    public static int[] generator(int min, int max, int amount) {
        int[] nums = new int[amount];
        ArrayList<Integer> used = new ArrayList<Integer>();
        for (int x = 0; x < amount; x += 1)
            nums[x] = (int)((Math.random() * max) + min);
        return nums;
    }
    
    public static void recur(int x, int y, int[] z) {
        if (y - x > 2) {
            int[][] indexes = {{x, (y + x) / 2}, {((y + x) / 2) + 1, y}};
            int limit = (y % 2 == 0) ? (y - 1) : ((y + x) / 2);
            recur(x, limit, z);
            if (y % 2 == 0) indexes = new int[][]{{x, (y - 1)}, {y, y}};
            else recur(((y + x) / 2) + 1, y, z);
            int[] merged = new int[(y - x) + 1];
            int[] tallys = new int[3];
            
            do {
                for (int o = 0; o < indexes.length; o += 1)
                    if (indexes[o][0] + tallys[o] > indexes[o][1]) {
                        int inverse = (o > 0) ? 0 : 1;
                        for (int v = tallys[inverse]; v < (indexes[inverse][1] - indexes[inverse][0]) + 1; v += 1, tallys[2] += 1)
                            merged[tallys[2]] = z[indexes[inverse][0] + v];
                    }
                    
                if (indexes[0][0] + tallys[0] <= indexes[0][1] && indexes[1][0] + tallys[1] <= indexes[1][1]) {
                    int[] comparison = {z[indexes[0][0] + tallys[0]], z[indexes[1][0] + tallys[1]]};                    
                    int de = (comparison[0] < comparison[1]) ? 0 : 1;
                    merged[tallys[2]] = comparison[de];
                    tallys[de] += 1;
                    tallys[2] += 1;
                }
            } while (tallys[2] < merged.length);
            
            for (int s = 0; s < merged.length; s += 1)
                z[x + s] = merged[s];
        } else if (y - x > 0) {
            int l = 0;
            do {
                for (l = 0; l < y - x; l += 1)
                    if (z[x + l] > z[x + l + 1]) {
                        int temp = z[x + l];
                        z[x + l] = z[x + l + 1];
                        z[x + l + 1] = temp;
                        break;
                    }
            } while (l < y - x);
        }
    }
    
    public static void main(String[] args)
    {
        String display = "";
        int min = 1, max = 25, amnt = 20;
        amnt = Integer.parseInt(prompt("How many numbers should I sort"));
        min = Integer.parseInt(prompt("What should the minimum value be"));
        max = Integer.parseInt(prompt("What should the maximum value be"));
        
        System.out.println("\nGenerating " + amnt + " Numbers....");
        int[] numbers = generator(min, max, amnt);
        int[] sorted = numbers.clone();
        
        System.out.println("Done.");
        System.out.println("Sorting...");
        recur(0, (amnt - 1), sorted);
        
        for (int s = 0; s < sorted.length; s += 1) {
            if (((display.length() + (String.valueOf(sorted[s]).length() + 1)) % 50) < (display.length() % 50))
                display += "\n";
            display += (sorted[s] + " ");
        }
        
        System.out.println("\nSorted:\n" + display);
    }
}
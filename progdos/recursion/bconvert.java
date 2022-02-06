import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class bconvert
{
    public static String recur(int num, int base)
    {
        String[] hexes = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        if (num == 0)
            return "";
        
        String n = String.valueOf(num % base);
        if ((num % base) - 10 >= 1)
            n = hexes[(num % base) - 10];
        return recur(num / base, base) + n;
    }

    public static void main (String[] args)
    {
        boolean continu = false;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Number (Base10):\t");
            int num = Integer.parseInt(scan.nextLine());
            System.out.print("Base:\t\t\t");
            int base = Integer.parseInt(scan.nextLine());
            
            String converted = recur(num, base);
            System.out.println("Result:\t\t\t" + converted);
            System.out.print("Continue? (y/n):\t");
            String answer = scan.nextLine();
            System.out.println("");
            
            if (answer.toUpperCase().equals("Y")) continu = true;
            else continu = false;
        } while (continu);
    }
}
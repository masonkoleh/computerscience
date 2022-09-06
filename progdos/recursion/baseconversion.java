import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class baseconversion
{
    public static int test(int num, int base)
    {
        int exponent = 0;
        double result = Math.pow(base, exponent);
        if (num > result)
            exponent = test(num, base, (exponent + 1));
        return exponent - 1;
    }
    
    public static int test(int num, int base, int exp)
    {
        int exponent = exp;
        double result = Math.pow(base, exponent);
        if (num > result)
            exponent = test(num, base, (exponent + 1));
        return exponent;
    }

    public static void main (String[] args)
    {
        String[] hexes = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Scanner scan = new Scanner(System.in);
        System.out.print("Number (Base10):\t");
        int num = Integer.parseInt(scan.nextLine());
        System.out.print("Base:\t\t\t");
        int base = Integer.parseInt(scan.nextLine());
        
        String converted = "";
        for (int x = test(num, base); x >= 0; x -= 1) {
            int point = (int)(num / Math.pow(base, x));
            num %= Math.pow(base, x);
            String value = (point - 10 >= 0) ? hexes[point - 10] : String.valueOf(point);
            converted += value;
        }
        
        System.out.println("Result:\t\t\t" + converted);
    }
}
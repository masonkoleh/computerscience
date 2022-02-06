import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class palindromes
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input String: ");
        String input = scan.nextLine();
        input = input.replaceAll("\\W", "");
        String palindrome = "";
        
        for (int x = input.length() - 1; x >= 0; x -= 1)
            palindrome += input.split("")[x];
            
        if (input.equalsIgnoreCase(palindrome)) System.out.println("It is a palindrome!");
        else System.out.println("It's not a palindrome.");
    }
}

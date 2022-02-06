import java.util.*;
import java.io.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class codechecker
{
    public static int calc(int a) {
        if (a > 9)
            return calc(a / 10) + (a % 10);
        return a;
    }
    
    public static void main (String[] args)
    {   
        String line = "";
        ArrayList<String> serials = new ArrayList<String>();
        try {
            FileReader filereader = new FileReader("files/SerialNumbers.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null)
                if (serials.indexOf(line) == -1)
                    serials.add(line);
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        try {
            FileWriter filewriter = new FileWriter("files/output.txt");
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            for (String num : serials) {
                String[] number = num.split("");
                int beginner = Integer.parseInt(number[0]);

                int divisor = 0;
                try {
                    divisor = Integer.parseInt(number[beginner - 1]);
                } catch (ArrayIndexOutOfBoundsException error) {
                    continue;
                }

                if (divisor != 0)
                    if (calc(Integer.parseInt(num)) % divisor == 0)
                        bufferedwriter.write(num + "\n");
            }
            
            bufferedwriter.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
    }
}
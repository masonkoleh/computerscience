import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

class customer
{
    public String name;
    public int position, time, served, waited;
    
    public customer(String name, int pos, int time) {
        this.name = name;
        this.position = pos;
        this.time = time;
    }
    
    public int served(int serv) {
        this.served = serv;
        this.waited = this.served - this.time;
        return this.waited;
    }
    
    public String toString() {
        String padded = this.name;
        int spaces = (4 * 2) - padded.length();
        for (int y = 0; y < spaces; y += 1)
            padded += " ";
        return padded + "\t" + this.position + "\t" + this.time + "\t" + this.served + "\t" + this.waited;
    }
}


public class butchershop
{
    public static void main(String[] args)
    {
        customer[] queue = new customer[100];
        ArrayList<Integer> waited = new ArrayList<>();
        Queue<customer> satisfied = new LinkedList<>();
        DecimalFormat rounding = new DecimalFormat("00.000");
        int back = 0, pos = 1, ticker = 0;
        
        System.out.println("Service Log:");
        try {
            FileReader filereader = new FileReader("files/Shop.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufferedreader.readLine()) != null) {
                String[] data = line.split("\t");
                if (!data[0].toLowerCase().equals("next"))
                    if (back < 99) {
                        queue[(queue[back] != null) ? back + 1 : back] = new customer(data[0], pos, Integer.parseInt(data[1]));
                        System.out.println(data[0] + " has entered the line.");
                        if (ticker < 100) ticker += 1;
                        else {
                            ticker = 1;
                            System.out.println("The ticker needs new numbers!");
                        }
                        if (queue[1] != null) back += 1;
                        if (pos < 100) pos += 1;
                        else pos = 1;
                    } else System.out.println("The line is at maximum capacity!");
                else {
                    if (queue[0] != null) {
                        int thewait = queue[0].served(Integer.parseInt(data[1]));
                        System.out.println(queue[0].name + " was served in " + thewait);
                        waited.add(thewait);
                        satisfied.add(queue[0]);
                        for (int i = 0; i < queue.length && queue[i] != null; i += 1)
                            if (i + 1 < queue.length) queue[i] = queue[i + 1];
                        if (back != 0) back -= 1;
                    } else System.out.println("Nobody is in line!");
                }
                if (back > 8) System.out.println("Call for Backup!");
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        double comb = 0;
        int longest = 0;
        for (int w : waited) {
            longest = (w > longest) ? w : longest;
            comb += w;
        }
        comb /= waited.size();
        
        System.out.println("\nEnd of Day Report:");
        System.out.println("Avg. Wait Time: " + rounding.format(comb));
        System.out.println("Longest Wait Time: " + longest);
        System.out.println("Customer Log:");
        System.out.println("Name\t\tTicket\tArrived\tServed\tWait");
        while (satisfied.size() > 0)
            System.out.println(satisfied.remove());
    }
}
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

class car {
    public int customer, num;
    public int position, time, served, waited;
    
    public car(int cust, int num, int time) {
        this.customer = cust;
        this.num = num;
        this.time = time;
    }
    
    public int served(int serv) {
        this.served = serv;
        this.waited = this.served - this.time;
        return this.waited;
    }
    
    public String toString() {
        return this.customer + "\t" + this.num + "\t" + this.time + "\t" + this.served + "\t" + this.waited;
    }
}


public class cardealers
{
    public static int[] intify(String[] strings) {
        int[] converted = new int[strings.length];
        for (int x = 0; x < strings.length; x += 1)
            converted[x] = Integer.parseInt(strings[x]);
        return converted;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Queue> queues = new ArrayList<>(Arrays.asList(new LinkedList<>(), new LinkedList<>(), new LinkedList<>()));
        ArrayList<Integer> waited = new ArrayList<>();
        Queue<car> fixed = new LinkedList<>();
        DecimalFormat rounding = new DecimalFormat("00.000");
        int back = 0, pos = 1;
        
        try {
            FileReader filereader = new FileReader("files/Customers.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufferedreader.readLine()) != null) {
                String[] data = line.split("\t");
                if (!data[0].toLowerCase().equals("customer number")) {
                    int[] intsnow = intify(data);
                    
                    int randint = (int)(Math.random() * 3);
                    queues.get(randint).add(new car(intsnow[0], intsnow[1], intsnow[2]));
                    for (Queue queue : queues)
                        while (queue.size() > 0) System.out.println(queue.remove());
                }
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        /*
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
        while (fixed.size() > 0)
            System.out.println(fixed.remove());
        */
    }
}
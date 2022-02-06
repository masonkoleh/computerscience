import java.util.*;
import java.io.*;
import java.lang.Math;

public class sortstats
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] indexes = {"NAME", "TEAM", "POS", "G", "AB", "R", "H", "DB", "TR", "HR", "RBI", "BB", "K", "SB", "AVG", "OBP", "SLG", "OPS"};
        ArrayList<statsplayer> players = new ArrayList<statsplayer>();
        try {
            FileReader filereader = new FileReader("files/stats18.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufferedreader.readLine()) != null) {
                String[] data = line.split("\t");
                if (!data[0].equals("Player"))
                    players.add(new statsplayer(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]), Integer.parseInt(data[12]), Integer.parseInt(data[13])));
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        String[][] allplayers = new String[players.size()][indexes.length];
        for (int x = 0; x < allplayers.length; x += 1)
            for (int y = 0; y < allplayers[x].length; y += 1)
                allplayers[x][y] = players.get(x).getinfo(y);
        
        System.out.print("What stats would you like to see:\t");
        String stat = scan.nextLine().toUpperCase();
        
        int selected = 0;
        for (selected = 0; selected < indexes.length; selected += 1)
            if (indexes[selected].equals(stat))
                break;
        
        String[][] sorted = allplayers.clone();
        for (int x = 0; x < sorted.length - 1; x += 1)
            if (selected < 18) {
                if (Double.parseDouble(sorted[x][selected]) < Double.parseDouble(sorted[x + 1][selected])) {
                    String[] temp = sorted[x];
                    sorted[x] = sorted[x + 1];
                    sorted[x + 1] = temp;
                    x = -1;
                }
            } else {
                if (sorted[x][0].compareTo(sorted[x + 1][0]) > 0) {
                    String[] temp = sorted[x];
                    sorted[x] = sorted[x + 1];
                    sorted[x + 1] = temp;
                    x = -1;
                }
            }

        System.out.print("How many stats would you like to see:\t");
        int amount = 0;
        try {
            amount = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException error) {
            amount = sorted.length;
        }
        
        String item = "";
        System.out.print("Would you like to filter by Nothing (0), Team (1), or Position (2):\t");
        int choice = Integer.parseInt(scan.nextLine());
        if (choice > 0) {
            System.out.print("What " + indexes[choice].toLowerCase() + " do you want to filter by:\t");
            item = scan.nextLine().toUpperCase();
        }
    
        String legend = "\nName\t\tTeam\tPOS\t";
        if (selected < 18)
            legend += indexes[selected];
        else
            for (int m = 3; m < indexes.length; m += 1)
                legend += indexes[m] + "\t";
        System.out.println(legend);
        
        int count = 0;
        for (int z = 0; z < sorted.length; z += 1)
            if (count < amount) {
                String padded = sorted[z][0];
                int spaces = 8 - sorted[z][0].length();
                int tabs = 0;
                if (spaces >= 1)
                    tabs = ((int)(spaces / 8) >= 1) ? 2 : 1;
                for (int a = 0; a < tabs; a += 1)
                    padded += "\t";
                if (choice > 0) {
                    if (sorted[z][choice].equals(item))
                        System.out.println(padded + "\t" + sorted[z][1] + "\t" + sorted[z][2] + "\t" + sorted[z][selected]);
                } else if (selected > 17) {
                    String result = padded + "\t";
                    for (int v = 1; v < sorted[z].length; v += 1)
                        result += sorted[z][v] + "\t";
                    System.out.println(result);
                } else {
                    System.out.println(padded + "\t" + sorted[z][1] + "\t" + sorted[z][2] + "\t" + sorted[z][selected]);
                }
                count += 1;
            }
    }
}
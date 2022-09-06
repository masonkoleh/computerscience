import java.util.*;
import java.io.*;
import java.lang.Math;

public class baseball
{
    public static void main (String[] args)
    {
        String line = "";
        ArrayList<player> players = new ArrayList<player>();
        try {
            FileReader filereader = new FileReader("files/Stats2018.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null) {
                String[] data = line.split("\t");
                if (!data[0].equals("Player")) {
                    /*
                     * final int sb = (data[13] != null) ? Integer.parseInt(data[13]) : 0;
                     * players.add(new player(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]), Integer.parseInt(data[12]), sb));
                     */
                    players.add(new player(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]), Integer.parseInt(data[12]), Integer.parseInt(data[13])));
                }
            }
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        try {
            FileWriter filewriter = new FileWriter("files/statoutput.txt");
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            bufferedwriter.write("Player  \tTeam\tPos\tG\tAB\tR\tH\tDB\tTR\tHR\tRBI\tBB\tK\tSB\tAVG\tOBP\tSLG\tOPS\n");
            for (player x : players)
                bufferedwriter.write(x + "\n");
            bufferedwriter.close();
        } catch(IOException error) {
            System.out.println(error);
        }
    }
}
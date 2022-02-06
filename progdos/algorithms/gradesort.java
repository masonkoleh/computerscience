import java.util.*;
import java.io.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class gradesort
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> files = new ArrayList<String>();
        String[] grades = {"A", "B", "C", "D", "F"};
        DecimalFormat rounding = new DecimalFormat("00.000");
        String file = "";
        
        try {
            FileReader filereader = new FileReader("files/Classes.txt");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((file = bufferedreader.readLine()) != null)
                files.add(file);
            bufferedreader.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
        
        ArrayList<studnt> classes = new ArrayList<studnt>();
        ArrayList<double[][]> periods = new ArrayList<double[][]>();
        ArrayList<ArrayList> groups = new ArrayList<ArrayList>();
        double[][] school = new double[5][3];
        
        double[] avg = new double[files.size() + 1];
        String line = "";
        
        for (String a : files) {
            try {
                int count = 0;
                FileReader filereader = new FileReader("files/" + a);
                BufferedReader bufferedreader = new BufferedReader(filereader);
                while ((line = bufferedreader.readLine()) != null) {
                    String[] data = line.split("\t");
                    if (!data[0].equals("Name")) {
                        count += 1;
                        try {
                            classes.add(new studnt(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                        } catch (ArrayIndexOutOfBoundsException error) {
                            classes.add(new studnt(data[0], 0, Integer.parseInt(data[2])));
                        } catch (NumberFormatException error) {
                            classes.add(new studnt(data[0], 0, Integer.parseInt(data[2])));
                        }
                    }
                }
                bufferedreader.close();
              
                if (count > 0) {
                    periods.add(new double[5][3]);
                    ArrayList<studnt> tmp = new ArrayList<studnt>();
                    groups.add(tmp);
                }
            } catch (FileNotFoundException error) {
                System.out.println(error);
            } catch (IOException error) {
                System.out.println(error);
            }
        }
        
        for (studnt x : classes)
            groups.get(x.period - 1).add(x);
        
        try {
            System.out.print("Would you like to sort students by name (0) or by score (1): ");
            boolean score = (Integer.parseInt(scan.nextLine()) != 0);
            String sortmethod = (score) ? "scores" : "names";
            System.out.print("Would you like to sort the entire schools' " + sortmethod + " (0)\nor individual periods' " + sortmethod + " (1): ");
            boolean range = (Integer.parseInt(scan.nextLine()) == 0);
            
            if (range) {
                for (int o = 0; o < (classes.size() - 1); o += 1) {
                    boolean abc123 = (score) ? (classes.get(o).getGrade() < classes.get(o + 1).getGrade()) : (classes.get(o).getName().compareTo(classes.get(o + 1).getName()) > 0);
                    if (abc123) {
                        studnt tmp = classes.get(o);
                        classes.set(o, classes.get(o + 1));
                        classes.set(o + 1, tmp);
                        o = -1;
                    }
                }
            } else {
                for (int o = 0; o < groups.size(); o += 1)
                    for (int q = 0; q < (groups.get(o).size() - 1); q += 1) {
                        ArrayList<studnt> p = (ArrayList)groups.get(o);
                        boolean abc123 = (score) ? (p.get(q).grade < p.get(q + 1).grade) : (p.get(q).name.compareTo(p.get(q + 1).name) > 0);
                        if (abc123) {
                            studnt tmp = p.get(q);
                            p.set(q, p.get(q + 1));
                            p.set(q + 1, tmp);
                            q = -1;
                        }
                    }
            }
            
            int[] mode = new int[102];
            if (range) {
                for (studnt j : classes) {
                    mode[j.grade] += 1;
                    System.out.println(j);
                }
                for (int x = 0; x < mode.length - 1; x += 1)
                    if (mode[x] > mode[mode[101]])
                        mode[101] = x;
                
                String result = mode[101] + "%";
                if (mode[mode[101]] < 2)
                    for (int c = 0; c < mode.length - 1; c += 1)
                        if (mode[c] > 0 && c != mode[101]) result += " and " + c + "%";
                System.out.println("Mode: " + result);
            } else {
                for (int z = 0; z < groups.size(); z += 1) {
                    ArrayList<studnt> a = groups.get(z);
                    System.out.println("\nPeriod " + (z + 1) + ":");
                    for (studnt b : a) {
                        mode[b.grade] += 1;
                        System.out.println(b);
                    }
                    for (int x = 0; x < mode.length - 1; x += 1)
                        if (mode[x] > mode[mode[101]])
                            mode[101] = x;
                    
                    String result = mode[101] + "%";
                    if (mode[mode[101]] < 2)
                        for (int c = 0; c < mode.length - 1; c += 1)
                            if (mode[c] > 0 && c != mode[101]) result += " " + c + "%";
                    System.out.println("Mode: " + result);
                    mode = new int[102];
                }
            }
            
            
            
            
            
            /*
            bufferedwriter.write("Name\t\tGrade\tPeriod\tLetter Grade\n");
            for (studnt b : classes)
                bufferedwriter.write(b + "\n");
            
            for (studnt c : classes)
                for (int d = 0; d < periods.size(); d += 1)
                    if (c.getPeriod() == (d + 1)) {
                        avg[d] += c.getGrade();
                        for (int e = 0; e < grades.length; e += 1) {
                            periods.get(d)[e][0] += 1;
                            if (c.letterGrade(c.getGrade()).equals(grades[e]))
                                periods.get(d)[e][1] += 1;
                        }
                    }
            
            for (double[][] f : periods)
                for (double[] g : f)
                    g[2] = (g[1] / g[0]) * 100;
            
            // Write Information
            for (int i = 0; i < periods.size(); i += 1) {
                bufferedwriter.write("\nPeriod " + (i + 1) + "\n");
                bufferedwriter.write(" - Average: " + rounding.format(avg[i] / periods.get(i)[0][0]) + "%\n");
                bufferedwriter.write(" - Grade Distribution\n");
                for (int j = 0; j < periods.get(i).length; j += 1) {
                    bufferedwriter.write("\t - " + grades[j] + "'s\n");
                    bufferedwriter.write("\t\tPercentage: " + rounding.format(periods.get(i)[j][2]) + "%\n");
                    bufferedwriter.write("\t\tStudents: " + (int)periods.get(i)[j][1] + "\n");
                }
            }
            
            for (studnt k : classes) {
                avg[files.size()] += (k.getGrade() / (double)classes.size());
                for (int l = 0; l < grades.length; l += 1) {
                    school[l][0] += 1;
                    if (k.letterGrade(k.getGrade()).equals(grades[l]))
                        school[l][1] += 1;
                }
            }
            
            for (double[] m : school)
                m[2] = (m[1] / m[0]) * 100;
            
            bufferedwriter.write("\nTotal\n");
            bufferedwriter.write(" - Average: " + rounding.format(avg[files.size()]) + "%\n");
            bufferedwriter.write(" - Grade Distribution\n");
            for (int n = 0; n < grades.length; n += 1) {
                bufferedwriter.write("\t - " + grades[n] + "'s\n");
                bufferedwriter.write("\t\tPercentage: " + rounding.format(school[n][2]) + "%\n");
                bufferedwriter.write("\t\tStudents: " + (int)school[n][1] + "\n");
            }
            
            bufferedwriter.close();
            */
        } catch(IndexOutOfBoundsException error) {
            System.out.println(error);
        }
    }
}

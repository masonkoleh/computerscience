import java.util.*;
import java.io.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class gradefile
{
    public static void main (String[] args)
    {
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
        
        ArrayList<students> classes = new ArrayList<students>();
        ArrayList<double[][]> periods = new ArrayList<double[][]>();
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
                            classes.add(new students(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                        } catch (ArrayIndexOutOfBoundsException error) {
                            classes.add(new students(data[0], 0, Integer.parseInt(data[2])));
                        } catch (NumberFormatException error) {
                            classes.add(new students(data[0], 0, Integer.parseInt(data[2])));
                        }
                    }
                }
                bufferedreader.close();
                
                if (count >= 1)
                    periods.add(new double[5][3]);
            } catch (FileNotFoundException error) {
                System.out.println(error);
            } catch (IOException error) {
                System.out.println(error);
            }
        }        
        
        try {
            FileWriter filewriter = new FileWriter("files/output.txt");
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            
            bufferedwriter.write("Name\t\tGrade\tPeriod\tLetter Grade\n");
            for (students b : classes)
                bufferedwriter.write(b + "\n");
            
            for (students c : classes)
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
                
            for (int h = 0; h < periods.size(); h += 1) {
                bufferedwriter.write("\nPeriod " + (h + 1) + "\n");
                bufferedwriter.write(" - Average: " + rounding.format(avg[h] / periods.get(h)[0][0]) + "%\n");
                bufferedwriter.write(" - Grade Distribution\n");
                for (int i = 0; i < periods.get(h).length; i += 1) {
                    bufferedwriter.write("\t - " + grades[i] + "'s\n");
                    bufferedwriter.write("\t\tPercentage: " + rounding.format(periods.get(h)[i][2]) + "%\n");
                    bufferedwriter.write("\t\tStudents: " + (int)periods.get(h)[i][1] + "\n");
                }
            }
            
            for (students j : classes) {
                avg[files.size()] += (j.getGrade() / (double)classes.size());
                for (int k = 0; k < grades.length; k += 1) {
                    school[k][0] += 1;
                    if (j.letterGrade(j.getGrade()).equals(grades[k]))
                        school[k][1] += 1;
                }
            }
            
            for (double[] l : school)
                l[2] = (l[1] / l[0]) * 100;
            
            bufferedwriter.write("\nTotal\n");
            bufferedwriter.write(" - Average: " + rounding.format(avg[files.size()]) + "%\n");
            bufferedwriter.write(" - Grade Distribution\n");
            for (int m = 0; m < grades.length; m += 1) {
                bufferedwriter.write("\t - " + grades[m] + "'s\n");
                bufferedwriter.write("\t\tPercentage: " + rounding.format(school[m][2]) + "%\n");
                bufferedwriter.write("\t\tStudents: " + (int)school[m][1] + "\n");
            }
            
            bufferedwriter.close();
        } catch(IOException error) {
            System.out.println(error);
        }
    }
}
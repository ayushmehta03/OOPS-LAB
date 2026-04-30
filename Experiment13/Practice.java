package Experiment13;
import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));
            bw.write("Ayush,1,90\nRam,2,85\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                System.out.println("Name: " + s[0] + " Roll: " + s[1] + " Marks: " + s[2]);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"));
            bw.write("ERROR\nINFO\nWARNING\nERROR\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("log.txt"));
            int e = 0, w = 0, i = 0;
            String l;
            while ((l = br.readLine()) != null) {
                if (l.equals("ERROR")) e++;
                else if (l.equals("WARNING")) w++;
                else if (l.equals("INFO")) i++;
            }
            System.out.println("ERROR:" + e + " WARNING:" + w + " INFO:" + i);
            br.close();
        } catch (Exception ex) {}

        try {
            FileInputStream in = new FileInputStream("students.txt");
            FileOutputStream out = new FileOutputStream("copy.txt");
            int c;
            while ((c = in.read()) != -1) out.write(c);
            in.close();
            out.close();
        } catch (Exception ex) {}

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            int lines = 0, words = 0, chars = 0;
            String l;
            while ((l = br.readLine()) != null) {
                lines++;
                words += l.split("\\s+").length;
                chars += l.length();
            }
            System.out.println("Lines:" + lines + " Words:" + words + " Chars:" + chars);
            br.close();
        } catch (Exception ex) {}

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("employee.txt", true));
            bw.write("Emp1,50000\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
            String l;
            while ((l = br.readLine()) != null) System.out.println(l);
            br.close();
        } catch (Exception ex) {}

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("enc.txt"));
            int c;
            while ((c = br.read()) != -1) bw.write(c + 2);
            br.close();
            bw.close();

            BufferedReader br2 = new BufferedReader(new FileReader("enc.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("dec.txt"));
            while ((c = br2.read()) != -1) bw2.write(c - 2);
            br2.close();
            bw2.close();
        } catch (Exception ex) {}

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"));
            bw.write("Name,Age\nAyush,21\nRam,22\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            String l;
            while ((l = br.readLine()) != null) {
                String[] s = l.split(",");
                System.out.println(Arrays.toString(s));
            }
            br.close();
        } catch (Exception ex) {}

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String word = "Ayush";
            String l;
            int lineNo = 1;
            while ((l = br.readLine()) != null) {
                if (l.contains(word)) {
                    System.out.println("Found at line " + lineNo + ": " + l);
                }
                lineNo++;
            }
            br.close();
        } catch (Exception ex) {}

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("append.txt", true));
            bw.write("New Data\n");
            bw.close();
        } catch (Exception ex) {}

        try {
            FileOutputStream fos = new FileOutputStream("bin.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(100);
            dos.writeInt(200);
            dos.close();

            DataInputStream dis = new DataInputStream(new FileInputStream("bin.dat"));
            System.out.println(dis.readInt());
            System.out.println(dis.readInt());
            dis.close();
        } catch (Exception ex) {}
    }
}
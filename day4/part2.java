package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class part2 {
    
    public static void part1(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        int overlap = 0;

        String sects = "";
        while ((sects = br.readLine()) != null) {
            String[] pairs = sects.split(",");
            String[] range1 = pairs[0].split("-");
            String[] range2 = pairs[1].split("-");
            int min1 = Integer.parseInt(range1[0]);
            int max1 = Integer.parseInt(range1[1]);
            int min2 = Integer.parseInt(range2[0]);
            int max2 = Integer.parseInt(range2[1]);

            if ((min2 > max1) || (min1 > max2)) {
            } else {
                overlap++;
            }
        }

        System.out.println(overlap);
    }

    public static void main(String[] args) throws IOException {
        part1("day4/sections.txt");
    }
}

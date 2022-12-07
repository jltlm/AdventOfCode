package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class fsjdlkfjdklsj {
    // time to make a helper
    public static void readFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        br.close();
    }

    public static void AHHH(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        int index = 0;
        boolean breaks = true;
        while (breaks) {
            HashSet<Character> ch = new HashSet<>();
            for (int i = 0; i < 14; i++) {
                ch.add(line.charAt(index + i));
            }

            breaks = false;

            if (ch.size() < 14) {
                breaks = true;
            }
            index++;
        }
        System.out.println(index + 13);

        br.close();
    }

    public static void part1(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        int index = 0;

        boolean breaks = true;
        while (breaks) {
            ArrayList<Character> ch = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                ch.add(line.charAt(index + i));
            }

            breaks = false;

            for (int i = 0; i < ch.size(); i++) {
                ArrayList<Character> copy = (ArrayList<Character>) ch.clone();
                copy.remove(i);
                if (copy.contains(ch.get(i))) {
                    breaks = true;
                }
            }
            index++;
        }

        System.out.println(index + 13);

        br.close();
    }

    public static void part2(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        int index = 0;
        char c1;
        char c2;
        char c3;
        char c4;
        boolean breaks = true;
        while (breaks) {
            c1 = line.charAt(index);
            c2 = line.charAt(index + 1);
            c3 = line.charAt(index + 2);
            c4 = line.charAt(index + 3);

            if (c1 != c2
                    && c2 != c3
                    && c3 != c4
                    && c1 != c4
                    && c1 != c3
                    && c2 != c4) {
                System.out.println("" + c1 + c2 + c3 + c4 + " ");
                breaks = false;
            }
            index++;
        }
        System.out.println(index + 3);

        br.close();
    }

    public static void main(String[] args) throws IOException {
        AHHH("day6/input.txt");
    }
}

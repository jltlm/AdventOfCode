package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bleh {

    public static void part1(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        int psum = 0;

        String bag = "";
        while ((bag = br.readLine()) != null) {
            String one = bag.substring(0, bag.length() / 2);
            String two = bag.substring(bag.length() / 2, bag.length());

            char p = 'd';
            for (int j = 0; j < one.length(); j++) {
                for (int i = 0; i < one.length(); i++) {
                    if (two.charAt(i) == one.charAt(j)) {
                        p = one.charAt(j);
                        break;
                    }
                }
            }

            int priority = 0;
            if (Character.isLowerCase(p)) {
                priority = p - 96;
            } else {
                priority = p - 65 + 27;
            }
            psum += priority;
        }
        System.out.println(psum);
        br.close();
    }

    public static void part2(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        int psum = 0;

        String bag = "";
        while ((bag = br.readLine()) != null) {
            String one = bag;
            bag = br.readLine();
            String two = bag;
            bag = br.readLine();
            String three = bag;

            char p = 'a';

            for (int j = 0; j < one.length(); j++) {
                for (int k = 0; k < three.length(); k++) {
                    for (int i = 0; i < two.length(); i++) {
                        if (two.charAt(i) == one.charAt(j)
                        && one.charAt(j) == three.charAt(k)) {
                            if (p != one.charAt(j)) {
                                System.out.println(one.charAt(j));
                            }
                            p = one.charAt(j);
                            // break;
                        }
                    }
                }
            }
            System.out.println(p);

            int priority = 0;
            if (Character.isLowerCase(p)) {
                priority = p - 96;
            } else {
                priority = p - 65 + 27;
            }
            psum += priority;
        }
        System.out.println(psum);
        br.close();

    }

    public static void main(String[] args) throws IOException {
        // part1("day3/bag.txt");
        part2("day3/bag.txt");
    }

}

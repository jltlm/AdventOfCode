package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Brainrotx2 {

    public static void suffer(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        ArrayList<Knot> knots = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Knot knot = new Knot(i);
            knots.add(knot);
        }

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            String direction = parts[0];
            int spaces = Integer.parseInt(parts[1]);
            for (int i = 0; i < spaces; i++) {
                for (int j = 0; j < 10; j++) {
                    Knot head = knots.get(j);
                    if (j != 0) {
                        head = knots.get(j-1);
                    }
                    Knot tail = knots.get(j);
                    if (direction.equals("U")) {
                        if (j == 0) {
                            head.move(0, 1);
                            knots.set(j, head);
                        } else {
                            tail.move(head.getX(), head.getY(), 2);
                            knots.set(j, tail);
                        }
                    } else if (direction.equals("L")) {
                        if (j == 0) {
                            head.move(-1, 0);
                        } else {
                            tail.move(head.getX(), head.getY(), 2);
                        }
                    } else if (direction.equals("D")) {
                        if (j == 0) {
                            head.move(0, -1);
                        } else {
                            tail.move(head.getX(), head.getY(), 2);
                        }
                    } else if (direction.equals("R")) {
                        if (j == 0) {
                            head.move(1, 0);
                        } else {
                            tail.move(head.getX(), head.getY(), 2);
                        }
                    }
                }
                // System.out.println(direction + "  " + knots.get(0).toString()
                // + "\t\t" + knots.get(1).toString()
                // + "\t\t" + knots.get(2).toString());
                set.add(knots.get(9).toString());
                set2.add(knots.get(1).toString());
            }
        }
        System.out.println(set.size());
        System.out.println(set2.size());

        br.close(); 
    }

    public static void main(String[] args) throws IOException {
        suffer("day9/shinunogaewa.txt");
    }

}

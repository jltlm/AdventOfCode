package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class IWannaDance {

    // part 1
    public static void suffer1(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        int sum = 0;
        int cycle = 1;
        int x = 1;

        String line = "";
        while ((line = br.readLine()) != null) {
            int sigStrength = 0;
            String[] parts = line.split(" ");
            if (parts[0].equals("noop")) {
                if (cycle % 40 - 20 == 0) {
                    sigStrength = x * cycle;
                    sum += sigStrength;
                    System.out.println(sigStrength + " " + cycle);
                }
                cycle += 1;
            } else {
                int v = Integer.parseInt(parts[1]);
                for (int i = cycle; i < cycle + 2; i++) {
                    if (i % 40 - 20 == 0) {
                        sigStrength = x * i;
                        sum += sigStrength;
                        System.out.println(sigStrength + " " + i);
                    }
                }
                cycle += 2;
                x += v;
            }
        }
        System.out.println(sum);
        br.close();
    }

    // part 2
    public static void suffer(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        int cycle = 0;
        int x = 1;
        String screen = "";
        HashMap<Integer, Integer> sprite = new HashMap<>();

        String line = "";
        while ((line = br.readLine()) != null) {
            sprite.put(0, x - 1);
            sprite.put(1, x);
            sprite.put(2, x + 1);
            String[] parts = line.split(" ");
            if (parts[0].equals("noop")) {
                if (sprite.containsValue(cycle)) {
                    screen += "#";
                } else {
                    screen += ".";
                }
                cycle += 1;
                if (cycle == 40) {
                    cycle = 0;
                    System.out.println(screen);
                    screen = "";
                }
            } else {
                int v = Integer.parseInt(parts[1]);
                for (int k = 0; k < 2; k++) {
                    if (sprite.containsValue(cycle)) {
                        screen += "#";
                    } else {
                        screen += ".";
                    }
                    cycle++;
                    if (cycle == 40) {
                        cycle = 0;
                        System.out.println(screen);
                        screen = "";
                    }
                }
                x += v;
            }
        }
        br.close();

    }

    public static void main(String[] args) throws IOException {
        suffer("day10/booya.txt");
    }

}

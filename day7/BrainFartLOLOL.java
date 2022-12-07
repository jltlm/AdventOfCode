package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BrainFartLOLOL {

    public static void AHHH(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line = "";

        HashMap<String, Integer> map = new HashMap<>();

        String currDir = " ";
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");

            // commands
            if (split[0].equals("$")) {
                if (split[1].equals("cd") && split[2].equals("..")) {
                    String[] copy = currDir.split(" ");
                    String copyDir = " ";
                    for (int i = 0; i < copy.length - 1; i++) {
                        copyDir += " " + copy[i];
                    }
                    currDir = copyDir.strip();
                } else if (split[1].equals("cd")) {
                    currDir += " " + split[2];
                    currDir = currDir.strip();
                    map.put(currDir, 0);
                } else if (split[1].equals("cd") && split[2].equals("/")) {
                    currDir = "/";
                }
            
            // file size
            } else if (!split[0].equals("dir")) {
                int memSpace = map.get(currDir) + Integer.parseInt(split[0]);
                map.put(currDir, memSpace);

                // adds file sizes to all containing directories
                String[] copy = currDir.split(" ");
                String copyDir = " ";
                for (int i = 0; i < copy.length - 1; i++) {
                    copyDir += " " + copy[i];
                    copyDir = copyDir.strip();
                    memSpace = map.get(copyDir) + Integer.parseInt(split[0]);
                    map.put(copyDir, memSpace);
                }

            }
        }
        System.out.println(map.get("/"));
        // int sum = 0;
        int min = 0;
        for (int i : map.values()) {
            if (i >= 5349983) {
                // sum += i;
                if (i < min || min == 0) {
                    min = i;
                }
            }
        }
        for (String i : map.keySet()) {
            if (map.get(i) == min) {
                System.out.println(min);
                System.out.println(i);
            }
        }

        System.out.println(min);

        br.close();
    }

    public static void main(String[] args) throws IOException {
        AHHH("day7/input.txt");
    }
}

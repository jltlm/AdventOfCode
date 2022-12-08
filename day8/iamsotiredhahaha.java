package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class iamsotiredhahaha {

    public static void quasont(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                row.add((int) line.charAt(i) - 48);
            }

            grid.add(row);
        }

        int topScore = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(row).size(); col++) {
                if (col > 0 && col < grid.get(row).size() - 1 && row > 0 && row < grid.size() - 1) {
                    int thisScore = 1;
                    boolean big = true;
                    for (int left = col - 1; left > 0 && big; left--) {
                        if (grid.get(row).get(left) >= grid.get(row).get(col)) {
                            // System.out.print(col - left + " ");
                            thisScore *= col - left;
                            big = false;
                        }
                    }
                    if (big) {
                        thisScore *= col;
                        // System.out.print(col + " ");
                    }
                    big = true;

                    for (int right = col + 1; right < grid.get(row).size() - 1 && big; right++) {
                        if (grid.get(row).get(right) >= grid.get(row).get(col)) {
                            thisScore *= right - col;
                            big = false;
                            // System.out.print(right - col + " ");
                        }
                    }
                    if (big) {
                        thisScore *= grid.get(row).size() - 1 - col;
                        // System.out.print(grid.get(row).size() - 1 - col + " ");
                    }
                    big = true;

                    for (int up = row - 1; up > 0 && big; up--) {
                        if (grid.get(up).get(col) >= grid.get(row).get(col)) {
                            thisScore *= row - up;
                            big = false;
                            // System.out.print(row - up + " ");
                        }
                    }
                    if (big) {
                        thisScore *= row;
                        // System.out.print(row + " ");
                    }
                    big = true;

                    for (int down = row + 1; down < grid.size() - 1 && big; down++) {
                        if (grid.get(down).get(col) >= grid.get(row).get(col)) {
                            thisScore *= down - row;
                            // System.out.print(down - row + " ");
                            big = false;
                        }
                    }
                    if (big) {
                        thisScore *= grid.size() - 1 - row;
                        // System.out.print(grid.size() - 1 - row + " ");
                    }
                    big = true;

                    // System.out.println(" this " + thisScore + " -- ");
                    if (topScore == 0 || thisScore > topScore) {
                        topScore = thisScore;
                    }
                }

            }
        }

        System.out.println(topScore);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        quasont("day8/wevemetbeforebutnicetomeetyou.txt");
    }
}

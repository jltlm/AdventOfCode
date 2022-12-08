package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class helloitssogoodtoseeyou {

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

        HashSet<String> visible = new HashSet<>();

        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(row).size(); col++) {

                boolean isVisible = true;

                if (col > 0 && col < grid.get(row).size() - 1 && row > 0 && row < grid.size() - 1) {
                    for (int left = 0; left < col && isVisible; left++) {
                        if (grid.get(row).get(left) >= grid.get(row).get(col)) {
                            isVisible = false;
                        }
                    }
                    if (isVisible) {
                        visible.add(row + " " + col);
                    } else {
                        isVisible = true;
                    }
                    for (int right = grid.get(row).size() - 1; right > col && isVisible; right--) {
                        if (grid.get(row).get(right) >= grid.get(row).get(col)) {
                            isVisible = false;
                        }
                    }
                    if (isVisible) {
                        visible.add(row + " " + col);
                    } else {
                        isVisible = true;
                    }
                    for (int up = 0; up < row && isVisible; up++) {
                        if (grid.get(up).get(col) >= grid.get(row).get(col)) {
                            isVisible = false;
                        }
                    }
                    if (isVisible) {
                        visible.add(row + " " + col);
                    } else {
                        isVisible = true;
                    }
                    for (int down = grid.size() - 1; down > row && isVisible; down--) {
                        if (grid.get(down).get(col) >= grid.get(row).get(col)) {
                            isVisible = false;
                        }
                    }

                }
                if (isVisible) {
                    visible.add(row + " " + col);
                }

            }
        }

        System.out.println(topScore);

        // System.out.println(visible.size());

        br.close();
    }

    public static void main(String[] args) throws IOException {
        quasont("day8/wevemetbeforebutnicetomeetyou.txt");
    }
}

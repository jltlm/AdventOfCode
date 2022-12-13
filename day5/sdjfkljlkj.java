package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class sdjfkljlkj {
    public static void part1(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<ArrayList<String>> stacks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            stacks.add(new ArrayList<String>());
            // 9 stacks created
        }

        String line = "";
        ArrayList<ArrayList<String>> rows = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            // 8 rows
            line = br.readLine();
            ArrayList<String> parts = new ArrayList<>();
            int index = 0;
            while (index < 8) {
                String add = line.substring(4*index, 4 + 4*index);
                parts.add(add);
                index++;
            }
            String add = line.substring(4*index, line.length());
            parts.add(add);
            rows.add(parts);
        }

        for (int j = 0; j < 9; j++) {
            ArrayList<String> stack = stacks.get(j);
            for (int i = 7; i >= 0; i--) {
                // put into stack
                ArrayList<String> row = rows.get(i);
                if (row.get(j).strip() != "") {
                    stack.add(row.get(j));
                }
            }
        }
        br.readLine();
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            int howmany = Integer.parseInt(split[1]);
            int start = Integer.parseInt(split[3]);
            int end = Integer.parseInt(split[5]);

        // // part 1
        //     for (int i = 0; i < howmany; i++) {
        //         ArrayList<String> arrayStart = stacks.get(start - 1);
        //         ArrayList<String> arrayEnd = stacks.get(end - 1);
        //         arrayEnd.add(arrayStart.remove(arrayStart.size() - 1));
        //     }
        // }

        ArrayList<String> arrayStart = stacks.get(start - 1);
        ArrayList<String> arrayEnd = stacks.get(end - 1);
        int index = arrayStart.size() - (howmany);
        for (int i = 0; i < howmany; i++) {
                arrayEnd.add(arrayStart.remove(index));
            }
        }

        for (int i = 0; i < stacks.size(); i++) {
            ArrayList<String> stack = stacks.get(i);
            System.out.print(stack.get(stack.size()-1));
        }
        br.close();

    }

    public static void main(String[] args) throws IOException {
        part1("day5/b.txt");
    }
}

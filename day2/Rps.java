package day2;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Rps {
    
    public static void score(String filename) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int pts = 0;
        String row = "";
        while((row = br.readLine()) != null) {
            String[] go = row.split(" ");

            Hashtable<String, Integer> win = new Hashtable<>();
            win.put("A", 2);
            win.put("B", 3);
            win.put("C", 1);

            Hashtable<String, Integer> tie = new Hashtable<>();
            tie.put("A", 1);
            tie.put("B", 2);
            tie.put("C", 3);

            Hashtable<String, Integer> lose = new Hashtable<>();
            lose.put("A", 3);
            lose.put("B", 1);
            lose.put("C", 2);

            if (go[1].equals("X")) {
                pts += lose.get(go[0]);
            } else if (go[1].equals("Y")) {
                pts += 3;
                pts += tie.get(go[0]);
            } else if (go[1].equals("Z")) {
                pts += 6;
                pts += win.get(go[0]);
            }


            // pts += win.get(go[0]);

            // if (go[0].equals("A")) {
            //     if (go[1].equals("X")) {
            //         pts += 3;
            //         System.out.println("draw");
            //     } else if (go[1].equals("Y")) {
            //         pts += 6;
            //         System.out.println("win");
            //     }
            // } else if (go[0].equals("B")) {
            //     if (go[1].equals("Y")) {
            //         pts += 3;
            //         System.out.println("draw");
            //     } else if (go[1].equals("Z")) {
            //         System.out.println("win");
            //         pts += 6;
            //     }
            // } else {
            //     if (go[1].equals("Z")) {
            //         pts += 3;
            //         System.out.println("draw");
            //     } else if (go[1].equals("X")) {
            //         System.out.println("win");
            //         pts += 6;
            //     }
            // }
        }

        br.close();
        System.out.println(pts);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        score("day2/strats.txt");
    }
}

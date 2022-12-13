package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Brainrot {

    public static void suffer(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        HashSet<String> set = new HashSet<>();
        int[][] knots = new int[10][];
        for (int i = 0; i < 10; i++) {
            int[] knot = new int[] { 0, 0 };
            knots[i] = knot;
        }
        set.add(knots[0][0] + " " + knots[0][1]);

        String line = "";
        while ((line = br.readLine()) != null) {
            int[] tcoord;
            int[] hcoord;

            String[] parts = line.split(" ");
            int spaces = Integer.parseInt(parts[1]);
            for (int i = 0; i < spaces; i++) {
                for (int j = 1; j < 10; j++) {
                    tcoord = knots[j];
                    hcoord = knots[j - 1];

                    if (parts[0].equals("U")) {
                        if (j == 1) {
                            hcoord = new int[] { hcoord[0], (hcoord[1] + 1) };
                        }

                        // check diagonals
                        if (Math.abs((hcoord[1] - tcoord[1])) > 1) {
                            if ((hcoord[0] - tcoord[0]) != 0) {
                                tcoord[0] = hcoord[0];
                            }
                            tcoord[1] += 1;
                        }
                        if (Math.abs((hcoord[0] - tcoord[0])) > 1) {
                            if ((hcoord[1] - tcoord[1]) != 0) {
                                tcoord[1] = hcoord[1];
                            }
                            if ((hcoord[0] - tcoord[0]) > 1) {
                                tcoord[0] += 1;
                            } else {
                                tcoord[0] -= 1;
                            }
                        }

                    } else if (parts[0].equals("L")) {
                        if (j == 1) {
                            hcoord = new int[] { (hcoord[0] - 1), hcoord[1] };
                        }
                        if (Math.abs((hcoord[0] - tcoord[0])) > 1) {
                            if ((hcoord[1] - tcoord[1]) != 0) {
                                tcoord[1] = hcoord[1];
                            }
                            tcoord[0] -= 1;
                        }
                        if (Math.abs((hcoord[1] - tcoord[1])) > 1) {
                            if ((hcoord[0] - tcoord[0]) != 0) {
                                tcoord[0] = hcoord[0];
                            }
                            if ((hcoord[1] - tcoord[1]) > 1) {
                                tcoord[1] += 1;
                            } else {
                                tcoord[1] -= 1;
                            }
                        }

                    } else if (parts[0].equals("D")) {
                        if (j == 1) {
                            hcoord = new int[] { hcoord[0], (hcoord[1] - 1) };
                        }
                        if (Math.abs((hcoord[1] - tcoord[1])) > 1) {
                            if ((hcoord[0] - tcoord[0]) != 0) {
                                tcoord[0] = hcoord[0];
                            }
                            tcoord[1] -= 1;
                        }
                        if (Math.abs((hcoord[0] - tcoord[0])) > 1) {
                            if ((hcoord[1] - tcoord[1]) != 0) {
                                tcoord[1] = hcoord[1];
                            }
                            if ((hcoord[0] - tcoord[0]) > 1) {
                                tcoord[0] += 1;
                            } else {
                                tcoord[0] -= 1;
                            }
                        }

                    } else if (parts[0].equals("R")) {
                        if (j == 1) {
                            hcoord = new int[] { (hcoord[0] + 1), hcoord[1] };
                        }
                        if (Math.abs((hcoord[0] - tcoord[0])) > 1) {
                            if ((hcoord[1] - tcoord[1]) != 0) {
                                tcoord[1] = hcoord[1];
                            }
                            tcoord[0] += 1;

                        }
                        if (Math.abs((hcoord[1] - tcoord[1])) > 1) {
                            if ((hcoord[0] - tcoord[0]) != 0) {
                                tcoord[0] = hcoord[0];
                            }
                            if ((hcoord[1] - tcoord[1]) > 1) {
                                tcoord[1] += 1;
                            } else {
                                tcoord[1] -= 1;
                            }
                        }
                    }
                    knots[j - 1] = hcoord;
                    knots[j] = tcoord;
                }
                set.add(knots[9][0] + " " + knots[9][1]);

            }
        }
        System.out.println(set.size());
        br.close();
    }

    public static void main(String[] args) throws IOException {
        suffer("day9/shinunogaewa.txt");
    }

}

package day1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Calories {

    public static void count (String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Integer> highests = new ArrayList<>();
        int highestCal = 0;
        int currentCal = 0;
        String cal = "";
        while((cal = br.readLine()) != null) {
            if (cal.isEmpty()) {
                if (currentCal > highestCal) {
                    highestCal = currentCal;
                }
                highests.add(currentCal);
                currentCal = 0;
            } else {
                currentCal += Integer.parseInt(cal);
            }
        }

        br.close();

        Collections.sort(highests);
        System.out.println(highests);
    }

    public static void main(String[] args) throws IOException {
        count("day1/fruit.txt");
    }

}
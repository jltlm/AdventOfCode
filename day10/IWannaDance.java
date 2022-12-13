package day10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IWannaDance {

    public static void suffer(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        br.close();
    }

    public static void main(String[] args) throws IOException {
        suffer("day10/booya.txt");
    }

}

package implementation.p10951;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10951/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            Add.add(line);
        }
    }
}

class Add {

    public static void add(String line) {
        String[] data = line.split(" ");
        add(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public static void add(int a, int b) {
        System.out.println(a + b);
    }
}

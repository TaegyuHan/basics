package implementation.p10951;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10951/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            Calculator.add(line);
        }
    }
}

class Calculator {

    public static void add(String line) {
        StringTokenizer st = new StringTokenizer(line);
        add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    public static void add(int a, int b) {
        System.out.println(a + b);
    }
}

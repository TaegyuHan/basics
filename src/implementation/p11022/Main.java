package implementation.p11022;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p11022/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= inputCount; i++) {
            Add.add(i, br.readLine());
        }
    }
}

class Add {

    public static void add(int index, String data) {
        String[] tmp = data.split(" ");
        add(index, Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }

    public static void add(int index, int a, int b) {
        System.out.println("Case #" + index + ": " + a + " + " + b + " = " + (a + b));
    }
}

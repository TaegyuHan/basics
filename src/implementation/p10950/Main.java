package implementation.p10950;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10950/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputCount; i++) {
            System.out.println(Add.add(br.readLine().split(" ")));
        }
    }
}

class Add {

    public static int add(String[] data) {
        return add(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
package implementation.p11720;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p11720/data/2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());
        if (inputCount != 0) {
            Sum.sum(br.readLine());
        }
    }
}

class Sum {
    public static void sum(String line) {
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            sum += Character.getNumericValue(c);
        }
        System.out.print(sum);
    }
}

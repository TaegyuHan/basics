package implementation.p2675;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2675/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputCount; i++) {
            StringRepeat.repeat(br.readLine());
        }
    }
}

class StringRepeat {
    public static void repeat(String line) {
        String[] data = line.split(" ");
        repeat(Integer.parseInt(data[0]), data[1]);
    }

    public static void repeat(int n, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(String.valueOf(str.charAt(i)).repeat(Math.max(0, n)));
        }
        System.out.println(sb);
    }
}
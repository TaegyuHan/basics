package implementation.p11021;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p11021/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());

        Add add = new Add();
        for (int i = 1; i <= inputCount; i++) {
            add.add(i, br.readLine());
        }
    }
}

class Add {

    public Add() {
    }

    public void add(int idx, String datas) {
        String[] data = datas.split(" ");
        add(idx, Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public void add(int idx, int a, int b) {
        System.out.println("Case #" + idx + ": " + (a + b));
    }
}

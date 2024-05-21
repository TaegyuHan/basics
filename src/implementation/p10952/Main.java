package implementation.p10952;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10952/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = br.readLine().split(" ");
            if (!Add.addCheck(data)) {
                break;
            }
            System.out.println(Add.add(data));
        }
    }
}

class Add {
    public Add() {}

    public static boolean addCheck(String[] data) {
        return (Integer.parseInt(data[0]) != 0)
                && (Integer.parseInt(data[1]) != 0);
    }

    public static int add(String[] data) {
        return add(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
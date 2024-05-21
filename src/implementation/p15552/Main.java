package implementation.p15552;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p15552/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Add add = new Add();
        for (int i = 0; i < N; i++) {
            add.add(br.readLine());
        }
        
        add.answer();
    }
}

class Add {
    private final StringBuilder sb;

    Add() {
        this.sb = new StringBuilder();
    }

    public void add(String stringData) {
        String[] data = stringData.split(" ");
        add(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public void add(int a, int b) {
        sb.append(a + b).append("\n");
    }

    public void answer() {
        System.out.println(sb);
    }
}
package implementation.p8393;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p8393/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        SumCalculator sc = new SumCalculator(n);
        System.out.print(sc.sum());
    }
}

class SumCalculator {

    private final int n;

    public SumCalculator(int n) {
        this.n = n;
    }

    public int sum() {
        return n * (n + 1) / 2;
    }
}

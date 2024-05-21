package implementation.p10818;

import implementation.Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10818/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        MinMaxFinder mmf = new MinMaxFinder();
        for (int i = 0; i < inputCount; i++) {
            int value = Integer.parseInt(st.nextToken());
            mmf.addValue(value);
        }
        mmf.show();
    }
}

class MinMaxFinder {

    private int min, max;

    public MinMaxFinder() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void addValue(int value) {
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    public void show() {
        System.out.print(min + " " + max);
    }
}

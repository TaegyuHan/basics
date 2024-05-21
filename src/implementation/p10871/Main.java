package implementation.p10871;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10871/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int inputCount = Integer.parseInt(input[0]);
        int value = Integer.parseInt(input[1]);
        SmallerNumberFinder finder = new SmallerNumberFinder(value);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            finder.check(num);
        }

        finder.answer();
    }
}

class SmallerNumberFinder {

    private final StringBuilder sb = new StringBuilder();
    private final int minNumber;

    public SmallerNumberFinder(int minNumber) {
        this.minNumber = minNumber;
    }

    public void check(int number) {
        assert 1 <= number && number <= 10_000;
        if (number < minNumber) {
            sb.append(number).append(" ");
        }
    }

    public void answer() {
        System.out.print(sb);
    }
}

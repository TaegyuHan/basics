package implementation.p2577;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2577/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NumberCount nc = new NumberCount(
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine())
        );

        nc.calculation();
        nc.answer();
    }
}

class NumberCount {
    private final int A;
    private final int B;
    private final int C;
    private final int[] numberCheckBox;

    NumberCount(int a, int b, int c) {
        assert 100 <= a && a <= 1_000;
        assert 100 <= b && b <= 1_000;
        assert 100 <= c && c <= 1_000;
        A = a;
        B = b;
        C = c;
        numberCheckBox = new int[10];
        Arrays.fill(numberCheckBox, 0);
    }

    public void calculation() {
        String multi = String.valueOf(A * B * C);
        for (int i = 0; i < multi.length(); i++) {
            int number = Character.getNumericValue(multi.charAt(i));
            numberCheckBox[number]++;
        }
    }

    public void answer() {
        for (int checkBox : numberCheckBox) {
            System.out.println(checkBox);
        }
    }
}

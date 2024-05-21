package implementation.p2480;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2480/data/3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ThreeDice.answer(br.readLine());
    }
}

class ThreeDice {

    public static void answer(String line) {
        String[] data = line.split(" ");
        answer(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }

    public static void answer(int a, int b, int c) {
        // 같은 눈이 3개가 나온 경우
        if (a == b && b == c) {
            System.out.print(10_000 + (a * 1_000));
            return;
        }
        // 모두 다른 눈이 나오는 경우
        if (a != b && a != c && b != c) {
            int max = Math.max(a, Math.max(b, c));
            System.out.print(max * 100);
            return;
        }
        // 같은 눈이 2개만 나오는 경우
        int tmp;
        if (a == b || a == c) {
            tmp = a;
        }
        else {
            tmp = b;
        }
        System.out.print(1_000 + (tmp * 100));
    }
}

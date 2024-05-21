package implementation.p2439;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2439/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Star star = new Star(N);
        star.show();
    }
}

class Star {
    private final int x;

    public Star(int x) {
        this.x = x;
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= x; i++) {
            sb.append(" ".repeat(Math.max(0, x - i)));
            sb.append("*".repeat(Math.max(0, i)));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

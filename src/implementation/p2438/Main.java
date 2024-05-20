package implementation.p2438;

import implementation.Implementation;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2438/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Star star = new Star(br.readLine());
        star.show();

    }
}

class Star {

    private final int NUM;

    public Star(String num) {
        NUM = Integer.parseInt(num);
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= NUM; i++) {
            sb.append("*".repeat(Math.max(0, i)));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

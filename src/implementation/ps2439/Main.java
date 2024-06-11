package implementation.ps2439;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p15552/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Star star = Star.of(br.readLine());
        star.answer();
    }
}

class Star {
    private final int size;
    private StringBuilder sb;

    Star(int size) {
        this.size = size;
        this.sb = new StringBuilder();
        build();
    }

    public static Star of(String line) {
        return Star.of(Integer.parseInt(line));
    }

    public static Star of(int size) {
        return new Star(size);
    }

    private void build() {
        for (int i = 1; i <= size; i++) {
            sb.append(" ".repeat(size - i));
            sb.append("*".repeat(i));
            sb.append("\n");
        }
    }

    public void answer() {
        System.out.println(sb);
    }
}
package implementation.p10987;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10987/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Count count = new Count(br.readLine());
        count.calculate();
        count.answer();
    }
}


class Count {
    private String line;
    private int count;

    Count(String line) {
        this.line = line;
    }

    public void calculate() {
        for (char c : line.toCharArray()) {
            switch (c) {
                case 'a': {
                    ++count;
                    break;
                }
                case 'e': {
                    ++count;
                    break;
                }
                case 'i': {
                    ++count;
                    break;
                }
                case 'o': {
                    ++count;
                    break;
                }
                case 'u': {
                    ++count;
                    break;
                }
            }
        }
    }

    public void answer() {
        System.out.println(count);
    }
}

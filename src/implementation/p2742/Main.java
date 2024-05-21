package implementation.p2742;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2742/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ForLoop fl = new ForLoop(br.readLine());
        fl.answer();
    }
}

class ForLoop {

    private final int N;

    ForLoop(String input) {
        N = Integer.parseInt(input);
    }

    public void answer() {
        for (int i = N; 0 < i; --i) {
            System.out.println(i);
        }
    }
}

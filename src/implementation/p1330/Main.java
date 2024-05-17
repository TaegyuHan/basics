package implementation.p1330;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1330/data/3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        Comparison c = new Comparison(data);
        c.check();
    }
}


class Comparison {

    private final int A;
    private final int B;

    public Comparison(String[] data) {
        this.A = Integer.parseInt(data[0]);
        this.B = Integer.parseInt(data[1]);
    }

    public void check() {
        if (A < B) {
            System.out.println("<");
        }
        else if (A > B) {
            System.out.println(">");
        }
        else { // =
            System.out.println("==");
        }
    }
}
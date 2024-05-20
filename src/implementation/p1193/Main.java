package implementation.p1193;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1193/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        Fountain f = new Fountain(X);
        f.find();
    }
}

class Fountain {
    private int X;

    public Fountain(int X) {
        this.X = X;
    }

    public void find() {

        int num = 1;
        while (X > num) {
            X -= num;
            num += 1;
        }

        int numerator, denominator;
        if (num % 2 == 0) {
            numerator = X;
            denominator = num - X + 1;
        } else {
            numerator = num - X + 1;
            denominator = X;
        }

        System.out.println(numerator + "/" + denominator);
    }
}

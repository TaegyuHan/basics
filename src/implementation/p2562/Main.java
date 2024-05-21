package implementation.p2562;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2562/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Max max = new Max();
        for (int i = 1; i <= 9; ++i) {
            max.setMax(i, br.readLine());
        }
        max.answer();
    }
}

class Max {
    private int max;
    private int maxIndex;

    public Max() {
        this.max = Integer.MIN_VALUE;
        this.maxIndex = -1;
    }

    public void setMax(int index, String data) {
        setMax(index, Integer.parseInt(data));
    }

    public void setMax(int index, int value) {
        if (value > max) {
            max = value;
            maxIndex = index;
        }
    }

    public void answer() {
        System.out.println(max);
        System.out.print(maxIndex);
    }
}

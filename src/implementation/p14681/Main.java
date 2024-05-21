package implementation.p14681;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p14681/data/2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        Quadrant q = new Quadrant(x, y);
        q.show();
    }
}

class Quadrant {

    private final int x, y;

    public Quadrant(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void show() {
        if (x < 0) {
            if (y < 0) {
                System.out.println(3);
            }
            else if (y > 0) {
                System.out.println(2);
            }
        }
        else if (x > 0) {
            if (y < 0) {
                System.out.println(4);
            }
            else if (y > 0) {
                System.out.println(1);
            }
        }
    }
}

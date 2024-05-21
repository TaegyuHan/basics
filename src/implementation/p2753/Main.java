package implementation.p2753;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2753/data/2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int y = Integer.parseInt(br.readLine());
        Year year = new Year(y);
        year.leapYearCheck();
    }
}

class Year {
    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public void leapYearCheck() {
        // 400의 배수일때
        if (year % 400 == 0) {
            System.out.println(1);
            return;
        }

        // 4의 배수이면서, 100의 배수가 아닐때
        if ((year % 4 == 0) && (year % 100 != 0)) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }
}

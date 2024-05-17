package implementation.p9498;

import implementation.Implementation;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p9498/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        GradeCalculator gc = new GradeCalculator(Integer.parseInt(br.readLine()));
        char answer = gc.calculateGrade();
        System.out.println(answer);
    }
}

class GradeCalculator {

    private final int point;

    public GradeCalculator(int point) {
        this.point = point;
    }

    public char calculateGrade() {
        if (90 <= point && point <= 100) {
            return 'A';
        }
        else if (80 <= point && point <= 89) {
            return 'B';
        }
        else if (70 <= point && point <= 79) {
            return 'C';
        }
        else if (60 <= point && point <= 69) {
            return 'D';
        }
        else {
            return 'F';
        }
    }
}
package implementation.p25206;

import implementation.Implementation;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p25206/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Test test = new Test();
        for (int i = 0; i < Test.TEST_COUNT; ++i) {
            test.addTest(br.readLine());
        }
        test.answer();
    }
}

enum PointTable {
    AP("A+", 4.5),
    AO("A0", 4.0),
    BP("B+", 3.5),
    BO("B0", 3.0),
    CP("C+", 2.5),
    CO("C0", 2.0),
    DP("D+", 1.5),
    DO("D0", 1.0),
    FO("F", 0.0);

    private String rating;
    private double point;

    PointTable(String rating, double point) {
        this.rating = rating;
        this.point = point;
    }

    public String getRating() {
        return this.rating;
    }

    public double getPoint() {
        return this.point;
    }
}

class Test {
    public static final int TEST_COUNT = 20;
    private double total;
    private int gradeTotal;

    Test() {
        this.gradeTotal = 0;
    }

    public void addTest(String line) {
        String[] data = line.trim().split(" ");
        addTest(data[0], Double.parseDouble(data[1]), data[2]);
    }

    public void addTest(String subject, double grade, String rating) {
        if ("P".equalsIgnoreCase(rating)) {
            return;
        }

        double ratingPoint = 0.0;
        for (PointTable pointTable : PointTable.values()) {
            if (pointTable.getRating().equals(rating)) {
                ratingPoint = pointTable.getPoint();
                break;
            }
        }
        gradeTotal += grade;
        total += grade * ratingPoint;
    }

    public void answer() {
        System.out.printf("%.4f", total / gradeTotal);
    }
}
package implementation.p5800;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p5800/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCount; i++) {
            ClassRoom cr = ClassRoom.of(i, br.readLine());
            cr.statistics();
            cr.answer();
        }
    }
}

class ClassRoom {
    private final int classNumber;
    private int[] points;
    private int maxTmp;

    ClassRoom(int classNumber, int size, int[] points) {
        this.classNumber = classNumber ;
        this.points = points;
        this.maxTmp = Integer.MIN_VALUE;
    }

    public static ClassRoom of(int index, String line) {
        String[] data = line.split(" ");

        int[] points = new int[data.length - 1];
        for (int i = 1; i < data.length; i++) {
            points[i - 1] = Integer.parseInt(data[i]);
        }

        return new ClassRoom(index, Integer.parseInt(data[0]), points);
    }

    public void statistics() {
        Arrays.sort(points);
        for (int i = 1; i < points.length; i++) {
            maxTmp = Math.max(maxTmp, points[i] - points[i - 1]);
        }
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class ").append(classNumber).append("\n");
        sb.append("Max ").append(points[points.length - 1]).append(", ");
        sb.append("Min ").append(points[0]).append(", ");
        sb.append("Largest gap ").append(maxTmp);
        System.out.println(sb);
    }
}

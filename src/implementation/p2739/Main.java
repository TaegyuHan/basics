package implementation.p2739;

import implementation.Implementation;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2739/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        MultiplicationTable mt = new MultiplicationTable(N);
        mt.answer();
    }
}


class MultiplicationTable {

    private final int multiNumber;

    public MultiplicationTable(int n) {
        this.multiNumber = n;
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        int MAX_NUMBER = 9;
        for (int i = 1; i <= MAX_NUMBER; i++) {
            sb.append(multiNumber).append(" * ").append(i).append(" = ").append((multiNumber * i)).append("\n");
        }
        System.out.print(sb);
    }
}
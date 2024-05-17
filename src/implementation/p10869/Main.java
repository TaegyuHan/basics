package implementation.p10869;

import implementation.Implementation;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10869/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        BasicArithmetic ba = new BasicArithmetic(data);
        ba.cmdAll();
    }
}

class BasicArithmetic {

    private final int A;
    private final int B;

    public BasicArithmetic(String[] data) {
        A = Integer.parseInt(data[0]);
        B = Integer.parseInt(data[1]);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int mod(int a, int b) {
        return a % b;
    }

    public void cmdAll() {
        System.out.println(add(A, B));
        System.out.println(sub(A, B));
        System.out.println(mul(A, B));
        System.out.println(div(A, B));
        System.out.print(mod(A, B));
    }
}
package implementation.p10430;

import implementation.Implementation;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10430/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Remainder remainder = new Remainder(br.readLine());
        remainder.answer();
    }
}

class Remainder {

    private final int A;
    private final int B;
    private final int C;

    public Remainder(String br) {
        String[] data = br.split(" ");
        A = Integer.parseInt(data[0]);
        B = Integer.parseInt(data[1]);
        C = Integer.parseInt(data[2]);
    }

    public void answer() {
        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
    }
}

package implementation.p11654;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p11654/data/2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ASCIICode asciiCode = new ASCIICode(br.readLine());
        asciiCode.intCode();
    }
}

class ASCIICode {
    private final char c;

    ASCIICode(String data) {
        c = data.charAt(0);
    }

    public void intCode() {
        System.out.println((int) c);
    }
}

package implementation.p2741;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2741/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ShowNumber sn = new ShowNumber(br.readLine());
        sn.show();
    }
}

class ShowNumber {

    private final int N;

    public ShowNumber(String data) {
        this.N = Integer.parseInt(data);
    }

    public void show() {
        for (int i = 1; i <= N; ++i) {
            System.out.println(i);
        }
    }
}

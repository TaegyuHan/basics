package implementation.p1110;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1110/data/5.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AddCycle ac = new AddCycle(br.readLine());
        ac.answer();
    }
}

class AddCycle {
    private final int startNumber;
    private int cycleCount;

    AddCycle(String line) {
        this.startNumber = Integer.parseInt(line);
    }

    public void cycle(int num) {

        ++cycleCount;

        String strNumber;
        // 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고,
        if (num < 10) {
            strNumber = "0" + num;
        } else {
            strNumber = String.valueOf(num);
        }

        // 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다.
        int frontNumber = Character.getNumericValue(strNumber.charAt(0));
        int backNumber = Character.getNumericValue(strNumber.charAt(1));

        String tmp = String.valueOf(frontNumber + backNumber);
        int nextNumber = Integer.parseInt(Integer.toString(backNumber) + tmp.charAt(tmp.length() - 1));

        if (nextNumber == startNumber) {
            return;
        }

        cycle(nextNumber);
    }

    public void answer() {
        cycle(startNumber);
        System.out.println(cycleCount);
    }
}

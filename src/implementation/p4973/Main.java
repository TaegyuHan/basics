package implementation.p4973;

import java.util.Arrays;


/**
 * URL : <a href="https://www.acmicpc.net/problem/4673">문제 Link</a> <br>
 * 문제명 : 셀프 넘버
 * <p>
 * BigO : O(4N) <br>
 * 문제의 내용 : 브루트포스 알고리즘 문제 입니다. D()함수를 구현하여 for문으로 적용가능한 곳을 찾는 것이 중점입니다.
 * <p>
 * 입력 <br>
 */
public class Main {

    public static void main(String[] args) {
        SelfNumber sn = new SelfNumber();
        sn.answer();
    }
}

class SelfNumber {

    private final int MAX_NUMBER = 10_000;
    private final boolean[] check = new boolean[MAX_NUMBER + 1];

    SelfNumber () {
        Arrays.fill(check, false);  // O(N)
        checkNumber();
    }

    private int d(int n) {
        int nextNumber = n;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) { // O(N)
            nextNumber += (s.charAt(i) - '0');
        }
        return nextNumber;
    }

    private void checkNumber() {
        for (int i = 0; i < MAX_NUMBER; i++) { // O(N)
            int checkIdx = d(i);
            if (checkIdx < MAX_NUMBER) {
                check[checkIdx] = true;
            }
        }
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < MAX_NUMBER; ++i) { // O(N)
            if (check[i]) { continue; }
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}

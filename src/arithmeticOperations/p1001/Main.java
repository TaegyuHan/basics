package arithmeticOperations.p1001;

import arithmeticOperations.ArithmeticOperations;

import java.io.*;

/**
 * URL : <a href="https://www.acmicpc.net/problem/1001">문제 Link</a> <br>
 * 문제명 : A - B
 * <p>
 * BigO : O(3) <br>
 * 문제의 내용 : 사칙연산 문제 2개의 정수를 받아서 빼기를 실시한 정수를 출력한다.<br><br>
 *
 * 입력 <br>
 *      0 <= A <= 10<br>
 *      0 <= B <= 10<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream( ArithmeticOperations.PATH + "/p1001/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        System.out.println(Integer.parseInt(data[0]) - Integer.parseInt(data[1]));
    }
}

package arithmeticOperations.p10998;

import arithmeticOperations.ArithmeticOperations;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * URL : <a href="https://www.acmicpc.net/problem/10998">문제 Link</a> <br>
 * 문제명 : A X B
 * <p>
 * BigO : O(3) <br>
 * 문제의 내용 : 두개의 정수를 곱하여 결과를 출력하는 문제<br><br>
 *
 * 입력 <br>
 *      0 <= A <= 10<br>
 *      0 <= B <= 10<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream( ArithmeticOperations.PATH + "/p10998/data/2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        System.out.println(Integer.parseInt(data[0]) * Integer.parseInt(data[1]));
    }
}

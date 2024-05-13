package implementation.p1000;

import implementation.Implementation;

import java.io.*;

/**
 * URL : <a href="https://www.acmicpc.net/problem/1000">문제 Link</a> <br>
 * 문제명 : A + B
 * <p>
 * BigO : O(3) <br>
 * 문제의 내용 : 백준의 입력을 받아보는 문제<br><br>
 *
 * 입력 <br>
 *      0 <= A <= 10<br>
 *      0 <= B <= 10<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream( Implementation.PATH + "/p1000/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        System.out.println(Integer.parseInt(data[0]) + Integer.parseInt(data[1]));
    }
}

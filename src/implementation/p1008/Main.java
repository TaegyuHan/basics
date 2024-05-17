package implementation.p1008;

import implementation.Implementation;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1008/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = br.readLine().split(" ");

        BigDecimal dividend = new BigDecimal(numbers[0]);
        BigDecimal divisor = new BigDecimal(numbers[1]);

        BigDecimal result = dividend.divide(divisor, 32, RoundingMode.HALF_UP);
        System.out.println(result);
    }
}
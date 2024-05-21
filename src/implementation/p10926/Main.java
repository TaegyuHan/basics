package implementation.p10926;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10926/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        UniqueIdValidator.isUnique(br.readLine());
    }
}

class UniqueIdValidator {
    public static void isUnique(String id) {
        System.out.println(id + "??!");
    }
}

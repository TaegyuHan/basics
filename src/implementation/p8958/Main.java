package implementation.p8958;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p8958/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            OXQuiz.answer(br.readLine());
        }
    }
}

class OXQuiz {
    public static void answer(String data) {
        int totalPoints = 0;
        int points = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == 'X') {
                points = 0;
                continue;
            }
            ++points;
            totalPoints += points;
        }
        System.out.println(totalPoints);
    }
}

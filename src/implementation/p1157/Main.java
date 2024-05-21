package implementation.p1157;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1157/data/4.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        WordStudy ws = new WordStudy(br.readLine());
        ws.check();
        ws.answer();
    }
}

class WordStudy {

    private final int[] alphabetCheck;
    private final String word;

    WordStudy(String word) {
        this.word = word;
        this.alphabetCheck = new int[26];
        Arrays.fill(alphabetCheck, 0);
    }

    public void answer() {
        int maxsize = 0;
        int index = 0;
        boolean questionMark = true;
        for (int i = 0; i < alphabetCheck.length; i++) {
            // 더 많은 단어가 존재할 경우
            if (alphabetCheck[i] > maxsize) {
                maxsize = alphabetCheck[i];
                index = i;
                questionMark = false;
                continue;
            }

            // 같은 단어가 발견된 경우
            if (alphabetCheck[i] == maxsize) {
                questionMark = true;
            }
        }

        if (questionMark) {
            System.out.println("?");
        }
        else {
            System.out.println((char) Character.toUpperCase('a' + index));
        }
    }

    public void check() {
        for (int i = 0; i < word.length(); i++) {
            int index = Character.toLowerCase(word.charAt(i)) - 'a';
            ++alphabetCheck[index];
        }
    }
}
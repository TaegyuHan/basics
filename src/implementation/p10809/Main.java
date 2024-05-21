package implementation.p10809;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p10809/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FindAlphabet fa = new FindAlphabet(br.readLine());
        fa.check();
        fa.answer();
    }
}

class FindAlphabet {
    private final int[] alphabetCheckBox;
    private final String word;

    FindAlphabet(String word) {
        this.word = word;
        this.alphabetCheckBox = new int[26];
        Arrays.fill(alphabetCheckBox, -1);
    }

    public void check() {
        for (int i = 0; i < word.length(); i++) {
            int checkBoxIndex = word.charAt(i) - 'a';
            if (alphabetCheckBox[checkBoxIndex] == -1) {
                alphabetCheckBox[checkBoxIndex] = i;
            }
        }
    }

    public void answer() {
        for (int checkBox : alphabetCheckBox) {
            System.out.print(checkBox + " ");
        }
    }
}

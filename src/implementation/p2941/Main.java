package implementation.p2941;

import implementation.Implementation;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2941/data/5.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        CroatiaAlphabet ca = new CroatiaAlphabet(word);
        ca.count();
        ca.answer();
    }
}

class CroatiaAlphabet {
    private final String word;
    private int count = 0;

    CroatiaAlphabet(String word) {
        this.word = word;
    }

    public void count() {

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == 'c' && i < word.length() - 1) {
                if (word.charAt(i + 1) == '=' || word.charAt(i + 1) == '-') {
                    i++;
                }
            }
            else if (ch == 'd' && i < word.length() - 1) {
                if (word.charAt(i + 1) == '-') {
                    i++;
                }
                else if (word.charAt(i + 1) == 'z' && i < word.length() - 2) {
                    if (word.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }
            else if ((ch == 'l' || ch == 'n') && i < word.length() - 1) {
                if (word.charAt(i + 1) == 'j') {
                    i++;
                }
            }
            else if ((ch == 's' || ch == 'z') && i < word.length() - 1) {
                if (word.charAt(i + 1) == '=') {
                    i++;
                }
            }

            count++;
        }

    }

    public void answer() {
        System.out.print(count);
    }
}

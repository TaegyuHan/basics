package implementation.p2941;

import implementation.Implementation;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2941/data/2.txt"));
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
        int idx = 0;
        while (idx < word.length()) {
            char alpha = word.charAt(idx);

            if (word.length() == (idx + 1)) {
                count += 1;
                break;
            } // 마지막 카운트는 1개 추가

            // C
            if ('c' == alpha) {
                if (word.charAt(idx + 1) == '=') {
                    count += 1;
                    idx += 2;
                }
                if (word.charAt(idx) == '-') {
                    count += 1;
                    idx += 2;
                }
                continue;
            }

            // d
            if ('d' == alpha) {
                if (word.charAt(idx + 1) == 'z') {
                    if (idx + 2 < word.length()) {
                        if (word.charAt(idx + 2) == '=') {
                            count += 1;
                            idx += 3;
                            continue;
                        }
                    }
                }
                if (word.charAt(idx) == '-') {
                    count += 1;
                    idx += 2;
                    continue;
                }
            }

            // l
            if ('l' == alpha) {
                if (word.charAt(idx + 1) == 'j') {
                    count += 1;
                    idx += 2;
                    continue;
                }
            }

            // n
            if ('n' == alpha) {
                if (word.charAt(idx + 1) == 'j') {
                    count += 1;
                    idx += 2;
                    continue;
                }
            }

            // s
            if ('s' == alpha) {
                if (word.charAt(idx + 1) == '=') {
                    count += 1;
                    idx += 2;
                    continue;
                }
            }

            // z
            if ('z' == alpha) {
                if (word.charAt(idx + 1) == '=') {
                    count += 1;
                    idx += 2;
                    continue;
                }
            }

            idx += 1;
            count += 1;
        }
    }

    public void answer() {
        System.out.print(count);
    }
}

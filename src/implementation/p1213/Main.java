package implementation.p1213;

import implementation.Implementation;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1213/data/4.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Palindrome pd = new Palindrome(br.readLine());
        pd.answer();
    }
}

class Palindrome {
    private final StringBuilder start, mid, end;
    private final String str;
    private boolean noAnswer;
    private final int[] checkAlpha;
    
    Palindrome(String line) {
        this.str = line;
        this.checkAlpha = new int[26];
        this.noAnswer = false;
        this.start = new StringBuilder();
        this.mid = new StringBuilder();
        this.end = new StringBuilder();
        build();
    }

    private void build() {
        for (int i = 0; i < str.length(); i++) {
            int index = this.str.charAt(i) - 'A';
            ++checkAlpha[index];
        }

        boolean isNumberEven = false;
        for (int i = 0; i < checkAlpha.length; i++) {
            int count = checkAlpha[i];

            if (isNumberEven && count % 2 != 0) {
                this.noAnswer = true;
                return;
            }

            if (count % 2 != 0) {
                mid.append(Character.toString('A' + i).repeat(1));
                isNumberEven = true;

                if (count == 1) {
                    continue;
                }
            }

            int repeatCount = count / 2;
            start.append(Character.toString('A' + i).repeat(repeatCount));
            end.append(Character.toString('A' + i).repeat(repeatCount));
        }
    }

    public void answer() {
        if (this.noAnswer) {
            System.out.print("I'm Sorry Hansoo");
        } else {
            System.out.print(start.append(mid).append(end.reverse()));
        }
    }
}
package implementation.p1316;


import implementation.Implementation;

import java.io.*;
import java.util.HashSet;
import java.util.Set;


/**
 * URL : <a href="https://www.acmicpc.net/problem/1316">문제 Link</a> <br>
 * 문제명 : 그룹 단어 체커
 * <p>
 * BigO : O(N) <br>
 * 문제의 내용 : 단어를 받아 단어의 모든 문자가 연속적인지 확인하는 문제 입니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1316/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        GroupWordChecker gwc = new GroupWordChecker();
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            gwc.setWord(br.readLine());
            answer += gwc.check();
        }
        System.out.print(answer);
    }
}

class GroupWordChecker {

    private String word;
    private Set<Character> checkNumber;

    public GroupWordChecker() {
    }

    public void setWord(String word) {
        // System.out.println(word);
        this.word = word;
        checkNumber = new HashSet<>();
    }

    public int check() {
        // 그룹 단어 확인

        int i = 0;
        while (i < word.length()) { // O(N)
            // 첫번째 방문 확인
            char alpha = word.charAt(i);

            // 처음 나온 알파벳이 나온 경우
            if (!checkNumber.contains(alpha)) {
                // 다음 나오는 알파벳 중 같은게 나오면 계속 넣기
                do {
                    i += 1;
                    if (word.length() <= i) {
                        break;
                    }
                }
                while (alpha == word.charAt(i));
                checkNumber.add(alpha);
                continue;
            }
            return 0;
        }
        return 1;
    }
}

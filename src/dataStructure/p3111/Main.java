package dataStructure.p3111;

import dataStructure.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(DataStructure.PATH + "/p3111/data/3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Text text = new Text(br.readLine(), br.readLine());
        text.censor();
        text.answer();
    }
}

class Text {

    private final String word;
    private final Stack<Character> left;
    private final Stack<Character> right;
    private final ArrayDeque<Character> text;

    public Text(String word, String text) {
        this.word = word;
        this.left = new Stack<>();
        this.right = new Stack<>();
        this.text = new ArrayDeque<>(text.length());

        for (char c : text.toCharArray())
            this.text.addLast(c);
    }

    public void censor() {
        while (true) {
            if (!firstCheck()) { // 첫번째 검사
                break;
            }
            if (!lastCheck()) { // 마지막 검사
                break;
            }
        }

//        System.out.println("text: " + text);
//        System.out.println("left: " + left);
//        System.out.println("right: " + right);
    }

    public boolean firstCheck() {
        int index = 0;
        boolean isFind = false;
        while (!text.isEmpty()) {
            char cText = text.removeFirst(); // 텍스트 단어 추출
            char cWord = word.charAt(index); // 검열 단어 추출

            left.push(cText);
            if (cWord != cText) { // 비교
                index = 0; // 다른경우 다시 찾기
                if (word.charAt(0) != cText) { // 첫번째랑 다른경우
                    continue; // 처음부터 다시 찾기
                }
            }

            // 같은 경우
            ++index;
            if (index == word.length()) { // 단어를 찾은 경우
                for (int i = 0; i < word.length(); ++i) {
                    left.pop();
                }
                isFind = true;
                break;
            }
        }

        // 다시 넣기
        while (!left.empty()) {
            text.addFirst(left.pop());
        }

        return isFind;
    }

    public boolean lastCheck() {
        int index = word.length() - 1;
        boolean isFind = false;
        while (!text.isEmpty()) {

            char cText = text.removeLast(); // 텍스트 단어 추출
            char cWord = word.charAt(index); // 검열 단어 추출

            right.push(cText);
            if (cWord != cText) { // 비교
                index = word.length() - 1; // 다른경우 다시 찾기
                if (word.charAt(index) != cText) {
                    continue;
                }
            }

            // 같은 경우
            --index;
            if (index == -1) { // 단어를 찾은 경우
                for (int i = 0; i < word.length(); ++i) {
                    right.pop();
                }
                isFind = true;
                break;
            }
        }

        // 다시 넣기
        while (!right.empty()) {
            text.addLast(right.pop());
        }

        return isFind;
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        while (!text.isEmpty()) {
            sb.append(text.removeFirst());
        }
        System.out.print(sb);
    }
}
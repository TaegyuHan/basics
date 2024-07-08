package implementation.p3111;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p3111/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Word word = new Word(br.readLine(), br.readLine());
        word.check();
    }
}

class Word {
    private final String comparison;
    private final ArrayDeque<Character> deque;
    private final Stack<Character> leftStack;
    private final Stack<Character> rightStack;

    public Word(String comparison, String line) {
        this.comparison = comparison;
        this.deque = new ArrayDeque<>(line.length());
        this.leftStack = new Stack<>();
        this.rightStack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            deque.addLast(line.charAt(i));
        }
    }

    public void check() {
        while (!deque.isEmpty()) {

            if (left()) { // 처음 등장하는 A 찾은 뒤 삭제
                break;
            }

            if (right()) { // 마지막으로 등장하는 A 찾은 뒤 삭제
                break;
            }
        }
    }

    private boolean left() {
        // T에 A가 없으면 알고리즘을 종료한다.
        // T에서 처음 등장하는 A를 찾은 뒤, 삭제한다.

        int index = -1; // 비교 인덱스
        while (!deque.isEmpty()) {
            // 비교
            // 같은 단어가 스택에 넣어질때 까지 반복
            // 같은 단어가 스택에 넣어진 경우 (인덱스로 판별) > 중지
            //  제거 후 > 스택에 있는 단어 다시 덱으로 넣기
            // 같은 단어인경우 index 추가
            // 아닌경우 스택에 계속 넣기

            // 같은 경우 제거

            // 다른 경우 stack에 넣기

            System.out.println();
            break;
        }

        while (!leftStack.isEmpty()) { // 복원하기
            deque.addFirst(leftStack.pop());
        }

        return true;
    }

    private boolean right() {
        // T에 A가 없으면 알고리즘을 종료한다.
        // T에서 마지막으로 등장하는 A를 찾은 뒤, 삭제한다.
        return true;
    }
}



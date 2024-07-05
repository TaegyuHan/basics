package stack.p12789;


import stack.StackPath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream(StackPath.PATH + "/p12789/data/3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        // 현재 줄서있는 곳
        Stack startLoad = new Stack(size);
        startLoad.pushAll(br.readLine());

        // 한 명씩만 설 수 있는 공간
        Stack tmpLoad = new Stack(size);
        String answer = Room.move(startLoad, tmpLoad);

        // 정답 출력
        System.out.println(answer);
    }
}

class Room {

    public static String move(Stack startLoad, Stack tmpLoad) {

        int outNumber = 1;
        while (!startLoad.empty() || !tmpLoad.empty()) { // 스택이 빌때 까지

            // 스택 2개에서 맨위 확인
            if (startLoad.peek() == outNumber) { // 출발 스택 확인
                startLoad.pop();
                ++outNumber;
                continue;
            }

            // 탬프 스택 확인
            if (tmpLoad.peek() == outNumber) { // 옮긴 부분 스택 확인
                tmpLoad.pop();
                ++outNumber;
                continue;
            }

            // 불가능한 경우
            if (startLoad.empty()) // 시작란에 없는데 사람이 존재하는 경우
                return "Sad";

            // 탬프로 스택으로 이동
            int tmp = startLoad.pop();
            tmpLoad.push(tmp);
        }

        return "Nice";
    }
}

class Stack {

    private final int[] array;
    private int index;

    Stack(int size) {

        this.array = new int[size];
        this.index = -1;
    }

    public static Stack of(String line) {

        return new Stack(Integer.parseInt(line));
    }

    public void pushAll(String line) {

        String[] data = line.split(" ");
        for (int i = 0; i < data.length; ++i) {
            ++index;
            array[i] = Integer.parseInt(data[data.length - i - 1]);
        }
    }

    public boolean empty() {

        return index == -1;
    }

    public void push(int value) {

        array[++index] = value;
    }

    public int pop() {
        int tmp = array[index];
        array[index--] = 0;
        return tmp;
    }

    public int peek() {

        if (empty()) {
            return 0;
        }
        return array[index];
    }
}
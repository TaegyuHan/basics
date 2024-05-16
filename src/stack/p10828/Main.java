package stack.p10828;

import stack.StackPath;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(StackPath.PATH + "/p10828/data/2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Stack stack = new Stack(size);
        for (int i = 0; i < size; i++) {
            stack.cmd(br.readLine());
        }
    }
}

class Stack {

    private final int[] arr;
    private int arrSize;
    private int index;

    Stack(int size) {
        this.index = -1;
        this.arrSize = size;
        this.arr = new int[size];
    }

    public void push(int data) {
        index += 1;
        arr[index] = data;
    }

    public int pop() {
        if (index == -1) {
            return index;
        }
        return arr[index--];
    }

    public int size() {
        return index + 1;
    }

    public int empty() {
        if (index == -1) {
            return 1;
        }
        return 0;
    }

    public int top() {
        if (index == -1) {
            return index;
        }
        return arr[index];
    }

    public void cmd(String cmd) {
        if (cmd.startsWith("push")) {
            String[] data = cmd.split(" ");
            push(Integer.parseInt(data[1]));
        }
        if (cmd.startsWith("pop")) {
            System.out.println(pop());
        }
        if (cmd.startsWith("size")) {
            System.out.println(size());
        }
        if (cmd.startsWith("empty")) {
            System.out.println(empty());
        }
        if (cmd.startsWith("top")) {
            System.out.println(top());
        }
    }
}
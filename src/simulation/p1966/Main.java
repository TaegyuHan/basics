package simulation.p1966;


import simulation.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Simulation.PATH + "/p1966/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        for (int i = 0; i < testCount; i++) {
            q.reset(br.readLine(), br.readLine());
            q.answer();
        }
    }
}


class Queue {
    private int findIndex;
    private final List<Paper> pages;
    private final int[] priority;

    Queue() {
        this.findIndex = -1;
        this.pages = new LinkedList<>();
        this.priority = new int[10];
    }

    public void reset(String line, String line2) {
        String[] data = line.split(" ");
        String[] pages = line2.split(" ");
        reset(Integer.parseInt(data[1]), pages);
    }

    public void reset(int findIndex, String[] pages) {
        this.findIndex = findIndex;
        this.pages.clear();
        Arrays.fill(this.priority, 0);

        for (int i = 0; i < pages.length; i++) {
            int priority = Integer.parseInt(pages[i]);
            this.pages.add(new Paper(i, priority));
            ++this.priority[priority];
        }
    }

    public void answer() {
        int count = 0;
        while (!pages.isEmpty()) {

            Paper paper = pages.remove(0);

            // 가장 높은 우선순위인 경우 > 프린트함
            if (getMaxPriority() == paper.getPriority()) {
                ++count;
                --priority[paper.getPriority()];
                // 원하는 번째 인 경우
                if (paper.getIndex() == findIndex) {
                    System.out.println(count);
                    return;
                }
            } else { // 아닌 경우 > 뒤로 뺌
                pages.add(paper);
            }
        }
    }

    private int getMaxPriority() {
        for (int i = 9; 1 <= i; --i) {
            if (priority[i] != 0) {
                return i;
            }
        }
        return -1;
    }
}

class Paper {
    private final int index;
    private final int priority;

    Paper(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}
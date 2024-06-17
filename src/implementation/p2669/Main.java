package implementation.p2669;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2669/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();
        for (int i = 0; i < board.INPUT_COUNT; ++i) {
            board.setData(br.readLine());
        }
//        board.show();
        board.answer();
    }
}

class Board {
    public final int INPUT_COUNT = 4;
    public final int SIZE = 100;
    private final int[][] map;
    private int area;

    public Board() {
        this.map = new int[SIZE][SIZE];
        this.area = 0;
    }

    public void setData(String line) {
        String[] data = line.split(" ");
        setData(
                Integer.parseInt(data[0]),
                Integer.parseInt(data[1]),
                Integer.parseInt(data[2]),
                Integer.parseInt(data[3])
        );
    }

    public void setData(int x1, int y1, int x2, int y2) {
        for (int r = x1; r < x2; ++r) {
            for (int c = y1; c < y2; ++c) {
                if (map[r][c] == 0) {
                    map[r][c] = 1;
                    ++area;
                }
            }
        }
    }

    public void show() {
        for (int r = 0; r < SIZE; ++r) {
            System.out.println(Arrays.toString(map[r]));
        }

    }

    public void answer() {
        System.out.print(this.area);
    }
}
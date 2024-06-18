package implementation.p2578;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2578/data/3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Board board = new Board();
        for (int i = 0; i < Board.SIZE; i++) {
            board.setData(i, br.readLine());
        }
        for (int i = 0; i < Board.SIZE; i++) {
            board.checkNumbers(br.readLine());
        }
        board.answer();
    }
}

class Board {
    public static final int SIZE = 5;
    public static final int BREAK_COUNT = 3;
    private int[][] board;
    private int inputCount;
    private int lineCount;

    Board() {
        this.board = new int[SIZE][SIZE];
        this.inputCount = 0;
        this.lineCount = 0;
    }

    public void setData(int row, String line) {
        String[] data = line.split(" ");
        for (int col = 0; col < SIZE; ++col) {
            this.board[row][col] = Integer.parseInt(data[col]);
        }
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; ++row) {
            sb.append(Arrays.toString(board[row])).append("\n");
        }
        System.out.println(sb);
    }

    private void checkNumber(int number) {
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                if (board[row][col] == -1) { continue; }
                if (board[row][col] != number) { continue; }
                ++this.inputCount;
                board[row][col] = -1;
                lineCount = Math.max(lineCount, checkLine());
                return;
            }
        }
    }

    private int checkLine() {
        int count = 0;
        // 가로 확인
        for (int row = 0; row < SIZE; ++row) {
            boolean lineCheck = true;
            for (int col = 0; col < SIZE; ++col) {
                if (board[row][col] != -1) {
                    lineCheck = false;
                    break;
                }
            }
            if (lineCheck) {
                ++count;
            }
        }

        // 세로 화인
        for (int col = 0; col < SIZE; ++col) {
            boolean lineCheck = true;
            for (int row = 0; row < SIZE; ++row) {
                if (board[row][col] != -1) {
                    lineCheck = false;
                    break;
                }
            }
            if (lineCheck) {
                ++count;
            }
        }

        // 대각선 확인 \
        boolean diagramCheck = true;
        for (int i = 0; i < SIZE; ++i) {
            if (board[i][i] != -1) {
                diagramCheck = false;
                break;
            }
        }
        if (diagramCheck) {
            ++count;
        }

        // 대각선 확인 /
        diagramCheck = true;
        for (int i = 0; i < SIZE; ++i) {
            if (board[i][(SIZE - 1) - i] != -1) {
                diagramCheck = false;
                break;
            }
        }
        if (diagramCheck) {
            ++count;
        }

        return count;
    }

    public void checkNumbers(String line) {
        if (BREAK_COUNT <= lineCount) { return; }
        String[] data = line.split(" ");
        for (int col = 0; col < data.length; col++) {
            int num = Integer.parseInt(data[col]);
            checkNumber(num);
            if (BREAK_COUNT <= lineCount) {
                return;
            }
        }
    }

    public void answer() {
        System.out.print(this.inputCount);
    }
}
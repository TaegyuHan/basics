package implementation.p1051;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1051/data/6.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = Board.of(br.readLine());

        for (int row = 0; row < board.getRow(); ++row) {
            board.setRow(row, br.readLine());
        }
        board.findMaxSize();
        board.answer();
    }
}

enum Direction {
    // 내위치
    CURRENT(0, 0),
    // 오른족
    RIGHT(0, 1),
    // 대각선
    DIAGONAL(1, 1),
    // 아래
    DOWN(1, 0);

    private final int rowTmp;
    private final int colTmp;

    Direction(int rowTmp, int colTmp) {
        this.rowTmp = rowTmp;
        this.colTmp = colTmp;
    }

    public int[] getTmp() {
        return new int[] { rowTmp, colTmp };
    }
}

class Board {
    private final int row;
    private final int col;
    private final int[][] board;
    public int maxSize;

    Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new int[row][col];
        this.maxSize = 1;
    }

    public int getRow() {
        return row;
    }

    public static Board of(String line) {
        String[] data = line.split(" ");
        return Board.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public static Board of(int row, int col) {
        return new Board(row, col);
    }

    public void setRow(int row, String line) {
        for (int i = 0; i < col; ++i) {
            this.board[row][i] = Character.getNumericValue(line.charAt(i));
        }
    }

    private int getPositionSize(int prow, int pcol) {
        int checkEndSize = Math.max(this.row, this.col);
        int ms = 1; // 가장 큰 값
        int checkSize = 4;
//        System.out.println("start > " + prow + ", " + pcol);

        sizeCheck:
        for (int s = 1; s <= checkEndSize; ++s) {
            int[] checkNumbers = new int[checkSize];
            int checkIndex = 0;

            for (Direction dir : Direction.values()) {
                int[] tmp = dir.getTmp();
                int newRow = prow + (tmp[0] * s);
                int newCol = pcol + (tmp[1] * s);
                if (!((0 <= newRow && newRow < this.row) && (0 <= newCol && newCol < this.col))) {
                    continue sizeCheck;
                }
                checkNumbers[checkIndex++] = this.board[newRow][newCol];
            }

            if ((checkNumbers[0] == checkNumbers[1]) && (checkNumbers[1] == checkNumbers[2]) && (checkNumbers[2] == checkNumbers[3])) {
                ms = Math.max(ms, (s + 1) * (s + 1));
            }
        }
        return ms;
    }

    public void findMaxSize() {
        for (int r = 0; r < this.row; ++r) {
            for (int c = 0; c < this.col; ++c) {
                int ms = getPositionSize(r, c);
                maxSize = Math.max(maxSize, ms);
            }
        }
    }

    public void answer() {
        System.out.print(this.maxSize);
    }
}
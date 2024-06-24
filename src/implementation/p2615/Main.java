package implementation.p2615;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2615/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Board board = new Board();
        for (int i = 0; i < Board.SIZE; ++i) {
            board.setRow(i, br.readLine());
        }
        board.calculate();
        board.show();
    }
}

enum State {
    BLACK(1),
    WHITE(2),
    EMPTY(0);

    private int value;

    State(int value) {
        this.value = value;
    }

    public static State of(int value) {
        for (State state : State.values()) {
            if (state.value == value) {
                return state;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

class Board {
    public static final int SIZE = 19;
    private final State[][] board;
    private State winner;

    Board() {
        this.board = new State[SIZE][SIZE];
    }

    public void setRow(int row, String line) {
        String[] data = line.split(" ");
        for (int col = 0; col < SIZE; ++col) {
            this.board[row][col] = State.of(Integer.parseInt(data[col]));
        }
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (State[] row : board) {
            sb.append(Arrays.toString(row));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void calculate() {
        for (int row = 0; row < (SIZE - 5); ++row) {
            for (int col = 0; col < (SIZE - 5); ++col) {
                if (row == 2 && col == 1) {
                    int[] position = check(row, col);
                    System.out.println(Arrays.toString(position));
                }
            }
        }
    }

    private int[] check(int row, int col) {
        // 가로 확인
        boolean blackCheck = true, whiteCheck = true, emptyCheck = false;
        for (int i = row; i <= row + 5; ++i) {
            for (int j = col; j <= col + 5; ++j) {
                State state = this.board[i][j];
                if (state == State.EMPTY) {
                    emptyCheck = true;
                    blackCheck = false;
                    whiteCheck = false;
                }
                if (state == State.BLACK) {
                    whiteCheck = false;
                }
                if (state == State.WHITE) {
                    blackCheck = false;
                }
            }
        }

        if (!emptyCheck && (blackCheck || whiteCheck)) {
            System.out.println("가로");
            return new int[]{row, col};
        }

        // 세로 확인
        blackCheck = true;
        whiteCheck = true;
        for (int j = col; j <= col + 5; ++j) {
            for (int i = row; i <= row + 5; ++i) {
                State state = this.board[i][j];
                if (state == State.EMPTY) {
                    blackCheck = false;
                    whiteCheck = false;
                }
                if (state == State.BLACK) {
                    whiteCheck = false;
                }
                if (state == State.WHITE) {
                    blackCheck = false;
                }
            }
        }

        if (!emptyCheck && (blackCheck || whiteCheck)) {
            System.out.println("세로");
            return new int[]{row, col};
        }

        // 대각선 확인
        blackCheck = true;
        whiteCheck = true;
        for (int t = 0; t <= 5; ++t) {
            State state = this.board[row + t][col + t];
            if (state == State.EMPTY) {
                blackCheck = false;
                whiteCheck = false;
            }
            if (state == State.BLACK) {
                whiteCheck = false;
            }
            if (state == State.WHITE) {
                blackCheck = false;
            }
        }

        if (!emptyCheck && (blackCheck || whiteCheck)) {
            System.out.println("대각선");
            return new int[]{row, col};
        }

        return new int[]{0, 0};
    }
}
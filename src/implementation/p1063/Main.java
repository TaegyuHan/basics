package implementation.p1063;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1063/data/6.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = Board.of(br.readLine());

//        board.show();
        for (int i = 0; i < board.getInputCount(); ++i) {
            board.setMove(br.readLine());
        }
//        board.show();
        board.answer();
    }
}

enum Pieces {
    KING("K"),
    PAWN("P"),
    EMPTY("0");

    private final String value;

    Pieces(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

enum Move {
    R("R", 0, 1), // 한 칸 오른쪽으로
    L("L", 0, -1), // 한 칸 왼쪽으로
    B("B", -1, 0), // 한 칸 아래로
    T("T", 1, 0), // 한 칸 위로
    RT("RT", 1, 1), // 오른쪽 위 대각선으로
    LT("LT", 1, -1), // 왼쪽 위 대각선으로
    RB("RB", -1, 1), // 오른쪽 아래 대각선으로
    LB("LB", -1, -1); // 왼쪽 아래 대각선으로

    private final String value;

    public int getTRow() {
        return tRow;
    }

    public int getTCol() {
        return tCol;
    }

    private final int tRow;
    private final int tCol;

    Move(String value, int tRow, int tCol) {
        this.value = value;
        this.tRow = tRow;
        this.tCol = tCol;
    }
}

class Space {
    private Pieces piece;
    private int row;
    private int col;

    public Space(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = Pieces.EMPTY;
    }

    public Space(int row, int col, Pieces piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public void setPosition(int[] position) {
        this.row = position[0];
        this.col = position[1];
    }

    public int[] getPosition() {
        return new int[] {row, col};
    }

    public int[] next(Move move) {
        int trow = move.getTRow();
        int tcol = move.getTCol();
        return new int[] {trow + row, tcol + col};
    }

    @Override
    public String toString() {
        return piece.getValue();
    }

    public String getAlphaPosition() {
        return Character.toString('A' + col) + (row + 1);
    }

    public boolean isPawn() {
        return piece == Pieces.PAWN;
    }
}

class Board {
    private final Space[][] spaces;
    private final int SIZE = 8;

    private final int inputCount;
    private Space king;
    private Space pawn;

    public Board(String kingPosition, String pawnPosition, int inputCount) {
        this.spaces = new Space[SIZE][SIZE];
        this.inputCount = inputCount;
        int[] kp = getIndex(kingPosition);
        int[] pp = getIndex(pawnPosition);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (kp[0] == row && kp[1] == col) {
                    this.spaces[row][col] = new Space(row, col, Pieces.KING);
                    king = spaces[row][col];
                }
                else if (pp[0] == row && pp[1] == col) {
                    this.spaces[row][col] = new Space(row, col, Pieces.PAWN);
                    pawn = spaces[row][col];
                }
                else {
                    this.spaces[row][col] = new Space(row, col);
                }
            }
        }
    }

    public static Board of(String line) {
        String[] data = line.split(" ");
        return new Board(data[0], data[1], Integer.parseInt(data[2]));
    }

    public int getInputCount() {
        return inputCount;
    }

    private int[] getIndex(String position) {
        char col = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        return new int[] {row - 1, (col - 'A')};
    }

    public void show() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < SIZE; row++) {
            // 원래 출력
            for (int col = 0; col < SIZE; col++) {
                sb.append(this.spaces[row][col]).append(" ");
            }
            sb.append("\t");
            // 정답 화면 출력
            for (int col = 0; col < SIZE; col++) {
                sb.append(this.spaces[(SIZE - 1) - row][col]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void setMove(String data) {
        int[] nextPosition = king.next(Move.valueOf(data));
        int nRow = nextPosition[0], nCol = nextPosition[1];

        // 판 밖으로 나감
        if (!(0 <= nRow && nRow < SIZE && 0 <= nCol && nCol < SIZE)) {
            return;
        }

        // 폰을 만난 경우
        if (this.spaces[nRow][nCol].isPawn()) {
            // 폰 이동 가능여부
            int[] nextPawnPosition = pawn.next(Move.valueOf(data));
            int npRow = nextPawnPosition[0], npCol = nextPawnPosition[1];
            // 이동 불가능 > 둘다 이동 X
            if (!(0 <= npRow && npRow < SIZE && 0 <= npCol && npCol < SIZE)) {
                return;
            }
            change(pawn.getPosition(), nextPawnPosition);
        }

        // 폰을 안만난 경우
        change(king.getPosition(), nextPosition);
    }

    public void change(int[] before, int[] after) {
        int brow = before[0], bcol = before[1];
        int arow = after[0], acol = after[1];
        Space tmp = spaces[brow][bcol];
        spaces[brow][bcol] = spaces[arow][acol];
        spaces[brow][bcol].setPosition(before);
        spaces[arow][acol] = tmp;
        spaces[arow][acol].setPosition(after);
    }

    public void answer() {
        System.out.println(king.getAlphaPosition());
        System.out.print(pawn.getAlphaPosition());
    }
}
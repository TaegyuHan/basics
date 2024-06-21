package implementation.p1913;

import implementation.Implementation;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1913/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Ground ground = Ground.of(br.readLine(), br.readLine());
        ground.snailMove();
        ground.answer();
    }
}

class Ground {
    private final Space[][] space;
    private final int size;
    private final int breakNumber;
    private final Snail snail;
    private int[] answerPosition;

    public Ground(int size, int breakNumber) {
        this.size = size;
        this.breakNumber = breakNumber;
        this.snail = new Snail(size);
        this.space = new Space[size][size];
        this.answerPosition = null;

        // 배열 초기화
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.space[row][col] = new Space();
            }
        }
        int[] snailPosition = snail.getPosition();
        this.space[snailPosition[0]][snailPosition[1]].visit(snail.getNumber());
    }

    public static Ground of(String size, String number) {
        return new Ground(Integer.parseInt(size), Integer.parseInt(number));
    }

    public void show() {
        for (int row = 0; row < size; row++) {
            System.out.println(Arrays.toString(this.space[row]));
        }
    }

    public void snailMove() {
        while (true) {

            if (breakNumber == snail.getNumber()) {
                answerPosition = snail.getPosition();
            }

            // 첫 이동은 무조건 앞으로
            int[] next = snail.getNextPosition();
            int cRow = next[0];
            int cCol = next[1];

            // 이동 가능 여부 체크
            if (!(((0 <= cRow && cRow < size) && (0 <= cCol && cCol < size)))) {
                break;
            }

            // 앞으로 이동
            snail.goNext();
            this.space[cRow][cCol].visit(snail.getNumber());

            // 돌리기 가능 여부 확인
            int[] turn = snail.turnPosition();
            if (!this.space[turn[0]][turn[1]].isVisit()) { // 돌리기 가능
                snail.turn();
            }
        }
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                sb.append(space[row][col].getNumber()).append(" ");
            }
            sb.append("\n");
        }
        sb.append(answerPosition[0] + 1).append(" ").append(answerPosition[1] + 1);
        System.out.print(sb);
    }
}

class Space {
    private int number;

    Space() {
        this.number = 0;
    }

    @Override
    public String toString() {
        return "" + number;
    }

    public void visit(int number) {
        this.number = number;
    }

    public boolean isVisit() {
        return this.number != 0;
    }

    public int getNumber() {
        return this.number;
    }
}

enum Direction {
    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    public final int tmpX;
    public final int tmpY;

    Direction(int tmpX, int tmpY) {
        this.tmpX = tmpX;
        this.tmpY = tmpY;
    }

    public int[] getTmp() {
        return new int[]{tmpX, tmpY};
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}

class Snail {
    private int x;
    private int y;
    private int number;
    private Direction direction;

    Snail(int size) {
        this.x = (size / 2);
        this.y = (size / 2);
        this.number = 1;
        this.direction = Direction.UP;
    }

    public int[] getNextPosition() {
        int[] tmp = this.direction.getTmp();
        return new int[]{x + tmp[0], y + tmp[1]};
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public int getNumber() {
        return number;
    }

    public void goNext() {
        ++this.number;
        int[] tmp = this.direction.getTmp();
        this.x = x + tmp[0];
        this.y = y + tmp[1];
    }

    public int[] turnPosition() {
        Direction turn = this.direction.turnRight();
        int[] tmp = turn.getTmp();
        return new int[]{x + tmp[0], y + tmp[1]};
    }

    public void turn() {
        this.direction = this.direction.turnRight();
    }
}
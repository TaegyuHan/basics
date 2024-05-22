package simulation.p14503;

import simulation.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Simulation.PATH + "/p14503/data/2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Room room = new Room(br.readLine());
        room.setRoomCleaner(br.readLine());

        for (int i = 0; i < room.getRow(); ++i) {
            room.setRow(i, br.readLine());
        }

        room.move();
        room.answer();
    }
}

enum Direction {
    LEFT(0, -1, 3),
    RIGHT(0, 1, 1),
    UP(-1, 0, 0),
    DOWN(1, 0, 2);

    private int x;
    private int y;
    private int direction;

    Direction(int x, int y, int direction) {
        assert 3 <= x && x <= 50;
        assert 3 <= y && y <= 50;
        assert 0 <= direction && direction <= 3;

        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static String toString(Direction direction) {
        switch (direction) {
            case LEFT:
                return "<";
            case RIGHT:
                return ">";
            case UP:
                return "^";
            case DOWN:
                return "v";
        }
        return null;
    }

    public static int[] go(int row, int col, Direction direction) {
        switch (direction) {
            case LEFT:
                return new int[]{row + LEFT.x, col + LEFT.y};
            case RIGHT:
                return new int[]{row + RIGHT.x, col + RIGHT.y};
            case UP:
                return new int[]{row + UP.x, col + UP.y};
            case DOWN:
                return new int[]{row + DOWN.x, col + DOWN.y};
        }
        return null;
    }

    public static Direction turn(Direction direction) {
        switch (direction) {
            case LEFT:
                return Direction.DOWN;
            case RIGHT:
                return Direction.UP;
            case UP:
                return Direction.LEFT;
            case DOWN:
                return Direction.RIGHT;
        }
        return null;
    }

    public static int[] back(int row, int col, Direction direction) {
        switch (direction) {
            case LEFT:
                return new int[]{row + RIGHT.x, col + RIGHT.y};
            case RIGHT:
                    return new int[]{row + LEFT.x, col + LEFT.y};
            case UP:
                return new int[]{row + DOWN.x, col + DOWN.y};
            case DOWN:
                return new int[]{row + UP.x, col + UP.y};
        }
        return null;
    }

    public static Direction of(int direction) {
        assert 0 <= direction && direction <= 3;

        switch (direction) {
            case 0:
                return UP;
            case 1:
                return RIGHT;
            case 2:
                return DOWN;
            case 3:
                return LEFT;
        }
        return null;
    }
}

enum Floor {
    CLEAN(2),
    WALL(1),
    NOT_CLEAN(0);

    private int state;

    Floor(int state) {
        this.state = state;
    }

    public static Floor of(String state) {
        return Floor.of(Integer.parseInt(state));
    }

    public static Floor of(int state) {
        assert 0 <= state && state <= 1;

        switch (state) {
            case 0:
                return NOT_CLEAN;
            case 1:
                return WALL;
            case 2:
                return CLEAN;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}

class Room {

    private int row;
    private int col;
    private Floor[][] board;
    private int cleanCount;
    private RobotCleaner robotCleaner;

    public Room(String line) {
        String[] data = line.split(" ");
        this.row = Integer.parseInt(data[0]);
        this.col = Integer.parseInt(data[1]);
        this.board = new Floor[row][col];
        this.cleanCount = 0;
    }

    public void setRoomCleaner(int row, int col, int direction) {
        assert 3 <= row && row <= 50;
        assert 3 <= col && col <= 50;
        assert 0 <= direction && direction <= 3;

        this.robotCleaner = new RobotCleaner(row, col, direction);
    }

    public void setRoomCleaner(String line) {
        String[] data = line.split(" ");
        setRoomCleaner(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }

    public void setRow(int index, String line) {
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < col; ++i) {
            board[index][i] = Floor.of(st.nextToken());
        }
    }

    public int getRow() {
        return row;
    }

    public void showBoard() {

        int[] cleanerPosition = robotCleaner.getPosition();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (cleanerPosition[0] == i && cleanerPosition[1] == j) {
                    sb.append(robotCleaner.toString()).append(" ");
                }
                else {
                    sb.append(board[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        sb.append(cleanCount).append("\n");
        System.out.println(sb);
    }

    public void move() {
        do {
            // showBoard();
            int[] position = robotCleaner.getPosition();

            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (!cleanCheck(position)) {
                clean(position);
            }

            // 현재 칸의 주변 4칸 중 청소 되지 않은 빈칸이 없는 경우
            if (!moveAroundCheck()) {
                int[] backPosition = robotCleaner.backPosition();

                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                if (!wallCheck(backPosition)) {
                    robotCleaner.move(backPosition);
                    continue;
                }
                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                else {
                    robotCleaner.off();
                    break;
                }
            }
            // 현재 칸의 주변 4칸 중 청소 되지 않은 빈칸이 있는 경우
            else {
                // 반시계 방향으로 90도 회전한다.
                robotCleaner.rotateLeft90();
                int[] frontPosition = robotCleaner.frontPostion();
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                if (!cleanCheck(frontPosition) && !wallCheck(frontPosition)) {
                    robotCleaner.move(frontPosition);
                }
            }
        } while (robotCleaner.getPower());
    }

    private boolean wallCheck(int[] position) {
        return board[position[0]][position[1]] == Floor.WALL;
    }

    private boolean cleanCheck(int[] position) {
        if (board[position[0]][position[1]] == Floor.CLEAN) {
            return true;
        }
        return false;
    }

    private void clean(int[] position) {
        ++cleanCount;
        board[position[0]][position[1]] = Floor.CLEAN;
    }

    private boolean moveAroundCheck() {
        int[][] around = robotCleaner.getAround();
        for (int[] position : around) {
            if (!cleanCheck(position) && !wallCheck(position)) {
                return true;
            }
        }
        return false;
    }

    public void answer() {
        System.out.print(cleanCount);
    }
}

class RobotCleaner {

    private int row;
    private int col;
    private boolean power;
    private Direction direction;

    public RobotCleaner(int row, int col, int direction) {
        assert 3 <= row && row <= 50;
        assert 3 <= col && col <= 50;
        assert 0 <= direction && direction <= 3;

        this.row = row;
        this.col = col;
        this.direction = Direction.of(direction);
        this.power = true;
    }

    public int[][] getAround() {
        int[][] around = new int[4][2];
        for (int i = 0; i < Direction.values().length; ++i) {
            assert Direction.of(i) != null;
            around[i] = Direction.go(row, col, Direction.of(i));
        }
        return around;
    }

    public void rotateLeft90() {
        this.direction = Direction.turn(this.direction);
    }

    public int[] getPosition() {
        return new int[]{row, col};
    }

    public void move(int[] position) {
        this.row = position[0];
        this.col = position[1];
    }

    public int[] backPosition() {
        return Direction.back(row, col, direction);
    }

    public void off() {
        this.power = false;
    }

    public boolean getPower() {
        return power;
    }

    public int[] frontPostion() {
        return Direction.go(row, col, direction);
    }

    @Override
    public String toString() {
        return Direction.toString(direction);
    }
}
package simulation.p3190;

import simulation.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Simulation.PATH + "/p3190/data/3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Board board = new Board(br.readLine());

        int appleCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < appleCount; ++i) {
            board.setApple(br.readLine());
        }

        int timeCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < timeCount; ++i) {
            board.setChangeData(br.readLine());
        }

        board.snakeMove();
        board.answer();
    }
}

class Board {
    private final int size;
    private final LinkedList<ChangeData> changeDatas;
    private final LinkedList<Space> snake;
    private Direction direction;
    private final Space[][] board;
    private int time;

    Board(String line) {
        this.time = 0;
        this.size = Integer.parseInt(line);
        this.changeDatas = new LinkedList<>();
        this.board = new Space[size][];
        for (int row = 0; row < size; ++row) {
            this.board[row] = new Space[size];
            for (int col = 0; col < size; ++col) {
                this.board[row][col] = new Space(row, col);
            }
        }

        this.snake = new LinkedList<>();
        this.direction = Direction.RIGHT;
        this.board[0][0].toSnake();
        snake.add(this.board[0][0]);
    }

    public void setChangeData(String line) {
        String[] data = line.split(" ");
        setChangeData(Integer.parseInt(data[0]), Direction.valueOf(data[1]));
    }

    public void setChangeData(int time, Direction direction) {
        this.changeDatas.add(new ChangeData(time, direction));
    }

    public void setApple(String line) {
        String[] data = line.split(" ");
        setApple(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public void setApple(int x, int y) {
        Space space = this.board[x - 1][y - 1];
        space.toApple();
    }

    public void show() {
        StringBuilder sb = new StringBuilder();

        sb.append(changeDatas.toString()).append("\n");

        for (Space s: snake) {
            sb.append("[").append(s.getX()).append(",").append(s.getY()).append("]");
        }
        sb.append("\n");
        sb.append(direction.toString()).append(" ").append(time).append("\n");

        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                sb.append(board[row][col]);
            }
            sb.append("\n");
        }
        sb.append("\n\n");
        System.out.print(sb);
    }

    public void snakeMove() {
        while (!snake.isEmpty()) {
            // 먼저 뱀은 몸길이를 늘려
            Space head = snake.peekFirst();
            int[] next = direction.next(head);

            // 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
            if (wallCheck(next) || bodyCheck(next)) {
                break;
            }

            // 사과가 없어지고 꼬리는 움직이지 않는다
            if (appleCheck(next)) {
                eatApple(next);
            }
            // 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉 몸길이는 변하지 않는다.
            else {
                Space tail = snake.removeLast();
                findSpace(tail).toEmpty();
            }

            // 머리를 다음 칸에 위치시킨다.
            findSpace(next).toSnake();
            snake.addFirst(findSpace(next));

            ++time;
            // 시간에 따른 방향 변경
            ChangeData changeData = changeDatas.peekFirst();
            if (!changeDatas.isEmpty() && changeData.getTime() <= time) {
                direction = changeData.getDirection().turn(direction);
                changeDatas.removeFirst();
            }
            // show();
        }
    }

    private Space findSpace(Space space) {
        return findSpace(space.getX(), space.getY());
    }

    private Space findSpace(int[] position) {
        return findSpace(position[0], position[1]);
    }

    private Space findSpace(int x, int y) {
        return this.board[x][y];
    }

    private void eatApple(int[] next) {
        this.board[next[0]][next[1]].toEmpty();
    }

    private boolean appleCheck(int[] next) {
        return this.board[next[0]][next[1]].isApple();
    }

    private boolean bodyCheck(int[] next) {
        return this.board[next[0]][next[1]].isSnake();
    }

    private boolean wallCheck(int[] next) {
        return !((0 <= next[0] && next[0] < size) && (0 <= next[1] && next[1] < size));
    }

    public void answer() {
        System.out.print(time + 1);
    }
}

enum Type {
    EMPTY(0),
    APPLE(1),
    SNAKE(2);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

enum Direction {
    D("D", -1, -1),
    L("L", -1, -1),
    LEFT("LEFT", 0, -1),
    RIGHT("RIGHT", 0, 1),
    UP("UP", -1, 0),
    DOWN("DOWN", 1, 0);

    private final String value;
    private final int x;
    private final int y;

    Direction(String value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public Direction turn(Direction turn) {
        switch (turn) {
            case DOWN: {
                if (this.value.equals("D")) {
                    return LEFT;
                } else {
                    return RIGHT;
                }
            }
            case UP: {
                if (this.value.equals("D")) {
                    return RIGHT;
                } else {
                    return LEFT;
                }
            }
            case RIGHT: {
                if (this.value.equals("D")) {
                    return DOWN;
                } else {
                    return UP;
                }
            }
            case LEFT: {
                if (this.value.equals("D")) {
                    return UP;
                } else {
                    return DOWN;
                }
            }
        }
        return null;
    }

    public int[] next(Space space) {
        return next(space.getX(), space.getY());
    }

    public int[] next(int row, int col) {
        return new int[]{row + this.x, col + this.y};
    }

}

class ChangeData {
    private final int time;
    private final Direction direction;

    ChangeData(int time, Direction direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return time;
    }

    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        return "[" + time + ", " + direction + "]";
    }
}

class Space {
    private final int x;
    private final int y;
    private Type type;

    Space(int x, int y) {
        this.x = x;
        this.y = y;
        this.type = Type.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void toApple() {
        this.type = Type.APPLE;
    }

    public void toSnake() {
        this.type = Type.SNAKE;
    }

    public void toEmpty() {
        this.type = Type.EMPTY;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    public boolean isSnake() {
        return this.type.getValue() == Type.SNAKE.getValue();
    }

    public boolean isApple() {
        return this.type.getValue() == Type.APPLE.getValue();
    }
}
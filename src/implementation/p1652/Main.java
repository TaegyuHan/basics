package implementation.p1652;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1652/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Room room = Room.of(br.readLine());

        for (int i = 0; i < room.getSize(); ++i) {
            room.setSpace(i, br.readLine());
        }
        room.check();
        room.answer();
    }
}

class Room {
    private final char[][] space;
    private final int size;
    private int widthCount, heightCount;

    public Room(int size) {
        this.size = size;
        this.space = new char[size][size];
        this.heightCount = 0;
        this.widthCount = 0;
    }

    public static Room of(String line) {
        return new Room(Integer.parseInt(line));
    }

    public int getSize() {
        return size;
    }

    public void setSpace(int row, String line) {
        for (int i = 0; i < line.length(); ++i) {
            space[row][i] = line.charAt(i);
        }
    }

    public void check() {
        // 가로 확인
        rowLoop:
        for (int row = 0; row < size; ++row) {
            for (int col = 1; col < size; ++col) {
                if (space[row][col] == '.' && space[row][col - 1] == '.') {
                    ++widthCount;
                    continue rowLoop;
                }
            }
        }

        // 세로 확인
        colLoop:
        for (int row = 1; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                if (space[row][col] == '.' && space[row - 1][col] == '.') {
                    ++heightCount;
                    continue colLoop;
                }
            }
        }
    }

    public void answer() {
        System.out.print(widthCount + " " + heightCount);
    }
}
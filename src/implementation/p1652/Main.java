package implementation.p1652;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p1652/data/4.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Room room = Room.of(br.readLine());
        for (int i = 0; i < room.getSize(); ++i) {
            room.setSpace(i, br.readLine());
        }
        room.find();
        room.answer();
    }
}

class Room {
    private final char[][] map;
    private final int size;
    private int width, height;

    public Room(int size) {
        this.map = new char[size][size];
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static Room of(String line) {
        return new Room(Integer.parseInt(line));
    }

    public void setSpace(int row, String line) {
        for (int i = 0; i < line.length(); ++i) {
            this.map[row][i] = line.charAt(i);
        }
    }

    public void find() {
        // 가로
        for (int row = 0; row < size; ++row) {
            boolean wall = true;
            for (int col = 1; col < size; ++col) {
                if (map[row][col - 1] == '.' && map[row][col] == '.') {
                    if (wall) {
                        ++width;
                        wall = false;
                    }
                    continue;
                }
                wall = true;
            }
        }

        // 세로
        for (int col = 0; col < size; ++col) {
            boolean wall = true;
            for (int row = 1; row < size; ++row) {
                if (map[row - 1][col] == '.' && map[row][col] == '.') {
                    if (wall) {
                        ++height;
                        wall = false;
                    }
                    continue;
                }
                wall = true;
            }
        }
    }

    public void answer() {
        System.out.print(width + " " + height);
    }
}
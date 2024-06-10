package implementation.p2566;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2566/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Board board = Board.of();
        for (int row = 0; row < board.SIZE; row++) {
            board.setRow(row, br.readLine());
        }
        board.answer();
    }
}

class Board {
    public final int SIZE = 9;
    private final Data[][] board = new Data[SIZE][SIZE];
    private Data max;

    Board() {
        max = Data.of(0, 0, Integer.MIN_VALUE);
    }

    public void setRow(int row, String line) {
        String[] data = line.split(" ");
        for (int col = 0; col < SIZE; col++) {
            int tmpNumber = Integer.parseInt(data[col]);
            if (max.getNumber() < tmpNumber) {
                max = Data.of(row, col, tmpNumber);
            }
        }
    }

    public void answer() {
        System.out.println(max.getNumber());
        System.out.print(max.getPosition());
    }

    public static Board of() {
        return new Board();
    }
}

class Data {
    private final int row;
    private final int col;
    private final int number;

    public Data(int row, int col, int number) {
        this.row = row;
        this.col = col;
        this.number = number;
    }

    public static Data of(int row, int col, int number) {
        return new Data(row, col, number);
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return (row + 1) + " " + (col + 1);
    }
}
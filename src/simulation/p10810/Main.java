package simulation.p10810;

import simulation.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Simulation.PATH + "/p10810/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        int size = Integer.parseInt(data[0]);
        int inputBallCount = Integer.parseInt(data[1]);

        Room room = new Room(size);
        for (int i = 0; i < inputBallCount; i++) {
            room.addBall(br.readLine());
        }
        room.answer();
    }
}

class Room {
    private final List<Basket> baskets;

    Room(int size) {
        this.baskets = new ArrayList<>(size + 1);
        for (int i = 0; i <= size; i++) {
            this.baskets.add(new Basket());
        }
    }

    public void addBall(String line) {
        String[] data = line.split(" ");
        addBall(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }

    public void addBall(int startIndex, int endIndex, int number) {
        for (int i = startIndex; i <= endIndex; i++) {
            baskets.get(i).setNumber(number);
        }
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < baskets.size(); i++) {
            sb.append(baskets.get(i).getNumber()).append(" ");
        }
        System.out.print(sb);
    }
}

class Basket {
    private int number;

    Basket() {
        this.number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
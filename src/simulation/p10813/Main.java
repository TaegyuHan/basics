package simulation.p10813;

import simulation.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Simulation.PATH + "/p10813/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        int size = Integer.parseInt(data[0]);
        int changeCount = Integer.parseInt(data[1]);

        Room room = new Room(size);
        for (int i = 0; i < changeCount; i++) {
            room.changeBasket(br.readLine());
        }
        room.answer();
    }
}

class Room {
    private final List<Basket> baskets;

    Room(int size) {
        this.baskets = new ArrayList<>(size);
        for (int i = 0; i <= size; i++) {
            this.baskets.add(new Basket(i));
        }
    }

    public void changeBasket(String line) {
        String[] data = line.split(" ");
        changeBasket(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public void changeBasket(int index1, int index2) {
        Basket basket1 = this.baskets.get(index1);
        Basket basket2 = this.baskets.get(index2);
        basket1.numberChange(basket2);
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < this.baskets.size(); i++) {
            sb.append(baskets.get(i));
        }
        System.out.print(sb);
    }
}

class Basket {
    private int number;

    Basket(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void numberChange(Basket other) {
        int tmp = number;
        this.number = other.getNumber();
        other.setNumber(tmp);
    }

    @Override
    public String toString() {
        return this.number + " ";
    }
}
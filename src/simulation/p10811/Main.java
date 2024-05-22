package simulation.p10811;

import simulation.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Simulation.PATH + "/p10811/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        int size = Integer.parseInt(data[0]);
        int reverseCount = Integer.parseInt(data[1]);

        Room room = new Room(size);
        for (int i = 0; i < reverseCount; i++) {
            room.removeBasket(br.readLine());
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

    public void removeBasket(String line) {
        String[] data = line.split(" ");
        removeBasket(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public void removeBasket(int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            // 변경
            Basket basket1 = this.baskets.get(startIndex++);
            Basket basket2 = this.baskets.get(endIndex--);
            basket1.change(basket2);
        }
    }

    public void answer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < this.baskets.size(); i++) {
            sb.append(this.baskets.get(i));
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

    public void change(Basket other) {
        int tmp = other.getNumber();
        other.setNumber(number);
        number = tmp;
    }

    @Override
    public String toString() {
        return number + " ";
    }
}
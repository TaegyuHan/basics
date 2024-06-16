package implementation.p2477;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p2477/data/4.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        KoreanMelonField kmf = KoreanMelonField.of(br.readLine());
        for (int i = 0; i < KoreanMelonField.INPUT_COUNT; ++i) {
            kmf.setData(br.readLine());
        }
        kmf.calculate();
        kmf.answer();
    }
}

enum QuadrangleType {
    S1(0, 2),
    S2(1, 3),
    S3(2, 1),
    S4(3, 0);

    private final int side0;
    private final int side1;

    QuadrangleType(int side0, int side1) {
        this.side0 = side0;
        this.side1 = side1;
    }

    public boolean isEqual(int side0, int side1) {
        return this.side0 == side0 && this.side1 == side1;
    }
}

class KoreanMelonField {
    private final int count;
    public final static int INPUT_COUNT = 6;
    public final static int SIDE_COUNT = 4;
    public final static int DATA_DEPTH = 2;
    private int index;
    private final int[][] originData;
    int[][] data;
    private int koreanMelonCount;

    KoreanMelonField(int count) {
        this.count = count;
        this.data = new int[SIDE_COUNT][DATA_DEPTH];
        this.originData = new int[INPUT_COUNT][DATA_DEPTH];
        this.koreanMelonCount = 0;
        this.index = 0;
    }

    public static KoreanMelonField of(String line) {
        return KoreanMelonField.of(Integer.parseInt(line));
    }

    public static KoreanMelonField of(int count) {
        return new KoreanMelonField(count);
    }

    public void setData(String line) {
        String[] data = line.split(" ");
        setData(Integer.parseInt(data[0]) - 1, Integer.parseInt(data[1]));
    }

    public void setData(int index, int length) {
        if (this.data[index][0] != 0) {
            this.data[index][1] = length;
        } else {
            this.data[index][0] = length;
        }
        this.originData[this.index][0] = index;
        this.originData[this.index][1] = length;
        ++this.index;
    }

    public void answer() {
        System.out.print(this.koreanMelonCount);
    }

    public void showData() {
        StringBuilder sb = new StringBuilder(SIDE_COUNT * DATA_DEPTH * 2);

        for (int[] datum : this.data) {
            sb.append(datum[0]).append(" ").append(datum[1]).append("\n");
        }

        sb.append("\n");

        for (int[] originDatum : this.originData) {
            sb.append(originDatum[0]).append(" ").append(originDatum[1]).append("\n");
        }
        System.out.println(sb);
    }

    private int maxQuadrangleSize() {
        int width = Math.max(
                Math.max(this.data[0][0], this.data[0][1]),
                Math.max(this.data[1][0], this.data[1][1])
        );

        int high = Math.max(
                Math.max(this.data[2][0], this.data[2][1]),
                Math.max(this.data[3][0], this.data[3][1])
        );
        return width * high;
    }

    private int minQuadrangleSize() {
        int side0 = 0;
        int side1 = 0;

        minSizeFindLoop:
        for (int i = 0; i < this.originData.length; ++i) {
            int ni = (i + 1) % (this.originData.length);
            int type0 = this.originData[i][0];
            int type1 = this.originData[ni][0];

            for (QuadrangleType quadrangle : QuadrangleType.values()) {
                if (quadrangle.isEqual(type0, type1)) {
                    side0 = this.originData[i][1];
                    side1 = this.originData[ni][1];
                    break minSizeFindLoop;
                }
            }
        }
        return side0 * side1;
    }

    public void calculate() {
        int maxSize = maxQuadrangleSize();
        int minSize = minQuadrangleSize();
        this.koreanMelonCount = (maxSize - minSize) * count;
    }
}
package sort.p2750;


import sort.Sort;

import java.io.*;

/**
 * URL : <a href="https://www.acmicpc.net/problem/2750">문제 Link</a> <br>
 * 문제명 : 수 정렬하기
 * <p>
 * BigO : O(N) <br>
 * 문제의 내용 : 기본적인 정수 정렬 문제 입니다.
 *
 * N(1 ≤ N ≤ 1,000)
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream( Sort.PATH + "/p2750/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        BubbleSort bs = new BubbleSort(size, arr);
        bs.sort();
        bs.answer();
    }
}

class BubbleSort {

    private int size;
    private int[] arr;

    public BubbleSort(int size, int[] arr) {
        this.size = size;
        this.arr = arr;
    }

    public void sort() {
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size - i; ++j) {

                if ((size) < j + 2) { continue; }

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void answer() {
        for (int i = 0; i < size; ++i) {
            System.out.println(arr[i]);
        }
    }
}
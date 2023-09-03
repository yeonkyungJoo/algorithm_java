package basic.ch6;

import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int minIdx = i;
            for (int j = i; j < N; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = tmp;
        }

        for (int n : array) {
            System.out.print(n + " ");
        }
    }
}

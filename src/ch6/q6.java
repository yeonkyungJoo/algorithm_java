package ch6;

import java.util.Arrays;
import java.util.Scanner;

public class q6 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int[] changed = array.clone();
        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            if (array[i] != changed[i]) {
                System.out.print(i+1 + " ");
            }
        }
    }
}

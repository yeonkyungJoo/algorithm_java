package basic.ch7;

import java.util.Scanner;

public class q4_ {

    static int[] arr;
    public static int fibo(int i) {

        if (arr[i] > 0) {
            return arr[i];
        }

        if (i <= 2) {
            return arr[i] = 1;
        }

        arr[i] = fibo(i - 2) + fibo(i - 1);
        return arr[i];
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        arr = new int[N + 1];
        fibo(N);
        for (int i = 1; i < N + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

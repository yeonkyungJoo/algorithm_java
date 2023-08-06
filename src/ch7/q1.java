package ch7;

import java.util.Scanner;

public class q1 {

    public static void recursive(int N) {

        if (N <= 0) {
            return;
        }
        recursive(N - 1);
        System.out.print(N + " ");
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        recursive(N);
    }
}

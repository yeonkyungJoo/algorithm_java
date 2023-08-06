package ch7;

import java.util.Scanner;

public class q3 {

    public static int factorial(int N) {

        if (N == 1) {
            return 1;
        }
        return factorial(N - 1) * N;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        System.out.println(factorial(N));
    }
}

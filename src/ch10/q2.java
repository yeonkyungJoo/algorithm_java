package ch10;

import java.util.Scanner;

public class q2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] answer = new int[N+1];

        answer[1] = 2;
        answer[2] = 3;
        for (int i = 3; i < N + 1; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }
        System.out.println(answer[N]);
    }
}

package basic.ch3;

import java.util.Scanner;

public class q1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = in.nextInt();
        }

        int M = in.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = in.nextInt();
        }

        int[] answer = new int[N + M];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < N && p2 < M) {
            int n1 = arr1[p1];
            int n2 = arr2[p2];
            if (n1 <= n2) {
                answer[i] = n1;
                p1 += 1;
            } else {
                answer[i] = n2;
                p2 += 1;
            }
            i += 1;
        }

        if (p1 != N) {
            for (int j = p1; j < N; j++) {
                answer[i] = arr1[j];
                i += 1;
            }
        }

        if (p2 != M) {
            for (int j = p2; j < M; j++) {
                answer[i] = arr2[j];
                i += 1;
            }
        }

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}

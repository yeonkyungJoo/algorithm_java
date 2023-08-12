package ch8;

import java.util.Scanner;

public class q6 {

    static int N, M;
    static int[] array;

    static int[] ch;
    static int[] answer;
    static void dfs(int idx) {

        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                answer[idx] = array[i];
                dfs(idx + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        ch = new int[N];
        answer = new int[M];
        dfs(0);
    }
}

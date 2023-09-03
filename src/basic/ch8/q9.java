package basic.ch8;

import java.util.Scanner;

public class q9 {

    static int N, M;
    static int[] ch;
    static int[] array;

    static void dfs(int idx, int k) {

        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = k + 1; i < N + 1; i++) {
//            if (ch[i] == 0) {
//                ch[i] = 1;
                array[idx] = i;
                dfs(idx + 1, i);
//                ch[i] = 0;
//            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        ch = new int[N + 1];
        array = new int[N];

        dfs(0, 0);
    }
}

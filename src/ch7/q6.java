package ch7;

import java.util.Scanner;

public class q6 {

    static int N;
    static int[] ch;
    static void dfs(int n) {

        if (n == N + 1) {
            String tmp = "";
            for (int i = 1; i < N + 1; i++) {
                if (ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
            return;
        }

        ch[n] = 1;
        dfs(n+1);

        ch[n] = 0;
        dfs(n+1);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();

        ch = new int[N + 1];
        dfs(1);
    }
}

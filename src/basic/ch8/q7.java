package basic.ch8;

import java.util.Scanner;

public class q7 {

    static int n, r;
    static int[][] array;

    static int dfs(int n, int r) {

        if (array[n][r] != 0) {
            return array[n][r];
        }

        if (r == n || r == 0) {
            return array[n][r] = 1;
        }

        if (r == 1) {
            return array[n][1] = array[n][n-1] = n;
        }

        array[n][r] = array[n][n-r] = dfs(n-1, r-1) + dfs(n-1, r);
        return array[n][r];
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();

        array = new int[n + 1][n + 1];
        dfs(n, r);
        System.out.println(array[n][r]);
    }
}

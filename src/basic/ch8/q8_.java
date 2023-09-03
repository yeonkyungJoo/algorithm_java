package basic.ch8;

import java.util.Scanner;

public class q8_ {

    static int N, F;
    static int[] ch;
    static int[] array;
    static int[] nums;

    static void dfs(int idx) {

        if (idx == N) {

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += nums[i] * array[i];
            }

            if (sum == F) {
                for (int i = 0; i < N; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                System.exit(0);
            }

            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                array[idx] = i;
                dfs(idx + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        F = in.nextInt();
        ch = new int[N + 1];
        array = new int[N];

        nums = new int[N];
        nums[0] = 1;
        for (int i = 1; i < N; i++) {
            nums[i] = (N - i) * nums[i - 1] / i;
        }

        dfs(0);
    }
}

package basic.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q2 {

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

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < N && p2 < M) {
            int n1 = arr1[p1];
            int n2 = arr2[p2];
            if (n1 < n2) {
                p1 += 1;
            } else if (n1 > n2) {
                p2 += 1;
            } else {
                // n1 == n2
                answer.add(n1);
                p1 += 1;
                p2 += 1;
            }
        }

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}

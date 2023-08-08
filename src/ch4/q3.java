package ch4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            queue.offer(arr[i]);
        }

        System.out.print(new HashSet<>(queue).size() + " ");
        for (int i = K; i < N; i++) {
            queue.poll();
            queue.offer(arr[i]);
            System.out.print(new HashSet<>(queue).size() + " ");
        }
    }
}

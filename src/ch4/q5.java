package ch4;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class q5 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Set<Integer> set = new TreeSet<>((o1, o2) -> {
            if (o1 > o2) {
                return -1;
            } else if (o1.equals(o2)) {
                return 0;
            } else {
                return 1;
            }
        });
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    set.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        Integer[] result = set.toArray(new Integer[0]);
        if (result.length < K) {
            System.out.println(-1);
        } else {
            System.out.println(result[K-1]);
        }
    }
}

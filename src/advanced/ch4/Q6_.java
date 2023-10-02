package advanced.ch4;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q6_ {

    public int solution(int[] tasks, long k) {

        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            int task = tasks[i];
            list.add(new int[]{task, i});
        }
        list.sort(Comparator.comparingInt(o -> o[0]));

        int minus = 0;
        int idx = 0;
        int rest = tasks.length;
        while (idx < tasks.length) {
            int[] cur = list.get(idx);
            int n = cur[0];
            int m = (n - minus) * rest;

            if (k >= m) {
                k -= m;
                rest--;
                minus += (n - minus);
            } else {
                break;
            }

            idx++;
        }

        if (rest == 0) {
            return -1;
        }

        // 2, 5 / 7, 8, 9, 10
        return (int) ((k % rest) + idx) + 1;
    }

    public static void main(String[] args){
        Q6_ T = new Q6_();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

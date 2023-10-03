package advanced.ch3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q3_ {

    public int[] solution(int[] arrival, int[] state){

        int n = arrival.length;
        int[] answer = new int[n];

        Queue<Integer> in = new LinkedList<>();
        Queue<Integer> out = new LinkedList<>();

        // 0 : 들어오는 사원, 1 : 나가는 사원
        int prev = 1;
        int count = 0;
        for (int t = 0, i = 0; t <= 200000; t++) {

            if (in.isEmpty() && out.isEmpty()) {
                prev = 1;
                t = arrival[i];
            }

            while (i < n && arrival[i] <= t) {
                int s = state[i];
                if (s == 0) {
                    in.add(i);
                } else {
                    out.add(i);
                }

                i++;
            }

            int idx;
            if (prev == 0) {
                // 1초 전 : 들어오는 사람
                if (!in.isEmpty()) {
                    idx = in.poll();
                } else {
                    idx = out.poll();
                    prev = 1;
                }

            } else {
                // 1초 전 : 나가는 사람
                if (!out.isEmpty()) {
                    idx = out.poll();
                } else {
                    idx = in.poll();
                    prev = 0;
                }
            }
            answer[idx] = t;
            count++;
            if (n == count) {
                break;
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Q3_ T = new Q3_();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}

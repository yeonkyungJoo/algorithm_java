package advanced.ch4;

import java.util.*;
public class Q3 {

    static class Pair {
        int x;
        int y;
        int diff;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.diff = x - y;
        }
    }

    public int solution(int[] nums, int k){
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((o1, o2) -> o2 - o1);

        int n = nums.length;
        // (12, 12), (8, 7), (5, 3), (3, 1), (1, 1)
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i+=2) {
            pairs.add(new Pair(list.get(i), list.get(i+1)));
        }
        pairs.sort((o1, o2) -> o2.diff - o1.diff);

        for (int i = 0; i < n / 2; i++) {
            if (k > 0) {
                answer += pairs.get(i).x;
                k--;
            } else {
                answer += pairs.get(i).y;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q3 T = new Q3();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}

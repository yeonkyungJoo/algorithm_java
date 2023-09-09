package advanced.ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1 {
    public int solution(int[] nums){

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            queue.offer(num);
        }

        int[] ordered = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            ordered[i] = queue.poll();
            i += 1;
        }

        int[] result = new int[nums.length];
        int answer = 1;
        Arrays.fill(result, 1);
        for (int j = 1; j < nums.length; j++) {
            if (ordered[j - 1] + 1 == ordered[j]) {
                result[j] = result[j - 1] + 1;
            } else if (ordered[j - 1] == ordered[j]) {
                result[j] = result[j - 1];
            } else {
                result[j] = 1;
            }

            answer = Integer.max(answer, result[j]);
        }

        return answer;
    }

    public static void main(String[] args){
        Q1 T = new Q1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
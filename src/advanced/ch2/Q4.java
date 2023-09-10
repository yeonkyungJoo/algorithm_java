package advanced.ch2;

import java.util.*;

public class Q4 {

    public int solution(int[] nums, int m){
        int answer = 0;

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            answer += map.getOrDefault(sum - m, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        Q4 T = new Q4();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}

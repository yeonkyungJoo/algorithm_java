package advanced.ch5;

import java.util.Arrays;

public class Q1 {

    public int solution(int[] nums, int m){
        int answer = 0;

        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (l == r) {
                answer++;
                break;
            } else {
/*
                if (nums[r] > m) {
                    r--;
                    answer++;
                    continue;
                }

                if (nums[l] > m) {
                    l++;
                    answer++;
                    continue;
                }
*/

                if (nums[l] + nums[r] <= m) {
                    answer++;
                    l++;
                    r--;
                } else {
                    answer++;
                    r--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Q1 T = new Q1();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}

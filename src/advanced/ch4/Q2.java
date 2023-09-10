package advanced.ch4;

import java.util.Arrays;

public class Q2 {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        int[] array = new int[100001];
        for (int num : nums) {
            array[num] += 1;
        }

        Arrays.sort(nums);
        int idx = answer.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num % 2 == 0) {
                int divided = num / 2;
                if (array[divided] > 0) {
                    array[divided] -= 1;
                    answer[idx] = divided;
                    idx--;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args){
        Q2 T = new Q2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}

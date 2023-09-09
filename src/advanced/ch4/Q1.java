package advanced.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Number {
    int num;
    int count;

    public Number(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

public class Q1 {

    private int count(int num) {
        int result = 0;

        while (num > 0) {
            int n = num % 2;
            if (n == 1) {
                result++;
            }
            num /= 2;
        }

        return result;
    }

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];

        List<Number> numbers = new ArrayList<>(nums.length);
        for (int num : nums) {
            numbers.add(new Number(num, count(num)));
        }

        numbers.sort((o1, o2) -> {
            if (o2.count == o1.count) {
                return o1.num - o2.num;
            }
            return o1.count - o2.count;
        });

        for (int i = 0; i < nums.length; i++) {
            answer[i] = numbers.get(i).num;
        }
        return answer;
    }

    public static void main(String[] args){
        Q1 T = new Q1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
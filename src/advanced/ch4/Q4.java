package advanced.ch4;

import java.util.Arrays;

public class Q4 {

    public int solution(int[] score, int k){
        Arrays.sort(score);

        int answer = 0;
        for (int l = 0; l < score.length - k; l++) {
            int r = l + (k - 1);
            if (score[r] - score[l] <= 10) {
                for (int i = l; i <= r; i++) {
                    answer += score[i];
                }
                return answer / k;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        Q4 T = new Q4();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}

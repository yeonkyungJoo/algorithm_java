package advanced.ch2;

import java.util.Arrays;

public class Q2 {

    public int[] solution(String s){
        int[] answer = new int[5];

        char[] array = s.toCharArray();
        for (int c : array) {
            answer[c - 'a'] += 1;
        }

        int max = 0;
        for (int n : answer) {
            if (n > max) {
                max = n;
            }
        }

        for (int i = 0; i < 5; i++) {
            answer[i] = max - answer[i];
        }

        return answer;
    }

    public static void main(String[] args){
        Q2 T = new Q2();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}

package advanced.ch1;

import java.util.*;
public class Q1 {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        for(int i = 0; i < n; i++){
            answer[i] = (char)(i + 65);
        }

        for(int[] line : ladder){
            for(int x : line){
                char tmp = answer[x];
                answer[x] = answer[x-1];
                answer[x-1] = tmp;
            }
        }
/*
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < n; i++) {
            int curIndex = i + 1;
            char name = alphabet.charAt(i);

            for (int j = 0; j < ladder.length; j++) {

                for (int k = 0; k < ladder[j].length; k++) {
                    if (ladder[j][k] == curIndex) {
                        curIndex += 1;
                    } else if (ladder[j][k] == curIndex - 1) {
                        curIndex -= 1;
                    }
                }
            }

            answer[curIndex - 1] = name;
        }*/

        return answer;
    }

    public static void main(String[] args){
        Q1 T = new Q1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
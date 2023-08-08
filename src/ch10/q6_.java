package ch10;

import java.util.Scanner;

public class q6_ {

    static class Quiz {
        int score;
        int time;

        public Quiz(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Quiz[] array = new Quiz[N];
        int s, t;
        for (int i = 0; i < N; i++) {
            s = in.nextInt();
            t = in.nextInt();
            array[i] = new Quiz(s, t);
        }

        int[] answer = new int[M+1];
        for (int j = 0; j < N; j++) {
            Quiz quiz = array[j];
            for (int i = M; i >= quiz.time; i--) {
                answer[i] = Integer.max(answer[i], answer[i - quiz.time] + quiz.score);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int n: answer) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println(max);
    }
}

package ch8;

import java.util.Scanner;

public class q3 {

    static class Quiz {
        int score;
        int time;

        public Quiz(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    static int N, M;
    static Quiz[] array;
    static int answer = 0;
    static void dfs(int idx, int totalScore, int totalTime) {

        if (totalTime > M) {
            return;
        }

        if (idx == N) {
            answer = Integer.max(answer, totalScore);
            return;
        }

        dfs(idx + 1, totalScore + array[idx].score, totalTime + array[idx].time);
        dfs(idx + 1, totalScore, totalTime);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        array = new Quiz[N];
        int s, t;
        for (int i = 0; i < N; i++) {
            s = in.nextInt();
            t = in.nextInt();
            array[i] = new Quiz(s, t);
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }
}

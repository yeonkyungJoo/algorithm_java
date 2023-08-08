package ch9;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q4_ {

    static class Request implements Comparable<Request> {
        int day;
        int money;

        public Request(int day, int money) {
            this.day = day;
            this.money = money;
        }

        @Override
        public int compareTo(Request o) {
            if (this.day == o.day) {
                return o.money - this.money;
            }
            return o.day - this.day;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Request[] array = new Request[N];
        int M, D;
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            M = in.nextInt();
            D = in.nextInt();
            array[i] = new Request(D, M);
            if (D > maxDay) {
                maxDay = D;
            }
        }

        Arrays.sort(array);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        Request request = null;
        int answer = 0;
        while (maxDay > 0) {

            while (i < N) {
                request = array[i];
                if (request.day >= maxDay) {
                    pq.offer(request.money);
                    i++;
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
            maxDay--;
        }
        System.out.println(answer);
    }
}

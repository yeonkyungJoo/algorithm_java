package basic.ch9;

import java.util.Arrays;
import java.util.Scanner;

public class q2_ {

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Meeting[] array = new Meeting[N];
        int s, e;
        for (int i = 0; i < N; i++) {
            s = in.nextInt();
            e = in.nextInt();
            array[i] = new Meeting(s, e);
        }

        Arrays.sort(array);
        int answer = Integer.MIN_VALUE;
        int count = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (array[i].start >= end) {
//                System.out.println(array[i].start + " " + array[i].end);
                count += 1;
                end = array[i].end;
            }
            answer = Integer.max(answer, count);
        }

        System.out.println(answer);
    }
}

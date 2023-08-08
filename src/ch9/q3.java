package ch9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q3 {

    static class Time {
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<Time> list = new ArrayList<>();
        int s, e;
        for (int i = 0; i < N; i++) {
            s = in.nextInt();
            list.add(new Time(s, 'c'));
            e = in.nextInt();
            list.add(new Time(e, 'l'));
        }

        list.sort((o1, o2) -> {
            if (o1.time == o2.time) {
                // c < l
                return o2.state - o1.state;
            }
            return o1.time - o2.time;
        });

        int count = 0;
        int answer = 0;
        for (Time time : list) {
//            System.out.println(time.time + " " + time.state);
            if (time.state == 'c') {
                count += 1;
            } else {
                count -= 1;
            }
            answer = Integer.max(answer, count);
        }
        System.out.println(answer);
    }
}

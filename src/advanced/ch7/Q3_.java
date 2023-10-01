package advanced.ch7;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_ {

    public int solution(int s, int e){

        Queue<Integer> queue = new LinkedList<>();
        int[][] checked = new int[2][200001];
        queue.add(s);
        checked[0][s] = 1;
        int second = 0;

        int cow = e;
        int cowMove = 1;
        while (!queue.isEmpty()) {

            second++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer x = queue.poll();

                if (x * 2 >= 0 && x * 2 <= 200000
                        && checked[second % 2][x * 2] == 0) {
                    checked[second % 2][x * 2] = 1;
                    queue.add(x * 2);
                }

                if (x + 1 >= 0 && x + 1 <= 200000
                        && checked[second % 2][x + 1] == 0) {
                    checked[second % 2][x + 1] = 1;
                    queue.add(x + 1);
                }

                if (x - 1 >= 0 && x - 1 <= 200000
                        && checked[second % 2][x - 1] == 0) {
                    checked[second % 2][x - 1] = 1;
                    queue.add(x - 1);
                }
            }
            cow += cowMove++;
            if (cow > 200000) {
                return -1;
            }

            if (checked[second % 2][cow] == 1) {
                return second;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Q3_ T = new Q3_();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}

package advanced.ch4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q7 {

    public int solution(int[][] meetings){

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < meetings.length; i++) {

            int[] meeting = meetings[i];
            // 0 : begin, 1 : end
            list.add(new int[]{meeting[0], 0});
            list.add(new int[]{meeting[1], 1});
        }
        // (0, 0), (2, 0), (5, 1), (5, 0), (10, 1), (12, 0), (15, 1), (25, 1)
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[0];
                }
                return o1[0] - o2[0];
            }
        });

        int count = 0;
        int answer = Integer.MIN_VALUE;
        for (int[] meeting : list) {
            if (meeting[1] == 0) {
                count++;
            } else {
                count--;
            }
            answer = Integer.max(answer, count);
        }
        return answer;
    }

    public static void main(String[] args){
        Q7 T = new Q7();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}

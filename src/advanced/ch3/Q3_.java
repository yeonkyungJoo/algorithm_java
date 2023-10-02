package advanced.ch3;

import java.util.*;

public class Q3_ {

    public int[] solution(int[] arrival, int[] state){

        Map<Integer, List<int[]>> map = new HashMap<>();
        int n = arrival.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arrival[i], new ArrayList<>());
            map.get(arrival[i]).add(new int[]{i, state[i]});
        }

        Comparator<int[]> inFirst = (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        };

        Comparator<int[]> outFirst = (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        };

        Queue<int[]> queue = new LinkedList<>();
        int second = 0;
        for (Integer arrivalTime : map.keySet()) {

//            if (queue.isEmpty()) {
//                queue.add()
//            }
        }

/*
0초 : 나감
1초 : 들어옴, 들어옴, 나감
2초 : 들어옴
3초 : 들어옴
8초 : 나감
8초 : 들어옴
*/

/*
        int second = 0;
        for (int[] s : list) {
            int index = s[0];
            int arrivalTime = s[1];

            int time = arrivalTime;
            if (second >= arrivalTime) {
                time = second;
            } else {
                // second < arrivalTime
                second = arrivalTime;
            }
            answer[index] = time;
            second++;
        }*/
        return answer;
    }

    public static void main(String[] args){
        Q3_ T = new Q3_();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}

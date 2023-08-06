package ch4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String str = in.next();
        char[] array = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char c = array[i];
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

//        System.out.println(map);
        char answer = ' ';
        int max = -1;
        for (Character c : map.keySet()) {
            if (max < map.get(c)) {
                max = map.get(c);
                answer = c;
            }
        }
        System.out.println(answer);
    }
}

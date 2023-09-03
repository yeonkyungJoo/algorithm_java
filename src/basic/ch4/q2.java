package basic.ch4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1 = in.next().toUpperCase();
        String s2 = in.next().toUpperCase();
//        System.out.println(s1 + " " + s2);

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean result = true;
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                result = false;
                break;
            }
            map.put(c, map.get(c) - 1);
        }

        if (result) {
            for (char c : map.keySet()) {
                if (map.get(c) != 0) {
                    result = false;
                }
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

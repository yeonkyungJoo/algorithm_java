package ch4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class q4 {

    private static boolean isAnagram(String s1, String s2) {
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
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String S = in.next();
        String T = in.next();

        char[] arr = S.toCharArray();
        int size = T.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length() - size + 1; i++) {
            sb.append(arr, i, i + size);
            System.out.println(sb);
            sb.deleteCharAt(i);
            sb.append(arr[i+size]);
        }
    }
}

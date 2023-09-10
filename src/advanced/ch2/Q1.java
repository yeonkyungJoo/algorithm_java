package advanced.ch2;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public int solution(String s) {

        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i + 1;
            }
        }

        return -1;
    }
/*
    public int solution(String s){

        char[] array = s.toCharArray();
        boolean[] duplicated = new boolean[array.length];

        int size = s.length();
        for (int i = 0; i < size; i++) {

            if (duplicated[i]) {
                continue;
            }

            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    duplicated[i] = duplicated[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (!duplicated[i]) {
                return i + 1;
            }
        }
        return -1;
    }
*/
    public static void main(String[] args){
        Q1 T = new Q1();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
package advanced.ch2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {

    public int solution(String s){
        int answer = 0;

        Map<Character, Integer> count = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (Character c : count.keySet()) {
            int value = count.get(c);
            while (set.contains(value)) {
                value -= 1;
                answer += 1;
            }
            if (value == 0) {
                continue;
            }
            set.add(value);
        }
        return answer;
    }


    public static void main(String[] args){
        Q3 T = new Q3();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}

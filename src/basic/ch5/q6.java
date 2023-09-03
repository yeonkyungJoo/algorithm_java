package basic.ch5;

import java.util.*;

public class q6 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            list.add(i);
        }
        Queue<Integer> queue = new LinkedList<>(list);

        int count = 1;
        while (queue.size() != 1) {
            Integer n = queue.poll();
            if (count != K) {
                queue.offer(n);
                count += 1;
            } else {
                count = 1;
            }
        }

        System.out.println(queue.poll());
    }
}

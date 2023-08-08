package ch7;

import java.util.LinkedList;
import java.util.Queue;

public class q10 {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                assert node != null;
                if (node.lt == null && node.rt == null) {
                    System.out.println(count + 1);
                    return;
                }

                if (node.lt != null) {
                    queue.offer(node.lt);
                }
                if (node.rt != null) {
                    queue.offer(node.rt);
                }
            }
            count++;
        }
    }
}

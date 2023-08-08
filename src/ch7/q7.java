package ch7;

import java.util.LinkedList;
import java.util.Queue;

public class q7 {

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
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.lt != null) {
                queue.offer(node.lt);
            }
            if (node.rt != null) {
                queue.offer(node.rt);
            }
        }
    }
}

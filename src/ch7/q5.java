package ch7;

public class q5 {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void dfs(Node node) {

        if (node == null) {
            return;
        }

        dfs(node.lt);
        dfs(node.rt);
        System.out.print(node.data + " ");
    }


    public static void main(String[] args) {

        // 1, 2, 3, 4, 5, 6, 7
        // 전위
        // 중위
        // 후위
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        dfs(root);
    }
}

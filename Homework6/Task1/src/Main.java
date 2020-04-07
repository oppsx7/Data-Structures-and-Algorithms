import org.w3c.dom.Node;

import java.util.Scanner;

public class Main {

    static class Node {
        private double value;
        private Node left;
        private Node right;
        private int height;

        public Node(double value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    static class AVLTree {
        private Node root;

        public boolean containsRecursive(Node current, double value) {
            if (current == null) {
                return false;
            }

            if (current.value == value) {
                return true;
            }

            if (value < current.value) {
                return containsRecursive(current.left, value);
            } else {
                return containsRecursive(current.right, value);
            }
        }

        public void printRecursive(Node current) {
            if (current == null) {
                return;
            }

            printRecursive(current.left);
            System.out.println(current.value);
            printRecursive(current.right);
        }


        public AVLTree() {
            root = null;
        }

        public void add(double value) {
            if (contains(value))
                System.out.println(value + " already added");
            root = add(value, root);


        }

        public Node add(double value, Node node) {

            if (root == null)
                return new Node(value, null, null);
            else if (value < root.value) {
                root.left = add(value, root.left);
                if (height(node.left) - height(node.right) == 2) {
                    if (value < node.left.value)
                        node = rotateWithLeftChild(node);
                    else
                        node = doubleWithLeftChild(node);
                }
            } else if (value > node.value) {
                node.right = add(value, node.right);
                if (height(node.right) - height(node.left) == 2)
                    if (value > node.right.value)
                        node = rotateWithRightChild(node);
                    else
                        node = doubleWithRightChild(node);
            } else
                ;
            node.height = max(height(node.left), height(node.right)) + 1;

            return node;

        }

        public void remove(double value) {

            root = remove(value, root);
        }

        public Node remove(double value, Node root) {
            if (root == null)
                return root;

            if (value < root.value)
                root.left = remove(value, root.left);

            else if (value > root.value)
                root.right = remove(value, root.right);

            else {

                if ((root.left == null) || (root.right == null)) {
                    Node temp = null;
                    if (temp == root.left)
                        temp = root.right;
                    else
                        temp = root.left;

                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else
                        root = temp;
                } else {

                    Node temp = minValueNode(root.right);

                    root.value = temp.value;

                    root.right = remove(temp.value, root.right);
                }
            }

            if (root == null)
                return root;

            root.height = max(height(root.left), height(root.right)) + 1;

            int balance = getBalance(root);

            if (balance > 1 && getBalance(root.left) >= 0)
                return rotateWithRightChild(root);

            if (balance > 1 && getBalance(root.left) < 0) {
                return doubleWithRightChild(root);
            }

            if (balance < -1 && getBalance(root.right) <= 0)
                return rotateWithLeftChild(root);

            if (balance < -1 && getBalance(root.right) > 0) {
                return doubleWithLeftChild(root);
            }

            return root;
        }

        public boolean contains(double value) {
            if (root == null) {
                return false;
            }

            return containsRecursive(root, value);
        }

        public void print() {
            if (root == null) {
                return;
            }

            printRecursive(root);
            System.out.println();
        }

        public int height(Node node) {
            return node == null ? -1 : node.height;
        }

        public int max(int l, int r) {
            return l > r ? l : r;
        }

        public Node rotateWithLeftChild(Node k2) {
            Node k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            k2.height = max(height(k2.left), height(k2.right)) + 1;
            k1.height = max(height(k1.left), k2.height) + 1;
            return k1;
        }

        public Node rotateWithRightChild(Node k1) {
            Node k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            k1.height = max(height(k1.left), height(k1.right)) + 1;
            k2.height = max(height(k2.right), k1.height) + 1;
            return k2;
        }

        public Node doubleWithLeftChild(Node k3) {
            k3.left = rotateWithRightChild(k3.left);
            return rotateWithLeftChild(k3);
        }

        public Node doubleWithRightChild(Node k1) {
            k1.right = rotateWithLeftChild(k1.right);
            return rotateWithRightChild(k1);
        }

        public int getBalance(Node N) {
            if (N == null)
                return 0;
            return height(N.left) - height(N.right);
        }

        public Node minValueNode(Node node) {
            Node current = node;

            while (current.left != null)
                current = current.left;

            return current;
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AVLTree tree = new AVLTree();
        double number = 0;
        int N = input.nextInt();

        for (int i = 0; i < N; i++) {
            String operation = input.next();
            if (operation != "print") {
                number = input.nextDouble();
            }

            if (operation.equals("add")) {
                tree.add(number);
            } else if (operation.equals("remove")) {
                tree.remove(number);
            } else if (operation.equals("contains")) {
                if (tree.contains(number)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if (operation.equals("print")) {
                tree.print();
            }
        }

    }
}


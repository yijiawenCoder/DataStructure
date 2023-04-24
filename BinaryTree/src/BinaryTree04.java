import java.awt.*;

public class BinaryTree04 {
    public static void main(String[] args) {
        int num[] = {50, 27, 80, 10, 35, 61, 90, 1, 45, 46};
        BinaryTree04 binaryTree04 = new BinaryTree04();
        for (int i : num) {
            binaryTree04.add(i);
        }
        binaryTree04.delete(50);
        System.out.println();
    }

    public int size;
    public Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
    }

    public void add(int i) {
        Node n = new Node();
        n.value = i;
        add(n, root);
    }

    public void add(Node n, Node head) {
        if (size == 0) {
            root = n;
            size++;
        } else if (n.value < head.value) {
            if (head.left != null) {
                add(n, head.left);
            } else {
                head.left = n;
                n.parent = head;
                size++;
            }

        } else if (n.value > head.value) {
            if (head.right != null) {
                add(n, head.right);
            } else {
                head.right = n;
                n.parent = head;
                size++;
            }

        }

    }

    public Node find(int i) {
        if (size == 0) {
            return null;
        } else {

            if (i == root.value) {
                return root;
            } else {
                return find(i, root);
            }
        }
    }

    public Node find(int i, Node head) {

     /*   if (i < head.value) {
            if (head.left != null) {
                if (head.left.value == i) {
                    return head.left;
                } else {
                    return find(i, head.left);
                }
            } else {
                return null;
            }
        } else if (i > head.value) {
            if (head.right != null) {
                if (head.right.value == i) {
                    return head.right;

                } else {
                    return find(i, head.right);
                }
            } else {
                return null;
            }
        }
        */
        if (i < head.left.value) {
            if (head.left != null) {
                if (head.left.value == i) {
                    return head.left;
                } else {
                    return find(i, head.left);
                }
            }
            return null;
        } else {
            if (head.right != null) {
                if (head.right.value == i) {
                    return head.right;
                } else {
                    return head.right;
                }
            } else {
                return null;
            }
        }
    }

    public void delete(int i) {
        if (find(i) == null) {
            System.out.println("wu");
        } else {
            Node node = find(i);
            delete(node);
        }

    }

    public void delete(Node n) {

        if (n.left == null && n.right == null) /*删除叶子*/ {
            if (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = null;
            } else {
                n.parent.right = null;
            }
        } else if (n.right == null && n.left != null)/*删除只有左边的节点*/ {

            if (n.parent.left != null && n.parent.left.value == n.value) {
                //在父节点的左边
                n.parent.left = n.left;
                n.left.parent = n.parent;
            } else {
                if (n.parent.right != null && n.parent.right.value == n.value) {
                    //在父节点的右边
                    n.parent.right = n.left;
                    n.left.parent = n.parent;
                }
            }
        }else if(n.right != null && n.left == null)/*删除只有右边的节点*/{
            if (n.parent.left != null && n.parent.left.value == n.value) {
                //在父节点的左边
                n.parent.left = n.right;
                n.right.parent = n.parent;
            } else {
                if (n.parent.right != null && n.parent.right.value == n.value) {
                    //在父节点的右边
                    n.parent.right = n.right;
                    n.right.parent = n.parent;
                }
            }
        }else {
            n.value = findMinRight(n.right).value;
            delete(findMinRight(n.right));

        }
    }
    public Node findMinRight(Node n ){
        if(n.left==null){
            return n;
        }else {
            return findMinRight(n.left);
        }

    }
}
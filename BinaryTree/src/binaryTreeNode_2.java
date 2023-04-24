public class binaryTreeNode_2 {
    public static void main(String[] args) {
        binaryTreeNode_2 treeNode_2 = new binaryTreeNode_2();
        int[] nums = {50, 27,80,10,35, 61, 90,1,45,46};
        for (int i : nums) {
            treeNode_2.add(i);
        }
        //  Node node = treeNode_2.find(30);
   //     treeNode_2.delete(50);
        System.out.println();
    }

    public Node root = new Node();
    public int size;

    class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int value;


    }

    public Node findMinRight(Node n) {
        if (n.left == null) {
            return n;
        } else {
            return findMinRight(n.left);
        }


    }

    public Node find(int i) {
        if (size == 0) {
            return null;
        } else if (i == root.value) {
            return root;
        } else {
            return find(i, root);
        }
    }

    public Node find(int i, Node head) {
        if (i < head.value) {
            if (head.left != null) {

                if (head.left.value == i) {
                    return head.left;
                } else {
                    return find(i, head.left);
                }
            } else {
                return null;
            }

        } else {
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
        } else {
            if (n.value < head.value) {
                if (head.left != null) {
                    add(n, head.left);
                } else {
                    head.left = n;
                    n.parent = head;
                    size++;

                }
            } else {
                if (head.right != null) {
                    add(n, head.right);
                } else {
                    head.right = n;
                    n.parent = head;
                    size++;
                }

            }

        }


    }

    public void delete(int i) {
        if (find(i) == null) {
            System.out.println("没这个元素");
        } else {
            delete(find(i));
        }

    }

    public void delete(Node n) {
        if (n.left == null && n.right == null) {
            if (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = null;
                size--;
            } else {
                n.parent.right = null;
                size--;

            }

        } else if (n.left == null && n.right != null) {
            if (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = n.right;
                n.right.parent = n.parent;
            } else {
                n.parent.right = n.right;
                n.right.parent = n.parent;
            }
           /* if (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = n.right;
                n.right.parent = n.right;
            } else {
                n.parent.right = n.right;
                n.right.parent = n.right;
            }*/
        } else if (n.left != null && n.right == null) {
            if (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = n.left;
                n.left.parent = n.parent;

            } else {
                n.parent.right = n.left;
                n.left.parent = n.parent;
            }
        } else {
            n.value = findMinRight(n.right).value;
            delete(findMinRight(n.right));
        }


    }
}

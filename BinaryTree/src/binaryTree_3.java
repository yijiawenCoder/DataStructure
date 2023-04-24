public class binaryTree_3 {


    public static void main(String[] args) {
        binaryTree_3 binaryTree_3 = new binaryTree_3();
        int[] nums = {50, 27, 80, 10, 35, 61, 90, 1, 45, 46};
        for (int i : nums) {
            binaryTree_3.add(i);
        }
        //  Node node = binaryTree_3.find(50);
        //  Node node = binaryTree_3.find(27);
        binaryTree_3.delete(50);
        System.out.println();
    }

    public int size;
    public Node root;

    public class Node {
        public int value;
        public Node parent;
        public Node left;
        public Node right;
    }

    public void add(int i) {
        Node n = new Node();
        n.value = i;
        if (size == 0) {
            root = n;
            size++;

        } else {
            add(n, root);
        }
    }

    public void add(Node n, Node head) {
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

    public Node find(int i) {
        if (size == 0) {
            return null;
        }
        if (i == root.value) {
            return root;
        } else {
            return find(i, root);
        }
    }

    public Node find(int i, Node head) {
        if (i < head.value) {
            if (head.left != null && head.left.value == i) {

                if (head.left != null) {
                    return head.left;
                } else {
                    return null;

                }
            } else return find(i, head.left);
        } else {
            if (head.right != null && head.right.value == i) {

                if (head.right != null) {
                    return head.right;
                } else {
                    return null;
                }
            } else {
                return find(i, head.right);
            }

        }
    }

    public void delete(int i) {
        if (find(i) == null) {
            System.out.println("没有这个元素");

        } else /*if (find(i).left == null && find(i).right == null)*//*删除二叉树叶子*//* {
            //判断i这个节点是否在i的父节点的左边
            if (find(i).parent.left != null && find(i).parent.left.value == i) {
                find(i).parent.left = null;

            } else {
                find(i).parent.right = null;
            }
        } else */ {
            delete(find(i));
        }
    }

    public Node findMinRight(Node n) {
        if (n.left == null) {
            return n;
        } else {
            return findMinRight(n.left);
        }


    }

    /* public Node findMinRight(Node n) {
         if (n.left == null) {
             return n;
         } else {
             return findMinRight(n.left);
         }
     }
 */
    public void delete(Node n) {
        if (n.left == null && n.right == null) {
            if (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = null;
                size--;
            } else {
                n.parent.right = null;
            }
        }
        //只有右边有值的节点
        else if (n.right != null && n.left == null) {
            //判断i这个节点是否在i的父节点的左边
            if (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = n.right;
                n.right.parent = n.parent;
                size--;
            } else {
                //i节点在i父节点的右边
                n.parent.right = n.right;
                n.right.parent = n.parent;
                size--;

            }

        } else if (n.left != null && n.right == null) {
            //   只有左边有值的节点
            if/*判断i这个节点是否在i的父节点的左边*/ (n.parent.left != null && n.parent.left.value == n.value) {
                n.parent.left = n.left;
                n.left.parent = n.parent;
                size--;

            } else {
                //i节点在父节点的右边
                n.parent.right = n.left;
                n.right.parent = n.parent;
                size--;
            }

        } else if (n.left != null && n.right != null) {

n.value = findMinRight(n.right).value;
delete(findMinRight(n.right));

        }
    }

}

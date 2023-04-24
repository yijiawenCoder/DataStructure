public class binaryTreeNode {
    /*
    简单的二叉树
    1.左小右大
    2.每个节点最多有两个分支
    3.头节点的左边所有的分支都比头节点小，右亦如此

     */
    public static void main(String[] args) {
        binaryTreeNode treeNode = new binaryTreeNode();
        int[] num = {50, 27, 1, 20, 30, 60, 70};
        for (int i : num) {
            treeNode.add(i);
        }
        Node node = treeNode.find(70);
        System.out.println();
        
    }


    class Node {
        public int value;
        public Node left;
        public Node right;
        public Node Parent;


    }

    public Node root;
    public int size;

    /* public Node find(Node n, int i) {
            if (size == 0) {
                return null;
            } else {
                return fide(root, i);
            }
        }
    
        public Node fide(Node head, int i) {
            if (i == root.value) {
                return root;
            } else if (i < root.value) {
                if (root.left != null) {
                    return fide(root.left, i);
                } else {
                    return null;
                }
    
            }else if (i >root.value) {
                if (root.right != null) {
                    return fide(root.right, i);
                } else {
                    return null;
                }
        }
        */

    public Node find(int i) {
        if (i == root.value) {
            return root;
        } else {
            return find(i, root);
        }

    }

    public Node find(int i, Node head) {
        if (i < head.value) {
            if (head.left != null) {
                if (i == head.left.value) {
                    return head.left;
                } else {
                    return find(i, head.left);
                }
            } else {
                return null;
            }
        } else {
            if (head.right != null) {
                if (i == head.right.value) {
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
        Node node = new Node();
        node.value = i;
        add(node, root);
    }

    /* public Node find(Node n, int i) {
         if (size == 0) {
             return null;
         } else {
             return fide(root, i);
         }
     }
 
     public Node fide(Node head, int i) {
         if (i == root.value) {
             return root;
         } else if (i < root.value) {
             if (root.left != null) {
                 return fide(root.left, i);
             } else {
                 return null;
             }
 
         }else if (i >root.value) {
             if (root.right != null) {
                 return fide(root.right, i);
             } else {
                 return null;
             }
     }
 */
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
                    n.Parent = head;
                    size++;
                }
            } else if (n.value > head.value) {
                if (head.right != null) {
                    add(n, head.right);
                } else {
                    head.right = n;
                    n.Parent = head;
                    size++;
                }
            }
       /* if (size == 0) {
           this.root = n;
           size++;

        } else {

            if (n.value < this.root.value) {
                if (root.left != null) {

                    add(n, root.left);

                } else {
                    root.left = n;
                    n.Parent = root;
                    size++;
                }
            } else if (n.value > this.root.value) {
                if (root.right != null) {
                    //
                    add(n, root.right);



                }else {
                    root.right = n;

                    n.Parent=root;
                    size++;

                }

            }
        }*/
        }
    }
}




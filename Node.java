public class Node {
    public Node node;
    public int[] data;
    public int tree;
    public Node[] child;
    public int currenct;
    public boolean leaf;

    BTreeNode(int tree, boolean leaf) {
        this.tree = tree;
        this.leaf = leaf;
        this.data = new int[2 * t - 1];
        this.childPointer = new BTreeNode[2 * t];
        this.currenct = 0;
    }
    public void traverse() {
        for (int i = 0; i < this.currenct; i++) {
            if (this.leaf == false) {
                child[i].traverse();
            }
            System.out.print(data[i] + " ");
            }
        if (leaf == false)
            child[i].traverse();
        }
    
}
import java.util.ArrayList;

public class BinarySearchTree {
  
  class Node {
    int key;
    ArrayList<String> data;

    Node right;
    Node left;

    Node(int key, ArrayList<String> value) {
      this.key = key;
      this.data = value;
    }
  }

  Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  private Node insert(Node node, int key, ArrayList<String> value) {
    if (node == null) {
      return new Node(key, value);
    } else if (key < node.key) {
      node.left = insert(node.left, key, value);
    } else if (key > node.key) {
      node.right = insert(node.right, key, value);
    } return node;
  }

  public void insert(Node node, ArrayList<String> value) {
    root = insert(node, hash(value), value);
  }

  public boolean search(Node node, String value) {
    if (node == null) {
      return false;
    } else if (node.data.contains(value)) {
      return true;
    }
    return search(node.left, value) || search(node.right, value);
  }  

  public Node remove(Node node, ArrayList<String> value) {
    int key = hash(value);
    if (node == null) {
      return null;
    }
    if (key < node.key) {
      node.left = remove(node.left, value);
    } else if (key > node.key) {
      node.right = remove(node.right, value);
    } else {
      // Caso 1: o nó a ser removido é a raiz da árvore
      if (node == root) {
        root = null;
      }
      // Caso 2: o nó a ser removido tem um filho à esquerda
      else if (node.left != null) {
        node = node.left;
      }
      // Caso 3: o nó a ser removido tem um filho à direita
      else if (node.right != null) {
        node = node.right;
      }
      // Caso 4: o nó a ser removido tem dois filhos
      else {
        Node inorderSuccessor = findInorderSuccessor(node.right);
        node.key = inorderSuccessor.key;
        node.data = inorderSuccessor.data;
        node.right = remove(node.right, inorderSuccessor.data);
      }
    }
    return node;
  }

  public void removeValue(Node node, String value) {
    if (node == null) {
      return;
    }
    if (node.data.contains(value)) {
      node.data.remove(value);
      if (node.data.isEmpty()) {
        node = remove(node, node.data);
      }
    }
    removeValue(node.left, value);
    removeValue(node.right, value);
  }
  
  private Node findInorderSuccessor(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
  
  public void edit(Node node, String oldValue, String newValue) {
    if (node == null) {
        return;
    }
    if (node.data.contains(oldValue)) {
        int index = node.data.indexOf(oldValue);
        node.data.set(index, newValue);
    }
    edit(node.left, oldValue, newValue);
    edit(node.right, oldValue, newValue);
  }  

  // Função de hash para gerar um valor de ordenação para uma string
  private int hash(ArrayList<String> str) {
    return str.hashCode();
}

  // Print the tree
  public void print(Node node) {
    if (node == null) {
      return;
    }
    print(node.left);
    System.out.println(node.data);
    print(node.right);
  }
  public static void main(String[] args) {
    ArrayList<String> name = new ArrayList<String>();
    name.add("Meu nome");
    ArrayList<String> phone = new ArrayList<String>();
    phone.add("121234");
    phone.add("763221");
    ArrayList<String> email = new ArrayList<String>();
    email.add("email1@email");
    email.add("email2@email");
    ArrayList<String> address = new ArrayList<String>();
    address.add("Rua 1");
    address.add("Rua 2");
    ArrayList<String> social = new ArrayList<String>();
    social.add("Instagram");
    social.add("Facebook");

    BinarySearchTree b = new BinarySearchTree();
    b.insert(b.root, name);
    b.insert(b.root, phone);
    b.insert(b.root, email);
    b.insert(b.root, address);
    b.insert(b.root, social);
    b.print(b.root);
    System.out.println(" ");
    b.edit(b.root, "Facebook", "Snap");
    b.print(b.root);
    System.out.println(" ");
    b.removeValue(b.root, "Snap");
    b.print(b.root);
  }

}

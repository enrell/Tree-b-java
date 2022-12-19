class BinarySearchTree {
  
  class Node {
    int key;
    String data;

    Node right;
    Node left;

    Node(int key, String value) {
      this.key = key;
      this.data = value;
    }
  }
  Node root;
  public BinarySearchTree() {
    this.root = null;
  }

  private Node insert(Node node, int key, String value) {
    if (node == null) {
      return new Node(key, value);
    }
    if (key < node.key) {
      node.left = insert(node.left, key, value);
    } else if (key > node.key) {
      node.right = insert(node.right, key, value);
    }
    return node;
  }
  
  public void insert(String value) {
    int hash = hash(value);
    root = insert(root, hash, value);
  }

  public boolean sch(Node node, String value) {
    if (node == null) {
      return false;
    }
    if (hash(value) < node.key) {
      return sch(node.left, value);
    } else if (hash(value) > node.key) {
      return sch(node.right, value);
    } else {
      return true;
    }
  }

  public Node remove(Node node, String value) {
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
    if (node.data.equals(oldValue)) {
        node.data = newValue;
        return;
    }
    edit(node.left, oldValue, newValue);
    edit(node.right, oldValue, newValue);
}

  // Função de hash para gerar um valor de ordenação para uma string
  private int hash(String value) {
    // Converte a string em um array de bytes
    byte[] bytes = value.getBytes();
    // Inicializa o valor de hash como zero
    int hash = 0;
    // Itera sobre os bytes da string e atualiza o valor de hash
    for (byte b : bytes) {
      hash = 31 * hash + b;
    }
    return hash;
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

}

public class BTree {
  private static final int t = 2; // Grau mínimo da árvore

  private static class Node {
    int n; // Número de chaves armazenadas no nó
    int[] keys; // Chaves armazenadas no nó
    Node[] child; // Filhos do nó

    Node(int n) {
      keys = new int[2 * n - 1];  // Cria um vetor de chaves com 2n - 1 posições
      child = new Node[2 * n];    //  Cria um vetor de filhos com 2n posições
    }
  }
  private Node root; // Raiz da árvore
  
  // Verifica se o nó é uma folha
  private boolean isLeaf() {
    return child[0] == null;  // Se o primeiro filho for nulo então o nó é uma folha
  }

  private void insertNonFull(int key) {
    int i = n - 1;  // Inicia o i com o último elemento do vetor de chaves
    
    if(isLeaf()) {                     // Se for uma folha inicia um loop que percorre as chaves do nó
      while(i >= 0 && keys[i] > key) { // Verifica se a chave é maior que a chave que está sendo inserida.
        keys[i + 1] = keys[i];         // Se for ele move o a chave para o próximo espaço do vetor
        i--;                           // e decrementa o i para apontar para a chave anterior, agora vazia.
      }
      keys[i] = key;                   // Quando o loop acaba ele insere a chave no espaço vazio.
      n++;                             // e incrementa o n para indicar que o nó agora tem uma chave a mais.
    }else {                            // Se não for uma folha ele inicia um loop que percorre as chaves do nó
      while(i >= 0 && keys[i] > key) { // Verifica se a chave é maior que a chave que está sendo inserida.
        i--;                           // Se for ele decrementa o i para apontar para a chave anterior até que o loop acabe.
      }
      i++;                             // Quando o loop acaba ele incrementa o i para apontar para a chave correta.

      if(child[i].n == 2 * t - 1) {
        splitChild(i, child[i]);
        if(keys[i] < key) {
          i++;
        }
      }
      child[i].insertNonFull(key);
      }
  }

  public insert(int key) {
    if(root == null) {
      root = new Node(t);
      root.keys[0] = key;
      root.n = 1;
    }else {
      if(root.n == 2 * t - 1) {
        Node node = new Node(t);
        node.child[0] = root;
        node.splitChild(0, root);
        int i = 0;
        
        if(node.keys[0] < key) {
          i++;
        }
        node.child[i].insertNonFull(key);
        root = node;
      }else {
        root.insertNonFull(key);
      }
    }
  }

}

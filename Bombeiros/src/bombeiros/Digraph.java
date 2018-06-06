package bombeiros;

public class Digraph {

    private int V; // número de vértices
    private int A; // número de arcos
    private No adj[]; // listas de adjcências

    // construtor da clsse
    // inicializa os atributos da classe e cria a 
    // o vetor de listas deadjacências para V vértices
    public Digraph(int V) {
        this.V = V;
        this.A = 0;
        this.adj = new No[V];
    }

    /* 
           Método insere um arco v-w no digrafo. O método supõe 
           que v e w são distintos, positivos e menores que V. 
           Se o digrafo já tem arco v-w, o método não faz nada.
           Insere aresta na lista de adjacencias no final
     */
    public void insereArco(int v, int w) {
        No aux = this.adj[v];
        No ant = null; //variavel anterior
        while (aux != null) {
            //Se o digrafo já tem arco v-w, o método não faz nada
            if (aux.getElem() == w) {
                return; // ejeta, para a função
            }
            ant = aux;
            aux = aux.getProx();
        }
        No novo = new No(w, null);
        this.A++;// incrementa o numero de arcos
        // testa se a lista esta vazia
        if (ant == null) // se lista vazia
        // joga no inicio da lista
        {
            this.adj[v] = novo;
        } else // insere no final da lista
        {
            ant.setProx(novo);
        }
    }

    /*
           Método remove do digrafo um arco aresta v-w. 
           O método supõe que v e w são distintos, positivos e 
           menores que V. Se não existe um arco v-w, método não 
           faz nada.
     */
    public void removeArco(int v, int w) {
        No aux = this.adj[v];
        No ant = null;
        while (aux != null) {
            if (aux.getElem() == w) {
                this.A--;
                ant.setProx(aux.getProx());
                break;
            }
            ant = aux;
            aux = aux.getProx();
        }
    }

    /*
           Metodo busca no digrafo um arco aresta v-w.
           O método supõe que v e w são distintos, positivos e 
           menores que V. Se não existe um arco v-w, método retorna false.
     */
    public boolean buscaArco(int v, int w) {
        No aux = this.adj[v];
        while (aux != null) {// se o elemento for igual a w o arco já existe
            if (aux.getElem() == w) { 
                return true;
            }
            aux = aux.getProx(); // para pegar o proximo no

        }
        return false;
    }
    
    /*
           Metodo busca no digrafo um ciclo caso o 
           arco aresta v-w seja adicionado.
           O método supõe que v e w são distintos, positivos e 
           menores que V. Se não existe um ciclo com a adicao
           do arco aresta v-w, método retorna false.
     */
    public boolean buscaCiclo(int v, int w){
        No aux = this.adj[w];
        boolean c = false;
        while(aux != null){
            if (c == true || aux.getElem() == v) {
                c = true;
                break;
            }else{
                c = this.buscaCiclo(v, aux.getElem());
            }
            aux = aux.getProx();
        }
        return c;
    }

    /*
           Para cada vértice v do grafo, este método imprime, em 
           uma linha, todos os vértices adjacentes a v. 
     */
    public void mostra() {

        for (int i = 0; i < this.V; i++) {
            System.out.print((i+1) + ": ");
            No aux = this.adj[i];
            while (aux != null) {
                System.out.print(aux.getElem()+1 + ", ");
                aux = aux.getProx();
            }
            System.out.println();
        }
    }

    /*
        Método indeg que calcula o grau de entrada um 
        vértice v de um digrafo.
        Grau de Entrada: número de arcos com ponta final em v
     */
    public int indeg(int v) {
        int a = 0;
        for (int i = 0; i < this.adj.length; i++) {
            No aux = this.adj[i];
            while (aux != null) {
                if (aux.getElem() == v) {
                    a++;
                }
                aux = aux.getProx();
            }
        }
        return a;
    }

    /*
        Método outdeg que calcula o grau de saida de um 
        vértice v em um digrafo.
        Grau de saida: número de arcos com ponta inicial em v
     */
    public int outdeg(int v) {
        No aux = this.adj[v];
        int a = 0;
        while (aux != null) {
            aux = aux.getProx();
            a++;
        }
        return a;
    }
}

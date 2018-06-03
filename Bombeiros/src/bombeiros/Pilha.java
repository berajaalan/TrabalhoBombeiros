package bombeiros;

public class Pilha {

    private int elementos[];
    private int topo;

    public Pilha(int tam) {
        this.elementos = new int[tam];
        this.topo = -1; // pilha esta vazia eh topo == -1
    }

    // insere (=empilhar) elemento na pilha (no topo da pilha)
    public void push(int elemento) {
        this.topo++;
        this.elementos[this.topo] = elemento;
    }

    // retira (=desempilhar) um elemento do topo e devolve (retornar)
    public int pop() {
        int elemento = this.elementos[this.topo];
        this.topo--;
        return elemento;
    }
    
    public boolean find(int x){
        for (int e : this.elementos) {
            if (e == x) {
                return true;
            }
        }
        return false;
    }

    // verifica se pilha esta vazia
    public boolean isEmpty() {
        return this.topo == -1;
    }
}

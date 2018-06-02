package bombeiros;

public class Main {

    public static void main(String[] args) {
        
        Digraph d = new Digraph(4);
        
        d.insereArco(0, 1);
        d.insereArco(0, 2);
        d.insereArco(1, 3);
        d.insereArco(2, 3);
        
        d.mostra();
        
        d.removeArco(1, 3);
        
        d.mostra();
        
    }
    
}

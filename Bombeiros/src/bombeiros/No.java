package bombeiros;

public class No {

    private int elem;
    private No prox;

    public No(int elem, No prox) {
        this.elem = elem;
        this.prox = prox;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "{" + "elem=" + this.elem + "," + this.prox + '}';
    }

}

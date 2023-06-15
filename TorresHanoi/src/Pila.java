
public class Pila {
    private int contadorNodo = 0;
    
    private Nodo cabeza;

    public int getContadorNodo() {
        return contadorNodo;
    }

    public void setContadorNodo(int contadorNodo) {
        this.contadorNodo = contadorNodo;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    public void push(Nodo n){
        contadorNodo++;
        if(cabeza == null){
            cabeza = n;
        }else{
            n.setAbajo(cabeza);
            //cabeza.setArriba(n);
            
            cabeza = n;
        }
    }
    
    public void pop(){
        if(contadorNodo > 0){
            contadorNodo--;
            cabeza = cabeza.getAbajo();
        }
    }
    
    public String Peek(){
        return cabeza.getDato();
    }
    
}

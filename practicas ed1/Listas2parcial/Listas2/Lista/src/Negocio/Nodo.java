package Negocio;


public class Nodo {
    Nodo Enlace;
    int Dato;
    
    public Nodo(){
        this(0);
    }
    
    public Nodo(int x){
        Enlace = null;
        Dato = x;
    }
    
    public void setDato(int Dato){
        this.Dato = Dato;
    }
    
    public void setEnlace(Nodo Enlace){
        this.Enlace = Enlace;
    }
    
    public int getDato(){
        return Dato;
    }
    
    public Nodo getEnlace(){
        return Enlace;
    }
}

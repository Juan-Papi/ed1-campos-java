package Negocio;


public class Nodo2 {
    Nodo2 Enlace;
    int Dato1;
    int Dato2;
    
    public Nodo2(){
        this(0,0);
    }
    
    public Nodo2(int x,int y){
        Enlace = null;
        Dato1 = x;
        Dato2 = y;
    }
    
    public void setDato1(int Dato1){
        this.Dato1 = Dato1;
    }
    
    public void setDato2(int Dato2){
        this.Dato2 = Dato2;
    }
    
    public void setEnlace(Nodo2 Enlace){
        this.Enlace = Enlace;
    }
    
    public int getDato1(){
        return Dato1;
    }
    
    public int getDato2(){
        return Dato2;
    }
    
    public Nodo2 getEnlace(){
        return Enlace;
    }
}

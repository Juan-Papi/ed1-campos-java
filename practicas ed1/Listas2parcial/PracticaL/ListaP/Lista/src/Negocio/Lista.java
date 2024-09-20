/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author cc
 */
public class Lista {
    Nodo L;
    int Cantidad;
    
    public Lista(){
        L=null;
        Cantidad=0;
    }
    
    public boolean Vacia(){
        return(L==null);
    }
    
    public void Insertar(int Ele){
        if (Vacia()){
            Nodo P= new Nodo();
            P.setData(Ele);
            L=P;
            Cantidad++;
        }else{
            Nodo Aux=L;
            Nodo Ant=null;
            while((Aux !=null)&&(Aux.getData()<=Ele)){
                Ant=Aux;
                Aux=Aux.getEnlace();
            }
            if (Ant==null){
                Nodo P=new Nodo();
                P.setData(Ele);
                P.setEnlace(L);
                L=P;
                Cantidad++;
            }else{
                if (Ant.getData()!=Ele){
                    Nodo P=new Nodo();
                    P.setData(Ele);
                    P.setEnlace(Aux);
                    Ant.setEnlace(P);
                    Cantidad++;
                }
            }
        }
    }
    
    public void Eliminar(int Ele){
        if (L!=null){
            Nodo Aux=L;
            Nodo Ant=null;
            while((Aux!=null)&&(Ele!=Aux.getData())){
                Ant=Aux;
                Aux=Aux.getEnlace();
            }
            if(Aux!=null){
                if(Ant==null){
                    L=L.getEnlace();
                    Cantidad--;
                }else{
                    Ant.setEnlace(Aux.getEnlace());
                    Cantidad--;
                }
            }
        }
    }
    
    @Override
//    public String toString(){
//        String S= "L->";
//        Nodo Aux=L;
//        while(L!=null){
//            S=S+Aux.getData()+",";
//        }
//        return(S);
//    }
    public String toString(){
        return(Mostrar(L));
    }
    private String Mostrar(Nodo P){
        if(P==null){
            return("");
        }else{
            String R= Mostrar(P.getEnlace());
            R=P.getData()+"->"+R;
            if (P==L){
                R="L->"+R;
            }
            return(R);
        }
    }
    
    
    public static void main(String[] args) {
       Lista l= new Lista();
       l.Insertar(7);
       l.Insertar(5);
       l.Insertar(8);
       l.Insertar(1);
       
        System.out.println(l);
    }
    
}

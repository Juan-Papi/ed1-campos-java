/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Mario Campos
 */
public class PilaL { Nodo Cima;
                     int cant;

    public PilaL() {
        this.Cima = null;
        this.cant = 0;
    }
 public boolean Vacia(){
 return Cima==null;
 }                    
 public void Push(int ele){
 Nodo p=new Nodo();
 p.setDato(ele);
 p.setEnlace(Cima);
 Cima=p;
 cant++;
 }  
 
 public int Pop(){
 int x=Cima.getDato();
 Cima=Cima.getEnlace();
 cant--;
 return x;
 }
 
 public int Get(){
 return Cima.getDato();
 }

    @Override
     public String toString() {
        String S="";
        Nodo Aux=Cima;
        while (Aux!=null) {
            S=S+Aux.getDato()+'\n';
            Aux=Aux.getEnlace();
            
        }
        S=S+"P";
        return S;
    };
    
 
 
 
}

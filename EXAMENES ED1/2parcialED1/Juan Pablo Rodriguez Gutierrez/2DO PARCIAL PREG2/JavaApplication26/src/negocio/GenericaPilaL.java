/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;

/**
 *
 * @author 59178
 */
public class GenericaPilaL<Tipovar> implements Serializable {
    NodoGP<Tipovar> Cima;
    int cant;

    public GenericaPilaL() {
        this.Cima = null;
        this.cant = 0;
    }
 public boolean Vacia(){
 return Cima==null;
 }                    
 public void Push(Tipovar ele){
 NodoGP<Tipovar> p=new NodoGP();
 p.SetDato(ele);
 p.SetEnlace(Cima);
 Cima=p;
 cant++;
 }  
 
 public Tipovar Pop(){
 Tipovar x=Cima.GetDato();
 Cima=Cima.GetEnlace();
 cant--;
 return x;
 }
 
 public Tipovar Get(){
 return Cima.GetDato();
 }
 public int getCant(){
     
     return cant;
 }

    @Override
     public String toString() {
        String S="";
        NodoGP<Tipovar> Aux=Cima;
        while (Aux!=null) {
            S=S+Aux.GetDato()+'\n';
            Aux=Aux.GetEnlace();
            
        }
        S=S+"P";
        return S;
    }
    
 public static void main(String[] args) {
        GenericaPilaL<Character> Pila1=new GenericaPilaL();
        
        Pila1.Push('+');
         Pila1.Push('-');
          Pila1.Push('*');
          System.out.println(Pila1.toString());
    }
 
    
}

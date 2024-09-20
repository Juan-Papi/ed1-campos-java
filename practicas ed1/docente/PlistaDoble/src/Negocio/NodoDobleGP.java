/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;

/**
 *
 * @author 59178
 */
public class NodoDobleGP<Tipovar> implements Serializable {
    
     //Campos o atributos
     Tipovar Dato;
     NodoDobleGP EnlaceIzq;
     NodoDobleGP EnlaceDer;
     //para el dominó
     char izq;
     char der;
     
    //Constructor sobrecargado
    public NodoDobleGP(Tipovar Dato, NodoDobleGP EnlaceIzq, NodoDobleGP EnlaceDer) {
        this.Dato = Dato;
        this.EnlaceIzq = EnlaceIzq;
        this.EnlaceDer = EnlaceDer;
    }
    
  //Constructor por defecto
    public NodoDobleGP() {//dato quedaría en null
      this.EnlaceIzq = null;
      this.EnlaceDer = null;   
    }
    
    //para el dominó
    public void setLetraIzq(char izq){
        this.izq=izq;
    }
    //para el dominó
    public void setLetraDer(char der){
        this.der=der;
    }
    public void setDato(Tipovar Dato) {
        this.Dato = Dato;
    }

    public void setEnlaceDer(NodoDobleGP EnlaceDer) {
        this.EnlaceDer = EnlaceDer;
    }

    public void setEnlaceIzq(NodoDobleGP EnlaceIzq) {
        this.EnlaceIzq = EnlaceIzq;
    }
    //para el dominó
    public char getLetraIzq(){
        return izq;
    }
    //para el dominó
    public char getLetraDer(){
        return der;
    }
    public Tipovar getDato() {
        return Dato;
    }

    public NodoDobleGP getEnlaceDer() {
        return EnlaceDer;
    }

    public NodoDobleGP getEnlaceIzq() {
        return EnlaceIzq;
    }
    //Para el dominó
    public String toStringDomin(){
        return "<- "+"|"+izq+"|"+der+"|"+" ->";
    }

    @Override
    public String toString() {
         return  "<- "+Dato+" ->";
    }
    public static void main(String[] args) {
    //-------------------------------------------------
        /*NodoDobleGP<Integer> n=new NodoDobleGP<>();
        n.setDato(8);
        System.out.println(n.toString());//Funciona!*/
    //-------------------------------------------------
        
        NodoDobleGP<Character> m=new NodoDobleGP<>();
        m.setDato('d');
        System.out.println(m.toString());
        
    }
  
}

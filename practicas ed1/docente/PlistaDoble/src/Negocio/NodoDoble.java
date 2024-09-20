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
public class NodoDoble {   
    //Campos o atributos
    int Dato;
     NodoDoble EnlaceIzq;
     NodoDoble EnlaceDer;
    //Constructor sobrecargado
    public NodoDoble(int Dato, NodoDoble EnlaceIzq, NodoDoble EnlaceDer) {
        this.Dato = Dato;
        this.EnlaceIzq = EnlaceIzq;
        this.EnlaceDer = EnlaceDer;
    }
  //Constructor por defecto
    public NodoDoble() {//dato quedaría en null
      this.EnlaceIzq = null;
      this.EnlaceDer = null;   
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public void setEnlaceDer(NodoDoble EnlaceDer) {
        this.EnlaceDer = EnlaceDer;
    }

    public void setEnlaceIzq(NodoDoble EnlaceIzq) {
        this.EnlaceIzq = EnlaceIzq;
    }

    public int getDato() {
        return Dato;
    }

    public NodoDoble getEnlaceDer() {
        return EnlaceDer;
    }

    public NodoDoble getEnlaceIzq() {
        return EnlaceIzq;
    }

    @Override
    public String toString() {
         return  "<- "+Dato+" ->";
    }
    
}

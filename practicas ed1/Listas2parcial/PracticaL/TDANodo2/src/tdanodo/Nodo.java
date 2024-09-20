/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdanodo;

/**
 *
 * @author Estudiante
 */
public class Nodo {
        int Dato;           // Object: Es para cualquier tipo de dato
        Nodo Enlace;        // Clase de Autoreferencia

//Contructores
public Nodo(){
    Enlace = null;
}

public Nodo(int dato){
    this.Dato = dato;
    Enlace = null;
}

//Setters
public void setDato(int Dato) {
    this.Dato = Dato;
}

public void setEnlace(Nodo Enlace) {
    this.Enlace = Enlace;
}

//Getters
public int getDato() {
    return Dato;
}

public Nodo getEnlace() {
    return Enlace;
}

@Override
public String toString() {
    return "Nodo{" + "Dato=" + Dato + '}';
    }




}

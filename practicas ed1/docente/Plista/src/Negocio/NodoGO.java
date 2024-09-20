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
public class NodoGO{  Object Dato;
                      NodoGO Enlace;

    public NodoGO() {
        this.Enlace=null;
    }
                 
    public NodoGO(Object Dato, NodoGO Enlace) {
        this.Dato = Dato;
        this.Enlace = Enlace;
    }

    public void setDato(Object Dato) {
        this.Dato = Dato;
    }

    public void setEnlace(NodoGO Enlace) {
        this.Enlace = Enlace;
    }

    public Object getDato() {
        return Dato;
    }

    public NodoGO getEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        return (Dato.toString()+ "->");
    }
        
    
    
}

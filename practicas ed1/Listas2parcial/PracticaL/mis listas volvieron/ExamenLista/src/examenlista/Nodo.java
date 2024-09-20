/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examenlista;

/**
 *
 * @author Auxiliarlab21
 */

    public class Nodo { int dato;
                    Nodo Enlace;
public Nodo(){
    Enlace= null;
}
public Nodo(int dato){
    this.dato =dato;
    Enlace= null;
}
public void set_dato(int x){
    dato= x;
}
public void set_enlace(Nodo P){
    Enlace= P;
}
public int get_dato(){
return (dato);
}
public Nodo get_enlace(){
return (this.Enlace);
}
}

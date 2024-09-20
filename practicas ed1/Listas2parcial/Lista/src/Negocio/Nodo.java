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
public class Nodo {
    int Data;
    Nodo Link;
    
    public Nodo(){
        Link=null;
    }
    
    public void setData(int Ele){
        Data=Ele;
    }
    
    public void setEnlace(Nodo P){
        Link=P;
    }
    
    public int getData(){
        return(Data);
    }
    
    public Nodo getEnlace(){
        return(Link);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listas;

/**
 *
 * @author hogar2013
 */
public class NodoD {
                int Data;
                NodoD EnlaceD;
                NodoD EnlaceI;
                
     public NodoD(){
     EnlaceD=null;
     EnlaceI=null;
     }
     public NodoD(int Ele){
     Data=Ele;
     EnlaceD=null;
     EnlaceI=null;
     }
     
     public void setData(int Ele){
     Data=Ele;
     }
     
     public int getData(){
     return (Data);
     }
     
     
     public void setEnlaceD(NodoD P){
     EnlaceD=P;
     }
     
     public NodoD getEnlaceD(){
     return (EnlaceD);
     }
     
     public void setEnlaceI(NodoD P){
     EnlaceI=P;
     }
     
     public NodoD getEnlaceI(){
     return (EnlaceI);
     }
}

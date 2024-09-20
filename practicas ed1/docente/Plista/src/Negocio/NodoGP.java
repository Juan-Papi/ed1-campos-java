/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;

/**
 *
 * @author Mario Campos
 */
    public class NodoGP <Tipovar> implements Serializable{   Tipovar Dato;
                                                             NodoGP<Tipovar> Enlace; 
                           
    public NodoGP(){
     
      Enlace=null;
    }              
    public NodoGP (Tipovar Dato){
       this.Dato=Dato;
      Enlace=null;    
    }
    public void SetDato(Tipovar Dato){
       this.Dato=Dato;
    }
    public Tipovar GetDato(){
        return Dato;
    }
    public void SetEnlace(NodoGP<Tipovar> P){
      Enlace=P;
    }
    public  NodoGP<Tipovar> GetEnlace(){
       return Enlace;
    }

    @Override
    public String toString() {
       return (Dato.toString());
    }
        public static void main(String[] args) {
            //Funciona correctamente
           /*NodoGP<fraccion>nodo1=new NodoGP<fraccion>();
           fraccion A=new fraccion(5,8,'-');
           nodo1.SetDato(A);
            System.out.println(nodo1.toString());*/
          
           //Funciona Correctamente
           /*NodoGP<Integer>n1=new NodoGP<Integer>();
                  n1.SetDato(45);
                System.out.println(n1.toString()); */
        
                 
                  
                    
        }
    
}

    
    


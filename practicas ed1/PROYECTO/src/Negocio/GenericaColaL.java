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
public class GenericaColaL<Tipovar> implements Serializable {
    //Campos o atributos
    NodoGP<Tipovar>  Frente;
    NodoGP<Tipovar> Atras;
    int cant;

    //Constructor default (de oficio) 
    public GenericaColaL() {
        this.Frente = null;
        this.Atras = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (Frente == null);
    }

    public void Encolar(Tipovar ele) {
        if (vacia()) {
            NodoGP<Tipovar> p = new NodoGP();
            p.SetDato(ele);
            Frente = p;
            Atras = p;
            cant++;
        } else {
            NodoGP<Tipovar> p = new NodoGP();
            p.SetDato(ele);
            Atras.SetEnlace(p);
            Atras =p;
            cant++;
        }
    }

    public Tipovar Decolar() {
        if (!vacia()) {
            Tipovar x = Frente.GetDato();
            if (Frente == Atras) {
                //Entra si hay 1 elemento
                Frente = null;
                Atras = null;
                cant--;
            }else{
                Frente=Frente.GetEnlace();
                cant--;
            }
         return x;
        }else{
            System.out.println("Error::Decolar:Cola vacía, nada por decolar");
            System.exit(1);
           return null;//Error cola vacía
       }
       
    }
    public Tipovar Get(){
        return Atras.GetDato();
    }
    public String toString(){
        String s="C->";
          NodoGP<Tipovar> aux=Frente;
          while(aux!=null){
              s=s+aux.GetDato()+" -> ";
              aux=aux.GetEnlace();
              
          }
         
        s=s+"null";
        return s;
    }
    public static void main(String[] args) {
        //La cola genérica funciona correctamente
     //---------------------------------------------------------
        GenericaColaL<Integer> cg=new GenericaColaL();
        cg.Encolar(5);
        cg.Encolar(8);
        System.out.println(cg.toString());
        System.out.println(cg.Decolar());
        System.out.println(cg.Decolar());
        System.out.println(cg.toString());
        //System.out.println( cg.Decolar());
     //---------------------------------------------------------   
        GenericaColaL<Double> cg1=new GenericaColaL();
        cg1.Encolar(2.8);
        cg1.Encolar(3.5);
        cg1.Encolar(4.0);
        cg1.Encolar(1.0);
        System.out.println(cg1.toString());
        System.out.println(cg1.Decolar());
        System.out.println(cg1.Decolar());
        System.out.println(cg1.toString());
     //---------------------------------------------------------
      GenericaColaL<Float> cg2=new GenericaColaL();
        cg2.Encolar((float)3.8);
        cg2.Encolar((float)4.5);
        cg2.Encolar((float)5.0);
        cg2.Encolar((float)1);
        System.out.println(cg2.toString());
        System.out.println(cg2.Decolar());
        System.out.println(cg2.Decolar());
        System.out.println(cg2.toString());
     //----------------------------------------------------------
     GenericaColaL<String> cg3=new GenericaColaL();
        cg3.Encolar("Hola");
        cg3.Encolar("mundo");
        cg3.Encolar("como");
        cg3.Encolar("estas");
        System.out.println(cg3.toString());
        System.out.println(cg3.Decolar());
        System.out.println(cg3.Decolar());
        System.out.println(cg3.toString());
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
    GenericaPilaL<Tipovar> P;//La pila con la que intercambiaremos extremos

    //Constructor default (de oficio) 
    public GenericaColaL() {
        this.Frente = null;
        this.Atras = null;
        this.cant = 0;
        P=new GenericaPilaL<>();
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
        //if (!vacia()) {
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
       /* }else{
            System.out.println("Error::Decolar:Cola vacía, nada por decolar");
            System.exit(1);
           return null;//Error cola vacía
       }*/
       
    }
    public Tipovar Get(){
        return Atras.GetDato();
    }
    public void intercambiarExtremos(){
        if(!vacia()&&!P.Vacia()){
            int cantPila=P.cant;
            int cantCola=cant;
            Tipovar px=P.Pop();
            Tipovar x=Decolar();
           
            for (int i = 1; i <=cantPila-1; i++) {
                Encolar(P.Pop());
                
            }
         
            for (int j = 1; j <=cantCola-1; j++) {
                P.Push(Decolar());
               
            }
            Tipovar y=P.Pop();
           
            for (int k = 1; k<=cantPila-1; k++) {
                P.Push(Decolar());
                     
            }
            Tipovar py=P.Pop();
            //hasta este punto según nuestro análisis en hoja y papel
            //la cola esta vacía y ya encontramos los extremos de la pila
            //y la cola,en la pila actualmente estan guardados los datos de
            //la pila inicialmente y de la cola inicialmente pero sin sus extre-
            //mos
            Encolar(y);
            for (int i = 1; i <=cantPila-2; i++) {
                Encolar(P.Pop());
            }
            Encolar(x);
            Encolar(py);
            for (int i = 1; i <=cantCola-2; i++) {
                Encolar(P.Pop());
            }
            Encolar(px);
            //En este punto la pila queda vacia
            //y los datos de la pila y la cola inicialmente 
            //estan guardados en la cola
            for (int i = 1; i <=cantPila; i++) {
                P.Push(Decolar());
                
            }
            for (int i =1; i <=cantCola; i++) {
                P.Push(Decolar());
                
            }
            //hasta aquí la cola queda nuevamente vacía
            for (int i =1; i<=cantCola; i++) {
                Encolar(P.Pop());
                
            }
            //Finalmente quedan intercambiados sus extremos de la pila y de
            // la cola
        }
    }
           
    public String toString(){
        String s="\n----------------------------------------------\n";
        s=s+"C-> ";
          NodoGP<Tipovar> aux=Frente;
          while(aux!=null){
              s=s+aux.GetDato()+" -> ";
              aux=aux.GetEnlace();
              
          }
         
        s=s+"null\n";
        s=s+"---------------------------------------------------";
        return s;
    }
    public static void main(String[] args) {
        //La cola genérica funciona correctamente
     //---------------------------------------------------------
       /* GenericaColaL<Integer> cg=new GenericaColaL();
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
        System.out.println(cg3.toString());*/
       
       GenericaColaL<Integer> c=new GenericaColaL<>();
       c.Encolar(8);
       c.Encolar(9);
       c.Encolar(10);
       c.Encolar(11);
       c.Encolar(12);
       c.Encolar(13);
       c.Encolar(14);
       
       
       c.P.Push(1);
       c.P.Push(2);
       c.P.Push(3);
       c.P.Push(4);
       /* System.out.println(c.toString());
        System.out.println(c.P.toString());*/
       c.intercambiarExtremos();
        System.out.println(c.toString());
        System.out.println(c.P.toString());
        
       
      
        
    }
}

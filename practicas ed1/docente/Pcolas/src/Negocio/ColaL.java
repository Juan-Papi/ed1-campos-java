/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author 59178
 */
//Las estructuras dinámicas no tienen el método llena!!
public class ColaL {

    //Campos o atributos
    Nodo Frente;
    Nodo Atras;
    int cant;

    //Constructor default (de oficio) 
    public ColaL() {
        this.Frente = null;
        this.Atras = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (Frente == null);
    }

    public void Encolar(int ele) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(ele);
            Frente = p;
            Atras = p;
            cant++;
        } else {
            Nodo p = new Nodo();
            p.setDato(ele);
            Atras.setEnlace(p);
            Atras = p;
            cant++;
        }
    }

    public int Decolar() {
        if (!vacia()) {
            int x = Frente.getDato();
            if (Frente == Atras) {
                //Entra si hay 1 elemento
                Frente = null;
                Atras = null;
                cant--;
            }else{
                Frente=Frente.getEnlace();
                cant--;
            }
         return x;
        }else{
            System.out.println("Error::Decolar:Cola vacía, nada por decolar");
            System.exit(1);
           return -9999999;//Error cola vacía
       }
    }
    
    public int Get(){
        return Atras.getDato();
    }
    public String toString(){
        String s="C->";
          Nodo aux=Frente;
          while(aux!=null){
              s=s+aux.getDato()+" -> ";
              aux=aux.getEnlace();
              
          }
         
        s=s+"null";
        return s;
    }
    public static void main(String[] args) {
         ColaL c=new ColaL();
         c.Encolar(8);
         c.Encolar(1);
         c.Encolar(5);
         System.out.println(c.toString());
    }
}


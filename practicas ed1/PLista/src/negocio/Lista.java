/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author 59178
 */
public class Lista {

    //Atributos
    Nodo L;//Referencia al primer nodo de la lista
    int cant;//La cantidad de nodos

    //Constructor por defecto
    public Lista() {
        L = null;
        this.cant = 0;
    }

    public boolean vacia() {
        //return (dim==0);Tambien se puede asi
        return (L == null);
    }

    public int getCantidad() {
        return this.cant;
    }
    public void insertar(int ele){
        if(vacia()){
            Nodo p=new Nodo(ele);
            L=p;
            this.cant++;
        }else{
            Nodo aux=L;
            Nodo ant=null;
            while((aux!=null)&& (aux.getDato()<=ele)){//Recorremos
                ant=aux;
                aux=aux.getEnlace();
                
            }
            if (ant==null) {//Insertar a la cabeza
                 Nodo p=new Nodo(ele);
                 p.setEnlace(L);
                 L=p;
                 this.cant++;
            } else {//Insertar al cuerpo
                
                if(ant.getDato()!=ele){
                    Nodo p=new Nodo(ele);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    //Aqui no se pone L=p por que insertamos entre dos nodos
                    this.cant++;
                            
                }
                    
            }
            
        }
    }
    
    
}

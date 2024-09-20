/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        this.L = null;
        this.cant = 0;
    }

    public boolean ListaVacia() {
        return (L == null);
    }

    public void Eliminar(int Ele) {
        if (ListaVacia()) { 
            System.out.println("Lista Vacia");   
            System.exit(1);
           
        } else {
            Nodo Aux = L;
            Nodo Ant = null;
            while (Aux != null && Aux.getDato() != Ele) {
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Aux != null) {
                if (Ant == null) {
                    L = L.getEnlace();  // ELIMINA EL PRIMERO (CABEZA)
                } else {
                    Ant.setEnlace(Aux.getEnlace()); // ELIMINA DEL CUERPO
                }
                cant--;
            }
        }
    }
    private void EliminarR1(int Ele, Nodo P){
        if (P==null){  
        }else{ if(P.getEnlace()== null){
                if(P.getDato()==Ele && L==P){
                    L=L.getEnlace();
                    cant--;
                }
        }else{
            EliminarR1(Ele,P.getEnlace());
            if (P.getEnlace().getDato() == Ele){
                P.setEnlace(P.getEnlace().getEnlace());
  
            }
        }
        
 // Hacer Insertar Recursivo 
 // Eliminar Repetidos Recursivo   L--> 1 -->1  -->2 -->2 -->2 -->3 (Ordenados pero con repetidos) = L-->1-->2-->3
 // Eliminar Repetido incluido Recursivo L--> 1 -->1  -->2 -->2 -->2 -->3 (Ordenados pero con repetidos) = L-->3
 // Eliminar Intercalado Recursivo (Izquierda a derecha)  L-->1-->2-->3-->4-->5-->6  = L-->1-->3-->5
 // Eliminar Intercalado (Derecha a izquierda) L-->1-->2-->3-->4-->5-->6  = L-->2-->4-->6
 // Lista circular
 // Volcar elementos de una lista de dos en dos  L-->1-->2-->3-->4-->5 = L-->2-->1-->4-->3-->5
 // Otra: Volcar al reves de derecha a izquierda L-->1-->2-->3-->4-->5 = L-->1-->3-->2-->5-->4
 // volcar de 3 en 3   L-->1-->2-->3-->4-->5-->6 = L-->3-->2-->1-->6-->5-->4
    }
    }
    public void InsertarEnL(int Dato) {
        Nodo NuevoNodo = new Nodo();
        NuevoNodo.Enlace = L;
        L = NuevoNodo;
    }

    public void Insertar(int Dato) {
        //Nodo NuevoNodo = new Nodo(Dato);
        if (ListaVacia()) {
            Nodo P = new Nodo();
            P.setDato(Dato);
            L = P;
            cant++;
        } else {
            Nodo Ant = null;
            Nodo Aux = L;
            while (Aux != null && Aux.getDato() <= Dato) {
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Ant == null) {
                Nodo P = new Nodo();
                P.setDato(Dato);
                P.setEnlace(L);
                L = P;
                cant++;
            } else if (Ant.getDato() != Dato) {
                Nodo P = new Nodo();
                P.setDato(Dato);
                Ant.setEnlace(P);
                P.setEnlace(Aux);
                cant++;
            }
        }
    }

    public int Tamaño() {
        return (cant);
    }

    public void EliminarEle(int Ele) {
        if (ListaVacia()) {
            System.out.println("No hay elementos en la lista");
        } else {
            Nodo Ant = null;
            Nodo Aux = L;
            while (Aux != null && Aux.Dato != Ele) {
                Ant = Aux;
                Aux = Aux.Enlace;
            }
            if (Aux != null) {
                if (Ant == null) {
                    L = Aux.Enlace;
                } else {
                    Ant.Enlace = Aux.Enlace;
                }
                cant--;
            }
        }
    }
//////////////////////////INVERTIR TRADICIONAL///////////////////////////////////////

    public void InvertirLista() {
        if (ListaVacia() || cant == 1) {
        } else {
            Nodo Ant = null;
            Nodo Act = L;
            Nodo Post = L.Enlace;//L.getEnlace();
            while (Post != null) {
                Act.Enlace = Ant;         //Act.setEnlace(Ant);
                Ant = Act;
                Act = Post;
                Post = Post.Enlace;//Post.getEnlace();
            }
            Act.Enlace = Ant; // Act.setEnlace(Ant);
            //Act = L;
            L = Act;
        }
    }
///////////////////////////////INVERTIR RECURSIVO ///////////////////////////////

    public void InvertirRecur() {
        InvertirR(L);
    }

    private void InvertirR(Nodo P) {
        if (P == null) {
        } else if (P.getEnlace() == null) {
            L = P;
        } else {
            InvertirR(P.getEnlace());
            P.getEnlace().setEnlace(P);
            P.setEnlace(null);
        }
    }

    public int GetElemento(int Pos) {
        Nodo Aux = L;
        for (int i = 1; i < Pos; i++) {
            Aux = Aux.getEnlace();
        }
        return (Aux.getDato());
    }

    public void EliminarPos(int n) {
        if (ListaVacia()) {
            System.out.println("La lista está vacía");
        } else {
            Nodo Ant = null;
            Nodo Aux = L;
            int cont = 1;
            while (Aux != null && cont != n) {
                Ant = Aux;
                Aux = Aux.Enlace;
                cont++;
            }
            if (cont <= cant) {
                if (Ant == null) {
                    L = Aux.Enlace;
                } else {
                    Ant.Enlace = Aux.Enlace;
                }
                cant--;
            }
        }
    }

    @Override
    public String toString() {
        String s = "Lista : ";
        Nodo Aux = L;
        while (Aux != null) {
            s = s + "[" + Aux.Dato + "]" + "->";
            Aux = Aux.Enlace;
        }
        s = s + "null";
        return s; //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Lista x = new Lista();
        x.Insertar(2);
        x.Insertar(7);
        x.Insertar(8);
        x.Insertar(9);
        // x.Insertar(1);
        // x.Insertar(6);

//        x.InsertarAlUltimo(20);
//        x.InsertarAlUltimo(19);
//        x.InsertarAlUltimo(84);
//        System.out.println(x.toString());
//        x.EliminarPos(2);
//        int y = x.Tamaño();
//        System.out.println(x.toString());
//        System.out.println(y);
//        x.EliminarEle(10);
        System.out.println(x.toString());
        x.InvertirLista();
        System.out.println(x.toString());
        x.InvertirRecur();
        System.out.println(x.toString());
        //x.Eliminar(10);
        //x.EliminarEle(2);
//        x.EliminarPos(5);
//        int y = x.Tamaño();
//        System.out.println(x.toString());
//        System.out.println(y);
//        System.out.println(x.GetElemento(2));
    }

}

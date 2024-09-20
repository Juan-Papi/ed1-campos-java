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
public class ConjuntoBits {

    //Atributos
    Bitwise C[];//Vector de Bits
    int cant;//cant de elementos en el conjunto

    //Constructor
    public ConjuntoBits() {
        this.cant = 100;

        int nbw = cant / 32;
        if ((cant % 32) != 0) {
            nbw++;
        }

        this.C = new Bitwise[nbw];
        for (int i = 0; i < nbw; i++) {//nbw="Numeros de bitwise"
            C[i] = new Bitwise();

        }

    }

//Verifica si el conjunto esta vacio
    public boolean vacia() {
        return (cant == 0);
    }

    //Inserta un elemento al conjunto
    public void insertar(int ele) {
        redimencionar(ele);
        int nbw = calcularnbw(ele);
        int nbit = calcularnbit(ele);
        C[nbw].set1(nbit);
    }

    //Elimina un elemento del conjunto
    public void eliminar(int ele) {
        if (pertenece(ele)) {
            int nbw = calcularnbw(ele);
            int nbit = calcularnbit(ele);
            C[nbw].set0(nbit);
        }
    }

    public boolean pertenece(int ele) {
        int nbw = (ele - 1) / 32;
        int nbit = ((ele - 1) % 32) + 1;
        return (C[nbw].getBit(nbit) == 1);
    }

    private void redimencionar(int ele) {
        if (ele > this.cant) {
            int nbw = ele / 32;
            if ((ele % 32) != 0) {
                nbw++;
            }

            Bitwise C1[] = new Bitwise[C.length];
            System.arraycopy(C, 0, C1, 0, C.length);

            C = new Bitwise[nbw];
            System.arraycopy(C1, 0, C, 0, C1.length);
            for (int i = C1.length; i < nbw; i++) {
                C[i] = new Bitwise();

            }
            this.cant = nbw * 32;
        }
    }

    //Calcula pos donde se insertara el elemento
    private int calcularnbit(int ele) {
        return ((ele - 1) % 32) + 1;
    }
    //calcula el nro de bitwise donde se insertara el elemento

    private int calcularnbw(int ele) {
        return ((ele - 1) / 32);
    }
    //Union forma 2
    public void union(ConjuntoBits A, ConjuntoBits B) {
        if (A.C.length > B.C.length) {//Para que el or funcione correctamente
            //Se alarga el vector donde irá el resultado del or
            C = new Bitwise[A.C.length];
            this.cant = A.C.length * 32;
            for (int i = 0; i < A.C.length; i++) {//A.C.length="Numeros de bitwise"
                C[i] = new Bitwise();

            }
        } else {
            C = new Bitwise[B.C.length];
            this.cant = B.C.length * 32;//Cant es el maximo valor que entra al conjunto
            for (int i = 0; i < B.C.length; i++) {//B.C.length="Numeros de bitwise"
                C[i] = new Bitwise();

            }
        }
        //Se hace el or de C con A
        for (int i = 0; i < A.C.length; i++) {
            C[i].v = C[i].v | A.C[i].v;

        }
        //Se hace el or del C modificado con B
        for (int i = 0; i < B.C.length; i++) {
            C[i].v = C[i].v | B.C[i].v;//(or) |(suma logica)

        }
    }
    //Interseccion forma 2
    public void interseccion(ConjuntoBits A, ConjuntoBits B) {
        if (A.C.length < B.C.length) {
            C = new Bitwise[B.C.length];
            this.cant=B.C.length*32;
            for (int i = 0; i < B.C.length; i++) {
                C[i] = new Bitwise();

            }
        } else {
            C = new Bitwise[A.C.length];
            this.cant=A.C.length*32;
            for (int i = 0; i < A.C.length; i++) {
                C[i] = new Bitwise();
            }
        }
        
        //Union de C con A
        for (int i = 0; i <A.C.length; i++) {
            C[i].v=C[i].v | A.C[i].v;//(and)&=producto logico
            
        }
        //Interseccion de C modificado con B =>a interseccion b
        for (int i = 0; i < B.C.length; i++) {
            C[i].v=C[i].v & B.C[i].v;
            
        }
    }
    //Union Forma 1
    public void union1(ConjuntoBits A,ConjuntoBits B){
        for (int i = 0; i <=A.cant; i++) {
             if(A.pertenece(i))
                 insertar(i);
            
        }
        for (int i = 0; i <=B.cant; i++) {
            if(B.pertenece(i))
                 insertar(i);
            
        }
        
    }
    //Interseccion forma 1
    public void interseccion1(ConjuntoBits A,ConjuntoBits B){
        int i=0;
        while(i<=A.cant && i<=B.cant){
            if(A.pertenece(i)&& B.pertenece(i))
                insertar(i);
                        
           i++;             
        }
        
    }
    public boolean Subconjunto(ConjuntoBits A,ConjuntoBits B){//A es subconjunto de B
        boolean b=true;
        int i=0;
             while(i <=A.cant && b) {//b=> b=true
                if(A.pertenece(i)){
                    if(!B.pertenece(i))
                       b=false;
                }
              i++;   
            
        }
        return b;
    }
    public String toString() {
        String cad = "<< ";
        for (int i = 0; i <= this.cant; i++) {
            if (pertenece(i)) {
                cad = cad + i + ", ";
            }

        }
        cad = cad + ">>";
        return cad;
    }
//Conclusion: tenemos dos formas de hacer la union  y la interseccion de dos conjuntos
    public static void main(String[] args) {
        ConjuntoBits A = new ConjuntoBits();
        A.insertar(4);
        A.insertar(20);
        A.insertar(30);
        //A.insertar(3);
        /*ConjuntoBits B = new ConjuntoBits();
        B.insertar(30);
        B.insertar(301);
        B.insertar(31);
        ConjuntoBits C = new ConjuntoBits();*/
        System.out.println(A);
        //System.out.println(B);
      //  boolean b=C.Subconjunto(A, B);//A es subconjunto de B?
       // boolean b1=C.Subconjunto(B, A);//B es subconjunto de A?
       //C.interseccion1(A, B);
      // C.interseccion(A, B);
       // System.out.println(C);

    }
}

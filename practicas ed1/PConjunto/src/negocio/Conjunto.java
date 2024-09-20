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
public class Conjunto {

    //Atributos
    int C[];
    int dim;
    //Constructor

    public Conjunto() {
        this.C = new int[10];
        this.dim = -1;
    }

    //Verifica si el conjunto esta vacío
    public boolean vacia() {
        return (dim == -1);
    }

    //Inserta un elemento al conjunto
    public void insertar(int ele) {
        if (vacia()) {
            dim++;
            C[dim] = ele;
        } else {
            if (!pertenece(ele)) {
                redimencionar();
                dim++;
                C[dim] = ele;
            }
        }

    }
  public void redimencionar(){
       if(C.length-1==dim){
           int cp[]=new int[C.length];
           System.arraycopy(C,0,cp,0,C.length);
           C=new int[cp.length+10];
           System.arraycopy(cp,0,C,0,cp.length);
       }
   }
    public boolean pertenece(int ele) {

        int i = 0;
        while (i <= dim && C[i] != ele) {
            i++;
        }
        return (i <= dim);

    }

    public void eliminar(int ele) {
        if (!vacia()) {
            int i = 0;
            while (i <= dim && C[i] != ele) {
                i++;
            }
            if (i <= dim) {
                for (int j = i; j < dim; j++) {
                    C[j] = C[j + 1];

                }
                dim--;
            }
        }
    }

    public void union(Conjunto A, Conjunto B) {
        for (int i = 0; i <= A.dim; i++) {
            insertar(A.C[i]);
        }
        for (int i = 0; i <= B.dim; i++) {
            insertar(B.C[i]);
        }
    }

    public void interseccion(Conjunto A, Conjunto B) {
        for (int i = 0; i <= A.dim; i++) {
            if (B.pertenece(A.C[i])) {
                insertar(A.C[i]);
            }

        }

    }

    public boolean subconjunto(Conjunto A, Conjunto B) {
        boolean b = true;
        for (int i = 0; i <= A.dim; i++) {
            if (!B.pertenece(A.C[i])) {
                b = false;
            }

        }
        return b;
    }

    public String toString() {
        String cad = "<< ";
        for (int i = 0; i <= dim; i++) {
            cad = cad + C[i] + ", ";

        }
        cad = cad + ">>";
       // cad = cad + "\n" + dim;
        return cad;

    }

    public static void main(String[] args) {
        //Conjunto A
        Conjunto A = new Conjunto();
        A.insertar(1);
        A.insertar(2);
        A.insertar(3);
        A.insertar(4);
        A.insertar(5);
        // A.insertar(6);
        //Conjunto B
        Conjunto B = new Conjunto();
        B.insertar(6);
        B.insertar(7);
        B.insertar(8);
        B.insertar(9);
        B.insertar(10);
        B.insertar(11);
        B.insertar(12);

        Conjunto C = new Conjunto();
        C.union(A, B);
        //C.interseccion(A, B);
        // boolean b=C.subconjunto(A, B);//Preg. A es subconjunto de B?
       // boolean b = C.subconjunto(B, A);//Preg. B es subconjunto de A?
        System.out.println(C);//Comprobado el redimencionar
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 *
 * @author 59178
 */
public class SparseBits<Tipovar> implements Serializable {

    //Atributos
    VectorBitsG VFC;//Vector fila columna
    Tipovar VD[];//Vector de datos
    int dim;
    int Nfilas;//Numero de filas
    int Ncol;//Numero de columnas
    Tipovar EP ;//Elemento predominante    
    Class<Tipovar> cl;//cl="clase"

    //Constructor
    public SparseBits(int Nfilas, int Ncol, Tipovar EP,Class<Tipovar> clase) {
        int x = calcularbits(Nfilas * Ncol);
        VFC = new VectorBitsG(10, x);
         VD=(Tipovar[]) Array.newInstance(clase,10);
        this.dim = -1;
        this.Nfilas = Nfilas;
        this.Ncol = Ncol;
        this.EP = EP;
        this.cl=clase;
    }

    public boolean vacia() {
        return (dim == -1);
    }

    private int calcularbits(int cant) {
        int i = 1;
        while (Math.pow(2, i) <= cant) {
            i++;
        }
        return (i);
    }

    public void Set(int fila, int col, Tipovar dato) {
        if ((fila > Nfilas) || (col > Ncol)) {
            System.out.println("Error::Set:fila y columna fuera de rango");
            System.exit(1);
        } else {
            int FC = (fila - 1) * Ncol + col;
            if (vacia()) {
                if (dato != EP) {

                    this.dim++;
                    VD[dim] = dato;
                    VFC.insertar(FC, this.dim + 1);

                }
            } else {
                int x = buscarFC(fila, col);
                //Si x==-1 significa que esa fila y columna
                //no esta usada por tanto insertamos
                if (x == -1) {//Insertamos
                    redimencionar();
                    this.dim++;
                    VD[this.dim] = dato;
                    VFC.insertar(FC, this.dim + 1);

                } else {
                    if (dato != EP) {//Actualizar
                        VD[x] = dato;
                    } else {//Eliminar
                        for (int i = x; i < dim; i++) {
                            VFC.insertar(VFC.Get(i + 2), i + 1);
                            VD[i] = VD[i + 1];

                        }
                        this.dim--;
                    }

                }
            }

        }
    }

    private int buscarFC(int fila, int col) {
        int FC = (fila - 1) * Ncol + col;
        int i = 0;
        while ((i <= dim) && VFC.Get(i + 1) != FC) {
            i++;
        }
        if (i <= dim) {
            return (i);
        } else {
            return (-1);
        }

    }

    private void redimencionar() {
        if (dim == VFC.dim - 1) {
            //Redimencionando el VFC"Vector fila columna"
            VectorBitsG aux = new VectorBitsG(VFC.dim, VFC.cantBits);
            System.arraycopy(VFC.v, 0, aux.v, 0, VFC.v.length);
            VFC = new VectorBitsG(aux.dim + 5, aux.cantBits);
            System.arraycopy(aux.v, 0, VFC.v, 0, aux.v.length);
            //Redimencionando VD"Vector de datos"
           
            
            Tipovar VD1[] =(Tipovar[]) Array.newInstance(cl,VD.length);
            System.arraycopy(VD, 0, VD1, 0, VD.length);
            VD=(Tipovar[]) Array.newInstance(cl,VD1.length+5);
            System.arraycopy(VD1, 0, VD, 0, VD1.length);
        }

    }

    public Tipovar Get(int fila, int col) {
        
        int x = buscarFC(fila, col);
        if (x != -1) {
            return (VD[x]);
        } else {
            return (EP);
        }

    }
  

    @Override
    public String toString() {
        String S = " M= [ ";
        S = S + '\n';
        for (int i = 1; i <= Nfilas; i++) {
            for (int j = 1; j <= Ncol; j++) {
                S = S + Get(i, j) + "  ,  ";
            }
            S = S + '\n';

        }
        S = S + " ] ";
        return (S);
    }

    public static void main(String[] args) {
      //El redimencionar funciona correctamente
      //La matriz genérica funciona correctamente
      
        SparseBits<Float> A = new SparseBits(5, 5,(float)0,Float.class);
       //Double es un valor más grande que float
       
      //Float
      A.Set(1, 1,(float)25);
      A.Set(5, 5,(float)30);
      A.Set(1, 2,(float)11);
      A.Set(1, 3,(float)12);
      A.Set(1, 4,(float)13);
      A.Set(5, 4,(float)14);
      A.Set(2, 1,(float)15);
      A.Set(2, 5,(float)16);
      A.Set(2, 3,(float)17);
      A.Set(2, 4,(float)18);
      A.Set(3, 1,(float)19);
      
      //Integer
      
      
      //String
      
      
      //Fraccion
      /*fraccion EP=new fraccion(1, 3, '+');
       SparseBits<fraccion> A = new SparseBits(5, 5,EP,fraccion.class);*/
       //Double es un valor más grande que float
       
      //Float
     /* fraccion f1=new fraccion(5, 1,'-');
      fraccion f2=new fraccion(1, 2,'+');
      fraccion f3=new fraccion(2, 3,'-');
      fraccion f4=new fraccion(3, 6,'+');
      fraccion f5=new fraccion(4, 4,'-');
      fraccion f6=new fraccion(6, 5,'+');
      fraccion f7=new fraccion(7, 7,'-');
      fraccion f8=new fraccion(8, 8,'+');
      fraccion f9=new fraccion(9, 10,'-');
      fraccion f10=new fraccion(10, 11,'+');
      fraccion f11=new fraccion(11, 12,'-');
      A.Set(1, 1,f1);
      A.Set(5, 5,f2);
      A.Set(1, 2,f3);
      A.Set(1, 3,f4);
      A.Set(1, 4,f5);
      A.Set(5, 4,f6);
      A.Set(2, 1,f7);
      A.Set(2, 5,f8);
      A.Set(2, 3,f9);
      A.Set(2, 4,f10);
      A.Set(3, 1,f11);
      //Lo muestra desordenado(falta dar detalles al toString)*/
        System.out.println(A.toString());
        System.out.println("Dato obtenido: "+A.Get(3,2));
         System.out.println("Dato obtenido: "+A.Get(5,4));
    }
}

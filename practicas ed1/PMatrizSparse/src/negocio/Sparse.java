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
public class Sparse {
    //Atributos

    int VFC[];//VFC "vector fila columna"
    float VD[];// Vector dato ->float=8bytes
    int dim;
    int Nfilas;//Numeros de filas
    int Ncol;//Numeros de columnas
    float EP;//Elemento predominante

    //Constructor
    public Sparse(int Nfilas, int Ncol, float EP) {
        this.VFC = new int[10];//En caso que necesitemos 
        //mas espacio redimencionamos
        this.VD = new float[10];//
        this.dim = -1;
        this.Nfilas = Nfilas;
        this.Ncol = Ncol;
        this.EP = EP;

    }

    public boolean vacia() {
        return (this.dim == -1);
    }

    public void Set(int fila, int col, float dato) {
        if ((fila > Nfilas) || (col > Ncol)) {
            System.out.println("Error::Set:fila y columna fuera de rango");
            System.exit(1);
        } else {
            int FC = (fila - 1) * Ncol + col;
            if (vacia()) {
                if (dato != EP) {
                    this.dim++;
                    VD[dim] = dato;
                    VFC[dim] = FC;
                }
            } else {
                int x = buscarFC(fila, col);
                if (x == -1) {
                    redimencionar();
                    dim++;
                    VD[dim] = dato;
                    VFC[dim] = FC;

                } else {
                    if (dato != EP) {//Actualizar
                        VD[x] = dato;
                    } else {//Eliminar
                        for (int i = x; i < dim; i++) {
                            VFC[i] = VFC[i + 1];
                            VD[i] = VD[i + 1];
                        }
                        dim--;
                    }

                }
            }

        }
    }

    private int buscarFC(int fila, int col) {
        int FC = (fila - 1) * Ncol + col;
        int i = 0;
        while ((i <= dim) && VFC[i] != FC) {
            i++;
        }
        if (i <= dim) {
            return (i);
        } else {
            return (-1);
        }

    }

    private void redimencionar() {
        if (dim == VFC.length - 1) {
            int VFC1[];
            float VD1[];
            VD1 = new float[VD.length];
            VFC1 = new int[VFC.length];
            System.arraycopy(VD, 0, VD1, 0, VD.length);
            System.arraycopy(VFC, 0, VFC1, 0, VFC.length);
            VD = new float[VD1.length + 5];
            VFC = new int[VFC1.length + 5];
            System.arraycopy(VD1, 0, VD, 0, VD1.length);
            System.arraycopy(VFC1, 0, VFC, 0, VFC1.length);
        }

    }

    public float Get(int fila, int col) {
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
        Sparse A = new Sparse(10, 10, 0);
        //Comprobando el insertar
        A.Set(1, 1, 8);
        A.Set(2, 5, 15);
        A.Set(3, 3, 3);
        A.Set(1, 10, 20);
        A.Set(8, 10, 19);
        A.Set(10, 10, 21);

        A.Set(1, 1, 4);//Comprobando el actualizar
        A.Set(1, 1, 0);//Comprobando el eliminar
        //A.Set(10, 10, 0);
        System.out.println(A.toString());//Funcionan correctamente
    }

}

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
public class SparseBits {

    //Atributos
    VectorBitsG VFC;//Vector fila columna
    float VD[];//Vector de datos
    int dim;
    int Nfilas;//Numero de filas
    int Ncol;//Numero de columnas
    float EP;//Elemento predominante     

    //Constructor
    public SparseBits(int Nfilas, int Ncol, float EP) {
        int x = calcularbits(Nfilas * Ncol);
        VFC = new VectorBitsG(10, x);
        VD = new float[10];
        this.dim = -1;
        this.Nfilas = Nfilas;
        this.Ncol = Ncol;
        this.EP = EP;
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
            float VD1[] = new float[VD.length];
            System.arraycopy(VD, 0, VD1, 0, VD.length);
            VD = new float[VD1.length + 5];
            System.arraycopy(VD1, 0, VD, 0, VD1.length);
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
        SparseBits A = new SparseBits(5, 5, 0);
        A.Set(1, 1, 19);
        A.Set(1, 5, 16);
        A.Set(5, 5, 48);
        A.Set(4, 1, 40);
        A.Set(3, 5, 17);
        A.Set(3, 5, 0);//Comprobando el eliminar
        A.Set(1, 1, 90);//Comprobando el actualizar
        A.Set(1, 5, 80);
        A.Set(1, 3, 19);
        A.Set(1, 2, 16);
        A.Set(5, 4, 47);
        A.Set(4, 3, 40);
        A.Set(5, 1, 1);
        A.Set(5, 3, 2);
        A.Set(4, 2, 30);
        A.Set(2, 3, 11);
        A.Set(5, 2, 22);
        A.Set(4, 3, 31);
        A.Set(2, 2, 99);
        A.Set(3, 2, 88);
        //A.Set(4, 1, 0);

        System.out.println(A.toString());
    }
}

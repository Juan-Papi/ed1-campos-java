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
public class VectorBitsG {

//Atributos
    int v[];//vector de elementos int
    int dim;//dimension del subvector
    int cantBits;//Cant de bits a usar

//Constructor sobrecargado por conveniencia
    public VectorBitsG(int cant, int nroBits) {
        int ent = (cant*nroBits) / 32;
        if (cant % 32 != 0) {
            ent++;
        }
        v = new int[ent];//ent=longitud del vector
       
        this.dim = cant;//dim del subvector  
        this.cantBits = nroBits;//Cantidad de bits que se usaran por elemento
    }
//Inserta un elemento ele al subvector en la posicion pos

    public void insertar(int ele, int pos) {
        int nbit = obtenernbit(pos);
        int nent = obtenerNent(pos);
        int mask = ((int) Math.pow(2, cantBits)) - 1;
        mask = mask << (nbit - 1);
        mask = ~mask;
        int cpe = ele;//Copia del elemento
        v[nent] = v[nent] & mask;
        ele = ele << (nbit - 1);
        v[nent] = v[nent] | ele;//se ha insertado el elemento
        if (((nbit - 1) + cantBits) > 32) {
            int mask1 = ((int) Math.pow(2, cantBits) - 1);
            mask1 = mask1 >>> (32 - (nbit - 1));
            mask1 = ~mask1;
            v[nent + 1] = v[nent + 1] & mask1;
            cpe = cpe >>> (32 - (nbit - 1));//ocultamos los primeros 4 bits que ya han sido insertados 
            v[nent + 1] = v[nent + 1] | cpe;//En este punto cualquier elemento queda insertado por completo
        }

    }
//Devuelve el elemento del subvector de la posicion 

    public int Get(int pos) {//Devuelve el elemento de la posicion pos de CantBits por elemento
        int ent = obtenerNent(pos);//1
        int nbit = obtenernbit(pos);//4
        int mask = (((int) Math.pow(2, cantBits)) - 1);
        mask = mask << (nbit - 1);
        mask = mask & v[ent];//v[ent]"el entero que esta en la posicion ent"
        mask = mask >>> (nbit - 1);
        if (((nbit - 1) + cantBits) > 32) {
            int mask1 = ((int) Math.pow(2, cantBits) - 1);
            mask1 = mask1 >>> (32 - (nbit - 1));
            mask1=mask1 & v[ent+1];
            mask1=mask1<<(32-(nbit-1));
            mask=mask | mask1;
        }
        return mask;
    }

    private int obtenernbit(int pos) {
        return ((((pos - 1) * cantBits) % 32) + 1);
    }

    private int obtenerNent(int pos) {
        return (((((pos - 1) * cantBits) / 32)));
    }

    public String toString() {
        String cad = "<< ";
        for (int i = 1; i <= dim; i++) {
                 cad=cad+Get(i)+" , ";
        }
         cad=cad+">>";
        return cad;
    }
    public int getNroBits(){
        return cantBits;
    }
    public int getDimSub(){
        return dim;
    }
    public static void main(String[] args) {
          VectorBitsG A=new VectorBitsG(10,8);
          A.insertar(10,1);
          A.insertar(15, 4);
          A.insertar(255, 10);
          
          System.out.println(A);
          
          
    }
}

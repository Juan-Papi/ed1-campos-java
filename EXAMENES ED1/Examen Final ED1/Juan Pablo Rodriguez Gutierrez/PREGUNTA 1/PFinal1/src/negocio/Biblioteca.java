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
public class Biblioteca {
    //Atributos

    VectorBitsG v;
    String autores[];
    String editoriales[];
    int dim;

    //Constructor sobrecargado
    public Biblioteca(int cant) {//cant=Cantidad de libros
        v = new VectorBitsG(cant, 22);
        autores = new String[cant];
        editoriales=new String[cant];
        this.dim = 0;
    }

    private boolean ExisteCodigo(int cod) {
        boolean b = false;
        int i = 1;
        while (i <= dim) {
            if (getCod(i) == cod) {
                b = true;
            }
            i++;
        }
        return b;
    }

    public void insertar(String autor, String editorial, int cod, int edicion, int Npag, int año) {
        if (!ExisteCodigo(cod)) {
            this.autores[dim] = autor;
            this.editoriales[dim] = editorial;
            this.dim++;

            int mask = cod;//codigo insertado
            mask = mask << 2;
            mask = mask | edicion;//edicion insertada
            mask = mask << 7;
            mask = mask | Npag;//N pag insertada
            mask = mask << 6;

            año = año - 1980;
            mask = mask | año;//año insertado

            v.insertar(mask, dim);
        }
        //Comprobando 
        // System.out.println("Dato:" + mask + ": ");
        //System.out.println(Integer.toBinaryString(mask));
        // System.out.println(v);
        // System.out.println(nombres[dim - 1]);

    }

    public String getAutor(int pos) {
        return autores[pos - 1];
    }

    public String getEditorial(int pos) {
        return editoriales[pos - 1];
    }

    public int getCod(int pos) {
        int codigo = v.Get(pos);
        codigo = (codigo >>> 15) & (int) (Math.pow(2, 7) - 1);
        return codigo;
    }

    public int getEdic(int pos) {
        int edic = v.Get(pos);
        edic = (edic >>> 13) & (int) (Math.pow(2, 2) - 1);
        return edic;
    }

    public int getNpag(int pos) {
        int Npa = v.Get(pos);
        Npa = (Npa >>> 6) & (int) (Math.pow(2, 7) - 1);
        return Npa;
    }

    public int getAño(int pos) {
        int año = v.Get(pos);
        año = (año >>> 0) & (int) (Math.pow(2, 6) - 1);
        return año + 1980;
    }

    public String MostrarBibliot(int pos) {
        String cad = "\n---------------------------------------\n";
        cad=cad+"N°: "+pos;
        cad = cad + "\nCodigo Libro: " + getCod(pos);
        cad = cad + "\nAutor: " + getAutor(pos);
        if (getEdic(pos) == 1) {
            cad = cad + "\nEdicion: 1°";
        } else {
            if (getEdic(pos) == 2) {
                cad = cad + "\nEdicion: 2°";
            } else {
                cad = cad + "\nEdicion: 3°";
            }
        }
        cad = cad + "\nN° de Pagina: " + getNpag(pos);
        cad = cad + "\nEditorial: " + getEditorial(pos);
        cad = cad + "\nAño: " + getAño(pos);
        return cad;
    }
    public String toString(){
        String S="";
        for (int i = 1; i <=dim; i++) {
            S=S+MostrarBibliot(i);
        }
        return S;
    }
    public static void main(String[] args) {
         Biblioteca b=new Biblioteca(3);
         b.insertar("Ruben Cab","Santillana",55, 1,80,2000);
          b.insertar("Luis Joyanes","Pauro",58, 2,85,1980);
         //System.out.println(b.MostrarBibliot(1));
         System.out.println(b.toString());
    }
}

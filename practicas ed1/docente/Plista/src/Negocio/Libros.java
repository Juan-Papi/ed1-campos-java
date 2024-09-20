/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;

/**
 *
 * @author Mario Campos
 */
public class Libros implements Comparable, Serializable {  int Cod;
                       String Titulo;
                       String Autor;
                       int Edicion;
                       int Año;
                       String Editorial;
                       int NumeroPag;

    public Libros() {
    }

    public Libros(int Cod, String Titulo, String Autor, int Edicion, int Año, String Editorial, int NumeroPag) {
        this.Cod = Cod;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Edicion = Edicion;
        this.Año = Año;
        this.Editorial = Editorial;
        this.NumeroPag = NumeroPag;
    }

                       
                       
    public void setCod(int Cod) {
        this.Cod = Cod;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public void setEdicion(int Edicion) {
        this.Edicion = Edicion;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public void setNumeroPag(int NumeroPag) {
        this.NumeroPag = NumeroPag;
    }

    public int getCod() {
        return Cod;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public int getEdicion() {
        return Edicion;
    }

    public int getAño() {
        return Año;
    }

    public String getEditorial() {
        return Editorial;
    }

    public int getNumeroPag() {
        return NumeroPag;
    }
    
  
    @Override
    public String toString() {
        return "Cod=" + Cod + '\n'+"Titulo=" + Titulo + '\n'+ "Autor=" + Autor +'\n'+ "Edicion=" + Edicion + '\n'+ "Año Publicacion=" + Año + '\n'+"Editorial=" + Editorial + '\n'+ "NumeroPag=" + NumeroPag+'\n'+'\n';
    }
                       
    @Override
    public int compareTo(Object o) {
        Libros A=(Libros)o;
        return ((getCod()<A.getCod())?-1:(getCod()>A.getCod())?1:0);
    }                                      
    
}

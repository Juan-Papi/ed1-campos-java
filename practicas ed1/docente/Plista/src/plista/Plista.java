/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plista;

import Negocio.Alumno;
import Negocio.Libros;
import Negocio.Lista;
import Negocio.ListaG;

/**
 *
 * @author Mario Campos
 */
public class Plista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /* Lista L=new Lista();
        L.insertar(10);
        L.insertar(2);
        L.insertar(1);
        L.insertar(10);
        L.insertar(5);
        L.insertar(8);
        L.insertar(3);
        L.insertar(2);
        System.out.println(L);
        L.Eliminar(8);
        L.Eliminar(1);
        System.out.println(L);
        L.insertar(4);
        L.insertar(1);
        L.Eliminar(10);
        L.Eliminar(50);
        System.out.println(L);
        System.out.println(L.Existe(4));
        System.out.println(L.Existe(10));
        L.insertar(0);
        System.out.println(L);
        System.out.println(L.getDato(2));*/
       /* ListaG LE=new ListaG<Integer>();
        LE.Insertar(1);
        LE.Insertar(20);
        LE.Insertar(5);
        LE.Insertar(3);
        System.out.println(LE.Mostrar());
        ListaG LF=new ListaG<Float>();
        LF.Insertar(10.2);
        LF.Insertar(1.1);
        LF.Insertar(5.1);
        LF.Insertar(8.41);
        System.out.println(LF.Mostrar());
        ListaG LS=new ListaG<String>();
        LS.Insertar("zalberto");
        LS.Insertar("carlos");
        LS.Insertar("raul");
        LS.Insertar("manuel");
        LS.Insertar("abigail");
        System.out.println(LS.Mostrar());
        System.out.println('\n');
        Alumno A=new Alumno();
        A.setCI(102);
        A.setEdad(32);
        A.setNombre("Abel");
        A.setRegistro(202058741);
        A.setSexo(true);
        Alumno B=new Alumno(5242,202158745,"Rene",true,25);
        Alumno C=new Alumno(5111,201758745,"Carlos",true,45);

        ListaG LA= new ListaG<Alumno>();
        LA.Insertar(A);
        LA.Insertar(B);
        LA.Insertar(C);
        for (int i = 1; i <= LA.Cant; i++) {
            Alumno x=(Alumno)LA.Getdato(i);
             System.out.println(x);
                      
        }
        */
        Libros M=new Libros(105,"Informatica basica","Pedro garron",1,2020,"Santillana",250);
        Libros N=new Libros(103,"Informatica I","Alberto Suarez",2,2021,"la Hoguera",150);
        Libros O=new Libros(101,"Estructuras","Luis Joyanes",4,2018,"Mc graw",550);
        Libros P=new Libros(107,"Sistemas Operativas I","Felix Ortuste",2,2015,"La estrella",450);
        Libros R=new Libros(103,"Sistemas Operativas I","Felix Ortuste",2,2015,"La estrella",450);
        ListaG LI=new ListaG<Libros>();
        LI.Insertar(M);
        LI.Insertar(N);
        LI.Insertar(O);
        LI.Insertar(P);
        LI.Insertar(R);
       /*for (int i = 1; i <= LI.cantidad(); i++) {
            Libros x=(Libros)LI.Getdato(i);
             System.out.println(x);
                      
        }*/ 
        System.out.println(LI.toString());
        
        
        
    }
    
}

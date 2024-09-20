/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plistadoble;

import Negocio.ListaDoble;

/**
 *
 * @author Mario Campos
 */
public class PlistaDoble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaDoble L=new ListaDoble();
        L.Insertar(5);
        L.Insertar(2);
        L.Insertar(1);
        L.Insertar(10);
        L.Insertar(2);
        L.Insertar(7);
        L.Insertar(3);
        L.Insertar(10);
        System.out.println(L);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectorbitsg;

import Negocio.VectorbitsGe;

/**
 *
 * @author Mario Campos
 */
public class VectorbitsG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VectorbitsGe A=new VectorbitsGe(10,5);
        A.Insertar(10, 1);
        A.Insertar(22,2);
        A.Insertar(25,3);
        A.Insertar(15, 5);
        A.Insertar(1, 8);
        A.Insertar(11,9);
        A.Insertar(8, 10);
       
        System.out.println(A);
        
    }
    
}

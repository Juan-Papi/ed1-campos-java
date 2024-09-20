/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcolas;

import Negocio.ColaB;
import Negocio.ColaV;

/**
 *
 * @author Mario Campos
 */
public class Pcolas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ColaV Q=new ColaV(10);
        ColaB Q=new ColaB(10,7);
        Q.Encolar(9);
        Q.Encolar(1);
        Q.Encolar(2);
        Q.Encolar(8);
        Q.Encolar(3);
        Q.Encolar(7);
        Q.Encolar(1);
        Q.Encolar(18);
        Q.Encolar(31);
        Q.Encolar(77);
        System.out.println(Q);
       // Q.Encolar(77);
        System.out.println();
        System.out.println(Q.Decolar());
        System.out.println(Q.Decolar());
        System.out.println(Q.Decolar());
        System.out.println(Q.Decolar());
        Q.Encolar(90);
        Q.Encolar(100);
        System.out.println();
        System.out.println(Q);
        
    }
    
}

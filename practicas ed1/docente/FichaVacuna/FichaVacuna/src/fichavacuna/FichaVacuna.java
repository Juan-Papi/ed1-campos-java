/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichavacuna;

import Negocio.Ficha;
import Negocio.VectorNbits;

/**
 *
 * @author ReyMarPc
 */
public class FichaVacuna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ficha A=new Ficha(100);
        A.insertar(15, 12, 2020, 0, 15);
        A.insertar(11, 10, 2021, 1, 15);
        System.out.println(A);
        A.setaño(1, 2021);
        A.setaño(2, 2020);
        System.out.println(A);
    }
    
}

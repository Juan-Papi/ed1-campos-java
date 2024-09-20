/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

import NEGOCIO.FCOVID;

/**
 *
 * @author fabio
 */
public class COVID19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FCOVID A =new FCOVID();
        A.insertar("fabio", 127, 0, 58.9, true, true, true, true, true, true, true, true, true);
        System.out.println(A.GetPgusto(0));
    }
    
}

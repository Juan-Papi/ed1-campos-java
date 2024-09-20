/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psparse;

import Negocio.Sparse;
import Negocio.SparseBit;

/**
 *
 * @author Mario Campos
 */
public class PSparse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                // TODO code application logic here
        
      /*  Sparse A=new Sparse(10,10,0);
        A.Set(1,2, 8);
        A.Set(5,8,15);
        A.Set(1,9, 18);
        A.Set(8,1,25); 
        A.Set(3,7,1);
        A.Set(10,3,35);
        A.Set(7,2, 1);
        A.Set(6,5,4); 
        System.out.println(A);
        A.Set(2,2, 78);
        A.Set(1,2,24);
        A.Set(1,9, 0);
        System.out.println(A);*/
        
        SparseBit A=new SparseBit(10,10,0);
        A.Set(1,2, 8);
        A.Set(5,8,15);
        A.Set(1,9, 18);
        A.Set(8,1,25); 
        A.Set(3,7,1);
        A.Set(10,3,35);
        A.Set(7,2, 1);
        A.Set(6,5,4); 
        System.out.println(A);
        A.Set(2,2, 78);
        A.Set(1,2,24);
        A.Set(1,9, 0);
        System.out.println(A);
        
    }
    
}

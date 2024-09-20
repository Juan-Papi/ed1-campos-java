/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda.polinomio;

import Negocios.Monomio;
import Negocios.Polinomio;

/**
 *
 * @author Mario Campos
 */
public class TDAPolinomio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Monomio a=new Monomio();
       a.setCoef(3);
       a.setExp(2);
       a.setsigno('-'); 
       Monomio b=new Monomio();
       b.setCoef(5);
       b.setExp(1);
       b.setsigno('+');
       Monomio c=new Monomio();
       c.setCoef(8);
       c.setExp(5);
       c.setsigno('+');
       Polinomio x=new Polinomio();
       x.Insertar(a);
       x.Insertar(b);
       x.Insertar(c);
        System.out.println(x);
       Monomio d=new Monomio();
       d.setCoef(3);
       d.setExp(2);
       d.setsigno('+');
       x.Insertar(d);
       System.out.println(x);
       
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdanodo;

/**
 *
 * @author Estudiante
 */
public class TDANodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        //P '10'E -> Q '20'E -> R '30'E
        
    /**    Nodo p = new Nodo();
        p.setDato(10);
        p.setEnlace(null);
        System.out.println(p);
        
        Nodo q = new Nodo(20);
        p.setEnlace(null);
        System.out.println(q);
        
        Nodo r = new Nodo();
        r.setDato(30);
        r.setEnlace(null);
        System.out.println(r);
        
        p.setEnlace(q);
        q.setEnlace(r);
        System.out.println(q.getDato());
        System.out.println(p.getEnlace().getDato());
        System.out.println(p.getEnlace().getEnlace().getDato());

        
         
          Lista L = new Lista();    // cant = 0
          L.Insertar(8);    // L -> '8'                             cant = 1
          L.Insertar(2);    // L -> '2','8'                         cant = 2
          L.Insertar(10);   // L -> '2','8','10'                    cant = 3
          L.Insertar(8);    // L -> No hará nada por elemento único cant = 3
          L.Insertar(9); 
          L.Insertar(1); 
            L.Insertar(15); 
            L.Insertar(12); 
            L.Insertar(9);
            L.Insertar(10);
            L.Insertar(4);
            System.out.println(L);
            L.Eliminar(1);
            L.Eliminar(10);
            L.Eliminar(15);
            L.Eliminar(5);
            L.Insertar(15);
            

         System.out.println(L);
         System.out.println(L.getDato(5));
       */     
         Lista L2 = new Lista();
         L2.Insertar(1); 
         L2.Insertar(2); 
         L2.Insertar(3);
         L2.Insertar(4);
         L2.Insertar(5);
         System.out.println(L2);
         
        // L2.InvertirR();
       //  System.out.println(L2);
         
         L2.Invertir();
         System.out.println(L2);
         
         
//Implementar un método de la Class Lista para invertir la Lista
    // Nota. Manipular enlaces 
    }
    
}

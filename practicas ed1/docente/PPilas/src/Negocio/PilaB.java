/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Mario Campos
 */
public class PilaB { VectorbitsGe P;
                     int cima;

    public PilaB(int cant, int nbits) {
        P=new VectorbitsGe(cant,nbits);
        cima=0;
    }
   public boolean Vacia(){
   return cima==0;
   } 
   public boolean llena(){
   return P.dim==cima;
   }
   
   public void Push(int ele){
     if (llena()){
      System.out.println("Error::Push: La pila Bits esta Llena");
      System.exit(1);
    }
    else{
      cima++;
      P.Insertar(ele, cima);
    }
   }   
   public int Pop(){
     cima--;
     return(P.Get(cima+1));
   
   }    
    public int Get(){
     return P.Get(cima);
     }
   @Override
    public String toString() {
        String S="";
        for (int i = cima; i >=1; i--) {
            S=S+P.Get(i)+'\n';
            
        }
        S=S+"P";
        return S;
    }
                     
}

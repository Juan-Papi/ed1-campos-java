/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

/**
 *
 * @author Mario Campos
 */
public class Polinomio { Monomio P[];//vector de Monomios
                         int dim;

    public Polinomio() {
        this.P = new Monomio[5];
        this.dim = -1;
    }
    public void Insertar(Monomio x){
      if (vacia()){
       
       dim++;
       P[dim]=x;
      }
      else { 
          redimencionar();
          int i=0;
            while  ((i<=dim)&&(P[i].getExp()>x.getExp())){
                i++;
            } 
           if (i>dim){
          
             dim++; 
             P[i]=x;
           
           }
           else{  if (P[i].getExp()!=x.getExp()){
                    for (int j = dim; j >=i; j--) {
                       P[j+1]=P[j];
                   
               };   
                    P[i]=x;
                    dim++;
           }
           else { int suma=P[i].Coef+x.Coef;
                    if (suma==0){
                        for (int j = i; j < dim; j++) {
                            P[j]=P[j+1];
                            
                        }
                        dim--;
                    }
                    else{
                      P[i].Coef=suma;
                    }
           }
           }
        }                     
    
}
public boolean vacia(){
return(dim==-1);//es una condicion
}
public void eliminar(int exp){
if (!vacia()){
   int i=0;
   while ((i<=dim)&&(P[i].getExp()!=exp)){
   i++;
   }
   if (i<=dim){
       for (int j = i; j < dim; j++) {
           P[j]=P[j+1];
           
       }
       dim--;  
   }}


}
private void redimencionar(){
  if (dim==P.length-1){//significa que el vector esta lleno
   Monomio q[]=new Monomio[P.length];
   System.arraycopy(P, P.length, q, 0, P.length);
   //copiamos de P length elementos a q desde la pos 0 length elementos
   P=new Monomio[q.length+5];
   System.arraycopy(q, q.length, P, 0, q.length);
   
}}

    @Override
    public String toString() {
        
        String S="P(x)=";
         for (int i = 0; i <= dim; i++) {
            S=S+P[i].toString();
            
        }
        
        return S;
    }



public void suma(Polinomio p, Polinomio q){
    for (int i = 0; i < p.dim; i++) {
        Insertar(p.P[i]);
        
    }
    for (int j = 0; j < q.dim; j++) {
        Insertar(q.P[j]);
        
    }
  };
public void resta(){};
public void Mult(){};
public void division(){};
public void Derivar(){};
public void integrar(){};



}
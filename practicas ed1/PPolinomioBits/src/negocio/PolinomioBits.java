/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author 59178
 */
public class PolinomioBits {
    //Atributos
    VectorBitsG v;
    int dim;
    //Constructor
    public PolinomioBits(int cantPol){//cantPol="Cantidad de polinomios"
        v=new VectorBitsG(cantPol,9);
        this.dim=0;
    }
    //Setters                  +       9       9      
   public void insertar(char signo,int coef,int exp){
       int s;
       if(signo =='+'){
           s=0;
       }else{
         s=1;
       }
       int dato=s;
      
       dato=dato<<4;//  ->|0|0000
       dato=dato|coef;//->|0|1001
       dato=dato<<4;//->  |0|1001|0000
       dato=dato|exp;//-> |0|1001|1001
       this.dim++;
       v.insertar(dato,this.dim);
     //System.out.println("dato:"+dato+"->"+Integer.toBinaryString(dato));
     // System.out.println(v.toString());
      
       
   } 
   public char getSigno(int pos){
        int dato=v.Get(pos);//|0|1001|1001
        //9-1=8;
        dato=dato>>>8;//00000000|0|
        dato=dato&1;  //0 ,1 2^1 -1=1
        //00000000|0|
        //00000000|1|=1
        //-------------
        //00000000|0|=0
        if(dato==0){
            return '+';
        }else{
            return '-';
        }
    }

   public int getNum(int pos){
       int dato=v.Get(pos);
       dato=dato>>>4;
       dato=dato & 15;
       return dato;
   }
   public int getExp(int pos){
        int dato=v.Get(pos);//|0|1001|1001
        //4-4=0;
        dato=dato&15;
        return dato;
    }
 public String toString(){
        String S=" ";
        for (int i = 1; i <=this.dim; i++) {
            S=S+getSigno(i)+" "+getNum(i)+"X^"+getExp(i);
        }
        return S;
    }

    public static void main(String[] args) {
         PolinomioBits A=new PolinomioBits(10);
         A.insertar('+', 8, 8);
         A.insertar('-', 5, 2);
         System.out.println(A.toString());
         
         
    }
}

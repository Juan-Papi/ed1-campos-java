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
public class ColaV { int C[];
                     int Frente;
                     int Atras;

    public ColaV(int cant) {
        this.C = new int[cant];
        this.Frente = -1;
        this.Atras = -1;
    }
    public boolean vacia(){
    return (Frente==-1);
    }
    public boolean Llena(){
    return((Atras+1)%C.length==Frente);
    
    }
    public void Encolar(int ele){
     if (vacia()){
         Frente=0;
         Atras=0;
         C[Atras]=ele;
     
     }else
     { if (Llena()){
     System.out.println("Error::Encolar:Cola Llena");
     System.exit(1);
     
     }else{
       Atras=(Atras+1)%C.length;
       C[Atras]=ele;
     }
     }
     }
    
    public int Decolar(){
    int x=C[Frente];
    if (Frente==Atras){
    Frente=-1;
    Atras=-1;
    }else
        Frente=(Frente+1)%C.length;
    return x;
    } 
    
    public int Get(){
    return(C[Frente]);
    }
    public void invertirR(){
        if(vacia()){//1er caso base
            //nada
        }else{
            if(Frente==Atras){//2do caso base
                //cuando hay 1 elemento
               //nada
            }else{//caso general
               int x=Decolar();
               invertirR();
                Encolar(x);
            }
        }
    }
    private int Menor(){
        if(Atras==Frente){//caso base
            //cuando hay 1 elemento
            return C[Atras];
        }else{
            int x=Decolar();
            int men=Menor();
            Encolar(x);
            if(x<men){
                men=x;
            }
            return men;
        }
    }
     public int MenorR(){
        int menor=Menor();
        invertirR();
         return menor;
     }
    @Override
    public String toString() {
        String S="Q=[";
        int Aux=Frente;
        while (Aux!=Atras){
        S=S+C[Aux]+" , ";
        Aux=(Aux+1)%C.length;
        }
        S=S+C[Aux]+"]"+"\n";
        return S;
    }
    public static void main(String[] args) {
    //----------------------------------------------------
        ColaV c1=new ColaV(10);
         c1.Encolar(8);
         c1.Encolar(5);
         c1.Encolar(7);
         c1.Encolar(1);
         System.out.println(c1.toString());
    //----------------------------------------------------
        /* c1.invertirR();
         System.out.println(c1.toString());*/
    //----------------------------------------------------
        System.out.println("El menor es: "+c1.MenorR());  
        System.out.println(c1.toString());
            
    }
    
}

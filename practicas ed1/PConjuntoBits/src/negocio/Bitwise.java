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
public class Bitwise {
    //Atributos
        int v;
    
  //Constructor

    public Bitwise() {
        this.v=0;
    }
  //Setters
    
    //Encender bit
    public void set1(int pos){
        int mask=1;
        mask=mask<<(pos-1);
        v=v|mask;
    }
    //Apagar bit
    public void set0(int pos){
        int mask=1;
        mask=mask<<(pos-1);
        mask=~mask;
        v=v&mask;
    }
    //Getters 
    
    //Obtener bit
    public int getBit(int pos){
        int mask=1;
        mask=mask<<(pos-1);
        mask=mask&v;
        mask=mask>>>(pos-1);
        return mask;
                
    }
    //Devuelve los atributos en una cadena
    public String toString(){
        String cad="V={ ";
        for (int i =32; i>=1; i--) {
            cad=cad+getBit(i)+"  ";
                    
            
        }
        cad=cad+"}";
        return cad;
    }
    public static void main(String[] args) {
        Bitwise A=new Bitwise();
        A.set1(1);
        A.set1(10);
        A.set1(15);
        A.set1(20);
        A.set1(31);
        System.out.println(A);
        A.set0(1);
        A.set0(10);
        A.set0(15);
        A.set0(20);
        A.set1(32);
        System.out.println(A);
    }
        
    
}

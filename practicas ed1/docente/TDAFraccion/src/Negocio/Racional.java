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
public class Racional {  int numerador;// representa al numerador y signo
                         int denominador;
//contructor por defecto
    public Racional() {
        numerador=0;
        denominador=1;
    }

    
 //constructor sobrecargado     
    public Racional(char signo, int numerador, int denominador) {
       if (denominador==0){
       System.out.println("Error::Racional:Denominador no debe ser 0");
       System.exit(1);
       
       }
       else{
        
             if (signo=='+'){
              this.numerador = +Math.abs(numerador);
              } else{
              this.numerador=- Math.abs(numerador);
              }
        
        this.denominador = Math.abs(denominador);
        simplificar();
    }
    }                  
//Modifica el Numerador del racional 
    public void setNumerador(int numerador) {
        if (this.numerador>=0)
        this.numerador = + Math.abs(numerador);
        else{ this.numerador=-Math.abs(numerador);
        }
        simplificar();
    }

    public void setDenominador(int denominador) {
        if (denominador==0){
            System.out.println("Error::Setdenominador :Denominador no debe ser 0");
            System.exit(1);
        }
        else{
        this.denominador = Math.abs(denominador);
        simplificar();
    }
    }
    
    public void setsigno(char signo){
    if (signo=='+'){
      this.numerador=+Math.abs(numerador);}
     else {
       this.numerador=-Math.abs(numerador);
    }
    }
//Devuelve el denominador del racional 
    public int getDenominador() {
        return denominador;
    }
//Devuelve el numerador del racional 
    public int getNumerador() {
        return Math.abs(numerador);
    }
    //Devuelve el signo del racional 
    public char getsigno(){
    if (this.numerador>=0)
        return('+');
    else
        return('-');
    
    }
 public void Suma(Racional A, Racional B){
 
  int comunD=A.denominador*B.denominador;   
   this.numerador=  comunD/A.denominador*A.numerador+comunD/B.denominador*B.numerador;
   this.denominador=comunD;
   simplificar();
 }
 
 public void Resta(Racional A, Racional B){
 
  int comunD=A.denominador*B.denominador;   
   this.numerador=  comunD/A.denominador*A.numerador-comunD/B.denominador*B.numerador;
   this.denominador=comunD;
   simplificar();
 }
 
 public void simplificar(){};
 
}

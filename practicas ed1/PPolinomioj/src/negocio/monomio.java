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
public class monomio {
    //Atributos
    fraccion coef;
    fraccion exp;
    //constructor por defecto

    public monomio() {
        coef=new fraccion();
        exp=new fraccion();

        this.coef.setNum(0);
        this.coef.setDen(1);
        
        this.exp.setNum(1);
        this.exp.setDen(1);
    }
    //constructor sobrecargado
    public monomio(char signo,fraccion coef,fraccion exp){
        if(signo=='+'){
            this.coef.num=+Math.abs(coef.num); 
            this.coef.den=+Math.abs(coef.den);
        }
        else{
            this.coef.num=-Math.abs(coef.num);
            this.coef.den=+Math.abs(coef.den);
        }
        this.exp=exp;   
    }
    //Setters

    public void setCoef(fraccion coef) {
        //precondicion
        if (coef.num==0) {
             System.out.println("Error::Monomio:SetCoef:coeficiente 0");
             System.exit(1);
        } else {
            if (coef.num>=0 && coef.den>0) {
                this.coef.num=+Math.abs(coef.num);
                this.coef.den=+Math.abs(coef.den);
            } else {
                this.coef.num=-Math.abs(coef.num);
                this.coef.den=+Math.abs(coef.den);
            }
        }
        
    }

    public void setExp(fraccion exp) {
        if(exp.num>=0){
        this.exp.num = exp.num;
        this.exp.den=+Math.abs(exp.den);
        }
        else{
            System.out.println("Error::Monomio:setExp:Exponente negativo");
            System.exit(1);
        }
          
    }
    public void setSigno(char signo){
        if (signo=='+') {
            this.coef.num=+Math.abs(coef.num);
        } else {
             this.coef.num=-Math.abs(coef.num);
        }
 
    }

    public fraccion getCoef() {
        return coef;
    }

    public fraccion getExp() {
        return exp;
    }
    public char getSigno(){
        if (this.coef.num>=0) {
            return '+';
            
        } else {
            return '-';
        }
    }
    public void derivar(){
        fraccion ncoef=new fraccion();
        ncoef.multiplicar(coef,exp);
        
        this.coef=ncoef;
        
        fraccion aux=new fraccion(1,1,'+');
        
        fraccion nexp=new fraccion();
        nexp.resta(exp,aux);
      
        exp=nexp;
        
    }
    public void integrar(){
        
        fraccion aux=new fraccion(1,1,'+');
        
        fraccion nexp=new fraccion();
        nexp.suma(exp,aux);
        
        exp=nexp;
        fraccion ncoef=new fraccion();
        ncoef.dividir(coef,exp);
        this.coef=ncoef;
        
    }
    //Devuelve las atributos en una cadena
    public String toString(){
       String s="";
       s=s+"("+coef.num+"/"+coef.den+")"+"X^"+"("+exp.num+"/"+exp.den+")";
        return s;
    }
    public static void main(String[] args) {
        monomio A=new monomio();
        fraccion coef=new fraccion();
        coef.num=-5;
        coef.den=8;
        //Insertando coef. al monomio
        A.setCoef(coef);
        
        fraccion exp=new fraccion();
        exp.num=4;
        exp.den=5;
        //Insertando exponente al monomio
        A.setExp(exp);
        //A.derivar();
        A.integrar();
        
        System.out.println(A.toString());
              
        
    }
    
    
    
      
}

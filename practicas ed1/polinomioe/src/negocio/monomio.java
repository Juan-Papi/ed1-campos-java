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
    int coef;
    int exp;
    //constructor por defecto

    public monomio() {
        this.coef=0;
        this.exp=1;
    }
    //constructor sobrecargado
    public monomio(char signo,int coef,int exp){
        if(signo=='+'){
            this.coef=+Math.abs(coef);   
        }
        else{
            this.coef=-Math.abs(coef);
        }
        this.exp=exp;   
    }
    //Setters

    public void setCoef(int coef) {
        //precondicion
        if (coef==0) {
             System.out.println("Error::Monomio:SetCoef:coeficiente 0");
             System.exit(1);
        } else {
            if (coef>=0) {
                this.coef=+Math.abs(coef);
            } else {
                this.coef=-Math.abs(coef);
            }
        }
        
    }

    public void setExp(int exp) {
        if(exp>=0)
        this.exp = exp;
        else{
            System.out.println("Error::Monomio:setExp:Exponente negativo");
            System.exit(1);
        }
          
    }
    public void setSigno(char signo){
        if (signo=='+') {
            this.coef=+Math.abs(coef);
        } else {
             this.coef=-Math.abs(coef);
        }
 
    }

    public int getCoef() {
        return Math.abs(coef);
    }

    public int getExp() {
        return exp;
    }
    public char getSigno(){
        if (this.coef>=0) {
            return '+';
            
        } else {
            return '-';
        }
    }
    public void derivar(){
        int ncoef=coef*exp;
        int nexp=exp-1;
        coef=ncoef;
        exp=nexp;
        
    }
    public void integrar(){
        int nexp=exp+1;
        int ncoef=coef/nexp; 
        coef=ncoef;
        exp=nexp;
    }
    //Devuelve las atributos en una cadena
    public String toString(){
       String s=""+getSigno();
        if(getExp()==0)
            s=s+getCoef();
          
        if(getExp()==1)
            s=s+getCoef()+"x";
        else if(getExp()!=0){
             s=s+getCoef()+"x^ "+getExp();
            
        }
        return s;
    }
    public static void main(String[] args) {
       monomio A=new monomio('-', 5, 3); 
      A.derivar();
       
        System.out.println(A.toString());
        
    }
    
    
    
      
}

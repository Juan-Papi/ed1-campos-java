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
public class Monomio { int Coef;// signo y coeficiente
                        int Exp;

    public Monomio() {
        Coef=0;
        Exp=0;
    }

    public Monomio(char signo, int Coef, int Exp) {
        if (signo=='+'){
            this.Coef=+ Math.abs(Coef);
          }else
            this.Coef=-Math.abs(Coef);
        this.Exp = Exp;
    }

    public void setCoef(int Coef) {
        if (this.Coef>=0)
           this.Coef = + Math.abs(Coef);
        else
          this.Coef = - Math.abs(Coef);
    }

    public void setExp(int Exp) {
        this.Exp = Exp;
    }
    
    public void setsigno(char signo){
      if (signo=='+')
         this.Coef=+Math.abs(Coef);
      else
         this.Coef=-Math.abs(Coef);
    }

    public int getCoef() {
        return (Math.abs(Coef));
    }

    public int getExp() {
        return Exp;
    }
    public char getsigno(){
    if (this.Coef>=0)
    return'+';
    else
    return'-';
    }

    @Override
    public String toString() {
        String S="";
        S=S+getsigno();
        S=S+getCoef();
        S=S+"X^";
        S=S+getExp();
        return S;
    }
    
    
    
}

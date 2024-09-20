package Negocio;

public class Monomio {

    int Coef; //signo + Coef
    int exp; //exponente

    public Monomio(char signo, int Coef, int exp) {
        if (signo == '+') {
            this.Coef = +Math.abs(Coef);
        } else {
            this.Coef = -Math.abs(Coef);
        }
        this.exp = exp;
    }

    public Monomio() {
        this.Coef = 0;
        this.exp = 1;
    }

    public void setCoef(int Coef) {
        //Pre: Coef<>0
        if (Coef == 0) {
            System.out.println("Error:: Monomio:SetCoef:Coeficiente 0");
            System.exit(1);
        } else {
            if (this.Coef >= 0) {
                this.Coef = +Math.abs(Coef);
            } else {
                this.Coef = -Math.abs(Coef);
            }
        }
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setSigno(char signo) {
        if (signo == '+') {
            this.Coef = +Math.abs(this.Coef);
        } else {
            this.Coef = -Math.abs(this.Coef);
        }
    }

    public int getCoef() {
        return Math.abs(Coef);
    }

    public int getExp() {
        return exp;
    }

    public char getSigno() {
        if (this.Coef >= 0) {
            return ('+');
        } else {
            return ('-');
        }
    }

    @Override
    public String toString() {
        String S = "" + getSigno();
        if (getCoef() != 1) {
            S = S + getCoef();
        }
     
        if (getExp() == 1) {
            S = S + "x";
        }
        else if (getExp() != 0){
            S = S + "x^" + getExp();
        }
        
        return S;
    }

}

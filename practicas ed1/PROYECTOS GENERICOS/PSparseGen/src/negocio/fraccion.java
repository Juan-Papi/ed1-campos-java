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
public class fraccion {
    //Atributos 

    int num;
    int den;

    //Constructor default
    public fraccion() {
        this.num = 0;
        this.den = 1;
    }

    //constructor sobrecargado
    public fraccion(int num, int den, char signo) {
        if (den == 0) {
            System.out.println("Error::fraccionj:Denominador no debe ser 0");
            System.exit(1);
        } else {
            if (signo == '+') {
                this.num = +Math.abs(num);
            } else {
                this.num = -Math.abs(num);
            }
            this.den = Math.abs(den);
        }
        simplificar();
    }

    //Setters
    //Modifica el numerador de la fraccion
    public void setNum(int num) {
        if (getSigno() == '+') {
            this.num = +Math.abs(num);
        } else {
            this.num = -Math.abs(num);
        }
    }

    //Modifica el denominador de la fraccion
    public void setDen(int den) {
        if (den == 0) {
            System.out.println("Error::SetDen:Denominador no puede ser cero");
            System.exit(1);
        } else {
            this.den = +Math.abs(den);
        }

    }

    //Modifica el signo de la fraccion
    public void setSigno(char signo) {
        if (signo == '+') {
            this.num = +Math.abs(num);

        } else {
            this.num = -Math.abs(num);
        }

    }

    //Getters
    //devuelve el numerador de la fraccion
    public int getNum() {
        return Math.abs(num);
    }

    //Devuelve el denominador de la fraccion
    public int getDen() {
        return den;
    }

    //Devuelve el signo de la fraccion 
    public char getSigno() {
        if (this.num >= 0) {
            return ('+');
        } else {
            return '-';
        }
    }

    //Funcion ToString
    //Devuelve los atributos en una cadena
    @Override
    public String toString() {
        return "  " + getNum() + "\n" + getSigno() + " /" + "\n" + "  " + getDen();
    }

    //Simplifica la fraccion
    public void simplificar() {
        int cd = MCD();
        int n = getNum();
        int d = getDen();
        setNum(n / cd);
        setDen(d / cd);
    }

    //Saca el MAXIMO COMUN DIVISOR del num y den 
    public int MCD() {
        int r = 1;//residuo
        int n = getNum();//numerador
        int d = getDen();//denominador
        if (d == 0) {
            return n;
        } else {
            while (r != 0) {
                r = n % d;
                n = d;
                d = r;
            }

            return n;
        }

    }
    //Realiza la suma de dos fracciones en el self

    public void suma(fraccion A, fraccion B) {
        int d = A.getDen() * B.getDen();
        int n = (d / A.getDen() * A.num) + (d / B.getDen() * B.num);
        setDen(d);
        if (n >= 0) {
            setNum(Math.abs(n));
            setSigno('+');
        } else {
            setNum(Math.abs(n));
            setSigno('-');
        }
        simplificar();
    }

    //Realiza la resta de 2 fracciones en el self
    public void resta(fraccion A, fraccion B) {
        int d = A.getDen() * B.getDen();
        int n = (d / A.getDen() * A.num) - (d / B.getDen() * B.num);
        setDen(d);
        if (n >= 0) {
            setNum(Math.abs(n));
            setSigno('+');
        } else {
            setNum(Math.abs(n));
            setSigno('-');
        }
        simplificar();
    }

    //Realiza la multiplicacion de 2 fracciones en el self
    public void multiplicar(fraccion a, fraccion b) {
        int n = a.num * b.num;
        int d = a.den * b.den;
        if (n >= 0) {
            this.num = +Math.abs(n);

        } else {
            this.num = -Math.abs(n);

        }
        this.den = d;
        simplificar();
    }

    //Realiza la division de 2 fracciones en el self
    public void dividir(fraccion a, fraccion b) {
        int n = a.num * b.den;
        int d = a.den * b.num;
        setDen(d);
         setNum(n);
        if (n<=0 && d<=0 ||n>=0 && d>=0) {
            setSigno('+');
            
        } else {
            setSigno('-');
            
        }
        simplificar();
    }

    public static void main(String[] args) {
        fraccion A = new fraccion(8, 10, '-');
        System.out.println(A.toString());
        /*fraccion B = new fraccion(8, 7, '-');
        System.out.println("--------------");
        System.out.println(B.toString());
        fraccion C = new fraccion();
        C.dividir(A, B);
        System.out.println("--------------");
        System.out.println(C.toString());
         */
        String prueba="Hola mundo";
          char caracter_indice=prueba.charAt(0);//H 
          System.out.println(caracter_indice);
          
          
    }
}

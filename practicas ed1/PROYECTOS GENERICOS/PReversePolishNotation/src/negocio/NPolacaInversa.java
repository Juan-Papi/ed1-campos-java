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
public class NPolacaInversa {

    PostFijo notacion;
    String infija;
    String rpn;//en notación polaca inversa
    int lector;

    public NPolacaInversa() {
        notacion = new PostFijo();
        this.infija = "";
        this.rpn = "";
        this.lector = 0;
    }

    public void setInfija(String inf) {
        this.infija = inf;
    }

    private void setRPN(String rpn) {
        this.rpn = rpn;
    }

    public void ConvertirRPN() {
        notacion.setEntrada(infija);
        notacion.convertir();//convierte de infija a postfija
        setRPN(notacion.toString()); //devuelve en notación postfija lo que hay en entrada   
    }

    public boolean EsOperador(String cad) {
        return ("+".equals(cad) || "-".equals(cad) || "*".equals(cad) || "/".equals(cad)) || "^".equals(cad);
    }

    public String LeerToken() {
        String token = "";

        if (EsOperador(String.valueOf(rpn.charAt(lector)))) {
            //entra si es operador
            token = String.valueOf(rpn.charAt(lector));

        } else {
            if (!" ".equals(String.valueOf(rpn.charAt(lector)))) {
                //entra si es operando
                String operando = "";
                int j = lector;
                while ((j <= rpn.length() - 1) && (!EsOperador(String.valueOf(rpn.charAt(j))))
                        && (!" ".equals(String.valueOf(rpn.charAt(j))))) {

                    operando = operando + String.valueOf(rpn.charAt(j));

                    j++;
                }
                token = operando;
                lector = j - 1;
            } else {
                token = " ";
            }
        }

        return token;
    }

    public double calcular() {
        //lector=0,1,2,3,4,5,6,7,8,9    rpn,len 9
        GenericaPilaL<String> stack = new GenericaPilaL();
        String Lecturado = "";

        double res;//guarda los resultados parciales

        OPERAR calc;// para ir calculando
        while (lector <= (rpn.length()) - 1) {

            Lecturado = LeerToken();

            if (EsOperador(Lecturado)) {
                //Entra si es operador
                if (stack.cant >= 2) {
                    String EleDer = stack.Pop();//8
                    String EleIzq = stack.Pop();//3
                    calc = new OPERAR(EleIzq, EleDer, Lecturado);
                    res = calc.Realizar();//11
                    stack.Push(String.valueOf(res));
                } else {
                    System.out.println(
                            "Error::calcular:El usuario no ha introducido" + "\n" + "suficientes argumentos en la expresion"
                    );
                    System.exit(1);
                }

            } else {
                if (!" ".equals(Lecturado)) {
                    //Entra si es operando
                    stack.Push(Lecturado);

                }
            }

            lector++;
        }
        double resultado;
        if (stack.cant == 1) {
            resultado = Double.parseDouble(stack.Pop());
        } else {
            resultado = -1;//Error el usuario ha introducido demasiados elementos 
        }
        return resultado;
    }

    public static void main(String[] args) {
    //Comprobado funciona correctamente!!
        NPolacaInversa c = new NPolacaInversa();
        //c.setInfija("(1-2)^4*(4*(5/((5-3)^2)))");
        //c.setInfija("((((58+34)*(43+90))+90)-40)/7");
        //c.setInfija("3  +  4*  2");
        // c.setInfija("(3+4)*2-4");
        // c.setInfija("5+((1+2)*4)-3");
        //c.setInfija("((45+88)-49)/8");
        //c.setInfija("850/9");
         //c.setInfija("2^(7-1)");
         
        
        c.ConvertirRPN();
        
        double calculado=c.calcular();
         System.out.println(calculado);
        //System.out.println(c.rpn.length());
        
       
        //Comprobado el leer token
        /*
        System.out.println(c.LeerToken());
        System.out.println(c.lector);
        c.lector++;
        System.out.println(c.LeerToken());
        System.out.println(c.lector);
        c.lector++;
         System.out.println(c.LeerToken());
        System.out.println(c.lector);
        c.lector++;
         System.out.println(c.LeerToken());
        System.out.println(c.lector);
        c.lector++;
         System.out.println(c.LeerToken());
        System.out.println(c.lector);*/
     
         
         
         
         //c.setInfija("3++4**2564(jk))");
        //parentesis cerrado
        
        
    }
}

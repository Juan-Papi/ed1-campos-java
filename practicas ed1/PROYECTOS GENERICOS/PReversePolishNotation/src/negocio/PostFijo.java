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
public class PostFijo {

    //Atributos(Campos)
    String Entrada;//la expresion que queremos leer
    int lector;//Recorre la cadena de entrada 
    //variable global

    GenericaPilaL<String> Salida;//PostFija(RPN)
    //Stack
    GenericaPilaL<String> Pila1;//(Entran Operadores y paréntesis)

    //solo para pruebas no ocupado 
    GenericaPilaL<Double> Pila2;//Operandos

    //Constructor default(De oficio)
    public PostFijo() {
        Entrada = "";
        Salida = new GenericaPilaL();
        
        Pila1 = new GenericaPilaL();
        
        Pila2 = new GenericaPilaL();//solo para prueba
        this.lector = 0;
    }

    //Modificadores
    public void setEntrada(String Entrada) {
        int i=0;
        String aux=""; 
        //Eliminamos los espacios en blanco de la cadena de entrada
        while(i<=Entrada.length()-1){
            if(Entrada.charAt(i)!=' '){
                aux=aux+Entrada.charAt(i);
            }
            i++;
        }
        this.Entrada =aux;
    }
    public void setLector(int lec){
        this.lector=lec;
    }
    //Selectores
    public String getEntrada() {
        return this.Entrada;
    }
    
    public boolean esDigito(String car) {
        String dig = "0123456789";
        return (dig.contains(car));
        //dig.contains verifica si lo que hay en car pertenece a la cadena dig 
        //Devuelve true si pertenece

    }
    
    public boolean EsOperador(String cad) {
        return ("+".equals(cad) || "-".equals(cad) || "*".equals(cad) || "/".equals(cad)) || "^".equals(cad);
    }
    
    public boolean EsParentesis(String cad) {
        return (cad.equals("(") || (cad.equals(")")));
    }

    //Convierte de infijo a postFijo y lo guarda en salida==Postfijo
    //Hecho para probar Funciona!!
    /*public void ConvertirToPostFijo() {
        int i = 0;

        while (i <= (this.Entrada.length() - 1)) {

            if (EsOperador(String.valueOf(Entrada.charAt(i)))) {
                Pila1.Push(String.valueOf(Entrada.charAt(i)));
                Salida.Push(String.valueOf(Entrada.charAt(i)));
            } else {
                if (!EsParentesis(String.valueOf(Entrada.charAt(i)))) {
                    //entra si es operando
                    String operando = "";
                    int j = i;
                    while ((j <= Entrada.length() - 1) && (!EsOperador(String.valueOf(Entrada.charAt(j))))
                            && (!EsParentesis(String.valueOf(Entrada.charAt(j))))) {

                        operando = operando + String.valueOf(Entrada.charAt(j));

                        j++;
                    }
                    if (operando != "") {
                        double ele = Double.parseDouble(operando);
                        Pila2.Push(ele);
                        Salida.Push(operando);
                    }
                    i = j - 1;
                }
            }
            i++;
        }

    }*/
    
    //Lee el operando,operador o paréntesis y lo devuelve en una cadena
    public String LeerToken() {
        String token = "";
        
        if (EsOperador(String.valueOf(Entrada.charAt(lector)))) {
            token = String.valueOf(Entrada.charAt(lector));
            
        } else {
            if (!EsParentesis(String.valueOf(Entrada.charAt(lector)))) {//entrada=85+(92*1) //op=85
                //entra si es operando                                 //j=2 //token=85 //Lector=1,2
                String operando = "";
                int j = lector;
                while ((j <= Entrada.length() - 1) && (!EsOperador(String.valueOf(Entrada.charAt(j))))
                        && (!EsParentesis(String.valueOf(Entrada.charAt(j))))) {
                    
                    operando = operando + String.valueOf(Entrada.charAt(j));
                    
                    j++;
                }
                token = operando;
                lector = j - 1;
            } else {
                //Devuelve el paréntesis
                token = String.valueOf(Entrada.charAt(lector));
            }
        }
        
        return token;
    }
    
    public int jerarquia(String operador) {
        int jerarquia;
        if ("+".equals(operador) || "-".equals(operador)) {
            jerarquia = 0;
        } else {
            if ("*".equals(operador) || "/".equals(operador)) {
                jerarquia = 1;
            } else {
                if ("^".equals(operador)) {
                    jerarquia = 2;
                } else {
                    jerarquia = -1;//Operador no reconocido
                }
            }
        }
        return jerarquia;
    }

    //Convierte de notación infija a notación Postfija
    //Convierte a Notación Postfija(RPN)(Notación Polaca Inversa)
    public void convertir() {//entrada=85+(92*1)
        //lector=2,3,5,6,7,8
        String Lecturado = "";
        while (lector <= (this.Entrada.length() - 1)) {
            Lecturado = LeerToken();
            if (EsOperador(Lecturado)) {

                //Entra si es operador
                if (!Pila1.Vacia()) {
                    
                    ListaG<String> ListaAux = new ListaG();
                    ListaAux.L = Pila1.Cima;
                    NodoGP<String> aux = ListaAux.L;
                    /* while ((aux != null) && (!EsOperador(aux.GetDato()))) {
                        aux = aux.GetEnlace();
                    }*/
                    // if (aux != null) {
                    if (EsOperador(Pila1.Cima.GetDato())) {
                        if (jerarquia(Lecturado) < jerarquia(aux.GetDato())) {
                            Salida.Push(aux.GetDato());
                            ListaAux.Eliminar(aux.GetDato());
                            Pila1.Cima = ListaAux.L;
                            Pila1.Push(Lecturado);
                        } else {
                            Pila1.Push(Lecturado);
                        }
                    } else {
                        Pila1.Push(Lecturado);
                    }
                    
                } else {
                    Pila1.Push(Lecturado);
                }
                
            } else {
                if (!EsParentesis(Lecturado)) {
                    //entra si es operando(numero)

                    Salida.Push(Lecturado);
                    
                } else {
                    //Entra si es Paréntesis
                    if ("(".equals(Lecturado)) {
                        //Entra si es paréntesis abierto
                        Pila1.Push(Lecturado);
                    } else {
                        //Entra si es paréntesis cerrado

                        String dato = Pila1.Get();//*,(
                        while ((Pila1.Cima != null) && (!"(".equals(dato))) {
                            Salida.Push(Pila1.Pop());
                            
                            dato = Pila1.Get();
                            
                        }
                        if (Pila1.Cima == null) {
                            System.out.println("Error::convertir:Parentesis sin pareja");
                            System.exit(1);
                        } else {
                            String Pop = Pila1.Pop();
                        }
                    }
                }
            }
            lector++;
        }
        
        while (Pila1.Cima != null) {
            if ("(".equals(Pila1.Cima.GetDato())) {
                System.out.println("Error:Convertir:Parentesis sin pareja");
                System.exit(1);
            } else {
                Salida.Push(Pila1.Pop());
            }
        }
        
    }
    
    public String toString() {
        String S = "";
        NodoGP<String> Aux = Salida.Cima;
        
        //s=85 92 1 * +
        //s=
        while (Aux != null) {
            S = Aux.GetDato() + " " + S;
            Aux = Aux.GetEnlace();
            
        }
        
        return S;
        
    }
    
    public static void main(String[] args) {
        PostFijo Pila = new PostFijo();
        //Pila.setEntrada("((45+88)-49)/8");
       // Pila.setEntrada("((((58+34)*(43+90))+90)-40)/7");
         Pila.setEntrada("    3  +  4*  2   ");
        //Pila.setEntrada("5+((1+2)*4)-3");
         //Pila.setEntrada("(1-2)^4*(4*(5/((5-3)^2)))");
         //Pila.setEntrada("850/9");
        //Pila.setEntrada("(3+4)*2-4");
        //System.out.println(Pila.Entrada);
        //Funcionan correctamente!!!
        Pila.convertir();
        System.out.println(Pila.toString());
        
    }
}

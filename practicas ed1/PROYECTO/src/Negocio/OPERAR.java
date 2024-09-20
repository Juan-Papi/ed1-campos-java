/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author
 */
public class OPERAR {
    //Atributos(Campos)
    Double EleIzq;
    Double EleDer;
    char Operador;

    //Constructor Parametrizado
    public OPERAR(String EleIzq,String EleDer,String Operador) {
        this.EleIzq = Double.parseDouble(EleIzq);
        this.EleDer = Double.parseDouble(EleDer);
        this.Operador = Operador.charAt(0);
    }
    public Double Realizar(){
        switch(Operador){
            case '+':return EleIzq+EleDer;
            case '-':return EleIzq-EleDer;
            case '*':return EleIzq*EleDer;
            case '/':return EleIzq/EleDer;
            case '^':return Math.pow(EleIzq, EleDer);

            default: return -1.0;
            
        }
        
    }
    
    

   
    
    
    
}

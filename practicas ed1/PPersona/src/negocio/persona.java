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
public class persona {
    //Constantes(con mayuscula)
    public static final char MASCULINO='M';
    public static final char FEMENINO='F';
    public static final char SOLTERO='S';
    public static final char CASADO='C';
    //Atributos
    private String nombre;
    private String ci;
    private char sexo;
    private int edad;
    private char estado;
    //constructor
    //crea una instancia del TDA Persona con parámetros de entrada
    public persona(String nombre, String ci, char sexo, int edad, char estado) {
        this.nombre = nombre;
        this.ci = ci;
        this.sexo = sexo;
        this.edad = edad;
        this.estado = estado;
    }
   //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    //Getters

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public char getEstado() {
        return estado;
    }
    //metodos extra
    public void saludar(){
        System.out.println("Hola como estas mi nombre es: "+nombre);
    }
   //toString devuelve los atributos en una cadena
    @Override
    public String toString() {
        return "persona{" + "nombre=" + nombre + ", ci=" + ci + ", sexo=" + sexo + ", edad=" + edad + ", estado=" + estado + '}';
    }
    public static void main(String[] args) {
        persona x=new persona("juan","9044667",persona.MASCULINO,19,persona.SOLTERO);
        //System.out.println(x.toString());
        x.saludar();
       
    }
    
   
  
}
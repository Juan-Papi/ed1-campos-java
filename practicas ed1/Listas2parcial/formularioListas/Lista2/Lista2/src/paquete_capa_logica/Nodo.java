
package paquete_capa_logica;

/**
 *
 * @author Reynaldo
 */
public class Nodo {
    int dato;
    Nodo enlace;
    public Nodo(){
      this.dato=0;
      enlace=null;
    }
    public void setDato(int dato){
      this.dato=dato;
    }
    public void setEnlace(Nodo p){
      this.enlace=p;
    }
    public int getDato(){
      return dato;
    }
    public Nodo getEnlace(){
      return enlace;
    }
    @Override
    public String toString(){
      String s="";
      s="Dato:"+dato;
      return s;
    }
}


package lista;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class Nodo {

            int dato;
            Nodo enlace;
            
    public Nodo(int dato)
    {
        this.dato = dato;
        enlace = null;
    }
    
    public void setDato(int dato)
    {
        this.dato = dato;
    }
    
    public void setEnlace(Nodo n)
    {
        this.enlace = n;
    }
    
    public int getDato()
    {
        return dato;
    }
    
    public Nodo getEnlace()
    {
        return enlace;
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
    }
}

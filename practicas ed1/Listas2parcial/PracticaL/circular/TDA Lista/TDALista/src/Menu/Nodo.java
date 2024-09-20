package Menu;

/**
 * Ayudantia 2/2016 Eddy Escalante
 */
public class Nodo {

    int Data;
    Nodo Enlace;

    public Nodo() {
        Enlace = null;
        //Data=0;
    }

    public Nodo(int d) {
        Data = d;
        Enlace = null;
    }

    public int getData() {
        return Data;
    }

    public void setData(int Dato) {
        this.Data = Dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    }

    public void setEnlace(Nodo L) {
        this.Enlace = L;
    }

}

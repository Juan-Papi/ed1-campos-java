
package ListaP;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class NodoP {
            private int x;
            private int y;
            private NodoP enlace;
            
      public NodoP()
      {
          enlace = null;
      }
      
      public NodoP(int X, int Y)
      {
          this.x = X;
          this.y = Y;
          enlace = null;
      }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the enlace
     */
    public NodoP getEnlace() {
        return enlace;
    }

    /**
     * @param enlace the enlace to set
     */
    public void setEnlace(NodoP enlace) {
        this.enlace = enlace;
    }
      
      
}

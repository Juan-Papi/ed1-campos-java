/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete;

public class ListaCircular {

    Nodo L;
    int nroNodo;

    public ListaCircular() {
        L = null;
        nroNodo = 0;
    }
////////////////////////////////////////////////////////////////////////////

    private void InsertarPr(Nodo Aux, int valor) {
        if (L.getData() == Aux.getData()) {
            Nodo p = new Nodo(valor);
            p.setEnlace(L);
            L = p;
            Aux.setEnlace(L);
        } else {
            if (Aux.getEnlace().getData() == L.getData()) {
                Nodo p = new Nodo(valor);
                Aux.setEnlace(p);
                p.setEnlace(L);
                L = p;
            } else {
                InsertarPr(Aux.getEnlace(), valor);
            }
        }
    }

    public void InsertarP(int valor) {
        if (L == null) {
            Nodo p = new Nodo(valor);
            L = p;
            p.setEnlace(L);
            nroNodo++;
        } else {
            InsertarPr(L.getEnlace(), valor);
        }
    }
////////////////////////////////////////////////////////////////////////////

    private void InsertarUl1(Nodo Aux, int valor) {
        if (L.getData() == Aux.getData()) {
            Nodo p = new Nodo(valor);
            Aux.setEnlace(p);
            p.setEnlace(L);
        } else {
            if (Aux.getEnlace().getData() == L.getData()) {
                Nodo p = new Nodo(valor);
                Aux.setEnlace(p);
                p.setEnlace(L);
            } else {
                InsertarUl1(Aux.getEnlace(), valor);
            }
        }
    }

    public void InsertarUl(int valor) {
        Nodo p = new Nodo(valor);
        if (L == null) {
            L = p;
            p.setEnlace(L);
        } else {
            InsertarUl1(L.getEnlace(), valor);
        }
    }
////////////////////////////////////////////////////////////////////////////

    private void InsertarR(Nodo Aux, int valor) {
        if (Aux.getData() > valor) {
            InsertarP(valor);
        } else {
            if (Aux.getEnlace().getData() > valor) {
                Nodo p = new Nodo(valor);
                p.setEnlace(Aux.getEnlace());
                Aux.setEnlace(p);
            } else {
                if (Aux.getEnlace().getData() < valor && Aux.getEnlace().getEnlace().getData() == L.getData()) {
                    InsertarUl(valor);
                } else {
                    InsertarR(Aux.getEnlace(), valor);
                }
            }
        }
    }

    public void Insertar(int valor) {
        if (L == null) {
            Nodo p = new Nodo(valor);
            L = p;
            p.setEnlace(L);
        } else {
            InsertarR(L, valor);
        }
    }
////////////////////////////////////////////////////////////////////////////

    private void EliminarPr(Nodo Aux) {
        if (L.getData() == Aux.getData()) {
            L = null;
        } else {
            if (Aux.getEnlace().getData() == L.getData()) {
                L = L.getEnlace();
                Aux.setEnlace(Aux.getEnlace().getEnlace());
            } else {
                EliminarPr(Aux.getEnlace());
            }
        }
    }

    public void EliminarP() {
        if (L == null) {
        } else {
            EliminarPr(L.getEnlace());
        }
    }
////////////////////////////////////////////////////////////////////////////

    private void EliminarUl1(Nodo Aux) {
        if (Aux.getEnlace().getData() == L.getData()) {
            L = null;
        } else {
            if (Aux.getEnlace().getEnlace().getData() == L.getData()) {
                Aux.setEnlace(Aux.getEnlace().getEnlace());
            } else {
                EliminarUl1(Aux.getEnlace());
            }
        }
    }

    public void EliminarUl() {
        if (L == null) {
        } else {
            EliminarUl1(L);
        }
    }
////////////////////////////////////////////////////////////////////////////

    private void EliminarR(Nodo Aux, int valor) {
        if (Aux.getData() == valor) {
            EliminarP();
        } else {
            if (Aux.getEnlace().getData() == valor) {
                Aux.setEnlace(Aux.getEnlace().getEnlace());
            } else {
                if (Aux.getEnlace().getData() != valor && Aux.getEnlace().getEnlace().getData() == L.getData()) {
                } else {
                    EliminarR(Aux.getEnlace(), valor);
                }
            }
        }
    }

    public void Eliminar(int valor) {
        if (L == null) {
        } else {
            EliminarR(L, valor);
        }
    }
////////////////////////////////////////////////////////////////////////////

    public String Mostrar() {
        String t = "L =[";
        String coma = ", ";
        Nodo p = L;
        if (L != null) {
            t = t + p.getData();
            p = p.getEnlace();
            while (L.getData() != p.getData()) {
                t = t + coma + p.getData();
                p = p.getEnlace();
            }
        }
        t = t + "]";
        return t;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ListaCircular d = new ListaCircular();
        d.InsertarUl(5);
        d.InsertarUl(8);
        d.InsertarUl(4);
        d.InsertarUl(2);
        //  d.InsertarP(1);
        d.Eliminar(4);
        //  d.Insertar(3);
        //d.Insertar(7);
        // d.Insertar(6);
        // d.Insertar(5);
        //   d.Insertar(2);
        //  d.EliminarUl();
        System.out.println(d.Mostrar());
    }
}

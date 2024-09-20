package ListaSimple;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class Lista {

    private Nodo L;
    private int n;

    public Lista() {
        L = null;
        setN(0);
    }

    public int getN() {
        return n;
    }

    private void setN(int n) {
        this.n = n;
    }

    public void InsP(int ele) {
        Nodo p = new Nodo();
        p.SetData(ele);
        if (L != null) {
            p.SetLink(L);
        }
        L = p;
        setN(getN() + 1);
    }

    public void InsF(int ele) {
        Nodo p = new Nodo();
        p.SetData(ele);
        if (L == null) {
            L = p;
        } else {
            Nodo aux = L;
            while (aux.GetLink() != null) {
                aux = aux.GetLink();
            }
            aux.SetLink(p);
        }
        setN(getN() + 1);
    }

    public String toString() {
        String s = "";
        Nodo x = L;
        while (x != null) {
            s = s + String.valueOf(x.GetData()) + " | ";
            x = x.GetLink();
        }
        return s;
    }

    //══════════════════════════════════════Procedimientos recursivos═══════════════════════════════════════════════════════════════════════════════════════
    //═══════════════════ Ej 1  Sumar todos los elementos ══════════════════════════════════════════════════════════════════════════════════════════════════
    private int suma(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            return p.GetData() + suma(p.GetLink());
        }
    }

    public int Sumar() {
        return suma(L);
    }

    //═══════════════════ Ej 2 Sumar todos los elementos de posiciones pares ═══════════════════════════════════════════════════════════════════════════════
    private int suma_p(Nodo p, int a) {
        if (p == null) {
            return 0;
        } else if (a % 2 == 0) {
            return p.GetData() + suma_p(p.GetLink(), a + 1);
        } else {
            return suma_p(p.GetLink(), a + 1);
        }
    }

    public int SumarP() {
        return suma_p(L, 1);
    }

    //═══════════════════ Ej 3 Insertar un elemento (al final) ═══════════════════════════════════════════════════════════════════════════════════════════════
    private void insertar(Nodo p, int ele) {
        if (p == null) {
            Nodo x = new Nodo();
            x.SetData(ele);
            L = x;
            n++;
        } else if (p.GetLink() == null) {
            Nodo x = new Nodo();
            x.SetData(ele);
            p.SetLink(x);
            n++;
        } else {
            insertar(p.GetLink(), ele);
        }
    }

    public void Insertar(int ele) {
        insertar(L, ele);
    }

    //═══════════════════ Ej 4 Contar los numeros primos ═══════════════════════════════════════════════════════════════════════════════════════════════════
    private boolean primo(int x, int i) {
        if (x > 2) {
            if ((x - 1) >= i) {
                if (x % i == 0) {
                    return false;
                } else {
                    return primo(x, i + 1);
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private int cont_p(Nodo p) {
        if (p == null) {
            return 0;
        } else if (primo(p.GetData(), 2)) {
            return 1 + cont_p(p.GetLink());
        } else {
            return cont_p(p.GetLink());
        }
    }

    public int Primos() {
        return cont_p(L);
    }

    //═══════════════════ Ej 5 Promedio de elementos posiciones pares ══════════════════════════════════════════════════════════════════════════════════════════
    private double promedio(Nodo p, int x) {
        if (x <= getN()) {
            if (x % 2 == 0) {
                return p.GetData() + promedio(p.GetLink(), x + 1);
            } else {
                return promedio(p.GetLink(), x + 1);
            }
        } else {
            return 0;
        }
    }

    public double Promedio() {
        return promedio(L, 1) / (getN() % 2 == 0 ? (getN() / 2) : ((getN() - 1) / 2));
    }

    //═══════════════════ Ej 6 Encontrar el elemento menor de posiciones x ════════════════════════════════════════════════════════════════════════════════════
    private int por_mx(Nodo p, int x, int r) {
        if (r <= getN()) {
            if (r % x == 0) {
                return p.GetData() < por_mx(p.GetLink(), x, r + 1) ? p.GetData() : por_mx(p.GetLink(), x, r + 1);
            } else {
                return por_mx(p.GetLink(), x, r + 1);
            }
        } else {
            return (Integer) null;
        }
    }

    public int EleMenor(int x) {
        return por_mx(L, x, 1);
    }

    //═══════════════════ Ej 7 Verificar si la lista esta ordenada descendentemente ═══════════════════════════════════════════════════════════════════════════
    private boolean ord_des(Nodo p) {
        if (p.GetLink() == null) {///toda la lista
            return true;
        } else if ((p.GetData() > p.GetLink().GetData()) && (ord_des(p.GetLink()))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean OrdDes() {
        return ord_des(L);
    }

    //═══════════════════ Ej 8 Verificar si todos los elementos son iguales ════════════════════════════════════════════════════════════════════════════════════
    private boolean igual(Nodo p) {
        if (p.GetLink() == null) {
            return true;
        } else {
            return p.GetData() == p.GetLink().GetData() ? igual(p.GetLink()) : false;
        }
    }

    public boolean Igual() {
        return igual(L);
    }

    //═══════════════════ Ej 9 Verificar si los elementos estan itercalados entre pares e impares ══════════════════════════════════════════════════════════════
    private boolean intercalados(Nodo p, int a) {
        if (p == null) {
            return true;
        } else if (a % 2 != 0 && p.GetData() % 2 == 0 || a % 2 == 0 && p.GetData() % 2 != 0) {
            return intercalados(p.GetLink(), a + 1);
        } else {
            return false;
        }
    }

    public boolean Intercalados() {
        return intercalados(L, n);
    }

    //═══════════════════ Ej 10 Verificar si todos los elementos de la lista son diferentes ════════════════════════════════════════════════════════════════════
    private int frecuencia(Nodo p, int x) {
        if (p == null) {
            return 0;
        } else {
            return p.GetData() == x ? 1 + frecuencia(p.GetLink(), x) : frecuencia(p.GetLink(), x);
        }
    }

    private boolean diferentes(Nodo p) {
        if (p == null) {
            return true;
        } else {
            return frecuencia(L, p.GetData()) > 1 ? false : diferentes(p.GetLink());
        }
    }

    public boolean Diferentes() {
        return diferentes(L);
    }

    //═══════════════════ Ej 11 Encontrar el elemento de mayor frecuencia ═══════════════════════════════════════════════════════════════════════════════════════*********************************
    private int ele_mayFrec(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            return frecuencia(L, p.GetData()) > ele_mayFrec(p.GetLink()) ? p.GetData() : ele_mayFrec(p.GetLink());
        }
    }

    public int EleMayFrec() {
        return ele_mayFrec(L);
    }

    //═══════════════════ Ej 12 Eliminar un elemento de la lista ══════════════════════════════════════════════════════════════════════════════════════════════════*********************************
    private void eliminar(Nodo p, int d) {
        if (p != null) {
            if (p.GetLink() == null && p.GetData() == d) {
                L = null;
            }

        }

    }

    public void Eliminar(int x) {
        eliminar(L, x);
    }

    //═══════════════════ Ej 13 Invertir la lista ═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════
    private void invertir(Nodo p) {
        if (p != null) {
            if (p.GetLink() == null) {
                L = p;
            } else {
                invertir(p.GetLink());
                p.GetLink().SetLink(p);
                p.SetLink(null);
            }
        }
    }

    public void Invertir() {
        invertir(L);
    }

    //═══════════════════ Ej 14 Insertar un elemento en una posicion X ═══════════════════════════════════════════════════════════════════════════════════════════════
    private void insertarX(Nodo p, int i, int t, int ele) {
        if (n >= t && t >= i) {
            if (t == i && i == 1) {
                Nodo x = new Nodo();
                x.SetData(ele);
                x.SetLink(p);
                L = x;
                n++;
            } else if (t == i) {
                Nodo x = new Nodo();
                x.SetData(p.GetData());
                x.SetLink(p.GetLink());

                p.SetData(ele);
                p.SetLink(x);
                n++;
            } else {
                i++;
                insertarX(p.GetLink(), i, t, ele);
            }
        }
    }

    public void InsertarX(int x, int ele) {
        insertarX(L, 1, x, ele);
    }

    //═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) {
        Lista x = new Lista();

        x.Insertar(1);
        x.Insertar(2);
        x.Insertar(3);

        x.InsertarX(3, 10);
        System.out.println(x.toString());

    }
}

package ListaSimple;

/**
 * Ayudantia 2/2017 Eddy Escalante
 */
public class ListaI {

    private Nodo L;
    private int n;

    public ListaI() {
        L = null;
        setN(0);
    }

    private void Incrementar_N() {
        setN(getN() + 1);///n++;
    }

    public int getN() {
        return n;
    }

    private void setN(int n) {
        this.n = n;
    }

    public boolean Vacia() {
        return (L == null);
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

    public String toString2() {
        String s = " L-> ";
        Nodo aux = L;
        while (aux != null) {
            s = s + "[" + aux.GetData() + "] ->";
            aux = aux.GetLink();
        }
        s = s.substring(1, s.length() - 2);
        return s;
    }

    public String ToStringNodo(Nodo n) {
        String s = " NODO=> ";
        Nodo aux = n;
        while (aux != null) {
            s = s + "[" + aux.GetData() + "] ->";
            aux = aux.GetLink();
        }
        s = s.substring(1, s.length() - 2);
        return s;
    }
    //═══════════════════ Procedimientos ITERATIVO═══════════════════════════════════════════════════════════════════════════════════════
    //═══════════════════ Ej InsertarPrincipio ═══════════════════════════════════════════════════════════════════════════════

    public void InsertarPrincipio(int ele) {
        Nodo p = new Nodo();
        p.SetData(ele);
        if (L != null) {
            p.SetLink(L);
        }
        L = p;
        setN(getN() + 1);
    }

    //═══════════════════ Ej InsertarFinal ═══════════════════════════════════════════════════════════════════════════════
    public void InsertarFinal(int ele) {
        Nodo p = new Nodo();
        p.SetData(ele);
        if (L == null) {
            L = p;
        } else {
            Nodo aux = L;
            //   System.out.println("*********");
            while (aux.GetLink() != null) {
                aux = aux.GetLink();
                ///      System.out.println("CICLO aux: " + ToStringNodo(aux));
            }
            aux.SetLink(p);
            //  L=aux;
            //  System.out.println("aux: " + ToStringNodo(aux));

            //  System.out.println("LLLL: " + ToStringNodo(L));
        }
        setN(getN() + 1);
    }

    public void InsertarOrdeASC(int ele) {
        if (Vacia()) {
            Nodo P = new Nodo();
            P.SetData(ele);
            L = P;
            Incrementar_N();
        } else {
            Nodo Ant = new Nodo();
            Ant = null;
            Nodo Aux = new Nodo();
            Aux = L;
            while ((Aux != null) && (Aux.GetData() <= ele)) {
                Ant = Aux;
                Aux = Aux.GetLink();
            }
            if (Ant == null) {
                Nodo P = new Nodo();
                P.SetData(ele);
                P.SetLink(L);
                L = P;
                Incrementar_N();
            } else if (Ant.GetData() != ele) {
                Nodo P = new Nodo();
                P.SetData(ele);
                P.SetLink(Aux);
                Ant.SetLink(P);
                Incrementar_N();
            }
        }

    }

    public void InsertarOrdeDESC(int ele) {
        if (Vacia()) {
            Nodo P = new Nodo();
            P.SetData(ele);
            L = P;
            Incrementar_N();
        } else {
            Nodo Ant = new Nodo();
            Ant = null;
            Nodo Aux = new Nodo();
            Aux = L;
            while ((Aux != null) && (Aux.GetData() >= ele)) {
                Ant = Aux;
                Aux = Aux.GetLink();
            }
            if (Ant == null) {
                Nodo P = new Nodo();
                P.SetData(ele);
                P.SetLink(L);
                L = P;
                Incrementar_N();
            } else if (Ant.GetData() != ele) {
                Nodo P = new Nodo();
                P.SetData(ele);
                P.SetLink(Aux);
                Ant.SetLink(P);
                Incrementar_N();
            }
        }

    }

    public void insertar(int x) {
        Nodo f = L, i = null;
        while ((f != null) && (f.GetData() < x)) {
            i = f;
            f = f.GetLink();
        }
        Nodo n = new Nodo(x);
        n.SetLink(f);
        try {
            if (x != f.GetData()) {
                if (i == null) {
                    L = n;
                } else {
                    i.SetLink(n);
                }
                Incrementar_N();
            }
        } catch (Exception e) {
            if (L == null) {
                L = n;
            } else {
                i.SetLink(n);
            }
            Incrementar_N();
        }
    }

    public void invertir() {
        if (!Vacia()) {
            Nodo a = null;
            Nodo b = L;
            Nodo c = b.GetLink();
            while (c != null) {
                b.SetLink(a);
                a = b;
                b = c;
                c = c.GetLink();
            }
            b.SetLink(a);
            L = b;
        } else {
            System.out.println("Lista vacia");
        }
    }

    public void eliminarElemento(int x) {
        if (!Vacia()) {
            Nodo fin = L, inicio = null;
            while ((fin != null)&& (fin.GetData() != x)) {
                inicio = fin;
                fin = fin.GetLink();
            }
            if (fin != null) {
                fin = fin.GetLink();
            }
            if (inicio == null) {
                L = fin;
            } else {
                inicio.SetLink(fin);
            }
            n--;
        } else {
            System.out.println("Lista vacia");
        }
    }

    public void EliminarUltimo() {
        if (!Vacia()) {
            Nodo fin = L, inicio = null;
            while (fin.GetLink() != null) {
                inicio = fin;
                fin = fin.GetLink();
                
            }
            if (fin != null) {
                fin = fin.GetLink();
            }
            if (inicio == null) {
                L = fin;
            } else {
                inicio.SetLink(fin);
            }
            n--;
        } else {
            System.out.println("Lista vacia");
        }
    }

    public int sacar(int pos) {
        if ((pos <= n) && (pos > 0)) {
            Nodo f = L;
            while ((pos != 0)) {
                pos--;
                f = f.GetLink();
            }
            return f.GetData();
        }
        System.out.println("La posicion esta fuera de rango");
        return 0;
    }

//L-->[1,2,3,4,5,6,]
//L-->[2,1,4,3,6,5,]
    public void Intercalar2a2() {
        if (!Vacia()) {
            Nodo aux = new Nodo();
            if (L != null) {
                Nodo Pri = new Nodo();
                Pri = L;
                if (Pri.GetLink() != null) {
                    Nodo Seg = new Nodo();
                    Seg = Pri.GetLink();
                    if (Seg.GetLink() == null) {
                        L = Seg;
                        Seg.SetLink(Pri);
                        Pri.SetLink(null);

                    } else {
                        L = Seg;
                        while (Pri.GetLink() != null) {
                            Pri.SetLink(Seg.GetLink());
                            Seg.SetLink(Pri);
                            aux.SetLink(Seg);
                            aux = Pri;
                            if (Pri.GetLink() != null) {
                                Pri = Pri.GetLink();
                                if (Pri.GetLink() != null) {
                                    Seg = Pri.GetLink();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
//═══════════════════ Ej Intercalar3n ITERATIVO ═══════════════════════════════════════════════════════════════════════════════   

    public void Intercalar3n() {
        if (!Vacia()) {
            Nodo aux = new Nodo();
            if (L != null) {
                Nodo Pri = new Nodo();
                Pri = L;
                if (Pri.GetLink() != null) {
                    Nodo Seg = new Nodo();
                    Seg = Pri.GetLink();
                    if (Seg.GetLink() != null) {
                        Nodo Ter = new Nodo();
                        Ter = Seg.GetLink();
                        if (Ter.GetLink() == null) {
                            L = Ter;
                            Seg.SetLink(Pri);
                            Ter.SetLink(Seg);
                            Pri.SetLink(null);
                        } else {
                            L = Ter;
                            while ((Pri.GetLink() != null) && (Seg.GetLink() != null)) {
                                Pri.SetLink(Ter.GetLink());
                                Seg.SetLink(Pri);
                                Ter.SetLink(Seg);
                                aux.SetLink(Ter);
                                aux = Pri;
                                if (Pri.GetLink() != null) {
                                    Pri = Pri.GetLink();
                                    if (Pri.GetLink() != null) {
                                        Seg = Pri.GetLink();
                                        if (Seg.GetLink() != null) {
                                            Ter = Seg.GetLink();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void intercalar2() {
        // aux = L -> [8] ->[27] ->[3] ->[7] ->[17] ->[2] 
        if (!Vacia() && L.GetLink() != null) {///existen 2 datos en la lista L
            Nodo aux = L;//[8] ->[27] ->[3] ->[7] ->[17] ->[2] 
            Nodo Resultado = new Nodo();//
            boolean sw = true;
            while (aux != null) {   // nada    
                Nodo guardar = aux.GetLink(); // [27] ->[3] ->[7] ->[17] ->[2] 
                Resultado = aux;//[8] ->[27] ->[3] ->[7] ->[17] ->[2] 
                aux.SetLink(aux.GetLink().GetLink()); // [8] ->[3] ->[7] ->[17] ->[2] 
                guardar.SetLink(Resultado);// [27] ->[8] ->[27] ->[3] ->[7] ->[17] ->[2]  
                Resultado.SetLink(aux);//[8] -> [8] ->[3] ->[7] ->[17] ->[2] 
            }
            L = Resultado;
        }
    }

    public void intercalar() {
        // aux = L -> [8] ->[27] ->[3] ->[7] ->[17] ->[2] 
        if (!Vacia() && L.GetLink() != null) {///existen 2 datos en la lista L
            Nodo aux = L;//[8] ->[27] ->[3] ->[7] ->[17] ->[2] 
            Nodo Resultado = new Nodo();//
            boolean sw = true;
            while (aux != null) {   // nada    
                System.out.println("*****************");
                Nodo guardar = aux.GetLink(); // [27] ->[3] ->[7] ->[17] ->[2] 
                aux.SetLink(aux.GetLink().GetLink()); // [8] ->[3] ->[7] ->[17] ->[2] 
                guardar.SetLink(aux); // [27] ->[8] ->[3] ->[7] ->[17] ->[2]    

                System.out.println("guardar: " + ToStringNodo(guardar));

                aux = guardar.GetLink().GetLink();// [3] ->[7] ->[17] ->[2]   
                System.out.println("aux: " + ToStringNodo(aux));
                //   Nodo aux = L;
                // Resultado = guardar;
                // Resultado.GetLink().GetLink().SetLink(null);
                //    System.out.println("Resultado : " + ToStringNodo(Resultado)); 
                if (sw) {
                    System.out.println("TRUE");
                    Resultado = guardar;
                    Resultado.GetLink().SetLink(null);
                    sw = false;
                } else {
                    System.out.println("FALSE");
                    guardar.GetLink().SetLink(null);
                    while (guardar != null) {
                        Nodo auxi = Resultado;
                        //   System.out.println("*********");
                        System.out.println("CICLO auxi: " + ToStringNodo(auxi));
                        while (auxi.GetLink() != null) {
                            auxi = aux.GetLink();
                            ///      System.out.println("CICLO aux: " + ToStringNodo(aux));
                        }
                        auxi.SetLink(guardar);
                        guardar = guardar.GetLink();
                        System.out.println("DATO : " + guardar.GetData());
                    }

                }

                //    
                System.out.println("Resultado : " + ToStringNodo(Resultado));
                // Resultado.GetLink().SetLink(guardar);
                //  Resultado=(guardar);
                //    System.out.println("Resultado.SetLink(guardar);: " + ToStringNodo(Resultado));
                //    Resultado.SetLink(Resultado.GetLink().GetLink());
                //    System.out.println("Resultado.SetLink(guardar.GetLink());: " + ToStringNodo(Resultado));
            }
            L = Resultado;
            /// 1ra // [27] ->[8] ->[3] ->[7] 
            /// 2da // [27] ->[8] ->[7] ->[3] 
        } else {
            System.out.println("No se puede intercalar");
        }

    }
    //  L-> [27] ->[8] ->[3] ->[7] ->[17] ->[2] 

    //══════════════════════════════ MAIN ═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) {
        ListaI x = new ListaI();

        x.InsertarFinal(8);
        x.InsertarFinal(27);
        x.InsertarFinal(3);
        x.InsertarFinal(7);
        x.InsertarFinal(17);
        x.InsertarFinal(2);
        System.out.println(x.toString2());
        x.eliminarElemento(7);
        x.eliminarElemento(3);
    //    x.EliminarUltimo();
    //    x.EliminarUltimo();
    //    x.EliminarUltimo();
    //    x.EliminarUltimo();
        //    x.intercalar();
        System.out.println(x.toString2());

        //    x.eliminarElemento(17);
        //   System.out.println("" + x.sacar(2));
//    x.invertir();
        // x.Intercalar3n();
        //   System.out.println(x.toString2());
    }
}

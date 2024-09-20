package Menu;

import jdk.nashorn.internal.ir.Terminal;

/**
 * Ayudantia 2/2016 Eddy Escalante
 */
public class Lista {

    Nodo L;
    int Cant;

    public Lista() {
        L = null;///dato = null ; enlace = null
        Cant = 0;
    }

    public boolean Vacia() {
        return (L == null);
    }

    public void Insertar(Nodo N) {
        if (Vacia()) {
            L = N;
        } else {
            N.setEnlace(L);
            L = N;
        }
        Cant++;
    }

    public void Insertar(int dato) {
        if (Vacia()) {
            Nodo aux = new Nodo();
            aux.setData(dato);
            L = aux;
        } else {
            Nodo N = new Nodo();
            N.setData(dato);
            N.setEnlace(L);
            L = N;
        }
        Cant++;
    }

    public void Insertar22(int dato) {
        System.out.println("*************** NEW");
        if (Vacia()) {
            Nodo aux = new Nodo();
            aux.setData(dato);
            L = aux;
            Cant++;
            System.out.println(ToStringNodo(L));
        } else {
            Nodo N = new Nodo();
            N.setData(dato);

            System.out.println("N_antes => " + ToStringNodo(N));

            N.setEnlace(L);
            System.out.println("L_actual => " + ToStringNodo(L));
            System.out.println("N_despues => " + ToStringNodo(N));
            L = N;
            System.out.println("L_final => " + ToStringNodo(L));
            Cant++;
        }
    }

    public void InsertarOrdeASC(int ele) {
        System.out.println("**********NEW");
        if (Vacia()) {
            Nodo P = new Nodo();
            P.setData(ele);
            System.out.println("true P = " + ToStringNodo(P));
            L = P;
            System.out.println("true L = " + ToStringNodo(L));
            Cant++;
        } else {
            Nodo Ant = new Nodo();
            Ant = null;
            Nodo Aux = new Nodo();
            Aux = L;
            System.out.println("false Aux = " + ToStringNodo(Aux));
            System.out.println("++++++++++++++++++++ IF");
            /*   
            int i=0;
           while (i<Cant) {                
                
                i++;
            }
             */
            while ((Aux != null) && (Aux.getData() <= ele)) {
                Ant = Aux;
                Aux = Aux.getEnlace();

                System.out.println("false while Ant = " + ToStringNodo(Ant) + "\n" + "false while Aux = " + ToStringNodo(Aux));
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            }
            if (Ant == null) {
                Nodo P = new Nodo();
                P.setData(ele);
                P.setEnlace(L);
                System.out.println("false (Ant == null) P = " + ToStringNodo(P));
                L = P;
                Cant++;
            } else if (Ant.getData() != ele) {
                Nodo P = new Nodo();
                P.setData(ele);
                P.setEnlace(Aux);
                Ant.setEnlace(P);
                Cant++;
                System.out.println("false (Ant.getData() != ele) Aux = " + ToStringNodo(Aux));
                System.out.println("false (Ant.getData() != ele) P = " + ToStringNodo(P));
                System.out.println("false (Ant.getData() != ele) Ant = " + ToStringNodo(Ant));
            }
        }

    }

    public void InsertarOrdeDESC(int ele) {
        System.out.println("**********NEW");
        if (Vacia()) {
            Nodo P = new Nodo();
            P.setData(ele);
            System.out.println("true P = " + ToStringNodo(P));
            L = P;
            System.out.println("true L = " + ToStringNodo(L));
            Cant++;
        } else {
            Nodo Ant = new Nodo();
            Ant = null;
            Nodo Aux = new Nodo();
            Aux = L;
            System.out.println("false Aux = " + ToStringNodo(Aux));
            System.out.println("++++++++++++++++++++ IF");
            while ((Aux != null) && (Aux.getData() >= ele)) {
                Ant = Aux;
                Aux = Aux.getEnlace();

                System.out.println("false while Ant = " + ToStringNodo(Ant) + "\n" + "false while Aux = " + ToStringNodo(Aux));
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            }
            if (Ant == null) {
                Nodo P = new Nodo();
                P.setData(ele);
                P.setEnlace(L);
                System.out.println("false (Ant == null) P = " + ToStringNodo(P));
                L = P;
                Cant++;
            } else if (Ant.getData() != ele) {
                Nodo P = new Nodo();
                P.setData(ele);
                P.setEnlace(Aux);
                Ant.setEnlace(P);
                Cant++;
                System.out.println("false (Ant.getData() != ele) Aux = " + ToStringNodo(Aux));
                System.out.println("false (Ant.getData() != ele) P = " + ToStringNodo(P));
                System.out.println("false (Ant.getData() != ele) Ant = " + ToStringNodo(Ant));
            }
        }

    }

    public void Eliminar(int ele) {
        if (!Vacia()) {
            Nodo auxx = new Nodo();
            auxx = L;
            Nodo ant = new Nodo();
            ant = null;
            while ((auxx != null) && (auxx.getData() < ele)) {
                ant = auxx;
                auxx = auxx.getEnlace();
                System.out.println("ant => " + ToStringNodo(ant));
                System.out.println("auxx => " + ToStringNodo(auxx));
            }
            if (ant == null) {
                if (auxx.getData() == ele) {
                    System.out.println("L.getEnlace() => " + ToStringNodo(L.getEnlace()));
                    L = L.getEnlace();
                    System.out.println("L => " + ToStringNodo(L));
                    Cant--;
                    System.out.println("entro");
                }
            } else if (auxx != null) {
                if (auxx.getData() == ele) {
                    System.out.println("entro2");
                    ant.setEnlace(auxx.getEnlace());
                    System.out.println("auxx.getEnlace() => " + ToStringNodo(auxx.getEnlace()));
                    System.out.println("ant => " + ToStringNodo(ant));
                    Cant--;
                    L = ant;//
                }
            }
        }
    }
//L-->[1,2,3,4,5,6,7,8,9,10,]
//L-->[2,3,1,5,6,4,8,9,7,10,]

    public void Intercalar3a3() {
        if (!Vacia()) {
            Nodo aux = new Nodo();
            if (L != null) {
                Nodo Pri = new Nodo();
                Pri = L;
                if (Pri.getEnlace() != null) {
                    Nodo Seg = new Nodo();
                    Seg = Pri.getEnlace();
                    if (Seg.getEnlace() != null) {
                        Nodo Ter = new Nodo();
                        Ter = Seg.getEnlace();
                        if (Ter.getEnlace() == null) {
                            L = Seg;
                            Ter.setEnlace(Pri);
                            Pri.setEnlace(null);
                        } else {
                            L = Seg;
                            while ((Pri.getEnlace() != null) && (Seg.getEnlace() != null)) {
                                Pri.setEnlace(Ter.getEnlace());
                                Ter.setEnlace(Pri);
                                aux.setEnlace(Seg);
                                aux = Pri;
                                if (Pri.getEnlace() != null) {
                                    Pri = Pri.getEnlace();
                                    if (Pri.getEnlace() != null) {
                                        Seg = Pri.getEnlace();
                                        if (Seg.getEnlace() != null) {
                                            Ter = Seg.getEnlace();
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

    public void Intercalar3n() {
        if (!Vacia()) {
            Nodo aux = new Nodo();
            if (L != null) {
                Nodo Pri = new Nodo();
                Pri = L;
                if (Pri.getEnlace() != null) {
                    Nodo Seg = new Nodo();
                    Seg = Pri.getEnlace();
                    if (Seg.getEnlace() != null) {
                        Nodo Ter = new Nodo();
                        Ter = Seg.getEnlace();
                        if (Ter.getEnlace() == null) {
                            L = Ter;
                            Seg.setEnlace(Pri);
                            Ter.setEnlace(Seg);
                            Pri.setEnlace(null);
                        } else {
                            L = Ter;
                            while ((Pri.getEnlace() != null) && (Seg.getEnlace() != null)) {
                                Pri.setEnlace(Ter.getEnlace());
                                Seg.setEnlace(Pri);
                                Ter.setEnlace(Seg);
                                aux.setEnlace(Ter);
                                aux = Pri;
                                if (Pri.getEnlace() != null) {
                                    Pri = Pri.getEnlace();
                                    if (Pri.getEnlace() != null) {
                                        Seg = Pri.getEnlace();
                                        if (Seg.getEnlace() != null) {
                                            Ter = Seg.getEnlace();
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

    public String ToStringNodo(Nodo n) {
        String s = " NODO=> ";
        Nodo aux = n;
        while (aux != null) {
            s = s + "[" + aux.getData() + "] ->";
            aux = aux.getEnlace();
        }
        s = s.substring(1, s.length() - 2);
        return s;
    }

    public String ToString2() {
        String s = " L-> ";
        Nodo aux = L;
        while (aux != null) {
            s = s + "[" + aux.getData() + "] ->";
            aux = aux.getEnlace();
        }
        s = s.substring(1, s.length() - 2);
        return s;
    }

    @Override
    public String toString() {
        String S = "L-->[";
        Nodo AUX = new Nodo();
        AUX = L;
        while (AUX != null) {
            S = S + AUX.getData() + ",";
            AUX = AUX.getEnlace();
        }
        S = S + "]";
        return S;
    }

    public static void main(String[] args) {
        Lista LL = new Lista();
        /////////////forma 1
        //   LL.Insertar(new Nodo(7));
        /////////////forma 2
        // Nodo NN = new Nodo(81);
        //  LL.Insertar(NN);
        /////////////////////
        // LL.Insertar22(8);
        //   LL.Insertar22(18);      
        //   LL.Insertar22(15);
//        LL.InsertarOrdeDESC(15);
//        LL.InsertarOrdeDESC(11);
//        LL.InsertarOrdeDESC(12);
//        LL.InsertarOrdeDESC(30);
//        LL.InsertarOrdeDESC(9);

        String jj;
        if (51>7) {
            jj="Mayor";
        }else{
            jj="Menor";
        }
        System.out.println(jj);
        
        System.out.println("****************************");
        String j = 5 > 7 ? "Mayor" : "Menor";
        System.out.println(j);
        
//        System.out.println("***********toString***********");
//        System.out.println(LL.ToString2());

        /*LL.Insertar(51);
        LL.Insertar(17);// [17]->[51] ; getEnlace() -> [51]
        LL.Insertar(21);
        LL.Insertar(7);

        //L-> [7] ->[21] ->[17] ->[51] 
        //inserto 7
        //L-> [7] ->[21] ->[17] ->[51]->[7]
        //insertar 17
        //L-> [7] -> [21] ->[17] ->[51] ->[7]->[17]
        //inserto 9
        //L-> [7] -> [9]->[21] ->[17] ->[51] ->[7]->[17]
        System.out.println("***********toString***********");
        System.out.println(LL.ToString2());
        //    System.out.println(LL.ToString2());
        //    System.out.println(LL.ToStringNodo(LL.L));
        //    System.out.println("***********Eliminar***********");
        //    LL.Eliminar(7);
        //    System.out.println(LL);
         */
    }

}

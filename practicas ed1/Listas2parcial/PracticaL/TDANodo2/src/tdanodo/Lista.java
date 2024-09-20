/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdanodo;

/**
 *
 * @author Estudiante
 */
public class Lista {
    Nodo L;
    int cant;

public Lista(){
    L = null;
    cant = 0;
}

public boolean Vacia(){
    return (L == null);
}

public int Cantidad(){
    return(cant);
}

public void Insertar(int ele){
    if (Vacia()){
        Nodo P = new Nodo();
        P.setDato(ele);
        L=P;
        cant++;
    }else{
        Nodo aux = L;
        Nodo ant= null;
        
        while((aux!=null)&&(aux.getDato()<=ele)){
            ant = aux;
            aux = aux.getEnlace();
        }
        
        if (ant == null){  //INSERTAR EN LA CABEZA Y ES ÚNICO
            Nodo P = new Nodo();
            P.setDato(ele);
            P.setEnlace(L);
            L = P;
            cant++;
        }else{              //INSERTAR EN EL CUERPO
            if(ant.getDato()!=ele){         
                Nodo P = new Nodo();
                P.setDato(ele);
                ant.setEnlace(P);
                P.setEnlace(aux);
                cant++;
            }
        } 
    }
}

public void Eliminar(int ele){
    if (!Vacia()){
        Nodo aux = L;
        Nodo ant = null;
        while((aux!=null)&&(aux.getDato()!=ele)){
            ant = aux;
            aux = aux.getEnlace();
        }
        if(ant == null){ //ELIMINAMOS EL PRIMER ELEMENTO
            L = aux.getEnlace();
            cant--;
        }else{ //ELIMINAR EN EL CUERPO
            if(aux!=null){ //LO ENCONTRO
                ant.setEnlace(aux.getEnlace());
                cant--;
            }
          }
}
}

public int getDato(int pos){
    Nodo aux = L;
    for (int i = 1; i < pos ; i++) {
        aux = aux.getEnlace();
    }
    return aux.getDato();
}

public void Invertir(){             // METODO TRADICIONAL
    if ((Vacia())|(cant==1)){     // CASO BASE
    //Nada
    }else{
        Nodo pos = L.getEnlace();
        Nodo ant = null;
        Nodo act = L;
            while(pos!=null){
                act.setEnlace(ant);
                ant = act;
                act = pos;
                pos = pos.getEnlace();
            }
            act.setEnlace(ant);
            L = act;
    }
}

public void InvertirR(){ // MÉTODO RECURSIVO
    Invertir1(L);
}

public void Invertir1(Nodo P){ // MÉTODO RECURSIVO
    if (P==null){
        // NADA
    }else{
        if (P.getEnlace()==null){
            L = P;
        }else{ // CASO GENERAL
            Invertir1(P.getEnlace());
            P.getEnlace().setEnlace(P);
            P.setEnlace(null);
        }
    }
}

@Override
public String toString(){
    String s = "L -> <";
    Nodo P = L;
    while (P!=null){
        s = s + P.getDato() + ",";
        P = P.getEnlace();
    }
        s = s + ">";
        return (s);
    }




////////////////////////////////////////////////////
/////////////////// Metodos ////////////////////////
////////////////////////////////////////////////////


// INSERTA UN VALOR EN LA PRIMERA POSICION
    public void insertarPrimPosc(int x) {
        try {
            Nodo p = new Nodo();
            p.setDato(x);
            if (L == null) {
                p.setEnlace(null);
                L = p;
            } else {
                p.setEnlace(L);
                L = p;
            }
            cant++;
        } catch (Exception e) {
            System.err.println("ERROR: La memoria esta Llena");
        }
    }
    
    //INSERTA UN VALOR EN LA ULTIMA POSICION
    public void InsertUltPos(int x) {
        try {
            Nodo p = new Nodo();
        } catch (Exception e) {
            System.out.print("Error ..." + e);
        }
        Nodo p = new Nodo();
        p.setDato(x);
        if (L == null) {
            p.setEnlace(null);
            L = p;
        } else {
            Nodo q;
            q = L;
            while (q.Enlace != null) {
                q = q.getEnlace();
            }
            q.setEnlace(p);
            p.setEnlace(null);

        }
        cant++;
    }
    
    //INSERTA UN VALOR EN LA LISTA ORDENADAMENTE
    public void InsertarOrden(int x) {
        if (cant == 0) { //vacio
            Nodo p = new Nodo();
            p.setDato(x);
            L = p;
            cant++;
        } else {//caso general
            Nodo q = L;
            Nodo ant = null;
            while ((q != null) && ((q.getDato()) <= x)) {
                ant = q;
                q = q.getEnlace();
            }
            if (ant == null) {
                Nodo p = new Nodo();
                p.setDato(x);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {
                if (x == (ant.getDato())) {
                    return;
                } else {
                    Nodo p = new Nodo();
                    p.setDato(x);
                    ant.setEnlace(p);
                    p.setEnlace(q);
                    cant++;
                }
            }
        }
    }
    
    //DEVUELVE EL VALOR DE LA LISTA EN POSICION POS
    public int GetPosList(int pos) {//INSERTA LA POSICION
        if ((pos <= cant) && (pos > 0) && (L != null)) { //CONDICION GENERAL
            Nodo q;
            q = L;
            for (int i = 1; i <= pos - 1; i++) {
                q = q.getEnlace();
            }
            return (q.getDato());
        } else {
            System.out.println("ERROR POSICION FUERA DE RANGO");
        }
        return 0;
    }
    
    //ELIMINA EL DATO X DE LA LISTA SI EXISTE
    public void EliminarValor(int x){
        Nodo p = L;
        Nodo ant = null;
        while ((p != null) && (x != p.getDato())) {
            ant = p;
            p = p.getEnlace();
        }
        if (p != null) {
            if (ant == null)//ELIMINAMOS EL PRIMERO
            {
                L = p.getEnlace();
            } else {
                ant.setEnlace(p.getEnlace());
            }
            cant--;
        }
    }
    
//CANTIDAD DE ELEMENTOS QUE HAY EN LA LISTA
    public int CantidadEle() {
        return cant;
    }
    
//SUMA NORMAL DE LA LISTA
    public int Sumar() {
        int sum = 0;
        Nodo p = L;
        while (p != null) {
            sum = sum + p.getDato();
            p = p.getEnlace();
        }
        return sum;
    }
    
//SUMA RESURSIVA DE LA LISTA
    public int SumaRecurList() {
        return (SumaRecurList1(L));
    }
//ESCLAVO
    private int SumaRecurList1(Nodo p) {
        if (p == null) {//CASO BASE
            return 0;
        } else {//CASO GENERAL
            int sum = SumaRecurList1(p.getEnlace());
            return (p.getDato() + sum);
        }
    }
    
//MULTIPLICAR LOS ELEMENTOS DE LA LISTA NORMAL
    public int Multiplicar() {
        int mult = 1;
        Nodo p = L;
        while (p != null) {
            mult = mult * p.getDato();
            p = p.getEnlace();
        }
        return mult;
    }
    
//RESTAR LOS ELEMENTOS DE LA LISTA NORMAL
    public int Restar() {
        int res = 0;
        Nodo p = L;
        while (p != null) {
            res = res - p.getDato();
            p = p.getEnlace();
        }
        return res;
    }
    
//MAYOR DE LA LISTA RECURSIVO
    //YO

    public int MayorList() {
        return MayorList1(L);
    }
//ESCLAVO
    private int MayorList1(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            int x = MayorList1(p.getEnlace());
            if (x < p.getDato()) {
                return (p.getDato());
            } else {
                return x;
            }
        }
    }
    
//SUMA PARES RECURSIVO
    //YO
    public int SumaPares() {
        return (SumaPares1(L));
    }
//ESCLAVO
    private int SumaPares1(Nodo p) {
        int Sum = 0;
        if (p == null) {
            return Sum;
        } else {
            Sum = SumaPares1(p.getEnlace());
            if (((p.getDato()) % 2) == 0) 
                Sum = Sum + p.getDato();
        }
        return Sum;
    }
   
//SI EXISTE UN OBJETO O DATO ME RETORNA VERDADERO NO RESURSIVO
  
    
//SI EXISTE UN DATO RETORNA VERDADERO
    public boolean Existe2(int x){
        boolean sw = false;
        Nodo p = L;
        while ((p != null) && (p.getDato() != x)) {
            p = p.getEnlace();
        }
        if ((p != null) && (p.getDato() == x)) {
            sw = true;
        }
        return sw;
    }
    
//ELIMINAR PARES DE UNA LISTA NO RECURSIVO
    public void EliminarParesDoc() {
        Nodo p = L;
        Nodo ant = null;
        while (p != null) {
            while ((p != null) && (p.getDato() % 2 != 0)) {
                ant = p;
                p = p.getEnlace();
            }
            if (p != null) {
                if (ant == null) {//EL PRIMERO ES PAR
                    L = p.getEnlace();
                    cant--;
                    p = L;
                } else {
                    ant.setEnlace(p.getEnlace());
                    p = p.getEnlace();
                    cant--;
                }
            }
        }
    }
    
//CANTIDAD FRECUENCIA CUENTA CUANTAS VECES SE REPITE EL DATO
    public int CantFrec(int dato) {
        int Cont = 0;
        if (L == null) {
            return Cont;
        } else {
            Nodo A = L;
            while (A != null) {
                if (A.getDato() == dato) {
                    Cont++;
                }
                A = A.getEnlace();
            }
        }
        return Cont;
    }
    
//SACAR EL MAYOR VALOR DE LA LISTA
    public int SacarMayor() {
        int pos = 1;
        int may = GetPosList(pos);
        for (int i = 2; i <= Cantidad(); i++) {
            if (may < GetPosList(i)) {
                may = GetPosList(i);
                pos = i;
            }
        }
        Eliminar(pos);
        return may;
    }
    
//SACAR EL MENOR VALOR DE LA LISTA
    public int SacarMenor() {
        int pos = 1;
        int men = GetPosList(pos);
        for (int i = 2; i <= Cantidad(); i++) {
            if (men > GetPosList(i)) {
                men = GetPosList(i);
                pos = i;
            }
        }
        Eliminar(pos);
        return men;
    }

    public boolean estaVacia() {
        return L == null;
    }
//public LISTASIMPLEE ORDENARMITAD()
// {
//    if(!estaVacia())
//    {
//        LISTASIMPLEE nl=new LISTASIMPLEE();
//        int n=Cant /2;
//        while(n>0)
//        {
//            nl.INSERTARULT(SacarMayor());
//            n--;
//        }
//        while (Cantidad()>0)
//        {
//            nl.INSERTARULT(SacarMenor());
//        }
//        return nl;
//    }
//     return null;
//}
//

    //INVERTIR UNA LISTA NO RECURSIVA
    public void InvertirList() {
        Nodo p = L;
        Nodo aux, ant;
        aux = L;
        if (L != null) {
            ant = null;
            while (aux != null) {
                aux = p.getEnlace();
                p.setEnlace(ant);
                ant = p;
                p = aux;
            }
            L = ant;
        }
    }
/*
    @Override
    public String toString() {
        if (L != null) {
            NODOSIMPLE p;
            p = L;
            String s = "PRIMERO ->";
            while (p != null) {
                s = s + " [ " + Integer.toString(p.GetData()) + " ] " + "->";
                p = p.GetLink();
            }
            return s;
        } else {
            return "";
        }
    }
*/
    
//SI EXISTE UN DATO ME RETORNA TRUE RECURSIVO
    public boolean ExisteRecurList(int e) {
        return (ExisteRecurList1(L, e));
    }
    private boolean ExisteRecurList1(Nodo p, int e) {
        if (p == null) {//CASO BASE N 1Âº
            return false;
        }
        if (p.getDato() == e) {//CASO BASE N 2Âº
            return true;
        } else {//CASO GENERAL
            return ExisteRecurList1(p.getEnlace(), e);
        }
    }
    
    
//ELIMINAR PARES RECURSIVO
    public void ELIMINARPARES() {
        ELIMINARPARES1(L);
    }
//ESCLAVO
    private void ELIMINARPARES1(Nodo p) {
        if ((p == null) || (p.getEnlace() == null)) {//PRIMER CASO BASE
            if (p == null) {
                return;
            } else {
                if ((p == L) && ((p.getDato()) % 2 == 0)) {//SEGUNDO CASO BASE
                    L = null;
                    cant = 0;
                }
            }
        } else {//CASO GENERAL
            if (L == p) {
                if (p.getDato() % 2 == 0) {
                    L = p.getEnlace();
                    cant--;
                }
            }
            ELIMINARPARES1(p.getEnlace());
            if (((p.getEnlace().getDato()) % 2) == 0) {
                p.setEnlace(p.getEnlace().getEnlace());
                cant--;
            }
        }
    }
    
//ELIMINAR IMPARES
    public void ELIMINARIMPARES() {
        ELIMINARIMPARES1(L);
    }
//ESCLAVO
    private void ELIMINARIMPARES1(Nodo p) {
        if ((p == null) || (p.getEnlace() == null)) {
            if (p == null) {//PRIMER CASO BASE
                return;
            } else {//SEGUNDO CASO BASE
                if ((p == L) && (p.getDato() % 2 == 1)) {
                    L = null;
                    cant = 0;
                }
            }
        } else {//CASO GENERAL
            if (L == p) {
                if (p.getDato() % 2 == 1) {
                    L = p.getEnlace();
                    cant--;
                }
            }
            ELIMINARIMPARES1(p.getEnlace());
            if (((p.getEnlace().getDato()) % 2) == 1) {
                p.setEnlace(p.getEnlace().getEnlace());
                cant--;
            }
        }
    }
    
//ELIMINAR RECURSIVO
    public void ELIMINARRECURSIVO(int e) {
        ELIMINARRECURSIVO1(L, e);
    }
//ESCLAVO
    private void ELIMINARRECURSIVO1(Nodo p, int e) {
        if ((p == null) || (p.getEnlace() == null)) {
            if (p == null) {//PRIMER CASO BASE
                return;
            } else {
                if ((p == L) && (p.getDato() == e)) {
                    L = null;
                    cant = 0;
                }
            }
        } else {//CASO GENERAL
            if (L == p) {
                if (p.getDato() == e) {
                    L = p.getEnlace();
                    cant--;
                }
            }
            ELIMINARRECURSIVO1(p.getEnlace(),e);
            if (((p.getEnlace().getDato())) == e) {
                p.setEnlace(p.getEnlace().getEnlace());
                cant--;
            }
        }
    }
//DEVUELVE EL VALOR DE LA POSICION POS
    public int NTH(int pos) {
        Nodo aux = L;
        while (pos > 1) {
            aux = aux.getEnlace();
            pos--;
        }
        return aux.getDato();
    }
    
//INTERCALAR DOS LISTAS
    public void Intercalar(Lista L1, Lista L2) {
        int i, j;
        i = j = 0;
        while ((i < L1.cant) || (j < L2.cant)) {
            if (i < L1.cant) {
                Insertar(L1.NTH(i));
                i++;
            }
            if (j < L2.cant) {
                Insertar(L2.NTH(j));
                j++;
            }
        }
    }
    
//CANTIDAD DE ELEMENTOS PARES EN LA LISTA NO RECURSIVO
    public int CantParList() {
        Nodo p = L;
        int cont = 0;
        while (p != null) {
            if (p.getDato() % 2 == 0) {
                cont++;
            }
            p = p.getEnlace();
        }
        return cont;
    }
    
//CANTIDAD DE ELEMENTOS PARES EN LA LISTA
    public int CantParesRec() {
        return (CantParesRec1(L));
    }
    private int CantParesRec1(Nodo p) {
        int cont = 0;
        if (p == null) {
            return cont;
        } else {
            cont = CantParesRec1(p.getEnlace());
            if (((p.getDato()) % 2) == 0) {
                cont++;
            }
        }
        return cont;
    }
    
//INVERTIR LISTA NORMAL
    public void invertirLista0() { 
        if (L != null) {
            Nodo a = null;
            Nodo b = L;
            Nodo c = b.getEnlace();
            while (c != null) {
                b.setEnlace(a);
                a = b;
                b = c;
                c = c.getEnlace();
            }
            b.setEnlace(a);
            L = b;
        }
    }
    
//INVERTIR1 RECURSIVO YO
    public void INVERTIRRECURSIVO() {
        INVERTIRRECURSIVO1(L);
    }
//ESCLAVO
    private void INVERTIRRECURSIVO1(Nodo p) {
        if (cant > 1) { //SI NO ES VACIO Y TIENE MAS DE UN ELEMENTO
            if (p != null) {
                if (p.getEnlace() != null) {
                    Nodo aux = p.getEnlace();
                    p.setEnlace(aux.getEnlace());
                    aux.setEnlace(L);
                    L = aux;
                   // INVERTIRRECURSIVO1(p);//HACE QUE EL PRIM
                }
            }
        }
    }
    
    //INVERTIR2 YO
    public void INVERTIRLISTAS() {
        INVERTIRLISTAS0(L);
    }
    //ESCLAVO MI OBJETIVO ES PONER EL ULTIMO VALOR AL PRIMER NODO
    public void INVERTIRLISTAS1(Nodo p) {
        if (p.getEnlace() == null) {//SI MI PILA APUNTA A TIERRA NO ME HACE NADA
            return;
        } else {
            //CASO GENERAL
            INVERTIRLISTAS1(p.getEnlace());
            int x = p.getDato();
            p.setDato(p.getEnlace().getDato());
            p.getEnlace().setDato(x);
            p = p.getEnlace();
        }
    }
//CONTINUA EL INVERTIR
    private void INVERTIRLISTAS0(Nodo pp) {
        if (pp.getEnlace() != null) {
            INVERTIRLISTAS1(pp);//ME MANDA MI NUEVA LISTA
            INVERTIRLISTAS0(pp.getEnlace());
        }
    }
    
//LE MANDO EL ELEMENTO DE LA LISTA Y ME DA COMO
    //RESULTADO LA POSICION DONDE SE ENCUENTRA EL ELEMENTO
    public int BUSCARPOS(int elemento) {
        Nodo P = L;
        boolean sw = true;
        int cont = 0;
        while ((P != null) && (sw == true)) {
            cont++;
            if (P.getDato() == elemento) {
                sw = false;
            }
            P = P.getEnlace();
        }
        return cont;
    }
    
    //  ELIMINA LOS NODOS CON DATOS IMPARES NO RECURSIVO
    public void ELIMINARDATOSIMPARES() {
        if (L != null) {
            Nodo ant = L;
            Nodo T = L.getEnlace();
            while (T != null) {
                if ((T.getDato() % 2) == 0) {
                    ant.setEnlace(T);
                    ant = T;
                    T = T.getEnlace();
                } else {
                    T = T.getEnlace();
                }
            }
            ant.setEnlace(T);
            ant = L;
            if ((L.getDato() % 2) == 1) {
                L = L.getEnlace();
                ant.setEnlace(T);
            }
        }
    }
    
    //  ELIMINA LOS NODOS DE LAS POSICIONES IMPARES
    public void ELIMINARPOSIMPARES() {
        if (L != null) {
            L = L.getEnlace();
            Nodo ant = null;
            Nodo T = L;
            while ((T.getEnlace() != null)) {
                ant = T;
                T = T.getEnlace();
                ant.setEnlace(T.getEnlace());
            }
        }
    }
    
    //  ELIMINA LOS NODOS DE LAS POSICIONES PARES
    public void ELIMINARPOSPARES() {
        if (L != null) {
            Nodo ant = null;
            Nodo T = L;
            while ((T.getEnlace() != null)) {
                ant = T;
                T = T.getEnlace();
                ant.setEnlace(T.getEnlace());
            }
        }
    }

    public int FRECUENCIA(int ele) {
        int f = 0;
        if (cant == 1) {
            if (ele == L.getDato()) {
                f = 1;
            }
        } else {
            Nodo aux = L;
            for (int i = 0; i < cant; i++) {
                if (aux.getDato() == ele) {
                    f++;
                }
                aux = aux.getEnlace();
            }
        }
        return f;
    }
    
    //RETORNA EL VALOR DE MAYOR FRECUENCIA
    public int ELEMAYORFRECUENCIA() {
        int ele = 0;
        if (cant == 1) {//EN CASO DE QUE ME ENVIE UN SOLO NODO
            ele = L.getDato();
        } else {
            int f1 = 0;
            Nodo aux = L;
            for (int i = 0; i < cant; i++) {
                int ele1 = aux.getDato();
                if (FRECUENCIA(ele1) > f1) {
                    f1 = FRECUENCIA(ele1);
                    ele = ele1;
                }
                aux = aux.getEnlace();
            }
        }
        return ele;
    }

    public void ORDENAR() {
        Nodo aux = L;
        //TNodo e=aux;
        if (aux == null) {
        } else {
            Nodo p = aux.getEnlace();
            while (aux != null) {
                while (p != null) {
                    if (aux.getDato() > p.getDato()) {
                        int x = p.getDato();
                        p.setDato(aux.getDato());
                        aux.setDato(x);
                    }
                    p = p.getEnlace();
                }
                aux = aux.getEnlace();
                p = aux;
            }
        }
        //list=e;
    }
////public void ELIMINARREPETIDOMAY(){
//// ELIMINARREPETIDOMAY1(L);
////}
////private void ELIMINARREPETIDOMAY1(NODOSIMPLE p){
////if((p == null)||(p.GetLink() == null)){
////return;
////}
////else{
////ELIMINARREPETIDOMAY1(p.GetLink());
////if(Cant > 1){
////NODOSIMPLE aux = L;
////p = p.GetLink();
////NODOSIMPLE ant = L;
////          while (p != null) {
////            if(aux.GetData() == p.GetData()){
////            p = p.GetLink();
////            ant.SetLink(p);
////            Cant--;
////            }
////            else{
////            ant=p;
////            p = p.GetLink();
////            }
////        }
////}
////}
////}

    public void ELIMINAREPETIDONORMAL() {
        if (cant > 1) {
            Nodo aux = L, p = L.getEnlace(), ant = L;
            while (aux != null && aux.getEnlace() != null) {
                while (p != null) {
                    if (aux.getDato() == p.getDato()) {
                        p = p.getEnlace();
                        ant.setEnlace(p);
                        cant--;
                    } else {
                        ant = p;
                        p = p.getEnlace();
                    }
                }
                aux = aux.getEnlace();
                ant = aux;
                if (aux != null) {
                    p = aux.getEnlace();
                }
            }
        }
    }
    
    public void ELIMINARNOREPETIDO() {
        if (cant > 0) {
            Nodo A = L, B, ant = null;
            int c;
            while (A != null) {
                c = 0;
                B = L;
                while (B != null) {
                    if (B.getDato() == A.getDato()) {
                        c++;
                    }
                    B = B.getEnlace();
                }
                if (c == 1) {
                    if (A == L) {
                        ant = A = L = L.getEnlace();
                    } else {
                        ant.setEnlace(A.getEnlace());
                        A = A.getEnlace();
                    }
                    cant--;
                } else {
                    ant = A;
                    A = A.getEnlace();
                }
            }
        }
    }

    public boolean CAPICUA() {
        if (cant > 1) {
            Nodo d = L, c = L, b;
            while (d.getEnlace() != null) {
                d = d.getEnlace();
            }
            int n = cant / 2;
            while (n > 0) {
                n--;
                if (d.getDato() != c.getDato()) {
                    return false;
                }
                b = c = c.getEnlace();
                while (b.getEnlace() != d) {
                    b = b.getEnlace();
                }
                d = b;
            }
            return true;
        }
        return false;
    }

    public void DelPares() {
       Nodo P = L;
       Nodo ant = null;
        while (P != null) {
            if (P.getDato() % 2 == 0) {
                if (ant == null) {
                    L = L.getEnlace();
                    P = L;
                    cant--;
                } else {
                    ant.setEnlace(P.getEnlace());
                    P = P.getEnlace();
                    cant--;
                }
            } else {
                ant = P;
                P = P.getEnlace();
            }
        }
    }
    
    public void DELPARESRECURSIVO(){
    L = DELPARESRECURSIVO1(L);
    }
    public Nodo DELPARESRECURSIVO1(Nodo P){
        if(P == null)
            return null;
    else
        if(P.getEnlace() == null && P.getDato() % 2 == 0)
            return null;
        else{
          while(P.getDato() % 2 == 0 && P != null){
              P = P.getEnlace();
          }
        P.setEnlace(DELPARESRECURSIVO1(P.getEnlace()));
        return P;
        }
    }
    
    public int PosicionMenor() {
        int c = 1;
        int p = 1;
        int s = L.getDato();
        Nodo aux = L;
        while (aux.getEnlace() != null) {
            if (s < aux.getDato()) {
                aux = aux.getEnlace();
                p++;
            } else {
                s = aux.getDato();
                aux = aux.getEnlace();
                c = p;
                p++;
            }
        }
        return c;
    }
    
   public Nodo ELIMINARULT(Nodo L){
    if(L == null)//caso base 1 mi lista apunta a null asea a nada
        return null;
    else
        if(L.getEnlace()== null)//caso base 2 mi lista tiene un nodo
            return null;
        else{ //caso general
            L.setEnlace(ELIMINARULT(L.getEnlace()));
//    NODOSIMPLE aux = ELIMINARULT(L.GetLink());
//    L.SetLink(aux);
        return L;
        }
    }
   
    public void eliminarult(Nodo L){
    Nodo p= L;
    Nodo ant = null;
    if(cant > 1){
        while (p.getEnlace() != null) {
            ant = p;
            p = p.getEnlace();
        }
        ant.setEnlace(null);
    }
    }
    
    //pregunta de examen invertir un lista
    public int Longitug(){
    Nodo p = L;
    int cont = 0 ;
        while (p != null) {
            cont++;
            p = p.getEnlace();
        }
    return cont;
    }
    
    public int  SEGUNDOMAYORLIS(){
    Nodo p = L;
    Nodo Ant = null;
    if(cant > 0){
        while (p.getEnlace()!= null) {
            Ant = p;
            p = p.getEnlace();
        }
    }
    return Ant.getDato();
    }
    
    public int NTH2(int pos){
    Nodo p = L;
        for (int i = 1; i <= pos-1; i++) {
            p = p.getEnlace();
        }
    return p.getDato();
    }
    
    public void ReserveSearch(Nodo L){
    if(L != null){
    int i = Longitug();
    int c = 0;
        while (c < Longitug()) {            
            int dato = NTH2(i);
            System.out.println(dato);
            i--;
            c++;
        }
    }
    }
    
    public void InsertarORDEREPETIDO(int x) {
        if (cant == 0) { //vacio
            Nodo p = new Nodo();
            p.setDato(x);
            L = p;
            cant++;
        } else {//caso general
            Nodo q = L;
            Nodo ant = null;
            while ((q != null) && ((q.getDato()) <= x)) {
                ant = q;
                q = q.getEnlace();
            }
            if (ant == null) {
                Nodo p = new Nodo();
                p.setDato(x);
                p.setEnlace(L);
                L = p;
                cant++;
            }else {
                    Nodo p = new Nodo();
                    p.setDato(x);
                    ant.setEnlace(p);
                    p.setEnlace(q);
                    cant++;
                }
            }
        }

    public Boolean DUPLICADOS (){
    return DUPLICADOS1(L);
    }
    private Boolean DUPLICADOS1(Nodo L){
    if(L.getEnlace() == null)
        return false;
    else
        if(L.getDato() == L.getEnlace().getDato())
            return true;
    else{
    return DUPLICADOS1(L.getEnlace());
    }
    }
    
    public Boolean DUPLISTDESORDENADO(){
    return DUPLISTDESORDENADO1(L);
    }
    private Boolean DUPLISTDESORDENADO1(Nodo L){
    Nodo P = L;
        if(L.getEnlace() == null)
        return false;
    else
        while(P != null){
        if(L.getDato() == P.getDato()){
        return true;
        }
        P = P.getEnlace();
        }
    return DUPLISTDESORDENADO1(L.getEnlace());
   }
    
  public void eliminarparrrrrrr(){
  eliminarparrrrrrr1(L);
  }
  private void eliminarparrrrrrr1(Nodo L){
      if (L == null)
          return;
      else
          if(L.getDato() % 2 == 0)
              L = L.getEnlace();
          else{//caso general
          eliminarparrrrrrr1(L.getEnlace());
          }
  }
  
}
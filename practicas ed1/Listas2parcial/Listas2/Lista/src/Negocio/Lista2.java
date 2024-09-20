package Negocio;


public class Lista2 {

    Nodo2 L;
    public int dim;
    
    public Lista2(){
        L = null;
        dim = 0;
    }
    
    public boolean Vacia(){
        return (dim == 0);
    }
    
    public void Insertar(int Izq, int Der){
        if (Vacia()){
            Nodo2 p = new Nodo2(); 
            p.setDato1(Izq);
            p.setDato2(Der);
            L = p;
            dim++;
        }else{
//            Nodo2 Ant = null;
            Nodo2 Aux = L;
            if (Aux != null){
                if (Der == L.getDato1()){
                    Nodo2 p = new Nodo2();
                    p.setDato1(Izq);
                    p.setDato2(Der);
                    p.setEnlace(L);
                    L = p;
                    dim++;
                }else{
                    while (Aux.getDato2() != Izq){
//                        Ant = Aux;
                        Aux=Aux.getEnlace();
                    }
                    Nodo2 p = new Nodo2();
                    p.setDato1(Izq);
                    p.setDato2(Der);
                    Aux.setEnlace(p);
                    p.setEnlace(null);
                    dim++;
                }
            }
        }
    }
    
    @Override
    public String toString(){
        String S = "L->";
        Nodo2 Aux = L;
        while(Aux != null){
            S = S + "[" + Aux.getDato1() + "]" + "[" + Aux.getDato2() + "]->";
            Aux = Aux.getEnlace();
        }
        return S+"null";
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lista2 A = new Lista2();
        
        A.Insertar(1, 2);
        A.Insertar(2, 3);
        A.Insertar(3, 4);
        A.Insertar(5, 1);
        
        System.out.println(A);
    }
    
}

package Negocio;


public class Lista {

    Nodo L;
    public int dim;
    
    public Lista(){
        L = null;
        dim = 0;
    }
    
    public boolean Vacia(){
        return (dim == 0);
    }
    
    public void Insertar(int ele){
        if (Vacia()){
            Nodo p = new Nodo();
            p.setDato(ele);
            L = p;
            dim++;
        }else{
            Nodo Ant = null;
            Nodo Aux = L;
            while ((Aux != null) && (Aux.getDato() <= ele)){
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Ant == null){
                Nodo p = new Nodo();
                p.setDato(ele);
                p.setEnlace(L);
                L = p;
                dim++;
            }else{
                if (Ant.getDato() != ele){
                    Nodo p = new Nodo();
                    p.setDato(ele);
                    Ant.setEnlace(p);
                    p.setEnlace(Aux);
                    dim++;
                }
            }
        }
    }
    
    public void Eliminar(int ele){
        if (!Vacia()){
            Nodo Ant = null;
            Nodo Aux = L;
            
            while ((Aux != null) && (Aux.getDato() != ele)){
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Ant == null){
                L = Aux.getEnlace();
                dim--;
            }else{
                if (Aux != null){
                    Ant.setEnlace(Aux.getEnlace());
                    dim--;
                }
            }
        }
    }
    
    public int Sacar(int pos){
        Nodo Aux = L;
        int i = 1;
        while (i < pos){
            Aux = Aux.getEnlace();
            i++;
        }
        return (Aux.getDato());
    }
    
    public boolean Buscar(int ele){
        Nodo Aux = L;
        while ((Aux != null) && (Aux.getDato() != ele)){
            Aux = Aux.getEnlace();
        }
        return (Aux != null);
    }
    
    public boolean BuscarR(int ele){
        return (BuscarR(ele, L));
    }
    
    private boolean BuscarR(int ele, Nodo p){
        if (p == null){
            return false;
        }else{
            boolean x = BuscarR(ele, p.getEnlace());
            if (!x){
                if (p.getDato() == ele){
                    x = true;
                }else{
                    x = false;
                }
            }
            return x;
        }
    }
    
    public void Invertir (){
        if (dim >= 2){
            Nodo Ant = null;
            Nodo Aux = L;
            Nodo Post = L.getEnlace();
            while (Post != null){
                Aux.setEnlace(Ant);
                Ant = Aux;
                Aux = Post;
                Post = Post.getEnlace();
            }
            Aux.setEnlace(Ant);
            L = Aux;
        }
    }
    
    public void InvertirR(){
        InvertirR(L);
    }
    
    private void InvertirR(Nodo p){
        if (p == null){
            
        }else{
            if (p.getEnlace() == null){
                L = p;
            }else{
                InvertirR(p.getEnlace());
                p.getEnlace().setEnlace(p);
                p.setEnlace(null);
            }
        }
    }
    
    public void Inter2a2(){
        if (!Vacia()){
            Nodo Aux=new Nodo();
            if (L != null){
                Nodo pri=L;
                if (pri.getEnlace() != null){
                    Nodo seg = pri.getEnlace();
                    if (seg.getEnlace() == null){
                        L=seg;
                        seg.setEnlace(pri);
                        pri.setEnlace(null);
                    }else{
                        L=seg;
                        while(pri.getEnlace() != null){
                            pri.setEnlace(seg.getEnlace());
                            seg.setEnlace(pri);
                            Aux.setEnlace(seg);
                            Aux=pri;
                            if(pri.getEnlace() != null){
                                pri=pri.getEnlace();
                                if (pri.getEnlace() != null){
                                    seg = pri.getEnlace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void Inter3a3(){
        if (!Vacia()){
            Nodo Aux=new Nodo();
            if(L != null){
                Nodo pri=L;
                if (pri.getEnlace() != null){
                    Nodo seg=pri.getEnlace();
                    if (seg.getEnlace() != null){
                        Nodo ter=seg.getEnlace();
                        if (ter.getEnlace()==null){
                            L=ter;
                            ter.setEnlace(seg);
                            seg.setEnlace(pri);
                            pri.setEnlace(null);
                        }else{
                            L=ter;
                            while ((pri.getEnlace()!=null)&&(seg.getEnlace()!=null)){
                                pri.setEnlace(ter.getEnlace());
                                ter.setEnlace(seg);
                                seg.setEnlace(pri);
                                Aux.setEnlace(ter);
                                Aux=pri;
                                if (pri.getEnlace()!=null){
                                    pri=pri.getEnlace();
                                    if(pri.getEnlace()!=null){
                                        seg=pri.getEnlace();
                                        if(seg.getEnlace()!=null){
                                            ter=seg.getEnlace();
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
    
    public void Inter1yn(){
        if (!Vacia()){
            Nodo Aux=new Nodo();
            if(L!=null){
                Nodo pri=L;
                if(pri.getEnlace()!=null){
                    Nodo ult=L;
                    if(pri.getEnlace().getEnlace()==null){
                        ult=ult.getEnlace();
                        L=ult;
                        ult.setEnlace(pri);
                        pri.setEnlace(null);
                    }else{
                        while(ult.getEnlace()!=null){
                            Aux=ult;
                            ult=ult.getEnlace();
                        }
                        L=ult;
                        ult.setEnlace(pri.getEnlace());
                        Aux.setEnlace(pri);
                        pri.setEnlace(null);
                    }
                }
            }
        }
    }
    
    public void Inter2a2_1(){
        if(!Vacia()){
            Nodo aux=L;
            Nodo aux2=L;
            if(L != null){
                Nodo pri=aux.getEnlace();
                if(pri.getEnlace() != null){
                    Nodo seg=pri.getEnlace();
                    if (seg.getEnlace() == null){
                        seg.setEnlace(pri);
                        pri.setEnlace(null);
                        aux.setEnlace(seg);
                    }else{
                        while(pri.getEnlace()!=null){
                            pri.setEnlace(seg.getEnlace());
                            seg.setEnlace(pri);
                            aux2.setEnlace(seg);
                            aux2=pri;
                            if(pri.getEnlace()!=null){
                                pri=pri.getEnlace();
                                if(pri.getEnlace()!=null){
                                    seg=pri.getEnlace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public String toString(){
        String S = "L->";
        Nodo Aux = L;
        while (Aux != null){
            S = S +"["+ Aux.getDato() + "]->";
            Aux = Aux.getEnlace();
        }
        return S+"null";
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lista A = new Lista ();
        
        A.Insertar(2);
        A.Insertar(5);
        A.Insertar(3);
        A.Insertar(4);
        A.Insertar(1);
        A.Insertar(6);
        A.Insertar(7);
        System.out.println(A);
        
//        A.Eliminar(2);
//        System.out.println(A);
//        
//        boolean x = A.Buscar(4);
//        System.out.println(x);
//        
//        x = A.Vacia();
//        System.out.println(x);
//        
//        int v = A.Sacar(3);
//        System.out.println(v);
//        
//        boolean y=A.BuscarR(2);
//        System.out.println(y);
        
//        A.Invertir();
//        A.InvertirR();
//        System.out.println(A);
        
//        A.Inter2a2();
//        System.out.println(A);
//        
        A.Inter3a3();
        System.out.println(A);
        
//        A.Inter1yn();
//        System.out.println(A);
        
//        A.Inter2a2_1();
//        System.out.println(A);
    }
    
}

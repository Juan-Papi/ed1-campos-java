/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examenlista;

/**
 *
 * @author Auxiliarlab21
 */
public class Lista {Nodo L;
                    int cant;

public Lista(){
    L=null;
    cant=0;    
}
public void insertar1(int ele){
    insertar(L, ele);
}
public void insertar(Nodo P,int ele)
{
       Nodo x = new Nodo(ele);
    if (P == null){
        L = x;
        cant++;
    }
    else if(P.get_enlace() == null){
        P.set_enlace(x);
        cant++;
    }
    else{
        int i = ((cant+1)/2)-1;
        while (i>0){
            P = P.get_enlace();
            i--;
        }
        Nodo aux = P.get_enlace();
        P.set_enlace(x);
        x.set_enlace(aux);
        cant++;
    }
    

}
public void intercambio(){
    intercambia(L);
}

private void intercambia(Nodo P){
    if (P == null){}
    else if ((P.get_enlace() == null) && (cant == 1)){}
    else{
        if(cant==2){
            Nodo ant=P;
            Nodo aux=P.get_enlace();
            aux.set_enlace(ant);
            ant.set_enlace(null);            
            L=aux;
        }else{
        if (P.get_enlace() == null){
            Nodo ant = L;
            while (ant.get_enlace() != P){
                ant = ant.get_enlace();
            }
            Nodo aux = L;
            
            P.set_enlace(aux.get_enlace());
            aux.set_enlace(null);
            ant.set_enlace(aux);
            L = P;
            P = aux;
        }
        intercambia(P.get_enlace());
        }
    }
}
public void insertarNormal(int x){
    if(L==null){
    Nodo P=new Nodo();
    P.set_dato(x);
    P.set_enlace(null);
    L=P;
    cant++;
    }else{
        Nodo Q=L;
        Nodo W=null;
        while((Q!=null)&&(Q.get_dato()<x)){
            W=Q;
            Q=Q.get_enlace();
        }
        if(Q!=null){
        if(x!=Q.get_dato()){
            Nodo P=new Nodo();
            P.set_dato(x);
            if(W==null){
                P.set_enlace(Q);
                L=P;
                cant++;
            }else{
                W.set_enlace(P);
                P.set_enlace(Q);
                cant++;
            }
        }
        }else{
            Nodo P=new Nodo();
            P.set_dato(x);
            W.set_enlace(P);
            P.set_enlace(Q);
            cant++;
    }
    }
    }


public String mostrar(){
    String s="";
    Nodo x=L;
    for(int i=1; i<=cant; i++){
        s=s+x.get_dato()+"|";
        x=x.get_enlace();
    }
    return s;
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista l=new Lista();
        l.insertar1(2); 
        l.insertar1(7); 
        l.insertar1(3);
        l.insertar1(10);
        l.insertar1(4);        
        l.insertar1(20);
        l.insertar1(15);
        System.out.println(l.mostrar());
        System.out.println();
        
        
        Lista l1=new Lista();
        l1.insertarNormal(1);        
        l1.insertarNormal(3);        
        l1.insertarNormal(5);  
        l1.insertarNormal(6);  
        l1.insertarNormal(7);            
       
        System.out.println(l1.mostrar());
        l1.intercambio();
        System.out.println(l1.mostrar());
        System.out.println();
        
        Lista l2=new Lista();
        l2.insertarNormal(9);
        l2.insertarNormal(15);
        System.out.println(l2.mostrar());
        l2.intercambio();
        System.out.println(l2.mostrar());

    }
    
}

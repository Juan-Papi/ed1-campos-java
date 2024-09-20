/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author estudiante
 */

	
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 

public class Lista1 {
    Nodo L;
    int cant;
public Lista1(){
    L=null;
    cant=0;
}
public void insertar(int x){
    if(L==null)
    {
    Nodo P=null;
    P.setDato(x);
    P.setEnlace(null);
    L=P;
    cant++;
    }else{
        Nodo Q=L;
        Nodo W=null;
        while((Q!=null)&&(Q.getDato()<x)){
            W=Q;
            Q=Q.getEnlace();
        }
        if(Q!=null){
        if(x!=Q.getDato()){
            Nodo P=null;
            P.setDato(x);
            if(W==null){
                P.setEnlace(Q);
                L=P;
                cant++;
            }else{
                W.setEnlace(P);
                P.setEnlace(Q);
                cant++;
            }
        }
        }else{
            Nodo P=null;
            P.setDato(x);
            W.setEnlace(P);
            P.setEnlace(Q);
            cant++;
    }
    }
    }
public void Insertar1(int Ele)
{
    if(cant>0)
    {
    Nodo P = null;
    P.setDato(Ele);
    L=P;
    cant++;
    }else{ // No esta Vacia
            Nodo pos= L;
            Nodo ant=null;
            while ((pos!=null) &&((pos.getDato())<Ele))
            {
                ant=pos;
                pos=pos.getEnlace();
            }
            if(ant==null) //Insertar la primera posicion
            {
                Nodo P= null;
                P.setDato(Ele);
                L=P;
                P.setEnlace(pos);
                cant++;
                P.setEnlace(P);
            }else{  if(ant.getDato()!=Ele)
                     //Insertar en el cuerpo de la lista
                    {
                        Nodo P=null;
                        P.setDato(Ele);
                        ant.setEnlace(P);
                        P.setEnlace(pos);
                        cant++;
                    }
            }
    }

}
public String mostrar(){
    String s="";
    Nodo x=L;
    for(int i=1; i<=cant; i++){
        s=s+x.getDato()+" | ";
        x=x.getEnlace();
    }
    return s;
}
/*public void eliminarRepp() {
        eliminarRepppp(L);
    }
 
    private void eliminarRepppp(Nodo p) {
        if ((p == null) || (p.getEnlace() == null)) {
            if (p == null) {//lista vacia
                //nada
            } else {
                if (p.getEnlace() == null) {//lista con un elemento
                    //nada
                }
            }
        } else {
            int x = p.getDato();
            eliminarRepppp(p.getEnlace());
            if (p != null) {
                if (p.getEnlace().getDato() == x) {
                    p.setEnlace(p.getEnlace().getEnlace());
                    cant--;
                }
 
 
            }
        }
    }*/

public void invertir(){
    invertir_R(L);
}
private void invertir_R(Nodo P){
    if(P==null){
 
    }else{
        if(P.getEnlace()==null){
            L=P;
        }else{
            invertir_R(P.getEnlace());
            P.getEnlace().setEnlace(P);
            P.setEnlace(null);
 
        }
    }
}
public void elim_pares(){
       elim_pares_R(L);
}
private void elim_pares_R(Nodo P){
    if(P==null){
    //nada
    }else{
        if(P.getEnlace()==null){
            if(P.getDato()%2==0){
                L=null;
                cant=0;
            }
        }else{
            elim_pares_R(P.getEnlace());
            if(P.getEnlace().getDato()%2==0){
                P.setEnlace(P.getEnlace().getEnlace());
                cant--;
            }
            if(L==P){
              if(P.getDato()%2==0){
                    L=P.getEnlace();
                    cant--;
              }
            }
        }
    }
}
public void elim_dato(int x){
       elim_dato_R(L,x);
}
private void elim_dato_R(Nodo P, int x){
    if(P==null){
    //nada
    }else{
        if(P.getEnlace()==null){
            if(P.getDato()==x){
                L=null;
                cant=0;
            }
        }else{
            elim_dato_R(P.getEnlace(),x);
            if(P.getEnlace().getDato()==x){
                P.setEnlace(P.getEnlace().getEnlace());
                cant--;
            }
            if(L==P){
              if(P.getDato()==x){
                    L=P.getEnlace();
                    cant--;
              }
            }
        }
    }
}
public int suma(){
    int x=suma_R(L);
    return x;
}
private int suma_R(Nodo P){
    int x;
    if(P==null){
        x=0;
    }else{
       x= suma_R(P.getEnlace());
       x=x+P.getDato();
    }
    return x;
}
public boolean existe_dato(int x){
    boolean b=existe_dato_R(L,x);
    return b;
}
private boolean existe_dato_R(Nodo P, int x){
    boolean b;
    if (P==null){
    b=false;
    }else{
        if(P.getDato()==x){
         b=true;
        }else{
            b=existe_dato_R(P.getEnlace(),x);
        }
    }
    return b;
}
public boolean escalera(){
 boolean b=escaleraR(L);
  return b;
}
private boolean escaleraR(Nodo P){
    boolean b=true;
    if((P==null)||(P.getEnlace()==null)){
        if(P==null){//1er caso base
        b=false;
        }
        if (P.getEnlace()==null) {//2do caso base
            b=true;
            }
    }else{//caso general
       if(P.getDato()+1==P.getEnlace().getDato()){
        b=escaleraR(P.getEnlace());
       }else{
       b=false;
       }
    }
      return b;
 
    }
public void insertar_R(int x){
    insertar_RR(L,x);
}
private void insertar_RR(Nodo P, int x){
     
    if((P==null)||(P.getEnlace()==null)){
        Nodo N=new Nodo(x);
        if(P==null){
            L=N;
            cant++;
        }else{
        if((P.getEnlace()==null)&&(P==L)){
            if(x>P.getDato()){
                L.setEnlace(N);
                cant++;
            }else{
                N.setEnlace(L);
                L=N;
                cant++;
            }
        }
        }
    }else{
    int c=cant;
        insertar_RR(P.getEnlace(),x);
        if(c==cant){
        if((P.getEnlace().getEnlace()==null)&&(x>P.getEnlace().getDato())){
            Nodo N=new Nodo(x);
            P.getEnlace().setEnlace(N);
            cant++;
        }else{
        if((P!=L)&&(x>P.getDato())){
            Nodo N=new Nodo(x);
            N.setEnlace(P.getEnlace());
            P.setEnlace(N);
            cant++;
        }else{
            if((P==L)&&(x>P.getDato())){
                Nodo N=new Nodo(x);
                N.setEnlace(P.getEnlace());
                P.setEnlace(N);
                cant++;
            }else{
                if(P==L){
                    Nodo N=new Nodo(x);
                    N.setEnlace(L);
                    L=N;
                    cant++;
                }
            }
        }
        }
    }
    }
}
public int may_pares(){
    int p=may_pares1(L);
    return p;
}
private int may_pares1(Nodo P){
    int p=0;
    if((P==null)||(P.getEnlace()==null)){
        if(P==null){
        p=0;
        }else{
        if((P.getEnlace()==null)){
            if(P.getDato()%2==0){
            p=P.getDato();
            }else{
            p=0;
            }
        }
        }
    }else{
        p=may_pares1(P.getEnlace());
        if(P.getDato()%2==0){
            if(P.getDato()>p){
                p=P.getDato();
            }
        }
    }
    return p;
}
public void eliminarRepp() {
        eliminarRepppp(L);
    }
 
    private void eliminarRepppp(Nodo p) {
        if ((p == null) || (p.getEnlace() == null)) {
            if (p == null) {//lista vacia
                //nada
            } else {
                if (p.getEnlace() == null) {//lista con un elemento
                    //nada
                }
            }
        } else {
            int x = p.getDato();
            eliminarRepppp(p.getEnlace());
            if (p != null) {
                if (p.getEnlace().getDato() == x){
                    p.setEnlace(p.getEnlace().getEnlace());
                    cant--;
                    //cant=cant-2;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Lista1 P=new Lista1();  
        P.insertar(1);
        P.insertar(2);
        P.insertar(3);
        P.insertar(4);
        P.insertar(5);
        //P.mostrar();
        System.out.println(P.mostrar());
        
        
        
        
        
        /*
        P.insertar_R(1);
        P.insertar_R(2);
        P.insertar_R(3);
        P.insertar_R(4);
        P.insertar_R(1);
        P.insertar_R(4);
        P.insertar_R(3);
        P.insertar_R(2);
        P.insertar_R(7);
        System.out.println(P.mostrar());
        P.eliminarRepp();
        System.out.println(P.mostrar());


        //int m;
        //m=P.may_pares();
        
         
 
 
        //P.in1vertir();
        //System.out.println(P.mostrar());
        //P.elim_pares();
        //System.out.println(P.mostrar());
        //P.elim_dato(5);
        //System.out.println(P.mostrar());
//        int s=P.suma();
//        System.out.println(s);
//        boolean b=P.existe_dato(10);
//        System.out.println(b);
//        boolean a=P.escalera();
//        System.out.println(a);
 
 */
    }
 
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listas;

/**
 *
 * @author lab46
 */
public class ListaSimple {
    Nodo L;
    int cant;
    
public ListaSimple()
{
L=null;
cant=0;
}
public boolean Vacia()
{
return (L==null); // Puede ser "return (cant==0);"
}
public void Insertar(int Ele)
{
    if(Vacia())
    {
    Nodo P = new Nodo();
    P.setData(Ele);
    L=P;
    cant++;
    }else{ // No esta Vacia
            Nodo pos= L;
            Nodo ant=null;
            while ((pos!=null) &&((pos.getData())<Ele))
            {
                ant=pos;
                pos=pos.getEnlace();
            }
            if(ant==null) //Insertar la primera posicion
            {
                Nodo P= new Nodo();
                P.setData(Ele);
                L=P;
                P.setEnlace(pos);
                cant++;
                P.setEnlace(P);
            }else{  if(ant.getData()!=Ele)
                     //Insertar en el cuerpo de la lista
                    {
                        Nodo P=new Nodo();
                        P.setData(Ele);
                        ant.setEnlace(P);
                        P.setEnlace(pos);
                        cant++;
                    }
            }
    }

}
public void Eliminar(int Ele)
{
    if(!Vacia())
    {
        Nodo p=L;
        Nodo ant=null;
        while((p!=null)&&(p.getData()!=Ele))
        {
            ant=p;
            p=p.getEnlace();
        }
        if(ant==null)
        {
        L=p.getEnlace();
        cant--;
        }else{
            ant.setEnlace(p.getEnlace());
            cant--;
        }
    
    
    }
}

    @Override
    public String toString() {
        String S="";
        S=S+L.getData();
        Nodo P = L.getEnlace();
       
        for (int i = 1; i < cant; i++) {
            
                S=S+" "+P.getData();
                P=P.getEnlace();
            }
        
        return S; //"ListaSimple{" + "L=" + L + ", cant=" + cant + '}';
    }

 /*Dada 1 3 5 7 9
Queda   9 7 5 3 1*/
public void InvertirMitades1()  //Algoritmo normales
{
    if ((Vacia())||(L.getEnlace()==null))
    {
        //nada
    }else{
            Nodo ant=null;
            Nodo p=L;
            Nodo pos = L.getEnlace();
            while (pos!=null)
            {
                p.setEnlace(ant);
                ant=p;
                p=pos;
                pos=pos.getEnlace();
            
            }
            p.setEnlace(ant);
            L=p;
    
         }

}
 /*Dada 1 3 5 7 9
Queda   9 7 5 3 1*/
public void InvertirRecursivo()
{
    InvertirRecursivoAux(L);
}
private void InvertirRecursivoAux(Nodo P)
{
        if (P==null){
        //nada
        
        }else{
                if (P.getEnlace()==null){ //IMPORTANTE
                L=P;
                }else{//caso general
                    InvertirRecursivoAux(P.getEnlace());
                    P.getEnlace().setEnlace(P);
                    P.setEnlace(null); 
                }  
             }
}
/* Dada 2 2 3 5 5 5 7 9
Queda  2 3 5 7 9*/   /*En caso de que se pudiera meter elementos repetidos en la lista OJOOO*/


/*Dada 1 2 3 4 5 6
Queda  2 4 6
Dada 1 2 3 4 5 6 7
Queda 1 3 5 7*/
public void EliminarDeUnaForma()
{
   
    EliminarDeUnaFormaAux(L,cant%2==0);
}
private void EliminarDeUnaFormaAux(Nodo P, boolean Do)
{
       if ((Vacia())||(P.getEnlace()==null))
    {
        //nada
    }else{
        EliminarDeUnaFormaAux(P.getEnlace(),!Do);
            if(Do==false)
            {
               P.setEnlace(P.getEnlace().getEnlace());
               cant--;
   
            }else{
                 if (L==P){
                      L=P.getEnlace();  
                      cant--;
                        }
                }    
        }
 
}   
/*Dada 1 2 3 4 5 6 
 Queda 4 5 6 1 2 3*/
public void InvertirMitad()
{
InvertirMitadAux(L,cant);

}
private void InvertirMitadAux(Nodo P,int i)
{
    if ((Vacia())||(P.getEnlace()==null)){
        if (cant>1){
        P.setEnlace(L);
        }
    }else{
        InvertirMitadAux(P.getEnlace(),i-1);
        if (i==((cant/2)+1)){
            L=P.getEnlace();
            P.setEnlace(null);
        }
    }
}


 public void Intercalar() {
     Nodo P = null;
     Nodo Q=null;
    if (this.cant%3==0)
    {P=L; Q=null;}
    if (this.cant%3==1)
    {P=L.getEnlace(); Q=L;}
    if (this.cant%3==2)
    {P=L.getEnlace().getEnlace(); Q=L.getEnlace();}
    
    IntercalarAux(P,Q);
    }
  private void IntercalarAux(Nodo P,Nodo Q) {
      if (P!=null)
      {
      IntercalarAux(P.getEnlace().getEnlace().getEnlace(),P.getEnlace().getEnlace());
      if (Q==null)
      {
          Nodo Oh=null;
        Oh=(P.getEnlace().getEnlace());
        Nodo Aux= P.getEnlace();
        P.setEnlace(Aux.getEnlace().getEnlace());
        Oh.setEnlace(Aux);
        Aux.setEnlace(P);
        L=Oh;
      }else{
        Q.setEnlace(P.getEnlace().getEnlace());
        Nodo Aux= P.getEnlace();
        P.setEnlace(Aux.getEnlace().getEnlace());
        Q.getEnlace().setEnlace(Aux);
        Aux.setEnlace(P);
            }
    }

}
  
public void Intercalar1(){
    
   IntercalarR1(L);
}

private void IntercalarR1(Nodo P){
    if (P == null){
        
    }else if (P.getEnlace()== null){}
    else{
      
       if (L == P){
       Nodo Aux = P.getEnlace();
       P.setEnlace(Aux.getEnlace());
       Aux.setEnlace(P);
       L = Aux;
       }
       else {
           Nodo Aux1 = L;
           while (Aux1.getEnlace() != P){
               Aux1 = Aux1.getEnlace();
           }
           Nodo Aux = P.getEnlace();
           P.setEnlace(Aux.getEnlace());
           Aux.setEnlace(P);
           Aux1.setEnlace(Aux);
           //IntercalarR(P.getEnlace());
       }
       IntercalarR1(P.getEnlace());
    }
}
    
public void Intercalar2(){
    IntercalarR2(L);
}

private void IntercalarR2(Nodo P){
    if (P == null){}
    else if (P.getEnlace() == null){}
    else{
        if ((cant % 2) == 0){
        if (L == P){
       Nodo Aux = P.getEnlace();
       P.setEnlace(Aux.getEnlace());
       Aux.setEnlace(P);
       L = Aux;
       }
       else {
           Nodo Aux1 = L;
           while (Aux1.getEnlace() != P){
               Aux1 = Aux1.getEnlace();
           }
           Nodo Aux = P.getEnlace();
           P.setEnlace(Aux.getEnlace());
           Aux.setEnlace(P);
           Aux1.setEnlace(Aux);
           //IntercalarR(P.getEnlace());
       }
       IntercalarR2(P.getEnlace());    
        }
        else{  // en caso de que sea cantidad impar
            Nodo Aux1 = P.getEnlace();
            Nodo Aux2 = Aux1.getEnlace();
            P.setEnlace(Aux2);
            Aux1.setEnlace(Aux2.getEnlace());
            Aux2.setEnlace(Aux1);
            IntercalarR2(Aux1);
        }
    }
}

public void EliminarIntercalado1(){
    ElimInterR1(L);
}

private void ElimInterR1(Nodo P){
    if (P == null){}
    else if (P.getEnlace() == null){}
    else{
        P.setEnlace(P.getEnlace().getEnlace());
        cant --;
        ElimInterR1(P.getEnlace());
        
    }
}

public void EliminarIntercalado2(){
   
    ElimInterR2(L);
    L = L.getEnlace();
    cant--;
}

private void ElimInterR2(Nodo P){
    if (P == null){}
    else if (P.getEnlace() == null){}
    else{
        if(L == P){
            P = P.getEnlace();
            ElimInterR2(P);
        }
        else{
            P.setEnlace(P.getEnlace().getEnlace());
            cant--;
            ElimInterR2(P.getEnlace());
        }

    }
}

public void EliminarIntercalado3(){
    ElimInterR3(L,cant);
}

private void ElimInterR3(Nodo P, int cantidad){
    if (P == null){}
    else if (P.getEnlace() == null){}
    else{
        ElimInterR3(P.getEnlace().getEnlace(),cantidad);
        if((cantidad%2)==0){
        Nodo ant = L;
        while ((ant.getEnlace()!= P) && (ant.getEnlace() != null)){
            ant = ant.getEnlace();
        }
        if (L != P){
        ant.setEnlace(P.getEnlace());
        cant--;
        }
        }else{
            
            P.setEnlace(P.getEnlace().getEnlace());
            cant--;
        }
    }
}


public void InvertirMitades(){
    InvMit(L);
}

private void InvMit(Nodo P){
    if(P == null){}
    else{
        Nodo aux = L;
        Nodo ant = null;
        for(int i = 1; i<= (cant/2); i++){
                ant = P;
                P = P.getEnlace();
            }
            Nodo ult = L;
            while(ult.getEnlace() != null){
                ult = ult.getEnlace();
            }
        if((cant%2)==1){
            
            L=P.getEnlace();
            ant.setEnlace(ult.getEnlace());
            ult.setEnlace(P);
            P.setEnlace(aux);
            
            
        }
        else{
            L = ant.getEnlace();
            ant.setEnlace(ult.getEnlace());
            ult.setEnlace(aux);
            
        }
    }
}

public void Intercalar3(){
    IntercalarR3(L);
}

private void IntercalarR3(Nodo P){
    if (P == null){}
    else if (P.getEnlace() == null){}
    else if (P.getEnlace().getEnlace() == null){}
    else{ 
        if(P == L){
            Nodo Aux = P.getEnlace().getEnlace();
            L = P.getEnlace();
            P.setEnlace(Aux.getEnlace());
            Aux.setEnlace(P);
        }
        else{
            Nodo aux1 = L;
            Nodo Aux = P.getEnlace().getEnlace();
            while(aux1.getEnlace()!= P){
                aux1 = aux1.getEnlace();
            }
            aux1.setEnlace(P.getEnlace());
            P.setEnlace(Aux.getEnlace());
            Aux.setEnlace(P);
            
        }
        IntercalarR3(P.getEnlace());
    }
}

public void Intercalar4(){
    IntercalarR4(L);
}

private void IntercalarR4(Nodo P){
    if (P == null){}
    else if (P.getEnlace() == null){}
    else if (P.getEnlace().getEnlace() == null){}
    
    else{
        if((cant%3)==0){
            if(P == L){
            Nodo Aux = P.getEnlace().getEnlace();
            L = P.getEnlace();
            P.setEnlace(Aux.getEnlace());
            Aux.setEnlace(P);
        }
        else{
            Nodo aux1 = L;
            Nodo Aux = P.getEnlace().getEnlace();
            while(aux1.getEnlace()!= P){
                aux1 = aux1.getEnlace();
            }
            aux1.setEnlace(P.getEnlace());
            P.setEnlace(Aux.getEnlace());
            Aux.setEnlace(P);
            
        }
        IntercalarR4(P.getEnlace());
        }
        else{
            if((cant%3)==1){
                Nodo Aux1 = P.getEnlace();
                Nodo Aux2 = Aux1.getEnlace().getEnlace();
                P.setEnlace(Aux1.getEnlace());
                Aux1.setEnlace(Aux2.getEnlace());
                Aux2.setEnlace(Aux1);
                IntercalarR4(Aux1);
            }
            else{
                if ((cant%3)==2){
                    Nodo Aux1 = P.getEnlace().getEnlace();
                    Nodo Aux2 = Aux1.getEnlace().getEnlace();
                    Nodo Aux3 = P.getEnlace();
                    Aux3.setEnlace(Aux1.getEnlace());
                    Aux1.setEnlace(Aux2.getEnlace());
                    Aux2.setEnlace(Aux1);
                    IntercalarR4(Aux2);
                }
            }
            
        }
        
                
                
    }
}

public void Intercambiar2(){
    IntercambiarR2(L);
}

private void IntercambiarR2(Nodo P){
    if(P == null){}
    else if(P.getEnlace() == null){}
    else{
        if(L == P){
            L = P.getEnlace();
            P.setEnlace(L.getEnlace());
            L.setEnlace(P);
        }
        else{
            Nodo aux = L;
            while(aux.getEnlace()!=P){
                aux = aux.getEnlace();
            }
            aux.setEnlace(P.getEnlace());
            aux = P.getEnlace();
            P.setEnlace(aux.getEnlace());
            aux.setEnlace(P);
        }
        if(P.getEnlace()!= null){
        IntercambiarR2(P.getEnlace().getEnlace());
        }
    }
}

public void IntercambiarFinal(){
    InterFinalR(L);
}

private void InterFinalR(Nodo P){
    if (P == null){}
    else if ((P.getEnlace() == null) && (cant == 1)){}
    else{
        if (P.getEnlace() == null){
            Nodo ant = L;
            while (ant.getEnlace() != P){
                ant = ant.getEnlace();
            }
            Nodo aux = L;
            
            P.setEnlace(aux.getEnlace());
            aux.setEnlace(null);
            ant.setEnlace(aux);
            L = P;
            P = aux;
        }
        InterFinalR(P.getEnlace());
    }
}

public void InsertarMedio(int dato){
    InsertMedioR(L,dato);
}

private void InsertMedioR(Nodo P, int dato){
    Nodo x = new Nodo(dato);
    if (P == null){
        L = x;
        cant++;
    }
    else if(P.getEnlace() == null){
        P.setEnlace(x);
        cant++;
    }
    else{
        int i = ((cant+1)/2)-1;
        while (i>0){
            P = P.getEnlace();
            i--;
        }
        Nodo aux = P.getEnlace();
        P.setEnlace(x);
        x.setEnlace(aux);
        cant++;
    }
}
public void insertar1(int valor){
    Nodo nuevo=new Nodo();
    nuevo.setData(valor);
    if (Vacia()){
        L=nuevo;
    }else{
        Nodo aux=L;
        while (aux.getEnlace()!=null){
            aux=aux.getEnlace();
        }
        aux.setEnlace(nuevo);
    }
    cant++;
}
public void Repetidos ()
{
   RepetidosR(L, false); 
}
private void RepetidosR(Nodo P, boolean sw){
    if(P == null){}
    else if(P.getEnlace() == null){
        if(sw == true){
            Nodo ant = L;
            while(ant.getEnlace()!=P){
                ant = ant.getEnlace();
            }
            ant.setEnlace(P.getEnlace());
            cant--;
        }   
    }
    else{
        if(L == P){
            Nodo aux = P.getEnlace();
            if(P.getData() == aux.getData()){
                L = L.getEnlace();
                cant--;
                sw = true;
            }
            else if(sw == true){
                L = L.getEnlace();
                cant--;
                sw = false;
            }
        }
        else{
            Nodo aux = P.getEnlace();
            Nodo ant = L;
                while(ant.getEnlace()!=P){
                    ant = ant.getEnlace();
                }                
            if(P.getData() == aux.getData()){
                
                ant.setEnlace(aux.getEnlace());
                cant = cant - 2;
                P = P.getEnlace();
                sw = false;
                if((ant.getEnlace()!= null)&&(aux.getData()==aux.getEnlace().getData())){
                sw = true;
                }
            }
            else{
                if (sw == true){
                    ant.setEnlace(aux);
                    cant--;
                    sw = false;
                }
            }
            }
        RepetidosR(P.getEnlace(),sw);
        }   
    }
}

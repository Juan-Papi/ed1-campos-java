/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listas;

/**
 *
 * @author hogar2013
 */
public class ListaDoble {
            NodoD P;
            NodoD U;
            int cant;
    
    public ListaDoble(){
    P=null;
    U=null;
    cant=0;
    }
    
    public boolean Vacia(){
     return ((P==null) && (U==null));
    }
    /*---------------INSERTAR AL PRINCIPIO (P)-------------------*/
    private void InsertarP(int Ele){
        NodoD r = new NodoD (Ele);
        r.setEnlaceD(P);
        P.setEnlaceI(r);
        P=r;
        cant++;
    }
     /*---------------INSERTAR AL ULTIMO (U)-------------------*/
    private void InsertarU(int Ele){
        NodoD r= new NodoD (Ele);
        r.setEnlaceI(U);
        U.setEnlaceD(r);
        U=r;
        cant++;
    }
    
    public void Insertar (int Ele)
    {
        if (Vacia()){
        NodoD r= new NodoD(Ele);
        P=r;
        U=r;
        cant++;
        }else{  NodoD pos=P;
                while((pos!=null)&&(pos.getData()<Ele))
                {
                    pos=pos.getEnlaceD();
                }
                if (pos==null)      /*Insertar Ultima posicion*/
                {
                    InsertarU(Ele);
                }else{  
                        if (pos.getData()!=Ele) 
                        {   
                            if (pos==P)     /*Insertar al principio*/
                            {
                                InsertarP(Ele);
                            }else{  /*Insertar al medio*/
                                    NodoD r=new NodoD(Ele);
                                    r.setEnlaceI(pos.getEnlaceI());
                                    r.setEnlaceD(pos);
                                    pos.setEnlaceI(r);
                                    r.getEnlaceI().setEnlaceD(r);
                                    cant++;
                                 }
                        }
                     }
             }

    }
    
public void Eliminar (int Ele)
{
    if (Vacia())
    {
    //nada
    }else{
            if ((P==U) && (P.getData()==Ele)) /*Elimina el unico elemento existente*/
            {
                P=null;
                U=null;
                cant--;
            }else{ /*Hay varios Elementos*/
                    NodoD Aux=P;
                    while ((Aux!=null)&&(Aux.getData()!=Ele))
                    {
                        Aux=Aux.getEnlaceD();
                    }
                    if (Aux!=null)
                    {   if (Aux==P) /*Eliminar el primer elemento*/
                        {
                            P=P.getEnlaceD();
                            P.setEnlaceI(null);
                        }else{  
                                if(Aux==U)/*Eliminar el ultimo elemento*/
                                {
                                    U=U.getEnlaceI();
                                    U.setEnlaceD(null);
                                }else{  /*Elimina elemento del medio*/
                                        Aux.getEnlaceI().setEnlaceD(Aux.getEnlaceD());
                                        Aux.getEnlaceD().setEnlaceI(Aux.getEnlaceI());
                                     }
                             }
                    cant--;
                    }
                 }
         }
}

    @Override
    public String toString() {
        String S="";
        S=S+P.getData();
        NodoD r=P.getEnlaceD();
        
        for (int i = 1; i < cant; i++) {
            S=S+" "+r.getData();
            r=r.getEnlaceD();
        }
       return (S);
    }

/*Recursivos */
public void EliminarRecursivo (int Ele)
{
    EliminarRecursivoAux(P,Ele);
}
private void EliminarRecursivoAux(NodoD L,int Ele)
{
    if (L==null)
    {
    //nada
    }else{
            if ((L==P)&&(L==U)&&(L.getData()==Ele))
            {
                P=null;
                U=null;
                cant--;
            }else{ /*Caso General*/
                    EliminarRecursivoAux(L.getEnlaceD(),Ele);
                    if (L.getData()==Ele)
                    { 
                        if(L==P)
                        {
                          P=P.getEnlaceD();
                          P.setEnlaceI(null);
                        }else{
                                if (L==U)
                                {
                                    U=U.getEnlaceI();
                                    U.setEnlaceD(null);
                                }else{
                                        L.getEnlaceD().setEnlaceI(L.getEnlaceI());
                                        L.getEnlaceI().setEnlaceD(L.getEnlaceD());
                                     }
                             }
                        
                     cant--;   
                    }
                 }
         }
}
    
/*Invertir Lista Doble */
public void Invertir ()
{
    InvertirAux(P);
}
private void InvertirAux(NodoD r)
{
    if (r==null) //Caso base si es vacio
    {
        //nada
    }else{ //Caso base si tiene un elemento, y tambien caso general 
            if (r.getEnlaceD()==null)
            {
                P=r;
                NodoD Aux=r.getEnlaceD();
                r.setEnlaceD(r.getEnlaceI());
                r.setEnlaceI(Aux);
            }else{//Caso general
                    InvertirAux(r.getEnlaceD());
                    
                    NodoD Aux=r.getEnlaceI();
                    r.setEnlaceI(r.getEnlaceD());
                    r.setEnlaceD(Aux);
                   
                    if(Aux==null)
                    {
                        U=r;
                    }
                 }
         }
}
public void InvertirDeDosEnDos()
{   
    NodoD L = null;
    if(cant%2==0)
    {
       L=P;
    }else{  
            if (cant%2==1)
            {
               L=P.getEnlaceD();
            }
         }
    InvertirDeDosEnDosAux(L);
}

private void InvertirDeDosEnDosAux(NodoD L)
{
    if (L!=null)
    {
        InvertirDeDosEnDosAux(L.getEnlaceD().getEnlaceD());
        if(L.getEnlaceD().getEnlaceD()==null && L.getEnlaceI()!=null)
        {
            L.setEnlaceD(L.getEnlaceD().getEnlaceD());
            L.getEnlaceI().setEnlaceD(U);
            U.setEnlaceI(L.getEnlaceI());
            U.setEnlaceD(L);
            L.setEnlaceI(U);
            U=L;
        }else{
                if((L.getEnlaceD().getEnlaceD()!=null) && (L.getEnlaceI()!=null))
                {
                    L.setEnlaceD(L.getEnlaceD().getEnlaceD());
                    L.getEnlaceD().getEnlaceI().setEnlaceI(L.getEnlaceI());
                    L.getEnlaceI().setEnlaceD(L.getEnlaceD().getEnlaceI());
                    L.setEnlaceI(L.getEnlaceD().getEnlaceI());
                    L.getEnlaceI().setEnlaceD(L);
                    L.getEnlaceD().setEnlaceI(L);
                }else{
                        if ((L.getEnlaceD().getEnlaceD()!=null) && (L.getEnlaceI()==null))
                        {
                            P=L.getEnlaceD();
                            L.setEnlaceD(P.getEnlaceD());
                            L.getEnlaceD().setEnlaceI(L);
                            P.setEnlaceD(L);
                            P.setEnlaceI(null);
                            L.setEnlaceI(P);
                        }else{
                                if ((L.getEnlaceD().getEnlaceD()==null)&&(L.getEnlaceI()==null))
                                {
                                    L.setEnlaceD(L.getEnlaceD().getEnlaceD());
                                    U.setEnlaceI(L.getEnlaceI());
                                    L.setEnlaceI(U);
                                    U.setEnlaceD(L);
                                    P=U;
                                    U=L;
                                }
                             }
                     }
             }
    }
}

public void Desplazar ()
{
    if (Vacia()){
    //Nada    
    }else{ 
        NodoD r =P;
        //while 
            while(r!=null)//cc
                           {  
            if (r.getEnlaceD()==null)
            {
                r=r.getEnlaceD();
            }else{
                    if (r.getEnlaceD().getEnlaceD()==null)
                    {
                      r=r.getEnlaceD().getEnlaceD();
                    }else{ 
                            if((r.getEnlaceD().getEnlaceD()==U)&&(r.getEnlaceI()==null))
                            {
                                P=r.getEnlaceD();
                                r.setEnlaceD(r.getEnlaceD().getEnlaceD().getEnlaceD());
                                U=r;
                                P.setEnlaceI(null);
                                P.getEnlaceD().setEnlaceD(U);
                                U.setEnlaceI(P.getEnlaceD());
                            }else{
                                    if ((r.getEnlaceD().getEnlaceD().getEnlaceD()!=null)&&(r.getEnlaceI()==null))
                                    {
                                     P=r.getEnlaceD();
                                     r.setEnlaceD(P.getEnlaceD().getEnlaceD());
                                     r.getEnlaceD().setEnlaceI(r);
                                     P.setEnlaceI(null);
            
                                     P.getEnlaceD().setEnlaceD(r);
                                     r.setEnlaceI(P.getEnlaceD());   
                                     
                                     
                                     r=r.getEnlaceD();
                                    }else{
                                            if((r.getEnlaceD().getEnlaceD().getEnlaceD()!=null)&&(r.getEnlaceI()!=null))
                                            {
                                                NodoD aux0=r;
                                                r=r.getEnlaceD();
                                                
                                                aux0.getEnlaceI().setEnlaceD(r);
                                                r.setEnlaceI(aux0.getEnlaceI());
                                                aux0.setEnlaceD(r.getEnlaceD().getEnlaceD());
                                                aux0.setEnlaceI(r.getEnlaceD());
                                                r.getEnlaceD().getEnlaceD().setEnlaceI(aux0);
                                                r.getEnlaceD().setEnlaceD(aux0);
                                                
                                               r= r.getEnlaceD().getEnlaceD().getEnlaceD();
                                            }else{
                                                    if((r.getEnlaceD().getEnlaceD()==U)&&(r.getEnlaceI()!=null))
                                                    {
                                                        U=r;
                                                        r=r.getEnlaceD();
                                                        U.setEnlaceD(r.getEnlaceD().getEnlaceD());
                                                        r.setEnlaceI(U.getEnlaceI());
                                                        U.getEnlaceI().setEnlaceD(r);
                                                        r.getEnlaceD().setEnlaceD(U);
                                                        U.setEnlaceI(r.getEnlaceD());
                                                        
                                                 r=       r.getEnlaceD().getEnlaceD();
                                                    
                                                    }
                                                 }
                                         }
                                 }
                          
                           
                         }
                   
                 }
            }//whiles    
         }
    
    
}




}

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
public class Lista {

            Nodo lista;
            int cant;
    
    public Lista()
    {
        lista = null;
        cant = 0;
    }
    public boolean vacia(){
        return (lista==null || (cant==0));
    }
    public void insertar(int x)
    {
        Nodo f = lista, i = null;
        while ((f != null)&&(f.getDato() < x))
        {
            i = f;
            f = f.getEnlace();
        }
        Nodo n = new Nodo(x);
        n.setEnlace(f);
        try{
            if (x != f.getDato())
            {
                if (i == null)
                    lista = n;
                else
                    i.setEnlace(n);
                cant++;
            }
        }catch(Exception e)
        {
            if (lista == null)
                lista = n;
            else
                i.setEnlace(n);
            cant++;
        }
    }
    
    public void eliminar(int x)
    {
        Nodo f = lista, i = null;
        while ((f != null)&&(f.getDato() != x))
        {
            i = f;
            f = f.getEnlace();
        }
        if (f != null)
            f = f.getEnlace();
        if (i == null)
            lista = f;
        else
            i.setEnlace(f);
        cant--;
    }
    
    public int sacar(int pos)
    {
        if ((pos <= cant)&&(pos > 0))
        {
            Nodo f = lista;
            while ((pos != 0))
            {
                pos--;
                f = f.getEnlace();
            }
            return f.getDato();
        }
        System.out.println("La posicion esta fuera de rango");
        return 0;
    }
    public void invertirlo(){
        if(vacia()||(lista.getEnlace()==null)){            
        }else{
            Nodo ant=null;
            Nodo aux=lista;
            Nodo pos=lista.getEnlace();
            while (pos!=null) {                
                aux.setEnlace(ant);
                ant=aux;
                aux=pos;
                pos=pos.getEnlace();                
            }
            aux.setEnlace(ant);
            lista=aux;                   
        }
    }
    public void invertir()
    {
        if (!vacia())
        {
            Nodo a = null;
            Nodo b = lista;
            Nodo c = b.getEnlace();
            while (c != null)
            {
                b.setEnlace(a);
                a = b;
                b = c;
                c = c.getEnlace();
            }
            b.setEnlace(a);
            lista = b;
        }else
            System.out.println("Lista vacia");
    }
    public boolean existe(int ele){
        if(vacia()){
            return false;
        }else{
            Nodo aux=lista;
            while ((aux!=null)&&(ele!=aux.getDato())) {                
                aux=aux.getEnlace();
            }
            return (aux!=null);
        }
        
    }
    
    //Metodos recursivos
    //para hacer metodos recursivos se necesita o requiere un metodo recursivo publico y otro privado
    public boolean existeR(int ele){
        return existeRR(lista, ele);
    }
    private boolean existeRR(Nodo P,int ele){
        if(P==null){
            return false;
        }else{
            if(P.getDato()==ele){
                return true;
            }else{
                boolean x=existeRR(P.getEnlace(), ele);
                return x;
            }
        }
    }      
    public void invertirR(){
        invertirRR(lista);
    }
    public void invertirRR(Nodo P){
        if(P==null){            
        }
        if(P.getEnlace()==null){
            lista=P;
        }else{
            invertirRR(P.getEnlace());
            P.getEnlace().setEnlace(P);
            P.setEnlace(null);
             
        }
       
    } 
    
    @Override
    public String toString()
    {
        String s = "";
        Nodo p = lista;
        while (p != null)
        {
            s = s + "   " + p.getDato();
            p = p.getEnlace();
        }
        return s;
    }
           
    public static void main(String[] args) {
        Lista l = new Lista();
        l.insertar(1);
        l.insertar(2);
        l.insertar(3);
        l.insertar(4);
        System.out.println(l.toString());
        l.invertirR();
        System.out.println(l.toString());
        System.out.println(l.existeR(4));
    }
}
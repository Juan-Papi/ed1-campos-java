
package lista;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */

public class Lista {
            Nodo lista;
            int cant;
    public Lista()
    {
        lista = null;
        cant = 0;
    }
    
    public void insertar(int x)
    {
        Nodo f = lista, i = null;
        while ((f != null)&&(f.getDato() < x))
        {   i = f;
            f = f.getEnlace();
        }
        Nodo n = new Nodo(x);
        n.setEnlace(f);
        try{ if (x != f.getDato())
            {   if (i == null)
                    lista = n;
                else
                    i.setEnlace(n);
                cant++;
            }
        }catch(Exception e)
        {   if (lista == null)
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
    
    
    public void invertir()
    {   if (lista != null)
        {
            Nodo a = null;
            Nodo b = lista;
            Nodo c = b.getEnlace();
            while (c != null)
            {   b.setEnlace(a);
                a = b;
                b = c;
                c = c.getEnlace();
            }
            b.setEnlace(a);
            lista = b;
        }else
            System.out.println("Lista vacia");
    }
    
    
    
    
    public void PermutarRec(Nodo ant){
     if((ant==null)||(ant.getEnlace()==null)||(ant.getEnlace().getEnlace()==null)){
         //nada
         
     }
     else{
//         if((ant.getEnlace().getEnlace().getEnlace()==null))
//         {
         ant=ant.getEnlace().getEnlace();
//        ant.getEnlace().getEnlace().setEnlace(ant.getEnlace());
//        ant.getEnlace().setEnlace(ant);
//        ant=ant.getEnlace().getEnlace().getEnlace();
//         }
//         
//         
//         else{
        ant.getEnlace().getEnlace().setEnlace(ant.getEnlace());
        ant.getEnlace().setEnlace(ant);
                 ant=ant.getEnlace().getEnlace().getEnlace();
                 lista=ant;
//         }
//        if((ant!=null))
//        {   
//            if((ant.getEnlace()!=null))
//                if(ant.getEnlace().getEnlace()!=null)
//                {
//                PermutarRec(ant.getEnlace().getEnlace());  
//                 }
//        }
             PermutarRec(ant);
//          }
       }
    }
    public void Permutar(){
         PermutarRec(lista);
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
//        l.insertar(4);
   l.Permutar();
        System.out.println(l.toString());
    
    
    }
}

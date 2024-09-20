
package ListaP;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class ListaP {
            NodoP l;
            NodoP u;
            int cant;
            
      public ListaP()
      {
          l = u = null;
          cant = 0;
      }
       //═══════════════════ ADICIONAR RECURSIVO ═══════════════════════════════════════════════════════════════════════════════   
      public void add(int x, int y)
      {
          add(u,l,x,y);
      }
     
      private void add(NodoP a, NodoP b, int x, int y)
      {
          if (l != null)
          if (b.getEnlace() != l)
          {
              if ((b.getX()!= x)||(b.getY() != y))
              if ((b.getX()<x) || (((b.getX()==x)&&(b.getY()<y))))
              {
                  a = b;
                  b = b.getEnlace();
                  add(a,b,x,y);
                  cant--;
              }else
              {
                  NodoP aux = new NodoP(x,y);
                  a.setEnlace(aux);
                  aux.setEnlace(b);
                  if (a == u)
                      l = aux;
              }
              else
                  cant--;
          }else
          {
              NodoP aux = new NodoP(x,y);
              if (b.getX()< x)
              {
                  if (cant < 2)
                  {
                      a.setEnlace(aux);
                      aux.setEnlace(b);
                  }else
                  {
                      b.setEnlace(aux);
                      aux.setEnlace(l);
                  }
                  u = aux;
              }else
              {
                  if (b.getY()!= y)
                  {
                     a.setEnlace(aux);
                     aux.setEnlace(b);
                  }else
                      cant--;
              }
          }
          else
          {
              NodoP aux = new NodoP(x,y);
              l = u = aux;
              aux.setEnlace(aux);
          }
          cant++;
      }
      //═══════════════════ ELIMINAR ═══════════════════════════════════════════════════════════════════════════════    
      public void eliminar()
      {
          NodoP a = u;
          NodoP p = l;
          int cont = cant;
          while (cont > 0)
          {
              if (cantRepet(p)==1)
                  eliminar(a,p);
              a = p;
              p = p.getEnlace();
              cont--;
          }
      }
  //═══════════════════ CANTIDAD REPETIDO NODO ═══════════════════════════════════════════════════════════════════════════════        
      public int cantRepet(NodoP p)
      {
          int can = 0;
          NodoP a = l;
          int cont = cant;
          while (cont > 0)
          {
              if ((a.getX() == p.getX())||(a.getY() == p.getY()))                  
                  can++;
              a = a.getEnlace();
              cont--;
          }
          return can;
      }
  //═══════════════════ ELIMINAR NODO ═══════════════════════════════════════════════════════════════════════════════        
      public void eliminar(NodoP a, NodoP b)
      {
          a.setEnlace(b.getEnlace());
          if (a == u)
          {
              l = b.getEnlace();
          }else
              if (b == u)
              {
                  u = a;
              }
          cant--;
      }
      
      public String toString()
      {
          String s = "";
          NodoP p = l;
          int cont = cant;
          while (cont > 0)
          {
              s = s  + ", ("+p.getX() +","+ p.getY()+")" ;
              p = p.getEnlace();
              cont--;
          }
          return s;
      }
//══════════════════════════════ MAIN ═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

      public static void main(String[] args)
      {
          ListaP l = new ListaP();
          l.add(0, 0);
          l.add(2, 3);
          l.add(3, 9);
          l.add(2, 1);
          l.add(2, 5);
          l.add(2, 6);
          l.add(1, 1);
          l.add(2, 4);
          l.eliminar();
          System.out.println(l.toString());
      }
}

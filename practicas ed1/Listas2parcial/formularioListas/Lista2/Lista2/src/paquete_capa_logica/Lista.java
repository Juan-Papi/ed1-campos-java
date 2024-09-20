
package paquete_capa_logica;

/**
 *
 * @author Reynaldo
 */
public class Lista {
    Nodo L;
    public int dim;
  
    public Lista(){
      this.L=null;
      this.dim=0;
    }
    public boolean Vacia(){
      if((dim==0)||(L==null))
          return true;
      return false;
      
    }
    public void Insertar(int ele){
      if(Vacia()){
        Nodo p=new Nodo();
        p.setDato(ele);
        L=p;
        dim++;
      }else{
        Nodo aux=L;
        Nodo ant=null;
          while ((aux!=null)&&(aux.getDato()<=ele)) {              
              ant=aux;
              aux=aux.getEnlace();
          }
          if(ant==null){
            Nodo p=new Nodo();
            p.setDato(ele);
            p.setEnlace(L);
            L=p;
            dim++;
          }else{
            if(ant.getDato()!=ele){
              Nodo p=new Nodo();
              p.setDato(ele);
              ant.setEnlace(p);
              p.setEnlace(aux);
              dim++;
            }
          }
      }
    }
    public void Eliminar(int ele){
      if(!Vacia()){
        Nodo aux=L;
        Nodo ant=null;
          while ((aux!=null)&&(aux.getDato()!=ele)) {              
              ant=aux;
              aux=aux.getEnlace();
          }
          if(ant==null){
            L=aux.getEnlace();
            dim--;
          }else{
            if(aux!=null){
              ant.setEnlace(aux.getEnlace());
              dim--;
            }
          }
      }
    }
    public int sacar(int pos){
      Nodo aux=L;
      int i=1;
        while (i<pos) {            
            aux=aux.getEnlace();
            i++;
        }
        return (aux.getDato());
    }
    @Override
    public String toString(){
      String s="";
      Nodo aux=L;
        while (aux!=null) {            
            s=s+"["+aux.getDato()+"]->";
            aux=aux.getEnlace();
        }
        return s+"null";
    }
    public boolean Buscar(int ele){
       Nodo aux=L;
        while ((aux!=null)&&(aux.getDato()!=ele)) {            
            aux=aux.getEnlace();
        }
        return (aux!=null);
    }
    
    //recursivo
    
    
    public boolean _Buscar(int ele){
      return (_BuscarR(ele,L));
    }
    private boolean _BuscarR(int ele,Nodo p){
      if(p==null){
        return false;
      }else{
        boolean x=_BuscarR(ele, p.getEnlace());
        if(!x){
          if(p.getDato()==ele){
            x=true;
          }else{
            x=false;
          }
        }
        return x;
      }
    }
    
    
    
    public boolean __Buscar(int ele){
      return (_BuscarRM(ele, L));
    }
    private boolean _BuscarRM(int ele,Nodo p){
      if(p==null){
        return false;
      }else{
        if(p.getDato()==ele)
            return true;
        boolean x=_BuscarRM(ele, p.getEnlace());
        return x;
      }
    }
    public void invertir(){
       if(dim>=2){
           Nodo ant=null;
           Nodo aux=L;
           Nodo post=L.getEnlace();
           while(post!=null){
              aux.setEnlace(ant);
              ant=aux;
              aux=post;
              post=post.getEnlace();
           }
           aux.setEnlace(ant);
           L=aux;
       }
    }
    
    
    
    
    public void _invertirR(){
        invertirR(L);
    }
    private void invertirR(Nodo p){
       if(p==null){
       
       }else{
          if(p.getEnlace()==null){
            L=p;
          }else{
              invertirR(p.getEnlace());
              p.getEnlace().setEnlace(p);
              p.setEnlace(null);
          }
       }
    }
    
    
    
    public void setEliminarR(int ele){
        EliminarR(ele, L,null);
    }
    private void EliminarR(int ele,Nodo p,Nodo ant){
       if(p==null){
          
       }else{
          if((ant==null)&&(p.getEnlace()==null)&&(p.getDato()==ele)){
            L=null;
            dim--;
          }else{
              if((ant!=null)&&(p.getDato()==ele)){
                  ant.setEnlace(null);
              }
              Nodo aux=p;
                if((aux!=null)&&(aux.getDato()!=ele)){
                    ant=aux;
                    EliminarR(ele, p.getEnlace(),ant);
                }else{
                   if((ant==null)&&(aux.getDato()==ele)){
                      L=aux.getEnlace();
                      dim--;
                   }else{
                       if((ant!=null)&&(aux.getDato()==ele)){
                         ant.setEnlace(aux.getEnlace());
                         dim--;
                       }
                   }
                }
              }
          }
       }
    
    
    
    public void setInsertarR(int ele){
        InsertarR(ele, L,null);
    }
    private void InsertarR(int ele,Nodo p,Nodo ant){
       if(p==null){
          Nodo q=new Nodo();
          q.setDato(ele);
          L=q;
          dim++;
       }else{
           Nodo aux=p;
          if((aux.getDato()<ele)&&(aux.getEnlace()!=null)){
            ant=aux;
            InsertarR(ele, p.getEnlace(), ant);
          }
          if((ant==null)&&(ele<aux.getDato())){
             Nodo q=new Nodo();
             q.setDato(ele);
             q.setEnlace(aux);
             L=q;
             dim++;
          }else{
             if(aux.getDato()>ele){
                 Nodo q=new Nodo();
                 q.setDato(ele);
                 ant.setEnlace(q);
                 q.setEnlace(aux);
                 dim++;
             }else{
                if((aux.getEnlace()==null)&&(aux.getDato()!=ele)){
                   Nodo q=new Nodo();
                   q.setDato(ele);
                   aux.setEnlace(q);
                   dim++;
                }
             }
          }
          
       }
    }
    
    
    
    public int getSacar(int pos){
        return SacarR(pos, L, 0);
    }
    private int SacarR(int pos,Nodo p,int cont){
     int x=0;
      if((p==null)){
       
      }else{
        Nodo aux=p;
        cont++;
        if((aux!=null)&&(cont!=pos)){
           x=SacarR(pos, p.getEnlace(), cont);
        }
           if(cont==pos){
             x=aux.getDato();
           }
        }
        
        return x;
    }
}
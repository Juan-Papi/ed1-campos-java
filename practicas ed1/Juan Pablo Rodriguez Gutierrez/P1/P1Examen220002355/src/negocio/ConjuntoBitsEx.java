/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author 59178
 */
public class ConjuntoBitsEx {
 //Atributos
    VectorBitsG C;
    String bSigno[];
    int dim;
    
  //Constructor
    public ConjuntoBitsEx(int cant){
        C=new VectorBitsG(cant,16);
        bSigno=new String[cant];
        this.dim=0;
    }
   
    public void insertar(int ele){
        if(dim!=bSigno.length){
        if(!pertenece(ele)){
        if(ele<0){
            bSigno[dim]="true";//Se pone true cuando el numero es negativo
            ele=ele*(-1);
        }
        else{
            bSigno[dim]="false";
        }
        
        
        this.dim++;
        C.insertar(ele,dim );}
        }
        
    }
    public String getElem(int pos){
        int ele;
        ele=C.Get(pos);
        if(bSigno[pos-1]=="true"){ 
           ele=ele*(-1);
        }
        String elem=String.valueOf(ele);
       return elem;
        
    }
     public boolean pertenece(int ele){
        boolean b=false;
        int elem;
        for (int i =1; i <=this.dim; i++) {
              elem=Integer.parseInt(getElem(i));
            if(elem==ele){
                b=true;//Si pertenece
            }
        }
        return b;
    }
    public String MostrarElemento(int pos){
        String cad="";
        cad=cad+getElem(pos);
        return cad;
    }
    public String toString(){
       String cad="<< ";
        for (int i = 1; i <=this.dim; i++) {
           cad=cad+MostrarElemento(i)+", ";
            
        }
        cad=cad+">>";
        return cad;
    }
    public static void main(String[] args) {
        ConjuntoBitsEx A=new ConjuntoBitsEx(10);
        A.insertar(25); 
        A.insertar(-25);
        A.insertar(25);
        A.insertar(-25);
       
        System.out.println(A);
    }
     
    
}

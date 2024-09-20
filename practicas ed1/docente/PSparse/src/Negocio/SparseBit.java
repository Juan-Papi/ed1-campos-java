/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Mario Campos
 */
public class SparseBit {VectorbitsGe VFC;  // vector de Fila y Columna
                        float VD[]; // vector de datos
                        int dim;
                        int Nfilas; // numero de filas
                        int Ncol;  //numero de columnas
                        float EP; // elemento predominante

    public SparseBit(int Nfilas, int Ncol, float EP) {
        int x=calcularbits(Nfilas*Ncol);
        this.VFC = new VectorbitsGe(10,x);
        this.VD = new float [10];
        this.dim = -1;
        this.Nfilas = Nfilas;
        this.Ncol = Ncol;
        this.EP = EP;
    }
    public boolean vacia(){
    return (dim==-1);
    };                  
    
    private int calcularbits(int cant){
    int i=1;
    while(Math.pow(2, i)<=cant)
        i++;
     return(i);   
    }
    
    public void Set(int fila, int col, float dato){
    if ((fila>Nfilas)||(col>Ncol)){
     System.out.println("Error::Set:Fila y Columna fuera de rango");
     System.exit(1);
     }
    else {
            int FC=(fila-1)*Ncol+col;
        
            if (vacia()){
                if (dato !=EP){
                dim++;
                VD[dim]=dato;
                VFC.Insertar(FC, dim+1);
                }
            }
            else{ int x=buscarFC(fila,col);
                  if (x==-1){
                   redimencionar();
                   dim++;
                   VD[dim]=dato;
                   VFC.Insertar(FC, dim+1);
              
                  }
                  else{  if (dato!=EP){
                            VD[x]=dato;
                           }
                        else{
                           for (int i = x; i < dim; i++) {
                               VFC.Insertar( VFC.Get(i+2), i+1);
                               VD[i]=VD[i+1];
                               }
                           dim--;
                          }

                  }
            
            }
    
    }
    
    }
    
   private int buscarFC(int fila, int col){
    int FC=(fila-1)*Ncol+col;  
   int i=0;
   while ((i<=dim)&&VFC.Get(i+1)!=FC){
    i++;
   }
   if (i<=dim)
       return(i);
   else
       return(-1);
   
   }
   
  private void redimencionar(){
   //if (dim==VFC.length-1){
     //int VFC1[];
    // float VD1[];
    // VD1=new float [VD.length];
   // VFC1=new int[VFC.length];
  //   System.arraycopy(VD, 0, VD1,0,VD.length);
  //   System.arraycopy(VFC, 0, VFC1,0,VFC.length);
   //  VD=new float[VD1.length+5];
   //  VFC=new int[VFC1.length+5];
    // System.arraycopy(VD1, 0, VD,0,VD.length);
   //  System.arraycopy(VFC1, 0, VFC,0,VFC.length);
   //}
  
  }
  
  public float Get(int fila, int col){
  int x=buscarFC(fila,col);
  if (x!=-1){
   return(VD[x]);
  }
  else
      return (EP);
  
  }

    @Override
    public String toString() {
       String S=" M= [ ";
       S=S+'\n';
        for (int i = 1; i <= Nfilas; i++) {
            for (int j = 1; j <=Ncol; j++) {
                S=S+Get(i,j)+"  ,  ";
            }
            S=S+'\n';
                     
        }
        S=S+" ] ";
        return (S);
    }
    
}

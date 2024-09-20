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
//SOLO PRÁCTICA
public class Polinomio {

    //Atributos
    monomio P[];
    int dim;

    //Constructor
    public Polinomio() {
        this.P = new monomio[10];
        dim = -1;//Representa 0 elementos
    }

    //
    //Inserta un monomio en el polinomio
    /*public void setM(monomio M) {
        if (this.dim==-1) {
            this.P[dim+1]=M;
            dim++;
        }
        if (this.P[dim].exp>M.exp) {
            P[dim+1]=M;
            dim++;
            
        } else {
            for (int i = 0; i <= this.dim; i++) {
                if ((this.P[i].exp>M.exp)&&(this.P[i+1].exp<M.exp)) {
                    for (int j = this.dim; j>=i+1; j--) {
                        P[j+1]=P[j];
                        
                    }
                    P[i+1]=M;
                    dim++;
                } else {
                    if(this.P[0].exp<M.exp){
                        for (int j =this.dim; j>=0; j--) {
                            P[j+1]=P[j];
                            
                        }
                        P[0]=M;
                        dim++;
                    }
                    else{
                        for (int j = 0; j <=this.dim; j++) {
                           //if(P[j].exp=M.exp){
                               //this.P[j]=sumarP(this.P[j],M);
                           }
                            
                        }
                    }
                }
                
            }
        }
     */
//Devuelve el monomio de exponente exp
    public void Insertar(monomio M) {
        if (vacia()) {
            dim++;
            this.P[dim] = M;

        } else {
            redimencionar();
            int i = 0;//0 1 2
            while ((i <= this.dim) && (this.P[i].getExp() > M.exp)) {
                i++;
            }
            if (i > this.dim) {
                dim++;
                this.P[dim] = M;
            } else {
                if (this.P[i].getExp() != M.exp) {
                    for (int j = dim; j >= i; j--) {
                        this.P[j + 1] = P[j];
                    }
                    this.P[i] = M;
                    dim++;
                } else {
                    int suma = this.P[i].coef + M.coef;
                    if (suma == 0) {
                        for (int j = i; j < dim; j++) {
                            this.P[j] = P[j + 1];

                        }
                        dim--;
                    }else{

                    this.P[i].coef = suma;
                    }
                }

            }

        }
    }

    boolean vacia() {
        return (this.dim == -1);
    }

    public void redimencionar() {
        if(dim==P.length-1){
        monomio q[] = new monomio[P.length];
        System.arraycopy(P, P.length, q, 0, P.length);
        P = new monomio[q.length + 5];
        System.arraycopy(q, q.length, P, 0, q.length);}

    }

    //Devuelve el monomio de exponente exp
    public monomio getM(int exp) {//exponente del monomio a obtener
        int i = 0;
        while (this.P[i].exp != exp) {
            i++;
        }
        return P[i];

    }

    //Devuelve la dimension del polinomio
    public int getDim() {
        return this.dim;
    }
    public void eliminar(int exp){
        int i=0;
        while(i<=this.dim && exp!=this.P[i].exp){
             i++;
            
        }
        if(i<this.dim){
        for (int j = i; j<this.dim; j++) {
            this.P[i]=this.P[i+1];
            
        }
        dim--;
        }else{
            if(i==dim){
                this.P[i]=null;
            }
            dim--;
                
        }
        
    }

    /*  //Verifica si el monomio de exponente exp pertenece al polinomio
    public int pertenece(int exp) {
        int i = 0;
        boolean b = false;
        while (i <= this.dim && !b) {
            if (this.P[i].exp == exp) {
                b = true;
            }
            i++;
        }
        if (b) {
            i = i - 1;//posicion donde esta el monomio
        } else {
            i = -1;//significa que el monomio no se encuentra
        }
        return i;

    }

    //Elimina un monomio del polinomio
    public void eliminarM(int exp) {
        for (int i = 0; i <= this.dim; i++) {
            if (this.P[i].exp == exp) {
                for (int j = i; j < this.dim; j++) {
                    this.P[i] = this.P[i + 1];

                }
                dim--;
            }

        }

    }*/
    public void sumarPolinomios(Polinomio A, Polinomio B) {
        for (int i = 0; i <= A.dim; i++) {
            this.Insertar(A.P[i]);

        }
        for (int j = 0; j <= B.dim; j++) {
            this.Insertar(B.P[j]);

        }

    }

    public void restarPolinomios(Polinomio A, Polinomio B) {

        for (int i = 0; i <= A.dim; i++) {
            this.Insertar(A.P[i]);

        }
        for (int i = 0; i <= B.dim; i++) {
            
            B.P[i].coef = B.P[i].coef * -1;

        }
        for (int i = 0; i <= B.getDim(); i++) {
            this.Insertar(B.P[i]);

        }
    }
    public void multiplicarPolinomios(Polinomio A,Polinomio B){
        monomio M;
        for (int i = 0; i <=A.dim; i++) {
            for (int j = 0;j<=B.dim; j++) {
                M=new monomio();
                int coef=A.P[i].coef*B.P[j].coef;
                M.setCoef(coef);
                int exp=A.P[i].getExp()+B.P[j].getExp();
                M.setExp(exp);
                Insertar(M);
                
            }
            
        }
    }
    public void dividirPolinomios(Polinomio A,Polinomio B){
          Polinomio aux=new Polinomio();
          aux=A;
          monomio M;
          Polinomio C;
          Polinomio D;
          Polinomio E;
          Polinomio F;
          
         while(aux.P[0].exp>=B.P[0].getExp()){
                M=new monomio();
                 M.setCoef(aux.P[0].coef);
                 int exp=aux.P[0].exp-B.P[0].exp;
                 M.setExp(exp);
                 Insertar(M);
                 C=new Polinomio();
                 C.Insertar(M);
                 D=new Polinomio();
                 D.multiplicarPolinomios(C,B );//D guarda la multiplicacion
                // del monomio del cociente por el divisor
                 E=new Polinomio();
                 E=aux;
                 aux=new Polinomio();
                 F=new Polinomio();
                 F.restarPolinomios(E,D);
                 aux=F;
                 
                 
                
                 
                 
                 
                 
                 
                 
              
         }
         
         
    }
 public void DerivarPolinomio(){
     int i=0;
     while(i<=dim){
        
         this.P[i].derivar();
        i++;
        
     }
     for (int j = 0; j <=dim; j++) {
         if(P[j].exp==-1)
             eliminar(P[j].exp);
         
     }
    
 }
 public void integrarPolinomio(){
       int i=0;
     while(i<=dim){
        
         this.P[i].integrar();
        i++;
        
     }
     
 }
 public double evaluar(int x){
     double suma=0;
     for (int i = 0; i <=dim; i++) {
         suma=suma+P[i].coef*Math.pow(x,P[i].exp);
         
     }
     return suma;
 }
    @Override
    public String toString() {
        String cad = "P[x]=";
        for (int i = 0; i <= this.dim; i++) {
            cad = cad + this.P[i].toString();

        }
        cad = cad + "\n" + "dim= " + this.dim;
        return cad;
    }

    public static void main(String[] args) {
        //Para el polinomio A----------------
       Polinomio A=new Polinomio();
       monomio M=new monomio('+',3,2);
       monomio H=new monomio('-',2,1);
       monomio L=new monomio('-',8,0);
       //monomio I=new monomio('+',1,0);
       A.Insertar(M);
       A.Insertar(H);
       A.Insertar(L);
      // A.Insertar(I);
       
       //Para el polinomio B---------------
       Polinomio B=new Polinomio();
       monomio N=new monomio('+',1,1);
       monomio Q=new monomio('+',2,0);
       B.Insertar(N);
       B.Insertar(Q);
       //Operaciones----------------------
       Polinomio C=new Polinomio();
       //C.sumarPolinomios(A,B);
        //C.restarPolinomios(A, B);
        //C.multiplicarPolinomios(A, B);
        //C.dividirPolinomios(A,B);
        //A.Derivar();
        //B.DerivarPolinomio();
        //A.integrarPolinomio();
        System.out.println(A.toString());
        double res=A.evaluar(3);
        System.out.println(res);
        
       

    }

}

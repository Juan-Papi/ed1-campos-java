
package Negocio;

public class Polinomio {

    Monomio P[];
    int dim;

    public Polinomio() {
        this.P = new Monomio[10];
        this.dim = -1;
    }

    public void Insertar(Monomio A) {
        if (vacia()) {
            dim++;
            P[dim] =  A;
        } else {
            int aux = 0;                   
            while ((aux <= dim) && (A.getExp() < P[aux].getExp())) {
                aux++;
            }
            if (aux <= dim) {
                if (P[aux].getExp() != A.getExp()) {
                    Redimensionar();
                    for (int i = dim; i >= aux; i--) {
                        P[i + 1] = P[i];
                    }
                    P[aux] = A;
                    dim++;
                } 
                else {
                    int suma = A.Coef + P[aux].Coef;
                    if (suma != 0) {
                        P[aux].Coef = suma;
                    } 
                    else {
                        for (int j = aux; j < dim; j++) {
                            P[j] = P[j + 1];
                        }
                        dim--;
                    }
                }
            } 
            else {
                Redimensionar();
                dim++;
                P[dim] = A;
            }
        }
    }

    private boolean vacia() {
        return (dim == -1);
    }

    private void Redimensionar() {
        if (P.length - 1 == dim) {
            Monomio Copia[] = new Monomio[P.length];
            System.arraycopy(P, 0, Copia, 0, P.length);
            P = new Monomio[P.length + 10];
            System.arraycopy(Copia, 0, P, 0, Copia.length);
        }
    }
    
    public void Eliminar(int exp){
        if (!vacia()){
            int i = 0;
            while ((i <= dim) && (exp != P[i].getExp()))
                i++;
            
            if (i < dim){
                for (int j = i; j < dim; j++){
                    P[j] = P[j+1];
                }
                dim--;
            }
            else if (i == dim){
                this.P[i] = null;
                dim--;
            }
        }
    }
    
    public double Evaluar(int x){
        double suma = 0;
        for (int i = 0; i <= dim; i++){
            suma = (suma + (P[i].Coef * Math.pow(x, P[i].getExp())));
        }
        return suma;
    }

    public Monomio getMonomio(int Exp) {
        int i = 0;
        while (P[i].getExp() != Exp) {
            i++;
        }
        return P[i];
    }
    
    public int[] getExps(){
        int exps[] = new int[dim + 1];
        for (int i = 0; i <= dim; i++){
            exps[i] = P[i].getExp();
        }
        return exps;
    }

    public void Sumar(Polinomio R, Polinomio Q){
        for (int i = 0; i <= R.dim; i++){
            this.Insertar(R.P[i]);
        }
        for (int i = 0; i <= Q.dim; i++){
            this.Insertar(Q.P[i]);
        }
    }
    
    public void Restar(Polinomio R, Polinomio Q){
        Polinomio aux = new Polinomio();
        for (int i = 0; i <= Q.dim; i++){
            aux.Insertar(Q.P[i]);
            aux.P[i].Coef = -aux.P[i].Coef;
        }
        this.Sumar(R, aux);
    }
        
    public void Multiplicar(Polinomio R, Polinomio Q){                                                            
        Monomio M = new Monomio();
        for (int i = 0; i <= R.dim; i++){ 
            for (int j = 0; j <= Q.dim; j++){
                M.Coef = R.P[i].Coef * Q.P[j].Coef;
                M.exp = R.P[i].exp + Q.P[j].exp;
                this.Insertar(M);
            }
        }
    }
    
    @Override
    public String toString() {
        String S = "";
        for (int i = 0; i <= dim; i++) {
            S = S + P[i] + " ";
        }
        return S;
    }
    

}

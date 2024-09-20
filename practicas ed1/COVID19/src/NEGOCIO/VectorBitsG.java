/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

/**
 *
 * @author fabio
 */
public class VectorBitsG { int V[];
                                    int dim;
                                    int cantbits;

    public VectorBitsG(int cant,int Nbits) {
        int NE=((cant*Nbits)/32);
        if (((cant*Nbits)%32)!=0)
            NE++;
        V = new int [NE];
        this.dim=cant;
        this.cantbits=Nbits;
    }
    
private int calcularNbit(int pos){
   return((((pos-1)*cantbits)%32)+1); 
} 
private int calcularNent(int pos){
    return (((pos-1)*cantbits)/32);
}
public void Insertar(int ele, int pos){
    int ele1=ele;
    int Nbit=calcularNbit(pos);
    int Nent=calcularNent(pos);
    int mask=((int)(Math.pow(2, cantbits))-1);
    mask=mask<<(Nbit-1);
    mask=~mask;
    V[Nent]=V[Nent]&mask;
    ele=ele<<(Nbit-1);
    V[Nent]=V[Nent]|ele;
    if ((Nbit-1)+cantbits>32){
        int mask1=((int)((Math.pow(2, cantbits))-1));
        mask1=mask1>>>(32-(Nbit-1));
        mask1=~mask1;  
        V[Nent+1]=V[Nent+1]&mask1;
        ele1=ele1>>>(32-(Nbit-1));
        V[Nent+1]=V[Nent+1]|ele1;
    }
}

    public int GetElem(int pos) {
    int Nbit=calcularNbit(pos);
    int Nent=calcularNent(pos);
    int mask=(int)(Math.pow(2, cantbits))-1;
    mask=mask<<Nbit-1;
    mask=mask&V[Nent];
    mask=mask>>>(Nbit-1);
    if ((Nbit-1)+cantbits>32){
        int mask1=((int)((Math.pow(2, cantbits))-1));
        mask1=mask1>>>(32-(Nbit-1));
        mask1=mask1&V[Nent+1];
        mask1=mask1<<(32-(Nbit-1));
        mask=mask|mask1;
    }
        return mask;
    }


    @Override
    public String toString() {
        String S="[";
        int i = 1;
        for (; i <dim ; i++) {
            S=S+GetElem(i)+"-";
        }
        S=S+GetElem(i)+"]";
        return S;
    }
    
}

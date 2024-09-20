/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;
import NEGOCIO.VectorBitsG;
/**
 *
 * @author 59178
 */
public class FCOVID {
    VectorBitsG A;
    String[] Nombre;
    public int dim;
    
    public int C(boolean da){
    if(da==true)
        return 1;
    else
        return 0;
    }
    
    public String V(boolean CA){
        if(CA==true)
        return "Si";
    else
        return "No";
    }
    

    public FCOVID() {
        A =new VectorBitsG(100, 28);
        Nombre=new String[100];
        this.dim=0;
    }
    
    public void insertar(String Nom,int edad,int sexo,double peso,boolean F,boolean T,boolean DG,boolean DC,boolean FR
                                ,boolean D, boolean DM, boolean PO, boolean PG){
        Nombre[dim]=Nom;
        int dato=edad;
        dato=dato<<1;
        dato=dato|sexo;
        int pesoE = (int)(peso);
        int pesoD = (int)((peso % 1)*10);
        dato=dato<<7;
        dato=dato|pesoE;
        dato=dato<<4;
        dato=dato|pesoD;
        dato=dato<<1;
        dato=dato|C(F);
        dato=dato<<1;
        dato=dato|C(T);
        dato=dato<<1;
        dato=dato|C(DG);
        dato=dato<<1;                             
        dato=dato|C(DC);
        dato=dato<<1;
        dato=dato|C(FR);
        dato=dato<<1;
        dato=dato|C(D);
        dato=dato<<1;
        dato=dato|C(DM);
        dato=dato<<1;
        dato=dato|C(PO);
        dato=dato<<1;
        dato=dato|C(PG);
        dim++;
        A.Insertar(dato, dim);
    }
    
    public void Modificar(int pos,String Nom,int edad,int sexo,double peso,boolean F,boolean T,boolean DG,boolean DC,boolean FR
                                ,boolean D, boolean DM, boolean PO, boolean PG){
        Nombre[pos]=Nom;
        int dato=edad;
        dato=dato<<1;
        dato=dato|sexo;
        int pesoE = (int)(peso);
        int pesoD = (int)((peso % 1)*10);
        dato=dato<<7;
        dato=dato|pesoE;
        dato=dato<<4;
        dato=dato|pesoD;
        dato=dato<<1;
        dato=dato|C(F);
        dato=dato<<1;
        dato=dato|C(T);
        dato=dato<<1;
        dato=dato|C(DG);
        dato=dato<<1;                             
        dato=dato|C(DC);
        dato=dato<<1;
        dato=dato|C(FR);
        dato=dato<<1;
        dato=dato|C(D);
        dato=dato<<1;
        dato=dato|C(DM);
        dato=dato<<1;
        dato=dato|C(PO);
        dato=dato<<1;
        dato=dato|C(PG);
        A.Insertar(dato, pos);
    }
    
    public String Getnombre(int pos){
    return this.Nombre[pos-1];
    }
    
    public boolean GetPgusto(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetPolfato(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>1;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetDmuscular(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>2;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetD(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>3;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetFrespiracion(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>4;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetDcabeza(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>5;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetDgarganta(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>6;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetTos(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>7;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public boolean GetFiebre(int pos){
        int x=A.GetElem(pos); // 28-1=27
        x=x>>>8;
        x=x&1;
        if(x==1){
        return true;}
        else{
        return false;}
    }
    public double GetPeso(int pos){
        int x=A.GetElem(pos);
        int PD=x>>>9;
        int mask=(int)((Math.pow(2, 4)-1));
        PD=PD&mask;
        int PE=x>>>13;//11111110|0110110
        int mask1=(int)((Math.pow(2, 7)-1));
        PE=PE&mask1;
        double Peso=(PD/(double)(10));
        Peso=Peso+PE;
        return Peso;
    }
    public char GetSexo(int pos){
        int x=A.GetElem(pos);
        x=x>>>20;
        x=x&1;
        if(x==1){
        return 'M';}
        else{
        return 'F';} 
    }
    public int GetEdad(int pos){
        int x=A.GetElem(pos);
        x=x>>>21;
        return x;
    }
     public String GetFormulario(int i){
       String S=" ";
        
            S=" Nro= "+i+"\n Nombre: "+Getnombre(i)+"\n Edad: "+GetEdad(i)+"\n Sexo: "+GetSexo(i)+"\n Peso: "+GetPeso(i)+"\n Fiebre: "+V(GetFiebre(i))
                    +"\n Tos: "+V(GetTos(i))+"\n Dolor de Cabeza: "+V(GetDcabeza(i))+"\n Falta de Respiracion:"+V(GetFrespiracion(i))+"\n Diarrea: "+V(GetD(i))+"\n Dolor Muscular:"+ V(GetDmuscular(i))
                    +"\n Perdida de Olfato: "+V(GetPolfato(i))+"\n Perdida del Gusto: "+V(GetPgusto(i));
        
        return S;
    }
     
     public boolean verificar(int pos){
         if(pos<=dim)
             return true;
         else
             return false;
     }
    
    
    public static void main(String[] args) {
        FCOVID A =new FCOVID();
        double PesoD=((5/(double)(10)));
        PesoD=PesoD+10;
        A.insertar("fabio", 15, 1, 54.5, true, true, true, true, true, true, true, true, true);
        A.insertar("lussi", 26, 1,48, true, true, true, true, true, true, true, true, true);
        System.out.println(A.GetFormulario(1));
        System.out.println(A.GetFormulario(2));
    }
    
}

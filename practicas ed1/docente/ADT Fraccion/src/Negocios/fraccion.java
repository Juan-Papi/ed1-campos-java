package Negocios;

public class fraccion {
   int nume;
   int deno;

public fraccion(){
    this.nume=0;
    this.deno=1;
}
public fraccion(int nume,int deno,char signo){
    this.deno=Math.abs(deno);
    if (signo=='+')
        this.nume=+Math.abs(nume);
    else
        this.nume=-Math.abs(nume);
}
public int getNume(){
    return Math.abs(nume);
}
public int getDeno(){
    return deno;
}
public char getSigno(){
    if (nume>=0) {
        return '+';
    } else {
        return '-';   
    }
}
public void setNume(int nume){
    if (this.nume>=0)
        this.nume=nume;
    else
        this.nume=-nume;
}
public void setDeno(int deno){
    this.deno=deno;
}
public void setSigno(char signo){
    if (signo=='+')
        nume=Math.abs(nume);
    else
        nume=-Math.abs(nume);
}
public void Suma(fraccion A,fraccion B){
    deno=A.getDeno()*B.getDeno();
    nume=(A.nume*B.getDeno())+(A.getDeno()*B.nume);
    Simplificar();
}
public void Resta(fraccion A,fraccion B){
    deno=A.getDeno()*B.getDeno();
    nume=(A.nume*B.getDeno())-(A.getDeno()*B.nume);
    Simplificar();
}
public void Multiplicar(fraccion A,fraccion B){
    deno=A.getDeno()*B.getDeno();
    nume=A.nume*B.nume;
    Simplificar();
}
public void Dividir(fraccion A,fraccion B){
    nume=A.nume*B.deno;
    deno=A.deno*B.nume;
    if (deno<0){
        nume=nume*-1;
        deno=Math.abs(deno);}
    Simplificar();
}
public void Simplificar(){
    int x=MCD();
    nume=nume/x;
    deno=deno/x;
}
public int MCD(){
     int u=Math.abs(nume);
     int v=Math.abs(deno);
     if (v==0)
       return u;
     else{
        int z;
        while(v!=0){
        z=u%v;
        u=v;
        v=z;
        }
        return (u);
     }
}
public String ToString(){
    String c=" C= ";
    c="       "+getNume()+"\n"+c+getSigno()+" ---"+"\n       "+getDeno();
    return c;        
}
public String AString(){
    String c="C= "+getSigno()+" "+getNume()+"/"+getDeno();
    return c;
}

public static void main(String[] args) {
     fraccion A=new fraccion(1,4,'+');
      System.out.println(A.ToString());
     fraccion B=new fraccion(1,2,'-');
      System.out.println(B.ToString());
     fraccion C=new fraccion();
     C.Dividir(A, B);  
     System.out.println(C.ToString());
     fraccion D=new fraccion();
     D.Multiplicar(A, B);
     System.out.println(D.ToString());

}
}

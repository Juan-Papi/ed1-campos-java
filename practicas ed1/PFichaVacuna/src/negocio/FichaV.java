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
public class FichaV {
    //Atributos
    VectorBitsG F;
   
    String Nombres[];
    int dim;//Cant de fichas (Subvector)
    //Constructor Sobrecargado
    public FichaV(int Nfichas){//Nfichas=Nro de Fichas
        F=new VectorBitsG(Nfichas,32);
        
       this.dim=0;//0 fichas
       Nombres=new String[Nfichas]; 
       
        
    }
   //Insertar datos 
    public void insertar(String nom,int dia,int mes,int año,int sexo,int edad)      {
        Nombres[dim]=nom;
        this.dim++;
        int mask=dia;
        mes=mes<<5;
        mask=mask|mes;
        año=año-2020;//año debe ser mayor o igual a 2020
        año=año<<9;
        mask=mask|año;
        sexo=sexo<<11;
        mask=mask|sexo;
        edad=edad<<12;
        mask=mask|edad;
        F.insertar(mask,dim);
    }  
    public String getNombre(int nroFich){//nroFich=numero de ficha   
        return (Nombres[nroFich-1]);               
    }
    //Los get estan implementados con la version larga
    public int getDia(int nroFich){
        int fichaB=F.Get(nroFich);//fichaB=ficha bits
        fichaB=fichaB<<27;
        fichaB=fichaB>>>27;//Aqui terminamos de aislar el dia
        return fichaB;
    }
    public int getMes(int nroFich){
        int mes=F.Get(nroFich);
        mes=mes>>>5;
        mes=mes<<28;
        mes=mes>>>28;//Aqui terminamos de aislar el mes
        return mes;
    }
    public int getAño(int nroFich){
       int año=F.Get(nroFich);
        año=año>>>9;
        año=año<<30;
        año=año>>>30;//Aqui terminamos de aislar el año
        return año+2020; 
    }
    public int getSexo(int nroFich){
         int sexo=F.Get(nroFich);
        sexo=sexo>>>11;
        sexo=sexo<<31;
        sexo=sexo>>>31;//Aqui terminamos de aislar el sexo
        return sexo; 
    }
    public int getEdad(int nroFich){
         int edad=F.Get(nroFich);
        edad=edad>>>12;
        edad=edad<<25;
        edad=edad>>>25;//Aqui terminamos de aislar la edad
        return edad;   
    }
    public String mostrarFicha(int pos){
      String s = "N° " + pos +"\nNombre: "+getNombre(pos)+"\nFecha: " + getDia(pos) + "/" + getMes(pos) + "/"
                + getAño(pos) + "\nSexo: ";
        s = (getSexo(pos) == 0) ? s + "Masculino" : s + "Femenino";
        s = s + "\nEdad: " + getEdad(pos);
        return s;
    }        
  public String toString(){
      String F = "--------------------------\n";
        for (int i = 1; i <= dim; i++) {
            F = F + mostrarFicha(i) + "\n-------------------------\n";
        }
        return F;
  }
    public static void main(String[] args) {
         FichaV ficha=new FichaV(10);
         ficha.insertar("Juan Perez",2,7,2020, 0, 19);
         //ficha.insertar("Juan Ramon",5,8,2022, 0, 20);
        System.out.println(ficha.toString());
    }
}

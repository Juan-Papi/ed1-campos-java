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
public class FichaCovid {
    //Atributos-------------------------------------------
   
    VectorBitsG F;
    VectorBitsG A;//Vector auxiliar donde guardaremos 
    //los datos faltantes de la ficha
    String nombres[];
    int dim;
    int dimSint;
   
    //Constructor sobrecargado----------------------------------
    public FichaCovid(int cantFich){
        F=new VectorBitsG(cantFich,30);
        A=new VectorBitsG(cantFich,9);
        nombres=new String[cantFich];
        this.dim=0;
        this.dimSint=0;//Cantidad de elementos del sub
        //subvector de elementos sintomas con 9bits por el elemento
        
    }
    //Insertar datos de la ficha Covid 19-------------------------
    public void insertar(String nom,int edad,int año,int mes,int dia,
            int sexo,int kg,int gr){ 
        nombres[this.dim]=nom;
        //Cargando los datos de la ficha 
        //que entran al primer vectorbits
        this.dim++;
        año=año-2020;
        int mask=edad;//edad
        mask=mask<<2;
        mask=mask|año;//año
        mask=mask<<4;
        mask=mask|mes;//mes
        mask=mask<<5;
        mask=mask|dia;//dia
        mask=mask<<1;
        mask=mask|sexo;//sexo
        mask=mask<<7;
        mask=mask|kg;//peso kg
        mask=mask<<4;
        mask=mask|gr;//peso gr
        
        F.insertar(mask,dim);
        
       //Comprobando
       /*
        System.out.println(nombres[dim-1]);
        System.out.println("dato: "+mask+":");
        System.out.println(Integer.toBinaryString(mask));*/
        
       
            
        
    }
    //Para mayor organizacion lo dividimos en 2 insertar
    public void insertarSintomas(int gusto,int olfato,
            int muscular,int diarrea,int respiracion,int cabeza,
            int garganta,int tos,int fiebre){
        this.dimSint++;
        int mask2=gusto;//gusto
        mask2=mask2<<1;
        mask2=mask2|olfato;//olfato
        mask2=mask2<<1;
        mask2=mask2|muscular;//muscular
        mask2=mask2<<1;
        mask2=mask2|diarrea;//diarrea
        mask2=mask2<<1;
        mask2=mask2|respiracion;//respiracion
        mask2=mask2<<1;
        mask2=mask2|cabeza;//cabeza
        mask2=mask2<<1;
        mask2=mask2|garganta;//garganta
        mask2=mask2<<1;
        mask2=mask2|tos;//tos
        mask2=mask2<<1;
        mask2=mask2|fiebre;//fiebre
        
        A.insertar(mask2,dimSint);//dimSint=dimension 
        //subvect de elementos sintoma
         
       //Comprobando 
         
        /*System.out.println("dato: "+mask2+":");
        System.out.println(Integer.toBinaryString(mask2));*/
        
    }
    //getters datos-------------------------------------------------------------
    public String getNombre(int pos){
        return nombres[pos-1];
    }
     public int getEdad(int pos){
       int edad=F.Get(pos);
       edad=edad>>>23;
       edad=edad&127;
         System.out.println(edad);
       return edad;
    }
      public int getAño(int pos){
      int año=F.Get(pos);
      año=año>>>21;
      año=año&3;
      return año+2020;
    }
      public int getMes(int pos){
        int mes=F.Get(pos);
        mes=mes>>>17;
        mes=mes&15;
        return mes;
    }
    public int getDia(int pos){
       int dia=F.Get(pos);
       dia=dia>>>12;
       dia=dia&31;
       return dia;
    }
    public String getSexo(int pos){
       int sexo=F.Get(pos);
       sexo=sexo>>>11;
       sexo=sexo&1;
       if(sexo==0){
           return "Masculino";
       }
       else{
           return "Femenino";
       }
       
    }
     public int getKg(int pos){
       int kg=F.Get(pos);
       kg=kg>>>4;
       kg=kg&127;
       return kg;
    }
     public int getGramos(int pos){
        int gr=F.Get(pos);
        gr=gr>>>0;
        gr=gr&15;
        return gr;
    }
     //getters sintomas---------------------------------------------------------
    
      //D=Dolor; P=Perdida
     public String getPGusto(int pos){
        int gusto=A.Get(pos);
        gusto=gusto>>>8;
        gusto=gusto&1;
       if(gusto==1){
           return "Si";
       }
       else{
           return "No";
       }
    }
     public String getPOlfato(int pos){
        int olfato=A.Get(pos);
        olfato=olfato>>>7;
        olfato=olfato&1;
        if(olfato==1){
           return "Si";
       }
       else{
           return "No";
       }
    }
      public String getDMuscular(int pos){
        int musc=A.Get(pos);
        musc=musc>>>6;
        musc=musc&1;
        if(musc==1){
           return "Si";
       }
       else{
           return "No";
       }
    }
       public String getDiarrea(int pos){
       int diarrea=A.Get(pos);
       diarrea=diarrea>>>5;
       diarrea=diarrea&1;
        if(diarrea==1){
           return "Si";
       }
       else{
           return "No";
       }
    }
       public String getFaltaRespiracion(int pos){
       int resp=A.Get(pos);
       resp=resp>>>4;
       resp=resp&1;
       if(resp==1){
           return "Si";
       }
       else{
           return "No";
       }
    }
        public String getDCabeza(int pos){
        int cab=A.Get(pos);
        cab=cab>>>3;
        cab=cab&1;//Aqui terminamos de aislar cabeza
        if(cab==1){
           return "Si";
       }
       else{
           return "No";
       }
    }
        public String getDgarganta(int pos){
       int gar=A.Get(pos);
       gar=gar>>>2;
       gar=gar&1;//Aqui terminamos de aislar garganta
         if(gar==1){
           return "Si";
       }
       else{
           return "No";
       }
    }
     public String getTos(int pos){
        int tos=A.Get(pos);
        tos=tos>>>1;
        tos=tos&1;
        if(tos==1)
            return "Si";
        else
            return "No";
        
    }
    public String getFiebre(int pos){
        int fiebre=A.Get(pos);
        
        fiebre=fiebre>>>0;
        fiebre=fiebre&1;
        if(fiebre==1)
            return "Si";
        else
            return "No";
    }
   
   //---------------------------------------------------------------------------
    
   
    
    public String MostrarFichaCovid(int pos){
        String cad="----------------------------------\n";
            cad=cad+"N° "+pos+"\n";
            cad=cad+"Nombre: "+getNombre(pos);
            cad=cad+"\nEdad: "+getEdad(pos);
            cad=cad+"\nSexo: "+getSexo(pos);
            cad=cad+"\nPeso: "+getKg(pos)+"."+getGramos(pos);
            cad=cad+"\nFecha: "+getDia(pos)+"-"+getMes(pos)+"-"+getAño(pos);
            cad=cad+"\n\nSintomas";
            cad=cad+"\nFiebre: "+getFiebre(pos);
            cad=cad+"\nTos: "+getTos(pos);
            cad=cad+"\nDolor de garganta: "+getDgarganta(pos);
            cad=cad+"\nDolor de cabeza: "+getDCabeza(pos);
            cad=cad+"\nFalta de respiracion: "+getFaltaRespiracion(pos);
            cad=cad+"\nDiarrea: "+getDiarrea(pos);
            cad=cad+"\nDolor Muscular: "+getDMuscular(pos);
            cad=cad+"\nPerdida de olfato: "+getPOlfato(pos);
            cad=cad+"\nPerdida de gusto: "+getPGusto(pos);
            cad=cad+"\n---------------------------------\n";
    
        return cad;    
       
    }
    public String toString(){
        String cad="";
        for (int i = 1; i <=dim; i++) {
            cad=cad+MostrarFichaCovid(i);
            
        }
     return cad;
    }
    public static void main(String[] args) {
       FichaCovid A=new FichaCovid(10);
       //El insertar funciona correctamente
       A.insertar("Juan Pablo",20, 2021, 7, 2, 0, 65, 9);
       //El insertar sintomas funciona correctamente
       A.insertarSintomas(0, 0, 0, 0, 0, 0, 0, 0, 0);
       /*A.insertar("Daniel",20,2020,6,1,0,70,8);
       A.insertarSintomas(1, 0, 0, 0, 1, 0, 0, 0, 1);*/
        System.out.println(A.toString());
       
       /* double p=55.9;
        String cad=p+"";
        
        System.out.println(cad.indexOf("."));
        System.out.println(cad);
        String entero=cad.substring(0,cad.indexOf("."));
        String dec=cad.substring(cad.indexOf(".")+1);
        System.out.println(entero);
        System.out.println(dec);*/
        
    }
    
}

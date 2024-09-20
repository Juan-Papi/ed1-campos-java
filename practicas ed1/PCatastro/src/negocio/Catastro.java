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
public class Catastro {

    //Atributos
    VectorBitsG v;
    String nombres[];
    int dim;

    //Constructor sobrecargado
    public Catastro(int cantC) {//cantC=Cantidad catastro
        v = new VectorBitsG(cantC, 29);
        nombres = new String[cantC];
        this.dim = 0;
    }

    //
    public void insertar(String nom, int sup, int zona, int uv, int mza,
            int lote, int luz, int agua, int pav, int alcant, int tel) {
        this.nombres[dim] = nom;
        this.dim++;
        sup = sup - 150;
        int mask = sup;
        mask = mask << 2;
        mask = mask | zona;
        mask = mask << 5;
        mask = mask | uv;
        mask = mask << 4;
        mask = mask | mza;
        mask = mask << 5;
        mask = mask | lote;
        mask = mask << 1;
        mask = mask | luz;
        mask = mask << 1;
        mask = mask | agua;
        mask = mask << 1;
        mask = mask | pav;
        mask = mask << 1;
        mask = mask | alcant;
        mask = mask << 1;
        mask = mask | tel;
        v.insertar(mask, dim);
        //Comprobando 
       // System.out.println("Dato:" + mask + ": ");
        //System.out.println(Integer.toBinaryString(mask));
       // System.out.println(v);
       // System.out.println(nombres[dim - 1]);

    }

    public String getNombre(int pos) {
        return nombres[pos - 1];
    }

    public int getSup(int pos) {
        int sup = v.Get(pos);
        sup = sup >>> 21;
        int aux = (int) (Math.pow(2, 8) - 1);
        sup = sup & aux;
        return sup + 150;

    }

    public char getZona(int pos) {
        int zona = v.Get(pos);
        zona = zona >>> 19;
        zona = zona & 3;

        if (zona == 0) {
            return 'N';
        }
        if (zona == 1) {
            return 'S';
        }
        if (zona == 2) {
            return 'E';
        }
        return 'O';
    }

    public int getUv(int pos) {
        int uv = v.Get(pos);
        uv = uv >>> 14;
        uv = uv & 31;
        return uv;
    }

    public int getMzna(int pos) {
        int mza = v.Get(pos);
        mza = mza >>> 10;
        mza = mza & 15;
        return mza;

    }

    public int getLote(int pos) {
        int Lot = v.Get(pos);
        Lot = Lot >>> 5;
        Lot = Lot & 31;
        return Lot;
    }

    //int luz,int agua,int pav,int alcant,int tel
    public int getLuz(int pos) {
        int Luz = v.Get(pos);
        Luz = Luz >>> 4;
        Luz = Luz & 1;
        return Luz;
    }

    public int getAgua(int pos) {
        int agua = v.Get(pos);
        agua = agua >>> 3;
        agua = agua & 1;
        return agua;
    }

    public int getPav(int pos) {
        int pav = v.Get(pos);
        pav = pav >>> 2;
        pav = pav & 1;
        return pav;
    }

    public int getAlcan(int pos) {
        int alcant = v.Get(pos);
        alcant = alcant >>> 1;
        alcant = alcant & 1;
        return alcant;
    }

    public int getTel(int pos) {
        int Tel = v.Get(pos);
        Tel = Tel >>> 0;
        Tel = Tel & 1;
        return Tel;
    }

    public String MostrarCatastro(int pos) {
        String cad = "---------------------------------------\n";
        cad = cad + "Nombre: " + getNombre(pos) + "\nSuperficie: " + getSup(pos);
        cad = cad + "\nZona: ";
        cad=cad+getZona(pos);
        cad=cad+"\nUv: "+getUv(pos);
//int luz,int agua,int pav,int alcant,int tel
        cad=cad+"\nManzano: "+getMzna(pos);
        cad=cad+"\nLote: "+getLote(pos);
        cad=cad+"\nLuz: ";
        if(getLuz(pos)==1)
            cad=cad+"Si";
        else 
            cad=cad+"No";
        
        cad=cad+"\nAgua: ";
        
        if(getAgua(pos)==1)
            cad=cad+"Si";
        else 
            cad=cad+"No";
        
        cad=cad+"\nPavimento: ";
        if(getPav(pos)==1)
            cad=cad+"Si";
        else 
            cad=cad+"No";
        
        cad=cad+"\nAlcantarillado: ";
        if(getAlcan(pos)==1)
            cad=cad+"Si";
        else 
            cad=cad+"No";
        
        cad=cad+"\nTelefono: ";
        if(getTel(pos)==1)
            cad=cad+"Si";
        else 
            cad=cad+"No";
    cad=cad+"\n---------------------------------------\n";
    
        return cad;
    }
    public String toString(){
        String cad="";
        for (int i = 1; i <=this.dim; i++) {
            cad=cad+MostrarCatastro(i);
            
        }
        return cad;
    }

    public static void main(String[] args) {
        Catastro A = new Catastro(10);
        A.insertar("Juan", 200, 0, 31, 0, 31, 0, 0, 1, 0, 1);
        A.insertar("Marta Cuellar",200, 2, 25, 15, 20, 1, 1, 1, 0, 1);
      //  System.out.println(A); 
        // System.out.println(A.getSup(1));
        System.out.println(A.MostrarCatastro(1)); 

    }

}

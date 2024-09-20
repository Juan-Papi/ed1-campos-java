/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author ReyMarPc
 */
public class Ficha {

    VectorNbits C;
    public int dim;

    public Ficha(int cantFicha) {
        this.dim = 0;
        C = new VectorNbits(cantFicha, 18);
    }

    public void insertar(int dia, int mes, int año, int sexo, int edad) {
        int mask = dia;
        this.dim++;
        mes = mes << 5;
        mask = mask | mes;
        año = año - 2020;
        año = año << 9;
        mask = mask | año;
        sexo = sexo << 10;
        mask = mask | sexo;
        edad = edad << 11;
        mask = mask | edad;
        C.insertar(mask, dim);
    }

    public int getdia(int num) {
        int x = C.sacar(num);
        x = x << 27;
        x = x >>> 27;
        return x;
    }

    public int getmes(int num) {
        int x = C.sacar(num);
        x = x << 23;
        x = x >>> 28;
        return x;
    }

    public int getaño(int num) {
        int x = C.sacar(num);
        x = x << 22;
        x = x >>> 31;
        return x + 2020;
    }

    public int getsexo(int num) {
        int x = C.sacar(num);
        x = x << 21;
        x = x >>> 31;
        return x;
    }

    public int getedad(int num) {
        int x = C.sacar(num);
        x = x >>> 11;
        return x;
    }

    public void setdia(int num, int dia) {
        int x = C.sacar(num);
        int mask = (int) Math.pow(2, 5) - 1;
        mask = ~mask;
        x = x & mask;
        x = x | dia;
        C.insertar(x, num);
    }

    public void setmes(int num, int mes) {
        int x = C.sacar(num);
        int mask = (int) Math.pow(2, 4) - 1;
        mask = mask << 5;
        mask = ~mask;
        x = x & mask;
        mes = mes << 5;
        x = x | mes;
        C.insertar(x, num);
    }

    public void setaño(int num, int año) {
        int x = C.sacar(num);
        int mask = 1;
        mask = mask << 9;
        mask = ~mask;
        x = x & mask;
        año = año - 2020;
        año = año << 9;
        x = x | año;
        C.insertar(x, num);
    }

    public void setsexo(int num, int sexo) {
        int x = C.sacar(num);
        int mask = 1;
        mask = mask << 10;
        mask = ~mask;
        x = x & mask;
        sexo = sexo << 10;
        x = x | sexo;
        C.insertar(x, num);
    }

    public void setedad(int num, int edad) {
        int x = C.sacar(num);
        int mask = (int) Math.pow(2, 7) - 1;
        mask = mask << 11;
        mask = ~mask;
        x = x & mask;
        edad = edad << 11;
        x = x | edad;
        C.insertar(x, num);
    }

    public String MostrarFicha(int pos) {
        String s = "N° " + pos + "\nFecha: " + getdia(pos) + "/" + getmes(pos) + "/"
                + getaño(pos) + "\nSexo: ";
        s = (getsexo(pos) == 0) ? s + "Masculino" : s + "Femenino";
        s = s + "\nEdad: " + getedad(pos);
        return s;
    }

    @Override
    public String toString() {
        String F = "--------------------------\n";
        for (int i = 1; i <= dim; i++) {
            F = F + MostrarFicha(i) + "\n-------------------------\n";
        }
        return F;
    }
}

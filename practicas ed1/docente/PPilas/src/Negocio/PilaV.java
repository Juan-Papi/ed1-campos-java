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
public class PilaV {

    int P[];
    int cima;

    public PilaV(int cant) {
        P = new int[cant];
        this.cima = -1;
    }

    public boolean Vacia() {
        return cima == -1;
    }

    public boolean llena() {
        return cima == P.length - 1;
    }

    public void Push(int ele) {
        if (llena()) {
            System.out.println("Error::Push: La pila esta Llena");
            System.exit(1);
        } else {
            cima++;
            P[cima] = ele;
        }
    }

    public int Pop() {
        cima--;
        return (P[cima + 1]);
    }

    public int Get() {
        return P[cima];
    }

    public void invertirR() {//forma mejorada 
        PilaV aux = new PilaV(P.length);
        invertir(aux);
    }

    private void invertir(PilaV q) {
        if (Vacia()) {//1er caso base
            //nada
        } else {
            if (cima == 0) {//2do caso base
                //cuando hay 1 elemento
                int x = Pop();
                q.Push(x);
                P = q.P;
                this.cima = q.cima;
            } else {//caso general 
                //mas de 1 elemento
                int x = Pop();
                q.Push(x);
                invertir(q);
            }
        }
    }
//Recursivo
    public int Mayor() {//Precondición 
        //antes de la llamada asegurarse que la pila no esté vacía
        if (cima == 0) {//1er caso base
            //tiene 1 elemento
            return P[cima];
        } else {
            int x=Pop();
            int may=Mayor();
            Push(x);
            if(x>may){
                may=x;
            }
          
            return may;
        }

    }


@Override
        public String toString
        
            () {
        String S = "";
            for (int i = cima; i >= 0; i--) {
                S = S + P[i] + '\n';

            }
            S = S + "P";
            return S;
        }
    

    public static void main(String[] args) {
        PilaV stack = new PilaV(10);
        stack.Push(8);
        stack.Push(1);
         stack.Push(7);
         stack.Push(2);     
         stack.Push(4);
         stack.Push(6);
        System.out.println(stack.toString());
        /*stack.invertirR();
        System.out.println("\n" + stack.toString());*/
        System.out.println("\n"+"El mayor es: "+stack.Mayor());
        System.out.println("\n"+stack.toString());
    }
}

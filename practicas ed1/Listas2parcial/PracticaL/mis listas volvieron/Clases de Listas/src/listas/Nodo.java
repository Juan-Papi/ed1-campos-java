/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listas;

/**
 *
 * @author hogar2013
 */
public class Nodo {
    int Data;
    Nodo Enlace;
    
public Nodo ()
{
    Enlace= null;
}
public Nodo(int Ele)
{
Enlace=null;
Data=Ele;
}
         

public void setData(int Ele)
{
Data=Ele;
}
public void setEnlace(Nodo P)
{
Enlace=P;
}
public int getData()
{
return Data;
}
public Nodo getEnlace()
{
return (Enlace);
}







}

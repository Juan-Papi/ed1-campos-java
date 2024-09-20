package Circular;

public class NodoC {
	NodoC enlace;
	int elemento;
	
	public NodoC(){
		enlace = null;
	}
	
	public NodoC getLink(){
		return this.enlace;
	}
	
	public int getData(){
		return this.elemento;
	}
	
	public void setLink(NodoC l){
		this.enlace = l;
	}
	
	public void setData(int data){
		this.elemento = data;
	}
}

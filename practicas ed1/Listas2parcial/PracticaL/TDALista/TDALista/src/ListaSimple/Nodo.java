package ListaSimple;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class Nodo {
	
	private Nodo enlace;
	private int elemento;
	
	public Nodo(){
		enlace = null;
	}
	
	public void SetData(int a){
		elemento = a;
	}
	
	public void SetLink(Nodo x){
		enlace = x;
	}
	
	public int GetData(){
		return elemento;
	}
	
	public Nodo GetLink(){
		return enlace;
	} 
}

package Circular;



public class ListaC {
	NodoC l;
	int n;
	
	public ListaC(){
		l = null;
	}
	
	public void Insertar(int data){
		NodoC p = new NodoC();
		p.setData(data);
		if(n == 0){
			l = p;
			p.setLink(l);
			n++;
		} else {
			NodoC aux = l;
			int x = n;
			while(x > 1){
				aux = aux.getLink();
				x--;
			}
			p.setLink(l);
			aux.setLink(p);
			n++;
		}	
	}
	
	public String toString(){
		String s = "";
		NodoC aux = l;
		for(int i = 1; i <= n; i++){
			s = s + " " + aux.getData();
			aux = aux.getLink();
		}
		return s;
	}
	public static void main(String[] args){
		ListaC l = new ListaC();
		l.Insertar(1);
		l.Insertar(2);
		l.Insertar(3);
		System.out.println(l.toString());
	}
}

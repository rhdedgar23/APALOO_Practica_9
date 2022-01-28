import java.util.ArrayList;

public class Pila<Tipo> implements Stack<Tipo> {
	ArrayList<String> list;
	
	public Pila() {
		list= new ArrayList<String>();
	}
	
	public void push(String elem) {
		list.add(list.size(), elem);
	}
	
	public void pop() {
		list.remove(list.size()-1);
	}
	
	public void hazNula() {
		list.clear();
	}
	
	public boolean esVacia() {
		if(list.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String valorTope() {
		return list.get(list.size()-1);
	} 
}

import java.util.ArrayList;
import java.util.ListIterator;

public class Convertidor {
	
	public Convertidor() {
	}
	
	public static void StringToArrayList(String ecuacion, ArrayList<String> contenedor) {//ingresa una cadena y un ArrayList y se pasan lo elementos de la cadena al ArrayList
		String []tokens;
		
		tokens= ecuacion.split(" ");
		for(int i=0; i<tokens.length; i++) {
			//System.out.println(tokens[i]);
			//System.out.println("Hola");
			contenedor.add(i, tokens[i]);
		}
	}
	
	public static void despliega(ArrayList<String> strings) {
		ListIterator<String> itr;
		itr= strings.listIterator();
		
		while(itr.hasNext()== true) {
			System.out.print(itr.next());
		}
		//System.out.println("\n");
	}
	
	public void desplieg_reversa(ArrayList<String> strings) {
		ListIterator<String> itr;
		itr= strings.listIterator(strings.size());
		
		while(itr.hasPrevious()== true) {
			System.out.println(itr.previous());
		}
		System.out.println("\n");
	}
	
}

import java.util.ArrayList;
import java.util.Scanner;

public class Principal  {
	
	public static void main(String[] args) {
		
		Pila<String> pos= new Pila<String>();
		Pila<String> aux= new Pila<String>();
		try (Scanner lector = new Scanner(System.in)) {
			ArrayList<String> contenedor= new ArrayList<String>();
			
			System.out.println("Por favor ingresa tu ecuacion: ");
			String ecuacion= lector.nextLine();
			
			Convertidor.StringToArrayList(ecuacion, contenedor);
			System.out.println("La ecuacion que ingresaste es:");
			Convertidor.despliega(contenedor);
			separa(contenedor, pos, aux);
		}
		//despliegaPila(pos, aux);
	}
	
	public static void separa(ArrayList<String> contenedor, Pila<String> pos, Pila<String> aux) {
		
		int i=0;
		String cadena;
		
		while(contenedor.size()>=i && i!=contenedor.size()) {
			cadena= contenedor.get(i);
			
			switch(cadena) {
			case "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t","u", "v", "w", "x", "y", "z":
				pos.push(cadena);
				System.out.println("\nLos valores de la pila posfija son: ");
				despliegaPila(pos);
				break;
				
			case "(":
				aux.push(cadena);
				System.out.println("\nLos valores de la pila auxiliar son: ");
				despliegaPila(aux);
				break;
				
			case ")" :
				System.out.println("\nAqui empieza el )");
				System.out.println("\nLos valores de la pila auxiliar son: ");
				despliegaPila(aux);
					
				while(aux.valorTope().compareTo("(")!=0) {
					pos.push(aux.valorTope());
					aux.pop();
					System.out.println("\nLos valores de la pila posfija son: ");
					despliegaPila(pos);
					System.out.println("\nLos valores de la pila auxiliar son: ");
					despliegaPila(aux);	
				}
				
				aux.pop();
				System.out.println("\nLos valores de la pila auxiliar son: ");
				despliegaPila(aux);
					
				break;
				
			case "+", "-", "*", "/" :
				while(aux.esVacia()== false && prioridad(aux.valorTope())>= prioridad(cadena)) {
					pos.push(aux.valorTope());
					aux.pop();
					System.out.println("\nLos valores de la pila auxiliar son: ");
					despliegaPila(aux);
				}
				aux.push(cadena);
				System.out.println("\nLos valores de la pila auxiliar son: ");
				despliegaPila(aux);
				break;
				
			default:
				System.out.println("ERROR, No concuerda con ningun tipo de operador");
			break;
			}
			
			i++;
		}
		
		while(aux.esVacia()== false) {
			pos.push(aux.valorTope());
			aux.pop();
			System.out.println("\nLos valores de la pila posfija son: ");
			despliegaPila(pos);
			System.out.println("\nLos valores de la pila auxiliar son: ");
			despliegaPila(aux);	
		}
	}
	
	public static int prioridad(String cadena) {
		
		int prior;
		
		switch(cadena) {
		case "a", "b", "c", "d","e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z":
			prior=1;
		break;
		
		case "+", "-" :
			prior=2;
		break;
		
		case "*", "/", "%" :
			prior=3;
		break;
		
		case "^":
			prior=4;
		break;
		
		case "(", ")":
			prior=0;
		break;
		
		default:
			prior=0;
			System.out.println("ERROR, No se encontro la prioridad");
		break;
		}
		
		return prior;
	}
	
	public static void despliegaPila(Pila<String> pila) {
		
		//while(pila.esVacia()==false) {
			//System.out.print(pila.valorTope());
			//pila.pop();
		//}
		
		Convertidor.despliega(pila.list);
	}
}

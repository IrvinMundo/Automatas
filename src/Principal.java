import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static String[] conjEdos; //Conjunto de estados, line 0 
	static String[] alfabeto; //Alfabeto, line 1
	static String estadoInicial; //Estado inicial, line 2
	static String[] edosFinales; //Conjunto de estados fianles, line 3
	static EstadoND [] estados ;


	@SuppressWarnings("unchecked")
	public static void main(){
		File file = new File("AFNDlmd.txt");

		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
			conjEdos = sc.nextLine().split(",");
			alfabeto =sc.nextLine().split(",");
			estados = new EstadoND [conjEdos.length];
			for(int i=0;i<conjEdos.length;i++){
				ArrayList<EstadoND>[] transiciones= new ArrayList[alfabeto.length];
				for(int j=0;j<alfabeto.length;j++){
					transiciones[j]=new ArrayList<EstadoND>();
				}
				estados[i] = new EstadoND(conjEdos[i],transiciones);
			}
			estadoInicial = sc.nextLine();
			edosFinales = sc.nextLine().split(",");
			while (sc.hasNextLine()) {
				String funcion = sc.nextLine();
				String fun [] = funcion.split("->");
				String [] operadores = fun[0].split(",");
				String [] trans = fun[1].split(",");
				int indice=encontrar(operadores[0]);
				for(int i = 0; i<trans.length;i++){
					((ArrayList<EstadoND>) estados[indice].transiciones[(operadores[1].charAt(0)-'a')]).add(estados[encontrar(trans[i])]);
				}
			}
			estadoAFD(estadoInicial);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void estadoAFD(String estadoInicial) {
		ArrayList<EstadoD> superEstados = new ArrayList<EstadoD>();
		ArrayList <EstadoND> inicio= new ArrayList<EstadoND>();
		inicio.add(estados[encontrar("q0")]);
		superEstados.add(new EstadoD("Q0",inicio,new EstadoD[alfabeto.length]));
		for(int i=0;i<alfabeto.length;i++){
			//superEstados.get(0).estados[0].transiciones
		}
	}
	private static int encontrar(String string) {
		for ( int i = 0; i<estados.length;i++){
			if(estados[i].nombre.equals(string)){
				return  i;
			}
		}
		return 0;
	}
	/*private static EstadoD(){
		new Estado
	}*/
}
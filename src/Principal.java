import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal<T> {
	static ArrayList<GLC> gramaticas = new ArrayList<GLC>();
	//Primer renglón
	static String alfabetoDePila="";
	//Primer renglón separado
	static String[]simbolosNT; //A,B
	
	//Segundo renglón
	static String alfabetoDeEntrada="";
	//Segundo renglón separado
	static String[]simbolosT; //a,b
	
	//Tercer renglón
	static String simboloNTI=""; //S
	
	//Cuarto renglón
	//S->aS S->aA etc
	static ArrayList<String> lineasDelTXT = new ArrayList<String>();
	static ArrayList<AP> automatasDePila = new ArrayList<AP>();
	
	//
	static AP revisarCadena = new AP();
	static AP ap;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		File file = new File("GLC.txt");
		
		try {	
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
			int numLinea = 1;
			
			while (sc.hasNextLine() != false) {
				if(numLinea==1){
					alfabetoDePila = sc.nextLine();
				}else if(numLinea==2){
					alfabetoDeEntrada = sc.nextLine();
				}else if(numLinea==3){
					simboloNTI = sc.nextLine();
				}else{
					lineasDelTXT.add(sc.nextLine());
				}				
				numLinea++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		simbolosNT = alfabetoDePila.split(",");
		simbolosT = alfabetoDeEntrada.split(",");
			
		ArrayList<String>list = new ArrayList<String>();
		
		while(!lineasDelTXT.isEmpty()){
			String [] campos = lineasDelTXT.get(0).split("->");
			lineasDelTXT.remove(0);
			if(list.isEmpty()){
				GLC gram = new GLC(campos[0]);
				gram.trans.add(campos[1]);
				gramaticas.add(gram);
				list.add(campos[0]);
			}else{
				boolean encontrado = false;
				int indice=0;
				for(int i = 0; i < list.size(); i++){
					if(campos[0].equals(list.get(i))){
						encontrado = true;
						indice = i;
					}
				}
				if(encontrado == true){
					gramaticas.get(indice).trans.add(campos[1]);
				}else{
					GLC gram = new GLC(campos[0]);
					gram.trans.add(campos[1]);
					gramaticas.add(gram);
					list.add(campos[0]);
				}
			}
			/*else{
				boolean encontrado = false;
				int indice=0;
				for(int i = 0; i < list.size(); i++){
					if(campos[0].equals(list.get(i))){
						encontrado = true;
						indice = i;
					}
					if(encontrado == true){
						gramaticas.get(indice).trans.add(campos[1]);
						encontrado = false;
					}else{
						GLC gram = new GLC(campos[0]);
						gram.trans.add(campos[1]);
						gramaticas.add(gram);
						list.add(campos[0]);
					}
				}
			}*/
		}
		
		System.out.println("qo,q1");
		System.out.println(alfabetoDeEntrada);
		System.out.println(alfabetoDePila);
		System.out.println("q1");
		
		
		for(int i = 0; i < gramaticas.size(); i++){
			
			GLC g = gramaticas.get(i);
			if(g.letra.equals(simboloNTI)){
				for(int j = 0; j < g.trans.size();j++){
					
					ap = new AP();
					ap.estadoInicial = "q0";
					ap.simboloPilaQueSale = "lmd";
					String transicion = g.trans.get(j);
					String letras[] = transicion.split("");
					int contador = 0;
					String simboloAlf="";
					String simboloPil="";
					
					while(contador < letras.length){
						char c = letras[contador].charAt(0);
						boolean b = mayusculaMinuscula(c);
						if(b == true){
							if(c == simboloNTI.charAt(0)){
								simboloPil = "lmd";
							}else{
								simboloPil = simboloPil+c;
							}	
						}else{
							simboloAlf = simboloAlf+c;
						}
						contador++;
					}
					ap.simboloPilaQueEntra = simboloPil;
					ap.simboloAlfabeto=simboloAlf;
					if(simboloPil == "lmd"){
						ap.estadoSiguiente = "q0";
					}else{
						ap.estadoSiguiente = "q1";
					}
					automatasDePila.add(ap);
				}
			}else{
				for(int j = 0; j < g.trans.size();j++){
					ap = new AP();
					ap.estadoInicial = "q1";
					ap.estadoSiguiente = "q1";
					ap.simboloPilaQueSale = g.letra;
					
					String transicion = g.trans.get(j);
					String letras[] = transicion.split("");
					int contador = 0;
					String simboloAlf="";
					String simboloPil="";
					while(contador < letras.length){
						char c = letras[contador].charAt(0);
						boolean b = mayusculaMinuscula(c);
						if(b == true){
							simboloPil = simboloPil+c;
						}else{
							simboloAlf = simboloAlf+c;
						}
						contador++;
					}
					if(simboloPil==""){
						simboloPil = "lmd";
					}
					ap.simboloPilaQueEntra = simboloPil;
					ap.simboloAlfabeto=simboloAlf;				
					automatasDePila.add(ap);				
				}
			}
		}
		for(int i = 0; i < automatasDePila.size(); i++){
			System.out.println(automatasDePila.get(i));
		}
		
		
		String cadena = 
		JOptionPane.showInputDialog("Por favor, dame una cadena y te diré si es aceptada");
		String [] letrasCadena = cadena.split("");
		
		JOptionPane.showMessageDialog(null, revisarCadena.recorrerAP(letrasCadena, ap));
	}
	
	//mayuscula true, minuscula false
	public static boolean mayusculaMinuscula(char c){
		return Character.isUpperCase(c);
	}
}

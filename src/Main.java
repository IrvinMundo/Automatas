import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		File file = new File("GLC.txt");
		ArrayList<GLC> gramaticas = new ArrayList<GLC>();
		//Primer renglón
		String alfabetoDePila="";
		//Primer renglón separado
		String[]simbolosNT; //A,B
		
		//Segundo renglón
		String alfabetoDeEntrada="";
		//Segundo renglón separado
		String[]simbolosT; //a,b
		
		//Tercer renglón
		String simboloNTI=""; //S
		
		//Cuarto renglón
		//S->aS S->aA etc
		ArrayList<String> lineasDelTXT = new ArrayList<String>();
		ArrayList<AP> automatasDePila = new ArrayList<AP>();
		
		
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
					
					AP ap = new AP();
					ap.nombre = "q0";
					ap.simboloPila = "lmd";
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
					ap.simboloPila2 = simboloPil;
					ap.simboloAlfabeto=simboloAlf;
					if(simboloPil == "lmd"){
						ap.estado = "q0";
					}else{
						ap.estado = "q1";
					}
					automatasDePila.add(ap);
				}
			}else{
				for(int j = 0; j < g.trans.size();j++){
					AP ap = new AP();
					ap.nombre = "q1";
					ap.estado = "q1";
					ap.simboloPila = g.letra;
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
					ap.simboloPila2 = simboloPil;
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
	}
	
	//mayuscula true, minuscula false
	public static boolean mayusculaMinuscula(char c){
		return Character.isUpperCase(c);
	}
}

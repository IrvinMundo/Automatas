
public class AP<T> {
	String nombre;
	String simboloAlfabeto;
	String simboloPila;
	String estado;
	String simboloPila2;
	Pila<String> pila;
	
	public AP() {
		
	}
	
	public String toString(){
		return nombre + "," + simboloAlfabeto + "," + simboloPila + "->(" + estado + "," +
				simboloPila2 + ")";
	}
	
	public int[] verificarNumDeLetras(String[] letrasCadena, int cantidadDeSimbolos){
		/* quiero saber el núm de repeticiones de c/símbolo terminal
		 * para saber cuantas veces lo llamo
		 * y a partir de cuando empiezo a poner fin a la recursión
		 */
		int[] numLetras = new int[cantidadDeSimbolos];
		for(int i=0; i<letrasCadena.length;i++){
			int j=0;
			if(i!=j){
				if(letrasCadena[i] == letrasCadena[j]){
					numLetras[i]++;
				}
			}
			j++;
		}
		return numLetras;
	}
	
	public String recorrerAP(String[] letrasCadena, int simbolosT, String[] simbT){
		pila = new Pila(letrasCadena.length);
		int contador = 0;
		int[] cantidad = verificarNumDeLetras(letrasCadena, simbolosT);
		String esdoActual = "q0";
		boolean proseguir = false;
		if(contador == 0){
			//Comparar con los simbolosT que salen de q0
			for(int i = 0; i < Principal.simbolosTQ0.length; i++){
				if(letrasCadena[contador] == Principal.simbolosTQ0[i]){
					proseguir = true;
				}
			}
			if(proseguir != true){
				return "La cadena es inválida";
			}else{
				//Se empezará a llenar la pila (y una pequeña trampa)
				//Y ver cuántos símbolosT iguales hay juntos
				
			}
		}else{
			
		}
		return "";
	}
	
	public void verificarPila(String letra, boolean llenar){
		if(llenar){
			pila.push(letra);
		}else{
			pila.pop();
		}
	}
}
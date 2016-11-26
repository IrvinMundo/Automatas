import java.util.ArrayList;

public class AP<T> {
	String[] estadoInicial;
	String[] simboloAlfabeto;
	String[] simboloPilaQueSale;
	String[] estadoSiguiente;
	String[] simboloPilaQueEntra;
	Pila<String> pila;
	
	public AP() {
		
	}
	
	public String toString(){
		return estadoInicial + "," + simboloAlfabeto + "," + simboloPilaQueSale + "->(" + estadoSiguiente + "," +
				simboloPilaQueEntra + ")";
	}
	
	public String recorrerAP(String[] letrasCadena, AP ap){
		pila = new Pila(letrasCadena.length);
		int contador = 0;
		String esdoActual = ap.estadoInicial[0];
		String simboloTrans = "";
		boolean proseguir = false, transEncontrada = false;
		//contador = 0 es q0, contador = 1 es q1
		if(contador == 0){
			
			if(){
				
			}
			
			//ver el simbTerminal para hacer la trnsición entre estados
			for(int i=0; i<ap.estadoInicial.length; i++){
				if(ap.estadoInicial[i] == "q0" && ap.estadoSiguiente[i+1] == "q1" && !transEncontrada) {
					simboloTrans = ap.simboloAlfabeto[i];
					transEncontrada = true;
				}
			}
			
			if(proseguir != true){
				return "La cadena es inválida";
			}else{
				
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
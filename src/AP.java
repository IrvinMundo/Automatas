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
		boolean proseguir = false;
		if(contador == 0){
			//ver si est�n todas las letras en los dos estados
			for(int i=0; i<ap.estadoInicial.length; i++){
				if(ap.estadoInicial[i] == "q1") {
					
				}
			}
			
			if(proseguir != true){
				return "La cadena es inv�lida";
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
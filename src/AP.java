
public class AP<T> {
	//[estadoInicial][simboloAlfabeto][simboloPilaQueSale][estadoSiguiente][simboloPilaQueEntra]
	//[?][1][1][1][1]
	String estadoInicial;
	String simboloAlfabeto;
	String simboloPilaQueSale;
	String estadoSiguiente;
	String simboloPilaQueEntra;
	Pila<String> pila;
	
	public AP() {
		
	}
	
	public String toString(){
		return estadoInicial + "," + simboloAlfabeto + "," + simboloPilaQueSale + "->(" + estadoSiguiente + "," +
				simboloPilaQueEntra + ")";
	}
	
	public String recorrerAP(String[] letrasCadena, AP<T> ap){
		pila = new Pila<String>(letrasCadena.length);
		String simboloTrans = "";
		boolean proseguir = false;
		int contador = 0;
		
		while(contador < letrasCadena.length){
			
			if(proseguir != true){
				return "La cadena es inválida";
			}else{
				
			}
			++contador;
		}
		return "";
	}
	
}
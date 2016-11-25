
public class AP {
	String nombre;
	String simboloAlfabeto;
	String simboloPila;
	String estado;
	String simboloPila2;

	public AP() {
		
	}
	
	public String toString(){
		return nombre + "," + simboloAlfabeto + "," + simboloPila + "->(" + estado + "," +
				simboloPila2 + ")";
	}

}

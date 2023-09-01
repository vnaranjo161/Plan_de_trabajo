import java.util.HashMap;

public class Diccionario {
	static HashMap<String, String> diccionario = new HashMap<String, String>();
	public static void main(String[] args) {
		crearDiccionario();
		consultarDiccionario("Hello");
		consultarDiccionario("Hola");
	}
	
	public static void crearDiccionario() {
		diccionario.put("Hello", "Hola");
		diccionario.put("Between", "En medio de");
		diccionario.put("Sun", "Sol");
		diccionario.put("Nigth", "Noche");
	}
	
	public static void consultarDiccionario(String key) {
		if (diccionario.containsKey(key)) {
			System.out.println("La traduccion de "+key+" es: "+diccionario.get(key));
		}else {
			System.out.println("No se encontro "+key+" en el diccionario");
		}
	}
	
}
 
import java.util.ArrayList;

public class Basicos {

	public static void main(String[] args) {
		nombre();
		mayor10(13);
		mayor10(8);
		int aleatorio = numAleatorio();
		System.out.println(aleatorio);
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(2);
		lista.add(4);
		lista.add(3);
		lista.add(22);
		lista.add(122);
		lista.add(1222);
		
		int mayor = mayor(lista);
		System.out.println(mayor);
		
	}
	
	public static void nombre() {
		System.out.println("Jhaineth Valentina  Naranjo Mejia");
	}
	
	public static void mayor10(double numero) {
		if (numero>10) {
			System.out.println(numero);
		}
	}
	
	public static int numAleatorio() {
		int aleatorio = (int)(Math.random()*(100+1));
		return aleatorio;
	}
	
	public static int mayor(ArrayList<Integer> lista) {
		int numMayor = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i)>numMayor) {
				numMayor=lista.get(i);
			}
		}
		return numMayor;
	}
	
	public static int[] sumaArrarys(int[] arreglo1, int[] arreglo2) {
		int[] suma = new int [arreglo1.length];
		if (arreglo1.length != arreglo2.length) {
			throw new IllegalArgumentException("Error: arreglos con tamaño diferente");
		}else {			
			for (int i = 0; i < arreglo1.length; i++) {
				suma[i]=arreglo1[i]+arreglo2[i];
			}
		}
		return suma;
	}

}

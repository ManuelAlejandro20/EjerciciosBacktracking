import java.util.Arrays;

public class Temp {
	public static void main(String[] args) {
		llenar(5);
	}
	
	public static void llenar(int n) {
		int[] arreglo = new int[2*n];
		for(int i = 0; i < 2*n; i++) {
			arreglo[i] = 0;
		}
		
		if(llenarBacktracking(arreglo, n, n)) {
			System.out.println(Arrays.toString(arreglo));
		}else {
			System.out.println("No hay solucion papu :,v");
		}
	}
	
	private static boolean llenarBacktracking(int[] arreglo, int actual, int n) {
		int k = 0;
		while(k != 2*n) {
			if(esAceptable(arreglo, actual, k)) {
				arreglo[k] = actual;
				arreglo[k+actual+1] = actual;
				if(!exito(arreglo)) {
					if(!llenarBacktracking(arreglo, actual - 1, n)) {
						arreglo[k] = 0;
						arreglo[k+actual+1] = 0;
					}
					else return true;
				}
				else return true;
			}
			k++;
		}
		return false;
	}
	
	private static boolean esAceptable(int[] arreglo ,int actual, int k) {
		try {
			return arreglo[k] == 0 && arreglo[k+actual+1] == 0;
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		
		
	}
	
	private static boolean exito(int[] arreglo) {
		for(int i : arreglo) {
			if(i == 0)return false;
		}
		return true;
	}
	
	
	
}
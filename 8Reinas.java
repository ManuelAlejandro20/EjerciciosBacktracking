import java.util.Arrays;

public class Temp {
	public static void main(String[] args) {
		//System.out.print("Este es un archivo de prueba");
		int[] reinas = {-1,-1,-1,-1,-1,-1,-1,-1};
		
		//System.out.print(Arrays.toString(reinas));
		try {
			proc(0, reinas);
		}catch(Exception e) {
			System.out.println("Ocurrio un error papu :v");
			System.out.println(Arrays.toString(reinas));
			
		}
		System.out.println(Arrays.toString(reinas));
			
	}
	
	public static void proc(int columna, int[] array) {
		int i = 0;
		while(i < 8 && columna < 8) {
			if(!detect(i, columna, array)) {
				array[columna] = i;
				proc(columna + 1, array);
				if(ver(array)) { 
					break;
				}
				else {
					array[columna] = -1;
				}
			}
			i++;
		}
	}
	
	public static boolean detect(int num, int columna,int[] array) {
		for(int i = 0; i < columna; i++) {
			if(array[i] == num) {
				return true;
			}
			int fila2 =  array[i];
			int filaAux = fila2;
			for(int j = i; j < columna + 1; j++) {
				if(filaAux == num && j == columna) {
					return true;
				}
				filaAux++;
			}
			filaAux = fila2;
			for(int j = i; j < columna + 1; j++) {
				if(filaAux == num && j == columna) {
					return true;
				}
				filaAux--;
				if(filaAux == -1) {
					break;
				}
			}
			
			
		}
		return false;
	}
	
	public static boolean ver(int[] array) {
		for(int i : array) {
			if(i == -1) {
				return false;
			}
		}
		return true;
	}
	
	
}

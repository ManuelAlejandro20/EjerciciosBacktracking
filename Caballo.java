import java.util.Arrays;

public class Caballo {
	private int mov;
	private int[][] tablero = {{1,-1,-1,-1,-1,-1},
							   {-1,-1,-1,-1,-1,-1},
							   {-1,-1,-1,-1,-1,-1},
							   {-1,-1,-1,-1,-1,-1},
							   {-1,-1,-1,-1,-1,-1},
							   {-1,-1,-1,-1,-1,-1}};
	private boolean exi;
	
	public Caballo() {
		this.mov = 1;
		
	}
	
	public void resolverTablero() {
		resolverTablero(0,0);
		for(int[] q : this.tablero) {
			System.out.println(Arrays.toString(q));
		}
	}
	
	private void resolverTablero(int i, int j) {

		int k = 1;
		int[] l;
		while(k < 9){
			l = esAceptable(k ,i ,j);
			if(l != null) {
				this.mov++;
				this.tablero[l[0]][l[1]] = mov;
				if(!exito()) {
					resolverTablero(l[0],l[1]);
					if(!this.exi) {
						tablero[l[0]][l[1]] = -1;
						mov--;
					}
					else return;
				}
				else {
					this.exi = true; 
					return;
				}
			}
			k++;
		}
		this.exi = false;
	}
	
	private int[] esAceptable(int num, int i, int j) {
		int[] lista;
		switch(num) {
		case 1:
			if(entre(i - 2) && entre(j - 1)) {
				if(this.tablero[i - 2][j - 1] == -1) {
					i -= 2; 
					j -= 1;
					lista = new int[]{i,j}; 
					return lista;	
				}
			}
			break;
		case 2:
			if(entre(i - 2)  && entre(j + 1)) {
				if(this.tablero[i - 2][j + 1] == -1) {
					i -= 2; 
					j += 1;
					lista = new int[]{i,j}; 
					return lista;
				}
			}
			break;
		case 3:
			if(entre(i - 1) && entre(j + 2)) {
				if(this.tablero[i - 1][j + 2] == -1) {
					i -= 1; 
					j += 2;
					lista = new int[]{i,j}; 
					return lista;
				}
			}
			break;
		case 4:
			if(entre(i + 1) && entre(j + 2)) {
				if(this.tablero[i + 1][j + 2] == -1) {
					i += 1; 
					j += 2;
					lista = new int[]{i,j}; 
					return lista;
				}
			}
			break;
		case 5:
			if(entre(i + 2) && entre(j + 1)) {
				if(this.tablero[i + 2][j + 1] == -1) {
					i += 2; 
					j += 1;
					lista = new int[]{i,j}; 
					return lista;
				}
			}
			break;
		case 6:
			if(entre(i + 2) && entre(j - 1)) {
				if(this.tablero[i + 2][j - 1] == -1) {
					i += 2; 
					j -= 1;
					lista = new int[]{i,j}; 
					return lista;
				}
			}
			break;
		case 7:
			if(entre(i + 1) && entre(j - 2)) {
				if(this.tablero[i + 1][j - 2] == -1) {
					i += 1; 
					j -= 2;
					lista = new int[]{i,j}; 
					return lista;
				}
			}
			break;
		default:
			if(entre(i - 1) && entre(j - 2)) {
				if(this.tablero[i - 1][j - 2] == -1)	{
					i -= 1; 
					j -= 2;
					lista = new int[]{i,j}; 
					return lista;
				}
			}
			break;
		}
		return null;
	}

	private boolean exito() {
		for(int i = 0; i < 6; i++) {
			for(int j=0; j<6; j++) {
				if(this.tablero[i][j] == -1) return false;
			}
		}
		return true;
	}
	
	private boolean entre(int num) {
		return num >= 0 && num <= 5;
	}
	
	
	
}

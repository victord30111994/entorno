package prueba;


public class Casilla {
	private boolean ocupada; //indica si la casilla está o no ocupada
	private String jugadoresQueLaOcupan; //numero de jugador que la ocupa
	private boolean tiraOtraVez; //indica si la casilla es o no una oca
	
	public Casilla( ) {
		this.tiraOtraVez=false;
		ocupada=false;
		jugadoresQueLaOcupan="";
	
	}

	public void ocupar (int jugador) {	
		ocupada=true;
		jugadoresQueLaOcupan= jugadoresQueLaOcupan + jugador+ " ";
	}
	/**
	 * Metodo que elimina un jugador de la casilla. Lo borra de la cadena
	 * que contiene los jugadores en esa casilla
	 * @param jugador
	 */
	public void desOcupar(int jugador) {
		//Borra de la cadena el jugador
		jugadoresQueLaOcupan=jugadoresQueLaOcupan.replaceAll(jugador + " ", "");
		//Si la cadena está vacía es que no esta ocupada
		if (jugadoresQueLaOcupan.length() ==0) {
			ocupada=false;
		}
	}

	

	public boolean esCasillaTiraOtraVez() {
		return tiraOtraVez;
	}

	public void setTiraOtraVez(boolean tiraOtraVez) {
		this.tiraOtraVez = tiraOtraVez;
	}

	public String toString() {
		String informacion;
		if (tiraOtraVez) {
			informacion="Tira Otra Vez";
		}
		else {
			informacion="" ;
		}
		if ( ocupada) {
			informacion=informacion + " Ocupada por jugador:" + jugadoresQueLaOcupan;
		}
		return informacion;
	}
	
	
}

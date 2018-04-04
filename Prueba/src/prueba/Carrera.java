package prueba;

import java.util.Random;

public class Carrera {
	private static final int CASILLA_INICIAL = 0;
	private static final int TOTAL_DE_CASILLAS = 24;
	private static final int NUMERO_CASILLAS_JUEGA_OTRA_VEZ = 5;

	private Casilla[] juego;
	private int numeroDeJugadores;
	private int[] posicionesDeJugadores;
	boolean juegoTerminado;

	public Carrera(int numeroJugadores) throws CarreraException {
		juegoTerminado = false;
		numeroDeJugadores = numeroJugadores;
		if(numeroDeJugadores<2) {
			throw new CarreraException("El numero de jugadores es incorrecto");
		}
		juego = new Casilla[TOTAL_DE_CASILLAS];
		posicionesDeJugadores = new int[numeroJugadores];
		crearCasillas();
		for(int jugador=0;jugador<numeroJugadores;jugador++) {
			juego[0].ocupar(jugador);
		}
	}

	private void crearCasillas() {
		Random numero = new Random();
		int i = 0;
		for(i=0;i<juego.length;i++) {
			juego[i]=new Casilla();
		}
		
		i=0;
		
		while (i < NUMERO_CASILLAS_JUEGA_OTRA_VEZ) {
			
			int aleatorio = (numero.nextInt((TOTAL_DE_CASILLAS - 2)) + 1);
			if (!juego[aleatorio].esCasillaTiraOtraVez()) {
				i++;
				juego[aleatorio].setTiraOtraVez(true);
			}
		}
	}

	public int getNumeroDeJugadores() {
		return numeroDeJugadores;
	}

	public boolean getTerminadoJuego() {
		return juegoTerminado;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < juego.length; i++) {
			sb.append((i + 1) + ":" + juego[i]);
			sb.append("\n");
		}
		return sb.toString();

	}

	/**
	 * 
	 * @param jugador
	 * @param dado
	 * @return devuelve el turno de quien le toca ahora. Si cae en una casilla de
	 *         "Tira Otra Vez", le toca otra vez al mismo jugador. Si no, le toca al
	 *         siguiente, salvo que sea el último jugador que le toca al primero. Si
	 *         llega a la casilla final y el juego termina, devolverá que le toca al
	 *         mismo jugador, el que ha ganado.
	 * @throws CarreraException 
	 */
	public int jugar(int jugador, int dado) throws CarreraException {
		if(dado<1 || dado>6) {
			throw new CarreraException("El resultado del dado es incorrecto");
		}
		juego[posicionesDeJugadores[jugador]].desOcupar(jugador);
		if(posicionesDeJugadores[jugador] + dado>=juego.length) {
			juegoTerminado=true;
		}
		else {
			posicionesDeJugadores[jugador] = posicionesDeJugadores[jugador] + dado;
			juego[posicionesDeJugadores[jugador]].ocupar(jugador);
			if (!juego[posicionesDeJugadores[jugador]].esCasillaTiraOtraVez()) {
				jugador++;
				if(jugador>=numeroDeJugadores) {
					jugador=0;
				}		
			}
		}
		return jugador;

	}

}

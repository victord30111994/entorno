package prueba;

import java.util.Scanner;

public class Principal {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Carrera juego;
		int jugador = 1;
		int numeroDeJugadores;

		try {
			System.out.println("Introduce el numero de jugadores: ");
			numeroDeJugadores = Integer.parseInt(teclado.nextLine());

			juego = new Carrera(numeroDeJugadores);

			do {
				System.out.println(juego);
				jugador = jugada(juego, jugador);

			} while (!juego.getTerminadoJuego());
			System.out.println("Enhorabuena " + jugador + "! Has ganado!!");
		} catch (CarreraException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Dato de entrada incorrecto");
		}

	}

	private static int jugada(Carrera juego, int jugador) {
		int dado;
		System.out.println("Turno del jugador: " + jugador + ".Puntos del dado: ");
		dado = Integer.parseInt(teclado.nextLine());
		// Devuelve el nuevo jugador
		try {
			jugador = juego.jugar(jugador, dado);
		} catch (CarreraException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Dato de entrada incorrecto");
		}

		return jugador;
	}

}

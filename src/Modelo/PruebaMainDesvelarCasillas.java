package Modelo;

import java.util.Scanner;

import utiles.Utiles;

public class PruebaMainDesvelarCasillas {
	public static void main(String[] args) {
		int lado = 5;
		int porcentaje = 10;
		int minas = Utiles.calculaMinas(lado, porcentaje);
		Tablero tablero = new Tablero(lado, minas);

		tablero.mostrarTablero();
		System.out.println();

		Coordenada coordenada = obtenerCoordenadaAdesvelar();
		tablero.desvelarCasilla(coordenada);
		tablero.mostrarTablero();
		System.out.println();
		Coordenada coordenadaMarcar = obtenerCoordenadaAmarcar();
		tablero.getCasilla(coordenadaMarcar).marcar();
		System.out.println();
		Coordenada coordenadaNueva = obtenerCoordenadaAdesvelar();
		tablero.desvelarCasilla(coordenadaNueva);
		tablero.mostrarTablero();
	}

	private static Coordenada obtenerCoordenadaAmarcar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce una coordenada a marcar");
		String nombre = scanner.next();
		int posX = Integer.parseInt(String.valueOf(nombre.charAt(0)));
		int posY = Integer.parseInt(String.valueOf(nombre.charAt(1)));
		Coordenada coordenada = new Coordenada(posX, posY);
		return coordenada;
	}

	private static Coordenada obtenerCoordenadaAdesvelar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce una coordenada a desvelar");
		String nombre = scanner.next();
		int posX = Integer.parseInt(String.valueOf(nombre.charAt(0)));
		int posY = Integer.parseInt(String.valueOf(nombre.charAt(1)));
		Coordenada coordenada = new Coordenada(posX, posY);
		return coordenada;
	}
}

package Modelo;

import java.util.Scanner;

import utiles.Utiles;

public class Principal {
	public static void main(String[] args) {
		int lado = 7;
		int porcentaje = 20;
		int minas = Utiles.calculaMinas(lado, porcentaje);
		Tablero tablero = new Tablero(lado, minas);
		tablero.mostrarTablero();
		
		for (int i = 0; i < 2; i++) {
			
			jugadaUnaVez(tablero);
		}
		
	}

	private static void jugadaUnaVez(Tablero tablero) {
		String coordenadas = obtenerCoordenadas();
		int posX=Integer.parseInt(String.valueOf(coordenadas.charAt(0)));
		int posY=Integer.parseInt(String.valueOf(coordenadas.charAt(1)));
		Coordenada coordenadaAdesvelar = new Coordenada(0, 0);
		tablero.desvelarCasilla(coordenadaAdesvelar);
		System.out.println("Tablero Después de desvelar");
		tablero.mostrarTablero();
	}

	private static String obtenerCoordenadas() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Que casilla quieres desvelar?");
		String coordenadas = scanner.next();
		return coordenadas;
	}
}

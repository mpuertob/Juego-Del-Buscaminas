package Modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utiles.Utiles;

class TableroTest {

	@Test
	void testTableroColocarMinas() {
		int lado = 4;
		int porcentaje = 10;
		int minas = Utiles.calculaMinas(lado, porcentaje);
		// Al crear el tablero se colocaran las minas
		Tablero tablero = new Tablero(lado, minas);
		// si todo ha salido bien cuando recorra el tablero
		// me encontrare un numero minas de minas
		int contadorMinas = 0;
		// Aqui nos vemos obligados a crear tanto codigo porque los resultados
		// son aleatorios
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				if (tablero.getCasilla(new Coordenada(i, j)).isMina()) {
					contadorMinas++;
				}
			}
		}
		assertEquals(minas, contadorMinas);
	}

	@Test
	void testTableroMarcarYDesmarcarCasilla() {
		int lado = 4;
		int porcentaje = 10;
		int numeroBombas = Utiles.calculaMinas(lado, porcentaje);
		System.out.println(numeroBombas);
		Tablero tablero = new Tablero(lado, numeroBombas);
		boolean marcada = false;
		if (tablero.getCasillas()[0][2].isVelada()) {
			marcada = tablero.marcarCasilla(new Coordenada(0, 2));
		}
		assertTrue(marcada);
		assertTrue(tablero.getCasillas()[0][2].isMarcada());
		if (tablero.getCasillas()[0][2].isVelada() && tablero.getCasillas()[0][2].isMarcada()) {
			marcada = tablero.desmarcarCasilla(new Coordenada(0, 2));
		}
		assertTrue(marcada);
		assertTrue(!tablero.getCasillas()[0][2].isMarcada());
		tablero.getCasillas()[0][3].setVelada(false);
		assertFalse(tablero.marcarCasilla(new Coordenada(0, 3)));
	}
}

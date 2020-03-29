package Modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Casilla;
import Modelo.Coordenada;
import utiles.Utiles;

class TableroTest {
	private int lado;
	private int porcentaje;
	private int minas;
	private Tablero tablero;

	@BeforeEach
	void setUp() {
		lado = 4;
		porcentaje = 10;
		minas = Utiles.calculaMinas(lado, porcentaje);
		tablero = new Tablero(lado, minas);
	}

	@Test
	void testTableroColocarMinas() {
		int contadorMinas = 0;
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
	void testDesvelarCasillaa() {
		// Hay que probar que se desvela si no esta marcada
		// Si hay 0 minas debe comenzar un proceso recursivo y
		// debéis probar que desvela las casillas contiguas que tb
		// son cero
		System.out.println();
	}

	@Test
	void testTableroIncrementaMinas() {
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				Coordenada posicion = new Coordenada(i, j);
				Casilla actual = tablero.getCasilla(posicion);
				int minasAlrededor = actual.getMinasAlrededor();
				// necesito algo que cuente las minas aldedor
				assertEquals(minasAlrededor, contarMinasAlrededor(tablero, posicion));
			}
		}
	}

	// Deberia probar este codigo
	private int contarMinasAlrededor(Tablero tablero, Coordenada posicion) {
		int bombasAlrededor = 0;
		int x = posicion.getPosX();
		int y = posicion.getPosY();
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				Coordenada alrededor = new Coordenada(i, j);
				// No tengo en cuenta la posicion que estoy comprobando
				if (!alrededor.equals(posicion)) {
					if (isDentroLimites(alrededor, lado) && tablero.getCasilla(alrededor).isMina()) {
						bombasAlrededor++;
					}
				}
			}
		}
		return bombasAlrededor;
	}

	private boolean isDentroLimites(Coordenada alrededor, int lado) {
		return alrededor.getPosX() >= 0 && alrededor.getPosX() < lado && alrededor.getPosY() >= 0
				&& alrededor.getPosY() < lado;
	}

	@Test
	void testTableroMarcarYDesmarcarCasilla() {
		boolean marcada = false;

		if (tablero.getCasilla(new Coordenada(0, 2)).isVelada()) {
			marcada = tablero.marcarCasilla(new Coordenada(0, 2));
		}
		assertTrue(marcada);
		assertTrue(tablero.getCasilla(new Coordenada(0, 2)).isMarcada());
		if (tablero.getCasilla(new Coordenada(0, 2)).isVelada()
				&& tablero.getCasilla(new Coordenada(0, 2)).isMarcada()) {
			marcada = tablero.marcarCasilla(new Coordenada(0, 2));
		}
		assertTrue(marcada);
		assertTrue(!tablero.getCasilla(new Coordenada(0, 2)).isMarcada());
		tablero.getCasilla(new Coordenada(0, 3)).setVelada(false);
		assertFalse(tablero.marcarCasilla(new Coordenada(0, 3)));
	}

	@Test
	void testDesvelarCasilla() {
		boolean error = false;
		int i = 0, j = 0;
		do {
			do {
				Coordenada posicion = new Coordenada(i, j);
				Casilla actual = tablero.getCasilla(posicion);
				tablero.mostrarTablero();
				if (!actual.isMina() && actual.getMinasAlrededor() == 0 && actual.isVelada()) {
					tablero.desvelarCasilla(posicion);
					error = comprobarDesvelo();
				}
				tablero.mostrarTablero();
			} while (++j < lado && !error);
			j = 0;
		} while (++i < lado && !error);
		assertTrue(!error);
	}

	private boolean comprobarDesvelo() {
		boolean error = false;
		int i = 0, j = 0;
		do {
			do {
				Coordenada posicion = new Coordenada(i, j);
				Casilla actual = tablero.getCasilla(posicion);
				if (actual.getMinasAlrededor() == 0 && !actual.isVelada()) {
					error = desveladasAroundMe(posicion);
				}
			} while (++j < lado && !error);
			j = 0;
		} while (++i < lado && !error);
		return error;
	}

	private boolean desveladasAroundMe(Coordenada posicion) {
		boolean error = false;
		for (int i = 0; i < 8 && !error; i++) {
			Coordenada alrededor = posicion.creaCoordenadaAlrededor(i);
			if (tablero.isDentroLimites(alrededor)) {
				Casilla actual = tablero.getCasilla(alrededor);
				if (!posicion.equals(actual)) {
					error = actual.isVelada();
				}
			}
		}
		return error;
	}
}

package Modelo;

import utiles.Utiles;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int lado, int numeroBombas) {
		super();
		crearTablero(lado);
		colocarMinas(lado, numeroBombas);
	}

	private void establecerMinasAlrededor(Coordenada posicionMinaCoordenada) {
		// TODO Auto-generated method stub

	}

	private void colocarMinas(int lado, int numeroBombas) {
		int posicionAleatoriaX = Utiles.dameNumero(lado);
		int posicionAleatoriaY = Utiles.dameNumero(lado);
		do {
			if (!this.casillas[posicionAleatoriaX][posicionAleatoriaY].isMina()) {
				this.casillas[posicionAleatoriaX][posicionAleatoriaY].setMina(true);
				numeroBombas--;
			} else {
				posicionAleatoriaX = Utiles.dameNumero(lado);
				posicionAleatoriaY = Utiles.dameNumero(lado);
			}
		} while (numeroBombas != 0);
		// Una vez colocada la mina
		// Tendremos una posicion que yo llamo 0,0 pero que será aleatoria
		// en vuestro programa
		// TODO
		Coordenada posicionMinaCoordenada = new Coordenada(0, 0);
		establecerMinasAlrededor(posicionMinaCoordenada);

	}

	private void crearTablero(int lado) {
		this.casillas = new Casilla[lado][lado];
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas[i].length; j++) {
				this.casillas[i][j] = new Casilla();
			}
		}
	}

	// TODO antes era private
	public Casilla getCasilla(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()];
	}

	private void setMina(Coordenada posicion, boolean bandera) {
		getCasilla(posicion).setMina(bandera);
	}

	private boolean isMina(Coordenada posicion) {
		return getCasilla(posicion).isMina();
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public boolean marcarCasilla(Coordenada coordenada) {
		boolean respuesta = false;
		Casilla casilla = this.casillas[coordenada.getPosX()][coordenada.getPosY()];
		if (casilla.isVelada() && !casilla.isMarcada()) {
			casilla.setMarcada(true);
			respuesta = true;
		}
		return respuesta;
	}

	public boolean desmarcarCasilla(Coordenada coordenada) {
		boolean respuesta = false;
		Casilla casilla = this.casillas[coordenada.getPosX()][coordenada.getPosY()];
		if (casilla.isVelada() && casilla.isMarcada()) {
			casilla.setMarcada(false);
			respuesta = true;
		}
		return respuesta;
	}

	public boolean desvelarCasilla(Coordenada coordenada) {
		// TODO Auto-generated method stub
		return false;
	}
}

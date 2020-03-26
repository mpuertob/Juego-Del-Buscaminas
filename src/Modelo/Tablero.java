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
		int x = posicionMinaCoordenada.getPosX();
		int y = posicionMinaCoordenada.getPosY();
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				Coordenada alrededor = new Coordenada(i, j);
				// No tengo en cuenta la posicion que estoy comprobando
				if (!alrededor.equals(posicionMinaCoordenada)) {
					if (isDentroLimites(alrededor) && !this.getCasilla(alrededor).isMina()) {
						this.getCasilla(alrededor)
								.setMinasAlrededor(this.getCasilla(alrededor).getMinasAlrededor() + 1);
					}
				}
			}
		}

	}

	private void colocarMinas(int lado, int numeroBombas) {
		int posicionAleatoriaX = Utiles.dameNumero(lado);
		int posicionAleatoriaY = Utiles.dameNumero(lado);
		do {
			if (!this.casillas[posicionAleatoriaX][posicionAleatoriaY].isMina()) {
				this.casillas[posicionAleatoriaX][posicionAleatoriaY].setMina(true);
				Coordenada posicionMinaCoordenada = new Coordenada(posicionAleatoriaX, posicionAleatoriaY);
				establecerMinasAlrededor(posicionMinaCoordenada);
				numeroBombas--;
			} else {
				posicionAleatoriaX = Utiles.dameNumero(lado);
				posicionAleatoriaY = Utiles.dameNumero(lado);
			}
		} while (numeroBombas != 0);

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
	public boolean conmutadorDeMarca(Coordenada coordenada) {
		boolean respuesta = false;
		respuesta=marcarCasilla(coordenada);
		if (!respuesta) {
			respuesta=desmarcarCasilla(coordenada);
		}
		return respuesta;
	}

	public boolean desvelarCasilla(Coordenada coordenada) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isDentroLimites(Coordenada alrededor) {
		int lado = this.casillas.length;
		return alrededor.getPosX() >= 0 && alrededor.getPosX() < lado && alrededor.getPosY() >= 0
				&& alrededor.getPosY() < lado;
	}
}

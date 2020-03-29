package Modelo;

import utiles.Utiles;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int lado, int numeroBombas) {
		super();
		crearTablero(lado);
		colocarMinas(lado, numeroBombas);
	}

	public Casilla[][] getCasillas() {
		return casillas;
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
		return getCasilla(coordenada).marcar();
	}

	public boolean desvelarCasilla(Coordenada coordenada) {
		// CasoUno
		boolean respuesta = false;
		Casilla casilla = this.getCasilla(coordenada);
		if (!casilla.isMarcada() && casilla.isVelada()) {
			casilla.setVelada(false);
			int x = coordenada.getPosX();
			int y = coordenada.getPosY();
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					Coordenada coordenadaNueva = new Coordenada(i, j);
					if (isDentroLimites(coordenadaNueva) && !casilla.equals(this.getCasilla(coordenadaNueva))
							&& casilla.getMinasAlrededor() == 0) {
						desvelarCasilla(coordenadaNueva);
						respuesta = true;
					}
				}
			}
		}
		return respuesta;
	}

	public boolean isDentroLimites(Coordenada alrededor) {
		int lado = this.casillas.length;
		return alrededor.getPosX() >= 0 && alrededor.getPosX() < lado && alrededor.getPosY() >= 0
				&& alrededor.getPosY() < lado;
	}

	public void mostrarTablero() {
		for (int i = 0; i < casillas.length; i++) {
			System.out.println();
			for (int j = 0; j < casillas[i].length; j++) {
				Coordenada coordenada = new Coordenada(i, j);
				Casilla casilla = this.getCasilla(coordenada);

				if (casilla.isMina()) {
					System.out.print("X \t");
				} else if (casilla.isMarcada()) {
					System.out.print("M \t");
				} else if (!casilla.isVelada()) {
					System.out.print(casilla.getMinasAlrededor() + " \t");
				} else {
					System.out.print("# \t");
				}

			}
		}
	}
}

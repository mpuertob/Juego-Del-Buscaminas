package Control;

import Modelo.Coordenada;
import Modelo.Tablero;

public class MarcadorController {
	private Tablero tablero;

	public void marcarCasilla(int x, int y) {
		Coordenada coordenada = new Coordenada(x, y);
		tablero.marcarCasilla(coordenada);
	}

}

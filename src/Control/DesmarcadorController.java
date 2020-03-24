package Control;

import Modelo.Coordenada;
import Modelo.Tablero;

public class DesmarcadorController {
	private Tablero tablero;

	public void desmarcarCasilla(int x, int y) {
		Coordenada coordenada = new Coordenada(x, y);
		tablero.desmarcarCasilla(coordenada);
	}
}

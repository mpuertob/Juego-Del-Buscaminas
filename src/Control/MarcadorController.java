package Control;

import Modelo.Coordenada;
import Modelo.Tablero;

public class MarcadorController {

	Tablero tablero;

	// Sirve para marcar/desmarcar casillas
	// Por lo tanto desaparece DesmarcadorController
	public boolean marcarCasilla(Coordenada coord) {
		return tablero.marcarCasilla(coord);
	}
}

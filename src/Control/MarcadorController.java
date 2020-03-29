package Control;

import Modelo.Coordenada;
import Modelo.Tablero;
import Vista.Botonera;

public class MarcadorController {

	Tablero tablero;

	// Sirve para marcar/desmarcar casillas
	// Por lo tanto desaparece DesmarcadorController
	public boolean marcarCasilla(String name) {
		Coordenada coordenada = Botonera.obtenCoordenada(name);
		return tablero.marcarCasilla(coordenada);
	}
}

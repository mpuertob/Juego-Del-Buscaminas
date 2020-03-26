package Control;

import Modelo.Coordenada;
import Modelo.Tablero;

public class MarcadorController{
	private Tablero tablero;

	public boolean conmutadorDeMarca(int x, int y) {
		Coordenada coordenada = new Coordenada(x, y);
		return tablero.conmutadorDeMarca(coordenada);
	}
}

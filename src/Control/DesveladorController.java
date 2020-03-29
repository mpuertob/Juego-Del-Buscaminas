package Control;

import Modelo.Coordenada;
import Modelo.Tablero;
import utiles.ConversorGrafico;
import Vista.Botonera;
import Vista.ElementoGrafico;

public class DesveladorController {

	Tablero tablero;

	public Tablero getTablero() {
		return tablero;
	}

	public DesveladorController(Tablero tablero) {
		super();
		this.tablero = tablero;
	}

	public void desvelarCasilla(String name) {
		// Este pequeno detalle de convertir el nombre en coordenada
		// hace que estemos ante un adapter
		// porque adecua API´s
		Coordenada obtenCoordenada = Botonera.obtenCoordenada(name);
		tablero.desvelarCasilla(obtenCoordenada);
	}

	public ElementoGrafico[][] getEntornoGrafico() {
		return ConversorGrafico.convertir(tablero.getCasillas());
	}
}

package Modelo;

public class Tablero {
	private Dificultad dificultad;
	private Casilla[][] casilla;

	public Tablero(Dificultad dificultad) {
		super();
		this.dificultad = dificultad;
		this.casilla = new Casilla[this.dificultad.getTamanoDelTablero()][this.dificultad.getTamanoDelTablero()];
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	public Casilla[][] getCasilla() {
		return casilla;
	}

	public void setCasilla(Casilla[][] casilla) {
		this.casilla = casilla;
	}

}

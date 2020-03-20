package Modelo;

public class Tablero {
	private int dimension;
	private Casilla[][] casilla;

	public Tablero(int dimension) {
		super();
		this.dimension = dimension;
		this.casilla = new Casilla[dimension][dimension];
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public Casilla[][] getCasilla() {
		return casilla;
	}

	public void setCasilla(Casilla[][] casilla) {
		this.casilla = casilla;
	}

}

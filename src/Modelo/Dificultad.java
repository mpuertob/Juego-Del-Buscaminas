package Modelo;

public class Dificultad {
	private int tamanoDelTablero;
	private int numeroDeMinas;

	public Dificultad(int tamanoDelTablero, int numeroDeMinas) {
		super();
		this.tamanoDelTablero = tamanoDelTablero;
		this.numeroDeMinas = numeroDeMinas;
	}

	public int getTamanoDelTablero() {
		return tamanoDelTablero;
	}

	public void setTamanoDelTablero(int tamanoDelTablero) {
		this.tamanoDelTablero = tamanoDelTablero;
	}

	public int getNumeroDeMinas() {
		return numeroDeMinas;
	}

	public void setNumeroDeMinas(int numeroDeMinas) {
		this.numeroDeMinas = numeroDeMinas;
	}

}

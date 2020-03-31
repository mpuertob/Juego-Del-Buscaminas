package Vista;

import javax.swing.Icon;

public class ElementoGrafico {
	private boolean ocultado;
	private boolean senalado;
	private boolean isMina;
	private int valor;

	public ElementoGrafico(boolean mostrada, boolean senalada, boolean isMina, int valor) {
		super();
		this.ocultado = mostrada;
		this.senalado = senalada;
		this.valor = valor;
		this.isMina = isMina;
	}

	public boolean isOcultado() {
		return ocultado;
	}

	public boolean isSenalada() {
		return senalado;
	}

	public boolean isMina() {
		return isMina;
	}

	public int getValor() {
		return valor;
	}

}

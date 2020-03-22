package Modelo;

public class Casilla {
	private Coordenada coordenada;
	private Tipo tipo;
	private boolean marcada, desvelada;

	public Casilla(Coordenada coordenada, Tipo tipo) {
		super();
		this.coordenada = coordenada;
		this.tipo = tipo;
		this.marcada = false;
		this.desvelada = false;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public int getX() {
		return coordenada.getX();
	}

	public int getY() {
		return coordenada.getY();
	}

	public Tipo getTipo() {
		return tipo;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

	public boolean isDesvelada() {
		return desvelada;
	}

	public void setDesvelada(boolean desvelada) {
		this.desvelada = desvelada;
	}

	public int getValor() {
		return tipo.getValor();
	}

	public void setValor(int valor) {
		tipo.setValor(valor);
	}

}

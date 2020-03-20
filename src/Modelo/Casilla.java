package Modelo;

public class Casilla {
	private Coordenada coordenada;
	private Tipo tipo;

	public Casilla(Coordenada coordenada, Tipo tipo) {
		super();
		this.coordenada = coordenada;
		this.tipo = tipo;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Tipo getTipo() {
		return tipo;
	}

}

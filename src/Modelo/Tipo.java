package Modelo;

public enum Tipo {
	bomba(-1), vacia(0), numero(1);
	private int valor;

	private Tipo(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	// se le cambia el valor en el caso de que la casilla tenga un número de bombas
	// alrededor
	// diferente de uno
	public void setValor(int valor) {
		this.valor = valor;
	}
}

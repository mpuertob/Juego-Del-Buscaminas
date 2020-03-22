package Modelo;

public enum Tipo {
	bomba(-1), vacia(0);
	private int valor;

	private Tipo(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	
	public void setValor(int valor) {
		this.valor = valor;
	}
}

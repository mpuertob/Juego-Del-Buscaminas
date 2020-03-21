package Modelo;

public class Casilla2 {
	private Coordenada coordenada;
	private boolean marcada, desvelada, mina;
	private int numeroMinasAlrededor;

	public Casilla2(Coordenada coordenada) {
		super();
		this.coordenada = coordenada;
		this.marcada = false;
		this.desvelada = false;
		this.mina = false;
		this.numeroMinasAlrededor = 0;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public int getNumeroMinasAlrededor() {
		return numeroMinasAlrededor;
	}

	public void setNumeroMinasAlrededor(int numeroMinasAlrededor) {
		this.numeroMinasAlrededor = numeroMinasAlrededor;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
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

}

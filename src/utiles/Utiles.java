package utiles;

public class Utiles {

	public static int dameNumero(int limite) {
		assert limite > 0;
		return (int) (Math.random() * (limite));
	}

	public static int calculaMinas(int lado, int porcentaje) {
		int porcentajeMaximo = 100;
		assert lado > 0 && porcentaje >= 0 && porcentaje <= porcentajeMaximo;
		return lado * lado * porcentaje / porcentajeMaximo;
	}

}

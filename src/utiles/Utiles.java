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
	//Para probar el test de desvelarCasilla
	public static int[] damePosicionAlrededor(int lugar) {
		int[][] posicion = { { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, -1 }, { 0, +1 }, { +1, -1 }, { +1, 0 },
				{ +1, +1 } };
		return posicion[lugar];
	}
}

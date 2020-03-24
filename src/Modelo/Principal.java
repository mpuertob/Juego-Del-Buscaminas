package Modelo;

import utiles.Utiles;

public class Principal {
	public static void main(String[] args) {
		int lado = 5;
		int porcentaje = 10;
		int minas = Utiles.calculaMinas(lado, porcentaje);
		Tablero tablero = new Tablero(lado, minas);

		paraVerDondeEstanLasMinas(tablero);
		paraVerLasCasillasQueTienenMinasAlrededor(tablero);

	}

	private static void paraVerLasCasillasQueTienenMinasAlrededor(Tablero tablero) {
		for (int i = 0; i < tablero.getCasillas().length; i++) {
			for (int j = 0; j < tablero.getCasillas()[i].length; j++) {
				Coordenada coordenada = new Coordenada(i, j);
				Casilla casilla = tablero.getCasilla(coordenada);
				if (casilla.getMinasAlrededor()>0) {
					System.out.println("Soy la i:" + i + " j:" + j+ " y tengo "+casilla.getMinasAlrededor()+" minas alrededor");
				}
			}
		}
	}

	private static void paraVerDondeEstanLasMinas(Tablero tablero) {
		for (int i = 0; i < tablero.getCasillas().length; i++) {
			for (int j = 0; j < tablero.getCasillas()[i].length; j++) {
				Coordenada coordenada = new Coordenada(i, j);
				if (tablero.getCasilla(coordenada).isMina()) {
					System.out.println("Una mina en la i:" + i + " j:" + j);

				}
			}
		}
	}

}

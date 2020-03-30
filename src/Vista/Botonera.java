package Vista;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Control.DesveladorController;
import Control.MarcadorController;
import Modelo.Coordenada;
import Vista.ElementoGrafico;

public class Botonera extends JPanel {
	DesveladorController desveladorController;
	MarcadorController marcadorController;
	MouseAdapter miMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JButton boton = ((JButton) e.getSource());

			if (SwingUtilities.isLeftMouseButton(e)) {
				desveladorController.desvelarCasilla(boton.getName());
			}
			if (SwingUtilities.isRightMouseButton(e)) {
				marcadorController.marcarCasilla(boton.getName());
			}
			// Al estar dentro de la botonera (el objeto)
			actualizaBotonera(desveladorController.getEntornoGrafico());
		}
	};

	public Botonera(int lado, DesveladorController desveladorController, MarcadorController marcadorController) {
		this.desveladorController = desveladorController;
		this.marcadorController = marcadorController;
		setLayout(new GridLayout(lado, lado, 0, 0));
		for (int filas = 0; filas < lado; filas++) {
			for (int columnas = 0; columnas < lado; columnas++) {
				JButton boton = new JButton();
				asignarNombreAlBoton(filas, columnas, boton);
				add(boton);
				// Esta linea ahora usar el adapter interno
				boton.addMouseListener(miMouseAdapter);
			}
		}
	}

	private void asignarNombreAlBoton(int filas, int columnas, JButton boton) {
		int limite = 10;
		String nombre;
		if (filas < limite && columnas < limite) {
			nombre = Integer.toString(filas) + Integer.toString(columnas);
			boton.setName(nombre);

		} else {
			if (filas >= limite && columnas < limite) {
				nombre = Integer.toString(filas) + "0" + Integer.toString(columnas);
				boton.setName(nombre);
			} else if (filas < limite && columnas >= limite) {
				nombre = "0" + Integer.toString(filas) + Integer.toString(columnas);
				boton.setName(nombre);
			}
		}
	}

	public void actualizaBotonera(ElementoGrafico[][] elementos) {
		Component[] components = getComponents();
		for (int i = 0; i < components.length; i++) {
			JButton boton = (JButton) components[i];
			Coordenada coordenada = obtenCoordenada(boton.getName());
			ElementoGrafico elementoGrafico = elementos[coordenada.getPosX()][coordenada.getPosY()];
			if (!elementoGrafico.isOcultado()) {
				boton.setText(String.valueOf(elementoGrafico.getValor()));
			} else if (elementoGrafico.isSenalada()) {
				boton.setText("X");
			} else {
				boton.setText("");
			}
		}
	}

	public static Coordenada obtenCoordenada(String name) {
		boolean isPar = name.length() % 2 == 0;
		Coordenada coordenada;
		if (isPar) {
			int pos = name.length() / 2;
			coordenada = new Coordenada(Integer.valueOf(name.substring(0, pos)),
					Integer.valueOf(name.substring(pos, name.length())));
		} else {
			coordenada = null;
		}
		return coordenada;
	}

}

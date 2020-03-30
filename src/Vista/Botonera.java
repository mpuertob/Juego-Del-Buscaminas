package Vista;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Control.DesveladorController;
import Modelo.Coordenada;
import Vista.ElementoGrafico;

public class Botonera extends JPanel {
	DesveladorController desveladorController;

	MouseAdapter miMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JButton boton = ((JButton) e.getSource());

			if (SwingUtilities.isLeftMouseButton(e)) {
				desveladorController.desvelarCasilla(boton.getName());
			}
			if (SwingUtilities.isRightMouseButton(e)) {
				// queremos marcar
			}
			// Al estar dentro de la botonera (el objeto)
			actualizaBotonera(desveladorController.getEntornoGrafico());
		}
	};

	public Botonera(int lado, DesveladorController desveladorController) {
		this.desveladorController = desveladorController;
		// TODO el nombre para cuando hay mas de 10 de lado.
		// debe ser de dos digitos por coordenada aunque el valor<10
		// es decir la coordenada 6:11 debe ser 06:11, por ejemplo.
		setLayout(new GridLayout(lado, lado, 0, 0));
		for (int filas = 0; filas < lado; filas++) {
			for (int columnas = 0; columnas < lado; columnas++) {
				JButton boton = new JButton();
				String nombre = Integer.toString(filas) + Integer.toString(columnas);
				boton.setName(nombre);
				add(boton);
				// Esta linea ahora usar el adapter interno
				boton.addMouseListener(miMouseAdapter);
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
		int pos = name.length() / 2;
		return new Coordenada(Integer.valueOf(name.substring(0, pos)),
				Integer.valueOf(name.substring(pos, name.length())));
	}

}

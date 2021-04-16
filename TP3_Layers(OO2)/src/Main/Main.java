package Main;

import java.awt.EventQueue;

import ar.unrn.tp3.bd.ConexionBD;
import ar.unrn.tp3.ui.UI;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {

				UI ui = new UI(new ConexionBD());
				ui.mostrarVentana();

			}
		});
	}
}

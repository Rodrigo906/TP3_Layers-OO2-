package ar.unrn.tp3.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp3.modelo.Cliente;
import ar.unrn.tp3.modelo.RepositorioClientes;

public class UI extends JFrame {

	private RepositorioClientes repositorioClientes;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;

	public UI(RepositorioClientes repositorioClientes) {
		this.repositorioClientes = repositorioClientes;
	}

	public void mostrarVentana() {

		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);

		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);

		JButton botonCargar = new JButton("Cargar");
		JFrame VentanaActual = this;
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					repositorioClientes
							.registrarCliente(new Cliente(nombre.getText(), telefono.getText(), region.getText()));
				} catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(VentanaActual, e2.getMessage());
				}
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

}

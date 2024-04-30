package examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Inicio extends JFrame{

	private JTextField nameText;
	private JLabel nameLabel;
	private JLabel passwdLabel;
	private JButton botonEntrar;
	private JPasswordField passText;
	private JButton btnSalir;
	
	public Inicio() {
		super("LOG IN");
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		nameText = new JTextField();
		nameText.setHorizontalAlignment(SwingConstants.CENTER);
		nameText.setBounds(155, 53, 145, 26);
		add(nameText);
		nameText.setColumns(10);

		nameLabel = new JLabel("Usuario");
		nameLabel.setBounds(41, 41, 48, 51);
		add(nameLabel);

		passwdLabel = new JLabel("Contraseña");
		passwdLabel.setBounds(41, 129, 80, 16);
		add(passwdLabel);

		botonEntrar = new JButton("Conectar");
		botonEntrar.addActionListener(new botonEntrarActionListener());
		botonEntrar.setBounds(186, 201, 80, 29);
		add(botonEntrar);

		passText = new JPasswordField();
		passText.setHorizontalAlignment(SwingConstants.CENTER);
		passText.addActionListener(new botonEntrarActionListener());
		passText.setBounds(155, 124, 145, 26);
		add(passText);

		ImageIcon img = new ImageIcon("files/salir.png");

		btnSalir = new JButton(img);
		btnSalir.setBounds(41, 174, 50, 50);
		btnSalir.setBorderPainted(false);
		btnSalir.setFocusPainted(false);
		btnSalir.addActionListener(new botonEntrarActionListener());
		add(btnSalir);
		setResizable(false);
		setVisible(true);
	}

	private class botonEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSalir) {
				JOptionPane.showMessageDialog(null, "Gracias por usar nuestro programa :)");
				System.exit(0);
			}
			if (e.getSource() == botonEntrar) {

				File f = new File("files/usuarios");
				try {

					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

					List<Usuario> leer = (List<Usuario>) ois.readObject();

					boolean login = false;
					for (Usuario u : leer) {
						System.out.println(u.getName() + " " + u.getPasswd());

						if (u.getName().equalsIgnoreCase(nameText.getText())
								&& u.getPasswd().equalsIgnoreCase(passText.getText())) {
							login = true;
							JOptionPane correcto = new JOptionPane();
							correcto.showMessageDialog(null, "Datos correctos", "LOGIN EXISTOSO!!!",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							Conex c = new Conex();
						}
					}
					if (!login) {
						JOptionPane incorrecto = new JOptionPane();
						incorrecto.showMessageDialog(null, "Datos incorrectos", "LOGIN FALLIDO",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}

package examples;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Nuevo extends JFrame{

	private JLabel seleccionLabel;
	private JRadioButton SobremesaRadioButton;
	private JRadioButton PortatilRadioButton;
	private JLabel marcaLabel;
	private JLabel modelLabel;
	private JTextField marca;
	private JTextField modelo;
	private JLabel priceLabel;
	private JTextField precio;
	private JLabel pantallaLabel;
	private JTextField pantalla;
	private JTextField so;
	private JLabel lblMemoria;
	private JTextField memoria;
	private JTextField color;
	private JTextField graficos;
	private JLabel lblGraficos;
	private JTextField procesador;
	private JTextField almacenamiento;
	private JLabel lblAlmacenamiento;
	private JLabel lblColor;
	private JLabel lblProcesador;
	private JLabel lblSo;
	private JButton addButton;
	private static String conex = "mongodb+srv://admin:a1234@servidor.yiu2atd.mongodb.net/";
	private static String databaseName = "ProyectoBDD";
	private static String collectionName = "Ordenadores";
	private JButton btnVolver;

	
	public Nuevo() {
		super("Creación de ordenadores");
		initialize();
	}


	
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		SobremesaRadioButton = new JRadioButton("Sobremesa");
		SobremesaRadioButton.setBounds(303, 21, 141, 23);
		add(SobremesaRadioButton);

		PortatilRadioButton = new JRadioButton("Portatil");
		PortatilRadioButton.setBounds(204, 21, 77, 23);
		add(PortatilRadioButton);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(PortatilRadioButton);
		grupo.add(SobremesaRadioButton);

		SobremesaRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pantalla.setEnabled(false);
				pantalla.setText("Desactivado");
				pantalla.setVisible(true);
			}
		});

		PortatilRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pantalla.setEnabled(true);
				pantalla.setText("");
			}
		});

		seleccionLabel = new JLabel("Selecciona el tipo: ");
		seleccionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		seleccionLabel.setBounds(16, 6, 265, 52);
		add(seleccionLabel);

		marcaLabel = new JLabel("Marca");
		marcaLabel.setBounds(16, 56, 61, 16);
		add(marcaLabel);

		modelLabel = new JLabel("Modelo");
		modelLabel.setBounds(232, 56, 61, 16);
		add(modelLabel);

		marca = new JTextField();
		marca.setBounds(71, 51, 130, 26);
		add(marca);
		marca.setColumns(10);

		modelo = new JTextField();
		modelo.setColumns(10);
		modelo.setBounds(303, 51, 130, 26);
		add(modelo);

		priceLabel = new JLabel("Precio");
		priceLabel.setBounds(16, 84, 61, 16);
		add(priceLabel);

		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(71, 79, 130, 26);
		add(precio);

		pantallaLabel = new JLabel("Pantalla");
		pantallaLabel.setBounds(232, 84, 61, 16);
		add(pantallaLabel);

		pantalla = new JTextField();
		pantalla.setColumns(10);
		pantalla.setBounds(303, 79, 130, 26);
		add(pantalla);

		so = new JTextField();
		so.setColumns(10);
		so.setBounds(71, 108, 130, 26);
		add(so);

		lblMemoria = new JLabel("Memoria");
		lblMemoria.setBounds(232, 112, 61, 16);
		add(lblMemoria);

		memoria = new JTextField();
		memoria.setColumns(10);
		memoria.setBounds(303, 108, 130, 26);
		add(memoria);

		color = new JTextField();
		color.setColumns(10);
		color.setBounds(71, 141, 130, 26);
		add(color);

		graficos = new JTextField();
		graficos.setColumns(10);
		graficos.setBounds(303, 141, 130, 26);
		add(graficos);

		lblGraficos = new JLabel("Gráficos");
		lblGraficos.setBounds(232, 146, 61, 16);
		add(lblGraficos);

		procesador = new JTextField();
		procesador.setColumns(10);
		procesador.setBounds(81, 176, 92, 26);
		add(procesador);

		almacenamiento = new JTextField();
		almacenamiento.setColumns(10);
		almacenamiento.setBounds(303, 176, 130, 26);
		add(almacenamiento);

		lblAlmacenamiento = new JLabel("Almacenamiento");
		lblAlmacenamiento.setBounds(186, 181, 107, 16);
		add(lblAlmacenamiento);

		lblColor = new JLabel("Color");
		lblColor.setBounds(16, 146, 61, 16);
		add(lblColor);

		lblProcesador = new JLabel("Procesador");
		lblProcesador.setBounds(6, 181, 77, 16);
		add(lblProcesador);

		lblSo = new JLabel("SO");
		lblSo.setBounds(16, 113, 51, 16);
		add(lblSo);

		addButton = new JButton("Añadir");
		addButton.addActionListener(new ManejadorBoton());
		addButton.setBounds(272, 224, 117, 29);
		add(addButton);
		addButton.setEnabled(true);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == btnVolver) {
					dispose();
					new Conex();
				}
			}

		});
		btnVolver.setBounds(71, 224, 117, 29);
		add(btnVolver);
		setVisible(true);
	}

	private class ManejadorBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (marca.getText().equalsIgnoreCase("") || modelo.getText().equalsIgnoreCase("")
					|| precio.getText().equalsIgnoreCase("") || pantalla.getText().equalsIgnoreCase("")
					|| so.getText().equalsIgnoreCase("") || memoria.getText().equalsIgnoreCase("")
					|| color.getText().equalsIgnoreCase("") || graficos.getText().equalsIgnoreCase("")
					|| procesador.getText().equalsIgnoreCase("") || almacenamiento.getText().equalsIgnoreCase("")) {
				new JOptionPane().showMessageDialog(null, "Todos los campos deben estar relleno", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {

				CodecRegistry pojoCodecRegistry = CodecRegistries
						.fromProviders(PojoCodecProvider.builder().automatic(true).build());
				CodecRegistry codecRegistry = CodecRegistries
						.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

				ConnectionString connectionString = new ConnectionString(conex);

				MongoClientSettings clientSettings = MongoClientSettings.builder()
						.applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

				MongoClient mongoClient = MongoClients.create(clientSettings);

				// Recuperar base de datos
				MongoDatabase db = mongoClient.getDatabase(databaseName);

				if (PortatilRadioButton.isSelected()) {
					addButton.setEnabled(true);
					MongoCollection<Portatil> collectionPortatil = db.getCollection(collectionName, Portatil.class);
					Portatil p = new Portatil().setTipo("Portatil").setPrecio(Float.parseFloat(precio.getText()))
							.setMarca(marca.getText()).setProcesador(procesador.getText()).setRam(memoria.getText())
							.setAlmacenamiento(almacenamiento.getText()).setGraficos(graficos.getText())
							.setModelo(modelo.getText()).setSo(so.getText()).setColor(color.getText());
					collectionPortatil.insertOne(p);
					new JOptionPane().showMessageDialog(null, "Ordenador portátil insertado correctamente",
							"ORDENADOR AÑADIDO", JOptionPane.INFORMATION_MESSAGE);
				}
				if (SobremesaRadioButton.isSelected()) {
					addButton.setEnabled(true);
					MongoCollection<Sobremesa> collectionSobremesa = db.getCollection(collectionName, Sobremesa.class);
					Sobremesa s = new Sobremesa().setTipo("Sobremesa").setMarca(marca.getText())
							.setPrecio(Float.parseFloat(precio.getText())).setProcesador(procesador.getText())
							.setRam(memoria.getText()).setAlmacenamiento(almacenamiento.getText())
							.setGraficos(graficos.getText()).setSo(so.getText()).setColor(color.getText())
							.setModelo(modelo.getText());
					collectionSobremesa.insertOne(s);
					new JOptionPane().showMessageDialog(null, "Ordenador sobremesa insertado correctamente",
							"ORDENADOR AÑADIDO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}

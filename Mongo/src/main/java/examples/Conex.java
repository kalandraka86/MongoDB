package examples;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

public class Conex extends JFrame {

	private static String conex = "mongodb+srv://admin:a1234@servidor.yiu2atd.mongodb.net/";
	private static String databaseName = "ProyectoBDD";
	private static String collectionName = "Ordenadores";
	private static MongoCollection<Document> collection;
	private JComboBox comboOrdenadores;
	private JRadioButton SobremesaRadioButton;
	private JRadioButton PortatilRadioButton;
	private JLabel seleccionLabel;
	private JButton carButton;
	private JButton deleteButton;
	private JButton addButton;
	private static MongoDatabase db;
	private static List<Sobremesa> sobremesas;
	private static List<Portatil> portatiles;
	private JButton btnSalir;
	private JLabel fotoOrdenador;

	public Conex() {
		super("Menú Principal");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		comboOrdenadores = new JComboBox();
		comboOrdenadores.setEnabled(false);
		comboOrdenadores.setBounds(261, 129, 103, 27);
		comboOrdenadores.setSize(175, 25);
		add(comboOrdenadores);

		ImageIcon img = new ImageIcon("files/salir.png");

		btnSalir = new JButton(img);
		btnSalir.setBounds(50, 120, 50, 50);
		btnSalir.setBorderPainted(false);
		btnSalir.setFocusPainted(false);
		btnSalir.addActionListener(new manejadorButton());
		add(btnSalir);

		fotoOrdenador = new JLabel();
		fotoOrdenador.setBounds(155, 111, 70, 70);
		add(fotoOrdenador);

		SobremesaRadioButton = new JRadioButton("Sobremesa");
		SobremesaRadioButton.setBounds(303, 63, 141, 23);
		add(SobremesaRadioButton);

		PortatilRadioButton = new JRadioButton("Portatil");
		PortatilRadioButton.setBounds(214, 63, 77, 23);
		add(PortatilRadioButton);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(PortatilRadioButton);
		grupo.add(SobremesaRadioButton);

		seleccionLabel = new JLabel("Selecciona el tipo: ");
		seleccionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		seleccionLabel.setBounds(16, 48, 265, 52);
		add(seleccionLabel);

		carButton = new JButton("Características");
		carButton.setEnabled(false);
		carButton.setBounds(315, 207, 117, 29);
		add(carButton);

		deleteButton = new JButton("Eliminar");
		deleteButton.setEnabled(false);
		deleteButton.setBounds(164, 207, 117, 29);
		add(deleteButton);
    

		addButton = new JButton("Nuevo");
		addButton.addActionListener(new manejadorButton());
		PortatilRadioButton.addActionListener(new manejadorButton());
		SobremesaRadioButton.addActionListener(new manejadorButton());
		carButton.addActionListener(new manejadorButton());
		deleteButton.addActionListener(new manejadorButton());
		addButton.setBounds(16, 207, 117, 29);
		getContentPane().add(addButton);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	public static void generarConex() {

		CodecRegistry pojoCodecRegistry = CodecRegistries
				.fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				pojoCodecRegistry);

		ConnectionString connectionString = new ConnectionString(conex);

		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.codecRegistry(codecRegistry).build();

		// Creamos el cliente MongoDB
		MongoClient mongoClient = MongoClients.create(clientSettings);

		// Recuperar base de datos
		db = mongoClient.getDatabase(databaseName);

		collection = db.getCollection(collectionName);

	}

	private class manejadorButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			generarConex();

			if (e.getSource() == addButton) {
				dispose();
				Nuevo n = new Nuevo();
			}

			if (e.getSource() == PortatilRadioButton) {
				if (PortatilRadioButton.isSelected()) {
					fotoOrdenador.setIcon(new ImageIcon("files/portatil.jpg"));
					comboOrdenadores.setEnabled(true);
					comboOrdenadores.removeAllItems();
					MongoCollection<Portatil> collectionPortatil = db.getCollection(collectionName, Portatil.class);
					// Documento para almacenar los resultados de la consulta
					MongoCursor<Portatil> resultDocument = collectionPortatil.find().iterator();

					// Lista para almacenar los modelos de sobremesa
					portatiles = new ArrayList<>();

					// Iterar sobre los resultados y agregar los modelos a la lista
					while (resultDocument.hasNext()) {
						Portatil portatil = resultDocument.next();
						portatiles.add(portatil);
					}

					// Agregar los modelos de sobremesa al JComboBox existente
					for (Portatil portatil : portatiles) {
						if (portatil.getTipo().equalsIgnoreCase("portatil"))
							comboOrdenadores.addItem(portatil.name());
					}
					if (comboOrdenadores.getSelectedItem() != null) {
						carButton.setEnabled(true);
						deleteButton.setEnabled(true);
					}
				}
			}
			if (e.getSource() == SobremesaRadioButton) {
				if (SobremesaRadioButton.isSelected()) {
					fotoOrdenador.setIcon(new ImageIcon("files/sobremesa.png"));
					comboOrdenadores.setEnabled(true);
					comboOrdenadores.removeAllItems();
					MongoCollection<Sobremesa> collectionSobremesa = db.getCollection(collectionName, Sobremesa.class);
					// Documento para almacenar los resultados de la consulta
					MongoCursor<Sobremesa> resultDocument = collectionSobremesa.find().iterator();

					// Lista para almacenar los modelos de sobremesa
					sobremesas = new ArrayList<>();

					// Iterar sobre los resultados y agregar los modelos a la lista
					while (resultDocument.hasNext()) {
						Sobremesa sobremesa = resultDocument.next();
						sobremesas.add(sobremesa);
					}

					// Agregar los modelos de sobremesa al JComboBox existente
					for (Sobremesa sobremesa : sobremesas) {
						if (sobremesa.getTipo().equalsIgnoreCase("sobremesa"))
							comboOrdenadores.addItem(sobremesa.name());
					}
					if (comboOrdenadores.getSelectedItem() != null) {
						carButton.setEnabled(true);
						deleteButton.setEnabled(true);
					}
				}
			}

			if (e.getSource() == carButton) {
				if (SobremesaRadioButton.isSelected()) {
					for (Sobremesa sobremesa : sobremesas) { // Utiliza la lista estática sobremesas
						String modelo = sobremesa.getMarca() + " " + sobremesa.getModelo();
						if (modelo.equalsIgnoreCase(comboOrdenadores.getSelectedItem().toString())) {
							JOptionPane.showMessageDialog(null, sobremesa.toString(), "CARACTERÍSTICAS",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (PortatilRadioButton.isSelected()) {
					for (Portatil portatil : portatiles) { // Utiliza la lista estática sobremesas
						String modelo = portatil.getMarca() + " " + portatil.getModelo();
						if (modelo.equalsIgnoreCase(comboOrdenadores.getSelectedItem().toString())) {
							JOptionPane.showMessageDialog(null, portatil.toString(), "CARACTERÍSTICAS",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}

			if (e.getSource() == deleteButton) {
				// Verificar si hay un elemento seleccionado en el JComboBox
				if (comboOrdenadores.getSelectedItem() != null) {
					// Obtener el nombre del modelo seleccionado
					String modeloSeleccionado = comboOrdenadores.getSelectedItem().toString();
					String[] modelo = modeloSeleccionado.split(" ");
					System.out.println("Modelo seleccionado: " + modeloSeleccionado);

					// Verificar que la conexión a la base de datos esté establecida correctamente
					if (db != null) {
						System.out.println("Conexión a la base de datos establecida correctamente");

						// Eliminar el documento de la base de datos
						DeleteResult deleteResult = collection.deleteOne(new Document("modelo", modelo[1]));

						// Verificar si se eliminó correctamente el documento
						if (deleteResult.getDeletedCount() > 0) {
							// Eliminar el elemento seleccionado del JComboBox
							comboOrdenadores.removeItem(modeloSeleccionado);
							JOptionPane.showMessageDialog(null,
									"Documento eliminado exitosamente de la base de datos y del JComboBox.");
							System.out.println("Documento eliminado correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "No se encontró el documento en la base de datos.");
							System.out.println("No se encontró el documento en la base de datos");
						}
					} else {
						System.out.println("Error: No se pudo establecer conexión a la base de datos");
					}
				}
			}

			if (e.getSource() == btnSalir) {
				JOptionPane.showMessageDialog(null, "Gracias por usar nuestro programa :)");
				System.exit(0);
			}
		}
	}
}

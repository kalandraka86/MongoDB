package examples;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ImgJFrame extends JFrame{

	private JLabel imagenlbl;
	private JProgressBar progressBar;

	public ImgJFrame() {
		super("Bienvenido a PCS!!!");
		initialize();
	}

	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		
        ImageIcon imagen = new ImageIcon("files/pcs.jpeg"); 
		imagenlbl = new JLabel(imagen);
		imagenlbl.setBounds(73, 24, 292, 210);
		add(imagenlbl);
		setVisible(true);
		
		// Crear y configurar la barra de progreso
        progressBar = new JProgressBar();
        progressBar.setBounds(50, 250, 350, 20);
        progressBar.setStringPainted(false); // Mostrar porcentaje
        add(progressBar);

        setVisible(true);

        // Configurar temporizador para simular progreso de carga
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int progreso = 0;

            @Override
            public void run() {
                // Incrementar el progreso
                progreso += 10;
                progressBar.setValue(progreso);

                if (progreso == 100) {
                    // Cuando la barra de progreso llega al 100%, cerrar el JFrame
                    dispose();
                    Inicio i = new Inicio();
                    cancel(); // Detener el temporizador
                }
            }
        }, 0, 500); // Cambiado a 500 milisegundos (0 segundos de espera antes de iniciar, 500 milisegundos entre cada actualización)


	}
}

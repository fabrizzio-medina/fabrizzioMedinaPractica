package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class ScoreFrame extends JFrame {

    private JButton btnSalir;
    private JLabel lblTtitulo;
    private JList<String> contenedor;
    private JScrollPane jScrollPane;

    public ScoreFrame(){
        //creamos nuestros componentes
        this.btnSalir = new JButton("Salir");
        this.lblTtitulo = new JLabel("Tabla de Clasificacion",SwingConstants.CENTER);

        DefaultListModel<String> modelo = new DefaultListModel();
        this.contenedor = new JList<>(modelo);
        this.jScrollPane = new JScrollPane();
        this.jScrollPane.setViewportView(contenedor);

        //titulo
        this.setTitle("Tabla Clasificacion UI");

        //ventana centrada de la pantalla
        this.setLocationRelativeTo(null);

        //tamanio de la ventanta
        this.setSize(800,600);

        this.setLayout(null);


        lblTtitulo.setBounds(300,30, 250, 50);
        lblTtitulo.setFont(new Font("Arial", Font.BOLD, 20));

        jScrollPane.setBounds(150,100,500,250 );

        btnSalir.setBounds(550,400, 100, 50);
        this.add(lblTtitulo);
        this.add(jScrollPane);
        this.add(btnSalir);

        btnSalir.addActionListener(click ->System.exit(0));

    }

    public void cargarData(Map<Integer, java.util.List<String>> mapaSource) {
        //borramos el modelo de la lista
        DefaultListModel<String> modelo = (DefaultListModel<String>) contenedor.getModel();
        modelo.clear();

        int indice = 1;
        //iteramos el mapa
        for (Map.Entry<Integer, List<String>> fila : mapaSource.entrySet()) {
            String linea;
            //iteramos en los nombres
            for (String nombre : fila.getValue()) {
                //mostramos solo el top 5
                if (indice > 5) {
                    return;
                }
                linea = indice + ".- " + fila.getKey() + " - " + nombre;
                //agregamos al modelo
                modelo.addElement(linea);
                indice++;
            }
        }
    }
}

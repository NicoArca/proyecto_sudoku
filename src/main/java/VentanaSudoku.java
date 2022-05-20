
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class VentanaSudoku extends JFrame implements ActionListener, WindowListener {

    public static final ImageIcon ICONO = new ImageIcon(VentanaSudoku.class.getResource("/images/sudoku.png"));
    public static final ImageIcon SALIR = new ImageIcon(VentanaSudoku.class.getResource("/images/cruz.png"));
    private final JPanel panelCentral;
    private CasillaSudoku[] casilla = new CasillaSudoku[81];
    private JMenuItem mnuReiniciar, mnuResolver, mnuSalir;
    private static final Color COLOR_FONDO_VENTANA = new Color(235, 235, 235);

    public VentanaSudoku(String title) throws HeadlessException {
        super(title);

        // Creación barra de menú
        JMenuBar mb = new JMenuBar();

        // Creacion de menú Opciones y añadiendo un Listener
        JMenu mnOpciones = new JMenu("Opciones");
        mnOpciones.addActionListener(this);

        // Creando JMenuItems del menú Opciones
        // Añadiendo también un Listener para cada Item
        mnuReiniciar = new JMenuItem("Reiniciar");
        mnuReiniciar.addActionListener(this);

        mnuResolver = new JMenuItem("Resolver");
        mnuResolver.addActionListener(this);

        mnuSalir = new JMenuItem("Salir");
        mnuSalir.addActionListener(this);

        // Asignamos los JMenuItems al menú
        mnOpciones.add(mnuReiniciar);
        mnOpciones.add(mnuResolver);
        mnOpciones.addSeparator();
        mnOpciones.add(mnuSalir);

        // Asignamos el menú a la barra de menú
        mb.add(mnOpciones);

        // Asignamos la barra de menú a la ventana
        setJMenuBar(mb);

        // Ajustes del panel central del sudoku
        panelCentral = new JPanel();
        panelCentral.setPreferredSize(new Dimension(450, 450));
        panelCentral.setBackground(COLOR_FONDO_VENTANA);
        panelCentral.setLayout(new GridLayout(81 / 9, 9, 4, 4));
        add(panelCentral);

        // Creacion de las casillas del tablero de sudoku (9x9)
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                // Añadimos las casillas al panel
                casilla[j] = new CasillaSudoku((((i / 3) % 2 != 0)
                        && ((j / 3) % 2 == 0))
                        || (((i / 3) % 2 == 0)
                        && ((j / 3) % 2 != 0)));

                panelCentral.add(casilla[j]);
            }
        }

        // Configuracion de la ventana
        addWindowListener(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(ICONO.getImage());
    }

    // Getter y Setters para el Array de casillas
    public CasillaSudoku[] getCasilla() {
        return casilla;
    }

    public void setCasilla(CasillaSudoku[] casilla) {
        this.casilla = casilla;
    }

    // Método de ventana emergente para confirmar salida del programa
    private void salir() {

        if (JOptionPane.showConfirmDialog(this, "¿Quieres salir?",
                "Cerrar elprograma", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, SALIR
        ) == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == mnuSalir)
        {
            salir();
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        salir();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}

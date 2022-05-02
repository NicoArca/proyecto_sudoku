
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.*;

public class VentanaSudoku extends JFrame {

    private final JPanel panelCentral;
    private JTextField[] casilla = new JTextField[81];

    public VentanaSudoku(String title) throws HeadlessException {
        super(title);

        // Ajustes del panel central del sudoku
        panelCentral = new JPanel();
        panelCentral.setPreferredSize(new Dimension(600, 600));
        panelCentral.setBackground(new Color(235, 235, 235));
        panelCentral.setLayout(new GridLayout(81 / 9, 9, 4, 4));
        add(panelCentral);

        // Creacion de las casillas del tablero de sudoku (9x9)
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                // Añadimos las casillas al panel
                casilla[j] = new JTextField();
                panelCentral.add(casilla[j]);
                
                // Condicional para pintar las casillas 
                // Fuente: mestre - Boletin 08.01)
                if ((((i / 3) % 2 != 0) && ((j / 3) % 2 == 0))|| (((i / 3) % 2 == 0) && ((j / 3) % 2 != 0))){
                    casilla[j].setBackground(Color.yellow);
                    
                }
            }

        }

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

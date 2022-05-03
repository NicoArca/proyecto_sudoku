
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class CasillaSudoku extends JTextField implements KeyListener {

    

    public CasillaSudoku(boolean oscura) {
        this(1, oscura);
        
    }

    public CasillaSudoku(int columns, boolean oscura) {
        super(columns);
        setFont(new Font("Arial", Font.ITALIC, 24));
        setHorizontalAlignment(JTextField.CENTER);
        addKeyListener(this);
        setBackground((oscura) ? Color.DARK_GRAY : Color.LIGHT_GRAY);


    }


    @Override
    public void keyTyped(KeyEvent e) {
        e.consume();
        char c = e.getKeyChar();
        if (Character.isDigit(c))
        {
            JTextField casilla = (JTextField) e.getSource();
            casilla.setText(Character.toString(c));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

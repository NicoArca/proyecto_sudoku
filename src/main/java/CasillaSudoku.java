
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class CasillaSudoku extends JTextField implements KeyListener {

    private static final Color COLOR_CASILLA_OSCURA = Color.DARK_GRAY;
    private static final Color COLOR_CASILLA_CLARA = Color.LIGHT_GRAY;
    private static final Color COLOR_LETRA_OSCURA = new Color(255, 255, 255);
    private static final Color COLOR_LETRA_CLARA = new Color(0, 0, 0);

    public CasillaSudoku(boolean oscura) {
        this(1, oscura);

    }

    public CasillaSudoku(int columns, boolean oscura) {
        super(columns);
        setFont(new Font("Arial", Font.ITALIC, 24));
        setHorizontalAlignment(JTextField.CENTER);
        setBackground((oscura) ? COLOR_CASILLA_OSCURA : COLOR_CASILLA_CLARA);
        setForeground((oscura) ? COLOR_LETRA_OSCURA : COLOR_LETRA_CLARA);
        addKeyListener(this);

    }

    public static Color getCOLOR_CASILLA_OSCURA() {
        return COLOR_CASILLA_OSCURA;
    }

    public static Color getCOLOR_CASILLA_CLARA() {
        return COLOR_CASILLA_CLARA;
    }

    public static Color getCOLOR_LETRA_OSCURA() {
        return COLOR_LETRA_OSCURA;
    }

    public static Color getCOLOR_LETRA_CLARA() {
        return COLOR_LETRA_CLARA;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        e.consume();
        char c = e.getKeyChar();
        if (Character.isDigit(c))
        {
            CasillaSudoku casilla = (CasillaSudoku) e.getSource();
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

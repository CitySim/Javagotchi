import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * erzeugt ein kleines Fenster auf dem ein KeyListener gesetzt werden kann mit
 * dem er dann Tastendrücke mitbekommen
 * 
 * @author Sven
 */
public class ConsoleKeyListener extends Frame implements KeyListener {
	TextField t1;
	Label l1;

	/**
	 * öffnet das Fenster und setzt den Listener
	 */
	public ConsoleKeyListener() {
		// bestimmt den Fenstertitel
		super("Javagotchi KeyListener");

		// im Fenster gibt es ein Label und ein Panel
		Panel p = new Panel();
		l1 = new Label("Javagotchi Key Input");
		p.add(l1);
		add(p);
		addKeyListener(this);
		setSize(200, 100);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// programm beenden wenn fenster geschlossen wird
				System.exit(0);
			}
		});
	}

	/**
	 * Wird nicht genutzt, durch Interface vorgeschrieben
	 */
	public void keyTyped(KeyEvent e) {
		// l1.setText("Key Typed" + e.getKeyCode());
	}

	/**
	 * Wird nicht genutzt, durch Interface vorgeschrieben
	 */
	public void keyPressed(KeyEvent e) {
		// l1.setText("Key Pressed " + e.getKeyCode());
	}

	/**
	 * wird automatisch aufgerufen wenn eine Taste losgelassen wird
	 */
	public void keyReleased(KeyEvent e) {
		l1.setText("Key Released " + e.getKeyCode());
	}
}
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ConsoleKeyListener extends Frame implements KeyListener {
	TextField t1;
	Label l1;

	public ConsoleKeyListener() {
		super("Javagotchi KeyListener");
		Panel p = new Panel();
		l1 = new Label("Javagotchi Key Input");
		p.add(l1);
		add(p);
		addKeyListener(this);
		setSize(200, 100);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void keyTyped(KeyEvent e) {
		//l1.setText("Key Typed" + e.getKeyCode());
	}

	public void keyPressed(KeyEvent e) {
		//l1.setText("Key Pressed " + e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		l1.setText("Key Released " + e.getKeyCode());
	}
}
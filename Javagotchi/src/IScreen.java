import java.awt.event.KeyEvent;

/**
 * ein Screen muss tastendrücke verarbeiten und "Drawable" sein
 */
public interface IScreen extends IDrawable {
	public void keyReleased(KeyEvent e);
}

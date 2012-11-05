import java.awt.event.KeyEvent;

public class MainScreen extends ConsoleKeyListener implements IDrawable {
	private Gotchi gotchi = null;
	
	private IScreen activeScreen = null;

	public IScreen getActiveScreen() {
		return activeScreen;
	}

	public void setActiveScreen(IScreen activeScreen) {
		this.activeScreen = activeScreen;
	}

	public Gotchi getGotchi() {
		return gotchi;
	}

	public void setGotchi(Gotchi gotchi) {
		this.gotchi = gotchi;
	}

	public void start() {
		activeScreen = new CreateScreen(this);;

		while (true) {
			Draw();
			if (gotchi != null) {
				gotchi.Update();
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void Draw() {
		clearScreen();

		// print the Header
		if (gotchi == null) {
			System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║ Javagotchi " + Javagotchi.VERSION + "                                                             ║");
			System.out.println("╟──────────────────────────────────────────────────────────────────────────────╢");
		} else {
			System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║ Javagotchi " + Javagotchi.VERSION + Utils.padLeft(gotchi.getName(), 60) + " ║");
			System.out.println("╟──────────────────────────────────────────────────────────────────────────────╢");
		}

		activeScreen.Draw();
	}

	/**
	 * Clears the console Window
	 */
	private void clearScreen() {
		// just move content out of view
		String out = "";
		for (int i = 0; i < 30; ++i) {
			out += "\n";
		}
		System.out.print(out);
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 27) {
			System.exit(0);
		} else {
			activeScreen.keyReleased(e);
			// System.out.println(e.getKeyCode());
		}
	}
}

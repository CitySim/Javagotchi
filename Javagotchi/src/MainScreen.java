import java.io.IOException;
import java.util.ArrayList;

public class MainScreen implements IDrawable {
	private Gotchi gotchi = null;
	private GameState state = GameState.GotchiScreen;

	public void start() {

		Draw();
	}

	@Override
	public void Draw() {
		while (!Javagotchi.Exit) {
			clearScreen();

			// print the Header
			System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║ Javagotchi " + Javagotchi.VERSION + "                                                             ║");
			System.out.println("╟──────────────────────────────────────────────────────────────────────────────╢");

			switch (state) {
			case CreateGotchi:
				System.out.println("create");
				break;
			case GotchiScreen:
				new GotchiScreen(new Dog("Dummy")).Draw();
				break;
			case ChooseAction:
				System.out.println("action");
				break;
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clears the console Window
	 */
	private void clearScreen() {
		// just move content out of view
		for (int i = 0; i < 50; ++i) {
			System.out.println("\n");
		}
	}

	public enum GameState {
		GotchiScreen, CreateGotchi, ChooseAction
	}
}

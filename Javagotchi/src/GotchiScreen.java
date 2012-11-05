import java.awt.event.KeyEvent;

public class GotchiScreen implements IScreen {
	private Gotchi gotchi = null;
	boolean showActionSelect = false;

	public GotchiScreen(Gotchi gotchi) {
		this.gotchi = gotchi;
	}

	@Override
	public void Draw() {
		if (showActionSelect && gotchi.getState() == GotchiState.DEFAULT) {
			System.out.println("║ Aktion durchführen                                                           ║");
			System.out.println("║                                                                              ║");
			System.out.println("║ Bitte wähle eine der verfügbaren Aktionen!                                   ║");
			System.out.println("║                                                                              ║");
			System.out.println("║       1) Füttern                                                             ║");
			System.out.println("║                                                                              ║");
			System.out.println("║       2) Spielen                                                             ║");
			System.out.println("║                                                                              ║");
			System.out.println("║       3) Schlafen                                                            ║");
			System.out.println("║                                                                              ║");
			System.out.println("║ Bitte drücke die Nummer der Aktion, die du machen willst!                    ║");
			System.out.println("║                                                                              ║");
			System.out.println("║ Drücke erneut [e] zum Abbrechen                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
		} else if (showActionSelect && gotchi.getState() != GotchiState.DEFAULT) {
			System.out.println("║ Aktion durchführen                                                           ║");
			System.out.println("║                                                                              ║");
			System.out.println("║ Dein Gotchi führt gerade eine andere Aktion aus!                             ║");
			System.out.println("║                                                                              ║");
			System.out.println("║ Bitte warte bis sie abgeslossen ist!                                         ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║ Drücke erneut [e] zum Abbrechen                                              ║");
			System.out.println("║                                                                              ║");
			System.out.println("║                                                                              ║");
		} else {
			String[] gotchiArt = gotchi.getImage();

			int linesPrinted = 0;
			// fill up to always have 15 lines for image
			for (int i = 0; i < (15 - gotchiArt.length) / 2; i++) {
				System.out.println("║                                                                              ║");
				linesPrinted++;
			}
			// print image
			for (int i = 0; i < gotchiArt.length; i++) {
				System.out.println("║" + Utils.centerString(gotchiArt[i], 80 - 2) + "║");
				linesPrinted++;
			}
			// fill up to always have 15 lines for image
			for (int i = linesPrinted; i < 15; i++) {
				System.out.println("║                                                                              ║");
			}
		}

		// print the Footer
		String formatAge = Utils.padLeft(String.valueOf((int) gotchi.getAge()), 7);
		String formatHunger = Utils.padLeft(String.valueOf(gotchi.getHunger()), 3);
		String formatLangeweile = Utils.padLeft(String.valueOf(gotchi.getLangeweile()), 3);
		String formatMuedigkeit = Utils.padLeft(String.valueOf(gotchi.getMuedigkeit()), 3);

		System.out.println("╟─────────────┬────────────────┬─────────────────┬────────────────┬────────────╢");
		System.out.println("║ Hunger: " + formatHunger + " │ Müdigkeit: " + formatMuedigkeit + " │ Langeweile: " + formatLangeweile + " │ Alter: " + formatAge + " │ Aktion [E] ║");
		System.out.println("╚═════════════╧════════════════╧═════════════════╧════════════════╧════════════╝");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'e': // e
			showActionSelect = !showActionSelect;
			break;
		case '1':
			if (showActionSelect) {
				gotchi.setState(GotchiState.EATING);
				showActionSelect = false;
			}
			break;
		case '2':
			if (showActionSelect) {
				gotchi.setState(GotchiState.PLAYING);
				showActionSelect = false;
			}
			break;
		case '3':
			if (showActionSelect) {
				gotchi.setState(GotchiState.SLEEPING);
				showActionSelect = false;
			}
		}

		// case 69: // e
		// case 37: // left
		// case 38: // up
		// case 39: // right
		// case 40: // down
	}
}

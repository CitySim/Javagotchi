import java.awt.event.KeyEvent;

/**
 * stellt den Gotchi und was er gerade macht da
 */
public class GotchiScreen implements IScreen {
	/**
	 * Der Gotchi
	 */
	private Gotchi gotchi = null;
	/**
	 * ob gerade der Auwahl bildschirm für einen aktion gezeigt wird
	 */
	boolean showActionSelect = false;

	/**
	 * erstellt einen neunen Gotchi Screen
	 * 
	 * @param gotchi
	 *            der anzuzeigende Gotchi
	 */
	public GotchiScreen(Gotchi gotchi) {
		this.gotchi = gotchi;
	}

	/**
	 * zeichnet je nach Status einen passenden Screen
	 */
	public void Draw() {
		// aktionmenü soll gezigt werden und Gotchi macht gerade nichts
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
		}
		// aktionmenü soll gezigt werden und Gotchi macht gerade etwas =>
		// blockiert
		else if (showActionSelect && gotchi.getState() != GotchiState.DEFAULT) {
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
		}
		// zeige den Gotchi an
		else {
			String[] gotchiArt = gotchi.getImage();

			int linesPrinted = 0;
			// über und unter dem eigentlichen Bild werden leerzeilen ausgegeben
			// um das Bild vertikal zu zentriet anzuzeigen
			for (int i = 0; i < (15 - gotchiArt.length) / 2; i++) {
				System.out.println("║                                                                              ║");
				linesPrinted++;
			}
			// print image
			for (int i = 0; i < gotchiArt.length; i++) {
				// das bild wird hier auch zentriert
				System.out.println("║" + Utils.centerString(gotchiArt[i], 80 - 2) + "║");
				linesPrinted++;
			}

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

	/**
	 * steuerung der aktionen
	 */
	public void keyReleased(KeyEvent e) {
		// aktion auswahl bildschirm beim drücken von e ein/ausblenden
		if (e.getKeyChar() == 'e') {
			showActionSelect = !showActionSelect;
		}
	
		// nur status ändern wenn Gotchi nicht beschäftig ist!
		if (showActionSelect && gotchi.getState() == GotchiState.DEFAULT) {
			switch (e.getKeyChar()) {
			case '1':
				gotchi.setState(GotchiState.EATING);
				showActionSelect = false;
				break;
			case '2':
				gotchi.setState(GotchiState.PLAYING);
				showActionSelect = false;
				break;
			case '3':
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

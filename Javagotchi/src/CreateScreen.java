import java.awt.event.KeyEvent;

/**
 * Bildschirm in den der Spieler sein Gotchi wählen kann
 */
public class CreateScreen implements IScreen {
	/**
	 * Referenz auf den MainScreen, um dort das Gotchi und den activeScreen zu
	 * ändern
	 */
	MainScreen mainScreen = null;

	/**
	 * erstellt einen neuen Auswahlbildshirm für Gotchie
	 * 
	 * @param mainScreen
	 *            Instanz des MainScreen
	 */
	public CreateScreen(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}

	/**
	 * zeichnet die Auswahl des Gotchie und eine kurze Info zum Spielablauf
	 */
	public void Draw() {
		System.out.println("║ Willkommen bei Javagotchi                                                    ║");
		System.out.println("║                                                                              ║");
		System.out.println("║ Bitte wähle eines der verfügbaren Javagotchie!                               ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       1) Hund                                                                ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       2) Katze                                                               ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       3) Bunny                                                               ║");
		System.out.println("║                                                                              ║");
		System.out.println("║ Bitte drücke die Nummer des Javagotchie, das du haben willst!                ║");
		System.out.println("║                                                                              ║");
		System.out.println("║ Dein Javagotchie hat Hunger, will schlafen und spielen. Wenn eines seiner    ║");
		System.out.println("║ Bedürfnisse über 500 steigt, wird es sterben!                                ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       Viel Spaß!                                                             ║");
		System.out.println("║                                                                              ║");
		System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
	}

	/**
	 * erzeugt je nach Taste ein Gotchi und setzt den activeScreen
	 */
	public void keyReleased(KeyEvent e) {
		// je nach Taste das passende Gotchi erzeugen
		switch (e.getKeyChar()) {
		case '1':
			mainScreen.setGotchi(new Dog("Bello"));
			break;
		case '2':
			mainScreen.setGotchi(new Cat("Murmur"));
			break;
		case '3':
			mainScreen.setGotchi(new Bunny("Hermine"));
			break;
		}

		// falls ein gotchi erzeugt wurde wird ein GotchiScreen als activeScreen
		// erzeugt und gesetzt
		if (mainScreen.getGotchi() != null) {
			mainScreen.setActiveScreen(new GotchiScreen(mainScreen.getGotchi()));
		}
	}
}

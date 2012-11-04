import java.awt.event.KeyEvent;

public class CreateScreen implements IScreen {
	MainScreen mainScreen = null;

	public CreateScreen(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}

	@Override
	public void Draw() {
		System.out.println("║ Willkoemmen bei Javagotchi                                                   ║");
		System.out.println("║                                                                              ║");
		System.out.println("║ Bitte wähle eines der verfügbaren Javagotchie!                               ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       1) Hund                                                                ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       2) Katze                                                               ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       3) Bunny                                                               ║");
		System.out.println("║                                                                              ║");
		System.out.println("║ Bitte Drücke die Nummer des Javagotchie das du haben willst!                 ║");
		System.out.println("║                                                                              ║");
		System.out.println("║ Dein Javagotchie hat Hunger, will schlafen und spielen. Wenn eines seiner    ║");
		System.out.println("║ Bedürfnisse über 500 steigt wird es sterben!                                 ║");
		System.out.println("║                                                                              ║");
		System.out.println("║       Viel Spaß!                                                             ║");
		System.out.println("║                                                                              ║");
		System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
	}

	@Override
	public void keyReleased(KeyEvent e) {
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
		
		if(mainScreen.getGotchi() != null) {
			mainScreen.setActiveScreen(new GotchiScreen(mainScreen.getGotchi()));
		}

		System.exit(0);
	}
}

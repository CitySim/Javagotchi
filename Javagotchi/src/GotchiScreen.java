import java.awt.event.KeyEvent;

public class GotchiScreen implements IScreen {
	private Gotchi gotchi = null;

	public GotchiScreen(Gotchi gotchi) {
		this.gotchi = gotchi;
	}

	@Override
	public void Draw() {
		// TODO Auto-generated method stub

		String[] gotchiArt = gotchi.getImage();

		// print image
		for (int i = 0; i < gotchiArt.length; i++) {
			System.out.println("║" + Utils.centerString(gotchiArt[i], 80 - 2) + "║");
		}
		// fill up to always have 15 lines for image
		for (int i = gotchiArt.length; i < 15; i++) {
			System.out.println("║                                                                              ║");
		}

		// print the Footer
		String formatAge = Utils.padLeft(String.valueOf((int)gotchi.getAge()), 7);
		String formatHunger = Utils.padLeft(String.valueOf(gotchi.getHunger()), 3);
		String formatLangeweile = Utils.padLeft(String.valueOf(gotchi.getLangeweile()), 3);
		String formatMuedigkeit = Utils.padLeft(String.valueOf(gotchi.getMuedigkeit()), 3);
		
		System.out.println("╟─────────────┬────────────────┬─────────────────┬────────────────┬────────────╢");
		System.out.println("║ Hunger: " + formatHunger + " │ Müdigkeit: " + formatMuedigkeit + " │ Langeweile: " + formatLangeweile + " │ Alter: " + formatAge + " │ Aktion [E] ║");
		System.out.println("╚═════════════╧════════════════╧═════════════════╧════════════════╧════════════╝");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 69: // e
			System.out.println("e");
		case 37: // left
		case 38: // up
		case 39: // right
		case 40: // down
		}
	}
}

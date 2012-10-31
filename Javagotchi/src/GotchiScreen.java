public class GotchiScreen implements IDrawable {
	private Gotchi gotchi = null;

	public GotchiScreen(Gotchi gotchi) {
		this.gotchi = gotchi;
	}

	@Override
	public void Draw() {
		// TODO Auto-generated method stub

		String[] gotchiArt = gotchi.getImage();
		int imageWidth = gotchiArt[0].length();

		// print image
		for (int i = 0; i < gotchiArt.length; i++) {
			System.out.println("║ " + padLeft(gotchiArt[i], (80 - 2) / 2));
		}
		// fill up to always have 15 lines for image
		for (int i = gotchiArt.length; i < 15; i++) {
			System.out.println("║ ");
		}

		// print the Footer
		String formatStarvation = padLeft(String.valueOf(gotchi.getStarvation()), 3);
		System.out.println("╟─────────────┬────────────────┬─────────────────┬────────────┬────────────────╢");
		System.out.println("║ Hunger: " + formatStarvation + " │ Müdigkeit: 000 │ Langeweile: 000 │ Alter: 000 │     Aktion [E] ║");
		System.out.println("╚═════════════╧════════════════╧═════════════════╧════════════╧════════════════╝");
	}

	private String padLeft(String content, int len) {
		while (content.length() < len) {
			content = " " + content;
		}
		return content;
	}
}

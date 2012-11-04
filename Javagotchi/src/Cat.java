public class Cat extends Gotchi {
	public Cat(String name) {
		super(name);
	}

	public String[] getDefaultImage() {
		String[] r = new String[10];
		r[0] = (" ,_     _        ");
		r[1] = (" |\\_,-~/         ");
		r[2] = (" / _  _ |    ,--.");
		r[3] = ("(  @  @ )   / ,-'");
		r[4] = (" \\  _T_/-._( (   ");
		r[5] = (" /         `. \\  ");
		r[6] = ("|         _  \\ | ");
		r[7] = (" \\ \\ ,  /      | ");
		r[8] = ("  || |-_\\__   /  ");
		r[9] = (" ((_/`(____,-'   ");
		return r;
	}

	public String[] getEatImage() {
		String[] r = new String[5];
		r[0] = ("              |\\__/,|   (`\\");
		r[1] = ("              |o o  |__ _) )");
		r[2] = ("            _.( T   )  `  /");
		r[3] = (" n n._ ((_ `^--' /_<  \\     ");
		r[4] = (" <\" _ }=- `` `-'(((/  (((/    ");
		return r;
	}

	private int playFrameCounter = 0;

	public String[] getPlayImage() {
		String[] r = new String[3];
		if (playFrameCounter == 0) {
			r[0] = ("    |\\__/,|   (`\\ ");
			r[1] = ("  _.|o o  |_   ) )");
			r[2] = ("-(((---(((-e-------");
			playFrameCounter = 1;
		} else {
			r[0] = ("                   ");
			r[1] = ("                   ");
			r[2] = ("-(((---(((---------");
			playFrameCounter = 0;
		}
		return r;
	}

	public String[] getSleepImage() {
		String[] r = new String[4];
		r[0] = ("      |\\      _,,,---,,_      ");
		r[1] = ("PRrrr /,`.-'`'    -.  ;-;;,_  ");
		r[2] = ("     |,4-  ) )-,_. ,\\ (  `'-' ");
		r[3] = ("    '---''(_/--'  `-'\\_)      ");
		return r;
	}
}

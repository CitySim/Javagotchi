
public class DummyGotchi extends Gotchi {
	public DummyGotchi(String name) {
		super(name);
	}

	public String[] getImage() {
		String[] r = new String[12];
		r[0] = "    /(                   ";
		r[1] = "    //\\                 ";
		r[2] = "   //   )_.-\"\"\"-._,-\"\"-. ";
		r[3] = "   \\ ^,'_\\     /_\\     )";
		r[4] = "    `./ /O\\|   |/O\\\\   / ";
		r[5] = "      \\ \\_/|   |\\_/ \\_/  ";
		r[6] = "       \\ .'  _  `. /     ";
		r[7] = "   .-.  ( .:(_):. )  ,-. ";
		r[8] = "  (   `._`._.-._,'_,'   )";
		r[9] = "   )                   ( ";
		r[10] = "  (   .-------------.   )";
		r[11] = "   `-'               `-' ";
		return r;
	}
}

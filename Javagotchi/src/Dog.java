public class Dog extends Gotchi {

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String[] getDefaultImage() {
		String[] r = new String[6];
		r[0] = (" .-\"-.     ");
		r[1] = (" /|6 6|\\   ");
		r[2] = ("{/(_0_)\\}  ");
		r[3] = (" _/ ^ \\_   ");
		r[4] = ("(/ /^\\ \\)-'");
		r[5] = (" \"\"' '\"\"   ");
		return r;
	}
	
	public String[] getEatImage() {
		String[] r = new String[12];
		r[0]  = "  /(                   ";
		r[1]  = "  //\\\\                 ";
		r[2]  = " //   )_.-\"\"\"-._,-\"\"-. ";
		r[3]  = " \\ ^,'_\\     /_\\     ) ";
		r[4]  = "  `./ /O\\|   |/O\\\\   / ";
		r[5]  = "    \\ \\_/|   |\\_/ \\_/  ";
		r[6]  = "     \\ .'  _  `. /     ";
		r[7]  = " .-.  ( .:(_):. )  ,-. ";
		r[8]  = "(   `._`._.-._,'_,'   )";
		r[9]  = " )                   ( ";
		r[10] = "(   .-------------.   )";
		r[11] = " `-'               `-' ";
		return r;
	}
	
	public String[] getPlayImage() {
		String[] r = new String[6];
		r[0] = ("               ;~~,__ ");
		r[1] = (":-....,-------'`-'._.'");
		r[2] = (" `-,,,  ,       ;'~~' ");
		r[3] = ("    ,'_,'~.__; '--.   ");
		r[4] = ("   //'       ````(;   ");
		r[5] = ("  `-'                 ");
		return r;
	}
	
	public String[] getSleepImage() {
		String[] r = new String[4];
		r[0] = ("    	  .\"-.              ");
		r[1] = ("   	 /x  | _o.----.	   _");
		r[2] = ("  	/\\_  \\/ /  __  \\_// )   ");
		r[3] = ("      \\__)-/_/\\_____)____/ ");
		return r;
	}
}

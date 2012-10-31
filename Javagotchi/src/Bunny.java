public class Bunny extends Gotchi {
	public Bunny(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String[] getDefaultImage() {
		String[] r = new String[3];
		r[0] = ("(\\___/)");
		r[1] = ("(='.'=)");
		r[2] = ("(\")_(\")");
		return r;
	}
	
	public String[] getEatImage() {
		String[] r = new String[3];
		r[0] = ("(\\___/)");
		r[1] = ("(=^.^=)");
		r[2] = ("(\")_(\")");
		return r;
	}
	
	public String[] getPlayImage() {
		String[] r = new String[13];
		r[0] = ("mm.           dM8 ");
		r[1] = (" YMMMb.       dMM8");
		r[2] = ("  YMMMMb     dMMM'");
		r[3] = ("   `YMMMb   dMMMP ");
		r[4] = ("     `YMMM  MMM'  ");
		r[5] = ("        \"MbdMP    ");
		r[6] = ("    .dMMMMMM.P    ");
		r[7] = ("   dMM  MMMMMM    ");
		r[8] = ("   8MMMMMMMMMMI   ");
		r[9] = ("    YMMMMMMMMM    ");
		r[10] = ("      \"MMMMMMP   ");
		r[11] = ("     MxM .mmm    ");
		r[12] = ("     W\"W \"\"\"     ");
		return r;
	}
	
	public String[] getSleepImage() {
		String[] r = new String[10];
		r[0] = ("         ____     ");
		r[1] = ("z     z  /    \\   ");
		r[2] = ("        /     \\   ");
		r[3] = ("    Z   ======= ) ");
		r[4] = ("         \\- -/ <> ");
		r[5] = ("    z ___/ ^ \\___ ");
		r[6] = ("         \\___/    ");
		r[7] = ("         _/ \\_    ");
		r[8] = ("      __//   \\__ ");
		r[9] = ("     /___\\/_\\/___\\");
		return r;
	}
}

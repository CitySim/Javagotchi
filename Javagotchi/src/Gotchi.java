import java.util.Date;

public abstract class Gotchi {

	private GotchiState state = GotchiState.DEFAULT;
	private String name = "";
	private Date birth = new Date();

	public Gotchi(String name) {
		this.name = name;
	}
	
	public  enum GotchiState {
		DEFAULT, SLEEPING, EATING, PLAYING
	}
}

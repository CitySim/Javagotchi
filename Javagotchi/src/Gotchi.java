import java.util.Date;

public abstract class Gotchi {

	private GotchiState state = GotchiState.DEFAULT;
	private String name = "";
	private Date birth = new Date();
	
	private int starvation = 0;
	
	// getter setter start

	public GotchiState getState() {
		return state;
	}

	public void setState(GotchiState state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public Date getBirth() {
		return birth;
	}

	public int getStarvation() {
		return starvation;
	}

	public void setStarvation(int starvation) {
		this.starvation = starvation;
	}

	// getter setter end

	public Gotchi(String name) {
		this.name = name;
	}

	public abstract String[] getImage();
}

import java.util.Random;

public abstract class Gotchi {
	private long lastTick = 0;
	private GotchiState state = GotchiState.DEFAULT;
	private String name = "";
	private double age = 0.0;
	
	private int hunger = 0;
	private int muedigkeit = 0;
	private int langeweile = 0;
	private int updatePlus;

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

	public double getAge() {
		return age;
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
		lastTick = System.currentTimeMillis();
	}

	public abstract String[] getSleepImage();

	public abstract String[] getPlayImage();

	public abstract String[] getEatImage();

	public abstract String[] getDefaultImage();

	public String[] getImage() {
		switch (state) {
		case EATING:
			return getEatImage();
		case PLAYING:
			return getDefaultImage();
		case SLEEPING:
			return getSleepImage();
		default:
		case DEFAULT:
			return getDefaultImage();
		}
	}
	
	public void Update(long tick)
	{
		// only update all 2s
		if (tick - lastTick > 2000) {
			age += 0.48; // randomly chosen random number
			
			lastTick = tick;
		}
	}
	
	// erhöht einen zufälligen Statuswert um 1 oder ruft mit 25%iger Chance rekursiv
	// die überladene Methode auf und erhöht einen zufälligen Statuswert um die Anzahl der Durchgänge
	
	public void updateStats() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100);
		
		if (randomNumber < 26) {
			hunger++;
		} else if (randomNumber < 51) {
			muedigkeit++;
		} else if (randomNumber < 76) {
			langeweile++;
		} else {
			updatePlus = 2;
			this.updateStats(updatePlus);
		}
	}
	
	// Überladung
	
	public void updateStats(int plus) {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100);
		
		if (randomNumber < 26) {
			hunger = hunger + plus;
		} else if (randomNumber < 51) {
			muedigkeit = muedigkeit + plus;
		} else if (randomNumber < 76) {
			langeweile = langeweile + plus;
		} else {
			updatePlus++;
			this.updateStats(updatePlus);
		}
	}
}

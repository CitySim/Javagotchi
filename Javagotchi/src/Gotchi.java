import java.util.Random;

/**
 * specihert und simuliert ein "Gotchi"
 */
public abstract class Gotchi {
	private GotchiState state = GotchiState.DEFAULT;
	private String name = "";
	
	private double age = 0.0;
	private int hunger = 0;
	private int muedigkeit = 0;
	private int langeweile = 0;
	private int updatePlus;

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

	public int getHunger() {
		return hunger;
	}

	public int getMuedigkeit() {
		return muedigkeit;
	}

	public int getLangeweile() {
		return langeweile;
	}
	
	// getter setter end

	public Gotchi(String name) {
		this.name = name;
	}

	public abstract String[] getSleepImage();

	public abstract String[] getPlayImage();

	public abstract String[] getEatImage();

	public abstract String[] getDefaultImage();

	/**
	 * gibt anhand des Status das passende Bild zurück
	 * @return
	 */
	public String[] getImage() {
		switch (state) {
		case EATING:
			return getEatImage();
		case PLAYING:
			return getPlayImage();
		case SLEEPING:
			return getSleepImage();
		default:
		case DEFAULT:
			return getDefaultImage();
		}
	}

	/**
	 * erhöht einen zufälligen Statuswert um 1 oder ruft mit 25%iger Chance
	 * rekursiv die überladene Methode auf und erhöht einen zufälligen
	 * Statuswert um die Anzahl der Durchgänge
	 */
	public void Update() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100);

		age += 0.48; // randomly chosen random number

		if (randomNumber < 26) {
			hunger++;
		} else if (randomNumber < 51) {
			muedigkeit++;
		} else if (randomNumber < 76) {
			langeweile++;
		} else {
			updatePlus = 2;
			Update(updatePlus);
		}
		
		// Wenn einer der Werte über 500 ist das Der Gotchi tot
		if (hunger > 500 || muedigkeit > 500 || langeweile > 500) {
			System.out.println("\nDein Javagotchi ist gestorben!!!!!!!!!11\n");
			System.exit(0);
		}
	}

	// Überladung
	public void Update(int plus) {
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
			Update(updatePlus);
		}
	}
}

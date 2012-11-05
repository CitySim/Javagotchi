import java.util.Random;

/**
 * specihert und simuliert ein "Gotchi"
 */
public abstract class Gotchi {
	/**
	 * Status ob der Gotchi gerade schläft, spielt, ...
	 */
	private GotchiState state = GotchiState.DEFAULT;
	private long startTimer = 0;
	/**
	 * Der Name des Gotchie
	 */
	private String name = "";

	/**
	 * Alter des Gotchi
	 */
	private double age = 0.0;
	/**
	 * Wie viel Hunger das Gotchi hat
	 */
	private int hunger = 0;
	/**
	 * Wie Müde das Gotchi ist
	 */
	private int muedigkeit = 0;
	/**
	 * wie langweilig dem Gotchi ist
	 */
	private int langeweile = 0;

	private int updatePlus;

	// getter setter start

	public GotchiState getState() {
		return state;
	}

	public void setState(GotchiState state) {
		this.state = state;
		startTimer = System.currentTimeMillis();
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

	/**
	 * erzeugt einen Gotchi mit Namen
	 * 
	 * @param name
	 *            Name des neuen Gotchi
	 */
	public Gotchi(String name) {
		this.name = name;
	}

	/**
	 * gibt das Bild des schlafenden Gotchi zurück
	 * 
	 * @return String[] mit dem zeilen des Bildes
	 */
	public abstract String[] getSleepImage();

	/**
	 * gibt das Bild des spielenden Gotchi zurück
	 * 
	 * @return String[] mit dem zeilen des Bildes
	 */
	public abstract String[] getPlayImage();

	/**
	 * gibt das Bild des essenden Gotchi zurück
	 * 
	 * @return String[] mit dem zeilen des Bildes
	 */
	public abstract String[] getEatImage();

	/**
	 * gibt das Bild des Gotchi zurück
	 * 
	 * @return String[] mit dem zeilen des Bildes
	 */
	public abstract String[] getDefaultImage();

	/**
	 * gibt anhand des Status das passende Bild zurück
	 * 
	 * @return String[] mit dem zeilen des Bildes
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

		switch (state) {
		case EATING:
			hunger -= 10;
			break;
		case SLEEPING:
			muedigkeit -= 5;
			break;
		case PLAYING:
			langeweile -= 5;
			break;
		}

		// werte dürfen nicht negativ sein
		if (hunger < 0)
			hunger = 0;
		if (muedigkeit < 0)
			muedigkeit = 0;
		if (langeweile < 0)
			langeweile = 0;

		// Wenn einer der Werte über 500 ist das Der Gotchi tot
		if (hunger > 500 || muedigkeit > 500 || langeweile > 500) {
			System.out.println("\nDein Javagotchi ist gestorben!!!!!!!!!11\n");
			System.exit(0);
		}

		// nach einer gewissen zeit hört der Gotchi mit einer aktion auf und
		// wechselt zurück zum Default status
		if (state != GotchiState.DEFAULT) {
			// verhindern, dass animationen zu schnell ablaufen
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int stopAction = rand.nextInt(100);
			// nur abbrechen wenn min. 2000ms vergangen sind
			if (stopAction > 95 && System.currentTimeMillis() - startTimer > 2000) {
				// das ganze bild soll mindestens 2 sekunden lang angezeigt
				// werden

				state = GotchiState.DEFAULT;
			}
		}
	}

	/**
	 * Überladung der Update Methode die einen Status Wert stärker erhöht
	 * 
	 * @param plus
	 *            um wie viel der Wert erhöht wird
	 */
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

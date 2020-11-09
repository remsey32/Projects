import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Time
 * 
 * A Console program that prints the time in hour, minutes and seconds. For
 * testing purposes you should try the following test entries: 5, 61, 85, 3600,
 * 3601.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Time extends ConsoleProgram {
	public static void main(String[] args) {
		new Time().start(args);
	}
	
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		println("Enter time in seconds since");
		int timeInSeconds = readInt("midnight: ");
		int hours = timeInSeconds / 60 / 60;
		/**
		 * Berechnung der Sekunden in Minuten.
		 */
		int secondsInMinutes = timeInSeconds / 60;
		/**
		 * Berechnung der verbleibenden Minuten => 35.
		 */
		int minutes = secondsInMinutes % 60;
		int seconds = timeInSeconds % 60;
		if (hours < 10 && minutes < 10 && seconds < 10) {
			println("The time is: 0" + hours + ":0" + minutes + ":0" + seconds);
		} else {
			if (hours < 10 && minutes < 10) {
				println("The time is: 0" + hours + ":0" + minutes + ":" + seconds);
			} else {
				if (hours < 10 && seconds < 10) {
					println("The time is: 0" + hours + ":" + minutes + ":0" + seconds);
				} else {
					if (minutes < 10 && seconds < 10) {
						println("The time is: " + hours + ":0" + minutes + ":0" + seconds);
					} else {
						if (hours < 10) {
							println("The time is: 0" + hours + ":" + minutes + ":" + seconds);
						} else {
							if (minutes < 10) {
								println("The time is: " + hours + ":0" + minutes + ":" + seconds);
							} else {
								if (seconds < 10) {
									println("The time is: " + hours + ":" + minutes + ":0" + seconds);
								} else {
									println("The time is: " + hours + ":" + minutes + ":" + seconds);
								}
							}
						}
					}
				}
			}
		}

	}
}
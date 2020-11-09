import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/**
 * Ein kleines textbasiertes Adventure game, bei dem man von Raum zu Raum laufen
 * kann.
 * 
 * @author Sven Remy
 */

public class Adventure extends ConsoleProgram {
	public static void main(String[] args) {
		new Adventure().start(args);
	}

	private HashMap<String, ArrayList<String>> roomMap = new HashMap<String, ArrayList<String>>();
	String currentRoom = "kitchen";

	public void run() {
		setFont("Times New Roman-bold-30");
		setSize(1000, 500);

		loadMap();

		while (true) {
			gameLoop();
		}

	}

	private void gameLoop() {
		println("You are currently in " + currentRoom);
		String nextRoom = readLine("Where do you want to go? " + roomMap.get(currentRoom) + ": ");
		currentRoom = nextRoom;
	}

	private void loadMap() {

		try {
			FileReader fr = new FileReader("World.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				parseLine(line);

			}
			fr.close();
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void parseLine(String line) {
		StringTokenizer toki = new StringTokenizer(line, ">");
		while (toki.hasMoreTokens()) {
			String from = toki.nextToken().trim();
			String to = toki.nextToken().trim();
			if (roomMap.containsKey(from)) {
				ArrayList<String> rooms = roomMap.get(from);
				rooms.add(to);
				roomMap.put(from, rooms);
			} else {
				ArrayList<String> rooms = new ArrayList<String>();
				rooms.add(to);
				roomMap.put(from, rooms);
			}

		}
	}
}
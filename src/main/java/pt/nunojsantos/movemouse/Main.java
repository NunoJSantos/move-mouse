package pt.nunojsantos.movemouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class Main {

	private static final int MAX_Y = 400;
	private static final int MAX_X = 400;
	private static int millisecondsInterval = 30000;

	public static void main(String... args) throws AWTException, InterruptedException {

		switch (args.length) {
			case 0:
				moveMouse();
				break;
			case 1:
				try {
					millisecondsInterval = Integer.parseInt(args[0]);
					moveMouse();
				} catch (NumberFormatException e) {
					System.err.println("Bad usage");
				}
				break;
			default:
				System.err.println("Bad Usage");
				break;
		}

	}

	private static void moveMouse() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Random random = new Random();
		while (true) {
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(millisecondsInterval);
		}
	}

}

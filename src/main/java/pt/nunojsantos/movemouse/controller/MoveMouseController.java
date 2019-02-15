package pt.nunojsantos.movemouse.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class MoveMouseController {

	private final int MAX_Y = 400;
	private final int MAX_X = 400;
	private int millisecondsInterval = 30000;

	public void start(String... args) {

		try {

			switch (args.length) {
				case 0:
					moveMouse();
					break;
				case 1:
						millisecondsInterval = Integer.parseInt(args[0]);
						moveMouse();
					break;
				default:
					System.err.println("Bad Usage");
					break;
			}

		} catch (NumberFormatException e) {
			System.err.println("Bad Usage");
		} catch (Exception e) {
			System.err.println("Some error ocurred");
		}

	}

	private void moveMouse() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Random random = new Random();
		while (true) {
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(millisecondsInterval);
		}
	}

}

package pt.nunojsantos.movemouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class Main {
	private static final int THIRTY_SECONDS = 30000;
	private static final int MAX_Y = 400;
	private static final int MAX_X = 400;

	public static void main(String... args) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Random random = new Random();
		while (true) {
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(THIRTY_SECONDS);
		}
}

}

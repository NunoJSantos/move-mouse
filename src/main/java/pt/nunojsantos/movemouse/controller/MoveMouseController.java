package pt.nunojsantos.movemouse.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;
import pt.nunojsantos.movemouse.view.MoveMouseView;

public class MoveMouseController {

	private static final int MAX_Y = 400;
	private static final int MAX_X = 400;

	private MoveMouseView view;

	public void init(String... args) {
		view.init(args);
	}

	public void moveMouse(int millisecondsInterval) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Random random = new Random();
		while (true) {
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(millisecondsInterval);
		}
	}

	public void setView(MoveMouseView view) {
		this.view = view;
	}

}

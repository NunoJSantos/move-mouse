package pt.nunojsantos.movemouse.service;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;
import pt.nunojsantos.movemouse.controller.MoveMouseController;

public class MoveMouseService {

	private static final int MAX_Y = 400;
	private static final int MAX_X = 400;

	private MoveMouseController view;

	private Robot robot;
	private Random random;
	private boolean isToMove;

	public void init(String... args) {
		view.init(args);
	}

	public void moveMouse(int secondsInterval) throws AWTException, InterruptedException {
		if (robot == null) {
			robot = new Robot();
		}
		if (random == null) {
			random = new Random();
		}

		int millisecondsInterval = secondsInterval * 1000;

		isToMove = true;

		while (isToMove) {
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(millisecondsInterval);
		}
	}

	public void stopMouse() {
		isToMove = false;
	}

	public void setView(MoveMouseController view) {
		this.view = view;
	}

}

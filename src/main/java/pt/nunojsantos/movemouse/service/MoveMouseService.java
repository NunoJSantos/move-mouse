package pt.nunojsantos.movemouse.service;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;
import pt.nunojsantos.movemouse.controller.MoveMouseController;

public class MoveMouseService {

	private static final int MAX_Y = 400;
	private static final int MAX_X = 400;

	private MoveMouseController view;

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

	public void setView(MoveMouseController view) {
		this.view = view;
	}

}

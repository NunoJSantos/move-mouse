package pt.nunojsantos.movemouse.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;
import pt.nunojsantos.movemouse.utils.Messages;
import pt.nunojsantos.movemouse.view.CliView;
import pt.nunojsantos.movemouse.view.GuiView;
import pt.nunojsantos.movemouse.view.MoveMouseView;

public class MoveMouseController {

	private static final int MAX_Y = 400;
	private static final int MAX_X = 400;
	private int millisecondsInterval = 30000;

	private MoveMouseView view;

	public void start(String... args) {

		view.init();

		try {

			switch (args.length) {
				case 0:
					moveMouse();
					break;
				case 1:
					millisecondsInterval = Integer.parseInt(args[0]) * 1000;
					moveMouse();
					break;
				default:
					view.showErrorMessage(Messages.BAD_USAGE);
					break;
			}

		} catch (NumberFormatException e) {
			view.showErrorMessage(Messages.BAD_USAGE);
		} catch (Exception e) {
			view.showErrorMessage(Messages.GENERIC_ERROR);
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

	public void setView(MoveMouseView view) {
		this.view = view;
	}

}

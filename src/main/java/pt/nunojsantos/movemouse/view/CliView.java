package pt.nunojsantos.movemouse.view;

import pt.nunojsantos.movemouse.controller.MoveMouseController;
import pt.nunojsantos.movemouse.utils.Messages;

public class CliView implements MoveMouseView {

	private MoveMouseController moveMouseController;
	private int timeInterval = 30000;

	@Override
	public void init(String... args) {
		System.out.println(Messages.WELCOME_CLI);

		if (args.length > 1) {
			System.err.println(Messages.BAD_USAGE);
			return;
		}

		try {

			if (args.length == 1) {
				timeInterval = Integer.parseInt(args[0]) * 1000;
			}
			moveMouseController.moveMouse(timeInterval);

		} catch (NumberFormatException e) {
			System.err.println(Messages.BAD_USAGE);
		} catch (Exception e) {
			System.err.println(Messages.GENERIC_ERROR);
		}

	}

	@Override
	public void setMoveMouseController(MoveMouseController moveMouseController) {
		this.moveMouseController = moveMouseController;
	}

}
